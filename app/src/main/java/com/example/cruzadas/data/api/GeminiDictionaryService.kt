package com.example.cruzadas.data.api

import android.util.Log
import com.example.BuildConfig
import com.example.cruzadas.data.generator.CrosswordGenerator
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit

object GeminiDictionaryService {

    private const val TAG = "GeminiDictionary"
    private const val API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent"

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    /**
     * Looks up the definition, category, and example for a specific Portuguese word.
     */
    suspend fun lookupWordDefinition(word: String): WordLookupResult = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext WordLookupResult(
                word = word,
                definition = "Definição indisponível offline. Adicione a sua chave de API nas configurações do AI Studio.",
                category = "Geral",
                difficulty = "Fácil",
                example = "Definição padrão."
            )
        }

        val prompt = """
            Forneça a definição clara e concisa em português de Portugal para a palavra: "$word".
            Responda EXCLUSIVAMENTE em formato JSON com o seguinte esquema:
            {
              "word": "$word",
              "definition": "Definição curta e direta adequada para palavras cruzadas",
              "category": "uma entre: História, Cultura, Geografia, Ciência, Gastronomia, Literatura, Desporto, Geral",
              "difficulty": "uma entre: Fácil, Médio, Difícil",
              "example": "Uma frase de exemplo simples usando a palavra"
            }
        """.trimIndent()

        try {
            val jsonPayload = JSONObject().apply {
                put("contents", JSONArray().apply {
                    put(JSONObject().apply {
                        put("parts", JSONArray().apply {
                            put(JSONObject().apply { put("text", prompt) })
                        })
                    })
                })
                put("generationConfig", JSONObject().apply {
                    put("responseMimeType", "application/json")
                    put("temperature", 0.3)
                })
            }

            val request = Request.Builder()
                .url("$API_URL?key=$apiKey")
                .post(jsonPayload.toString().toRequestBody("application/json".toMediaType()))
                .build()

            val response = okHttpClient.newCall(request).execute()
            val responseBodyStr = response.body?.string() ?: ""

            if (!response.isSuccessful || responseBodyStr.isBlank()) {
                Log.e(TAG, "Gemini API error: ${response.code} $responseBodyStr")
                return@withContext WordLookupResult(word, "Definição não encontrada na internet.", "Geral", "Médio", "")
            }

            val rootJson = JSONObject(responseBodyStr)
            val candidates = rootJson.optJSONArray("candidates")
            val firstCandidate = candidates?.optJSONObject(0)
            val content = firstCandidate?.optJSONObject("content")
            val parts = content?.optJSONArray("parts")
            val text = parts?.optJSONObject(0)?.optString("text") ?: ""

            val wordJson = JSONObject(text)
            WordLookupResult(
                word = wordJson.optString("word", word),
                definition = wordJson.optString("definition", "Definição de $word"),
                category = wordJson.optString("category", "Geral"),
                difficulty = wordJson.optString("difficulty", "Médio"),
                example = wordJson.optString("example", "")
            )
        } catch (e: Exception) {
            Log.e(TAG, "Error looking up word definition", e)
            WordLookupResult(word, "Erro ao pesquisar a definição na internet.", "Geral", "Médio", "")
        }
    }

    /**
     * Generates a batch of thematic Portuguese words with clues to build a new dynamic crossword puzzle.
     */
    suspend fun generateThematicWords(theme: String, difficulty: String, count: Int = 10): List<CrosswordGenerator.CandidateWord> = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            // Return fallback dictionary candidates
            return@withContext getFallbackCandidates(theme)
        }

        val prompt = """
            Gere uma lista de $count palavras em Português de Portugal sobre o tema "$theme" com nível de dificuldade "$difficulty".
            Cada palavra deve ter entre 3 e 10 letras, sem espaços ou hífenes.
            As pistas/definições devem ser diretas e desafiantes para um jogo de palavras cruzadas Mente Ativa.
            
            Responda EXCLUSIVAMENTE num array JSON de objetos com o formato:
            [
              {
                "word": "PALAVRA",
                "clue": "Pista curta para palavras cruzadas",
                "category": "$theme"
              }
            ]
        """.trimIndent()

        try {
            val jsonPayload = JSONObject().apply {
                put("contents", JSONArray().apply {
                    put(JSONObject().apply {
                        put("parts", JSONArray().apply {
                            put(JSONObject().apply { put("text", prompt) })
                        })
                    })
                })
                put("generationConfig", JSONObject().apply {
                    put("responseMimeType", "application/json")
                    put("temperature", 0.7)
                })
            }

            val request = Request.Builder()
                .url("$API_URL?key=$apiKey")
                .post(jsonPayload.toString().toRequestBody("application/json".toMediaType()))
                .build()

            val response = okHttpClient.newCall(request).execute()
            val responseBodyStr = response.body?.string() ?: ""

            if (!response.isSuccessful || responseBodyStr.isBlank()) {
                return@withContext getFallbackCandidates(theme)
            }

            val rootJson = JSONObject(responseBodyStr)
            val candidatesJson = rootJson.optJSONArray("candidates")
            val text = candidatesJson?.optJSONObject(0)?.optJSONObject("content")?.optJSONArray("parts")?.optJSONObject(0)?.optString("text") ?: ""

            val jsonArray = JSONArray(text)
            val result = mutableListOf<CrosswordGenerator.CandidateWord>()
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val w = obj.optString("word")
                val c = obj.optString("clue")
                val cat = obj.optString("category", theme)
                if (w.isNotBlank() && c.isNotBlank()) {
                    result.add(
                        CrosswordGenerator.CandidateWord(
                            originalWord = w,
                            normalizedWord = CrosswordGenerator.normalizeForGrid(w),
                            clue = c,
                            category = cat
                        )
                    )
                }
            }
            if (result.isEmpty()) getFallbackCandidates(theme) else result
        } catch (e: Exception) {
            Log.e(TAG, "Error generating thematic words from Gemini API", e)
            getFallbackCandidates(theme)
        }
    }

    /**
     * Gets a smart hint / explanation for a specific crossword clue.
     */
    suspend fun getSmartHint(word: String, clue: String): String = withContext(Dispatchers.IO) {
        val apiKey = BuildConfig.GEMINI_API_KEY
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            return@withContext "Dica: A palavra tem ${word.length} letras e começa por '${word.take(1)}'."
        }

        val prompt = "Tenho a pista de palavras cruzadas '$clue' para uma palavra de ${word.length} letras. Sem revelar a resposta exata ('$word'), dá-me uma dica inteligente e subtil de 1 frase para me ajudar a descobrir a palavra."

        try {
            val jsonPayload = JSONObject().apply {
                put("contents", JSONArray().apply {
                    put(JSONObject().apply {
                        put("parts", JSONArray().apply {
                            put(JSONObject().apply { put("text", prompt) })
                        })
                    })
                })
            }

            val request = Request.Builder()
                .url("$API_URL?key=$apiKey")
                .post(jsonPayload.toString().toRequestBody("application/json".toMediaType()))
                .build()

            val response = okHttpClient.newCall(request).execute()
            val responseBodyStr = response.body?.string() ?: ""

            val rootJson = JSONObject(responseBodyStr)
            val text = rootJson.optJSONArray("candidates")?.optJSONObject(0)?.optJSONObject("content")?.optJSONArray("parts")?.optJSONObject(0)?.optString("text") ?: ""
            if (text.isNotBlank()) text else "A palavra tem ${word.length} letras e começa com '${word.take(1)}'."
        } catch (e: Exception) {
            "A palavra tem ${word.length} letras e começa com '${word.take(1)}'."
        }
    }

    private fun getFallbackCandidates(theme: String): List<CrosswordGenerator.CandidateWord> {
        return listOf(
            CrosswordGenerator.CandidateWord("CARAVELA", "CARAVELA", "Embarcação histórica de vela", theme),
            CrosswordGenerator.CandidateWord("LUSITANO", "LUSITANO", "Relativo a Portugal", theme),
            CrosswordGenerator.CandidateWord("AZULEJO", "AZULEJO", "Placa de cerâmica tradicional", theme),
            CrosswordGenerator.CandidateWord("BACALHAU", "BACALHAU", "Peixe emblemático salgado", theme),
            CrosswordGenerator.CandidateWord("FADO", "FADO", "Canção nostálgica de Lisboa", theme),
            CrosswordGenerator.CandidateWord("TEJO", "TEJO", "Rio que desagua na capital", theme),
            CrosswordGenerator.CandidateWord("SAUDADE", "SAUDADE", "Sentimento melancólico único", theme)
        )
    }
}

data class WordLookupResult(
    val word: String,
    val definition: String,
    val category: String,
    val difficulty: String,
    val example: String
)
