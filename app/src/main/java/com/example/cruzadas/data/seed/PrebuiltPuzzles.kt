package com.example.cruzadas.data.seed

import com.example.cruzadas.data.generator.CrosswordGenerator
import com.example.cruzadas.data.generator.CrosswordGenerator.CandidateWord
import com.example.cruzadas.data.models.DictionaryWord
import com.example.cruzadas.data.models.Puzzle

object PrebuiltPuzzles {

    fun getInitialDictionaryWords(): List<DictionaryWord> {
        return listOf(
            // ==================== 1. PORTUGAL (HISTÓRIA E CULTURA) ====================
            // Fácil
            DictionaryWord("Lisboa", "Capital de Portugal e cidade das sete colinas junto ao rio Tejo", "Portugal", "Fácil"),
            DictionaryWord("Porto", "Cidade Invicta no norte de Portugal famosa pelo Vinho do Porto e pontes", "Portugal", "Fácil"),
            DictionaryWord("Bacalhau", "Prato de peixe seco tradicional da gastronomia portuguesa e consoada", "Portugal", "Fácil"),
            DictionaryWord("Pastel de Belém", "Doce conventual tradicional de massa folhada e creme nascido em Belém", "Portugal", "Fácil"),
            DictionaryWord("Fado", "Estilo musical tradicional português classificado Património Imaterial da Humanidade", "Portugal", "Fácil"),
            DictionaryWord("Mondego", "O rio mais longo que nasce em Portugal e desagua na Figueira da Foz", "Portugal", "Fácil"),
            DictionaryWord("Sobreiro", "Árvore protegida em Portugal da qual se extrai a cortiça", "Portugal", "Fácil"),
            DictionaryWord("Açores", "Arquipélago português de nove ilhas vulcânicas no Oceano Atlântico", "Portugal", "Fácil"),
            DictionaryWord("Afonso Henriques", "Primeiro Rei e fundador da nacionalidade de Portugal (O Conquistador)", "Portugal", "Fácil"),
            DictionaryWord("Torre de Belém", "Monumento e fortaleza manuelina erguida no rio Tejo na Era dos Descobrimentos", "Portugal", "Fácil"),
            DictionaryWord("Madeira", "Maior ilha do arquipélago da Madeira, com capital no Funchal", "Portugal", "Fácil"),
            DictionaryWord("Galo de Barcelos", "Animal de barro colorido símbolo lendário do artesanato português", "Portugal", "Fácil"),
            DictionaryWord("Francesinha", "Sanduíche típico do Porto com carnes variadas, queijo e molho picante", "Portugal", "Fácil"),
            DictionaryWord("Serra da Estrela", "Cordilheira onde se situa o ponto mais alto de Portugal Continental (Torre)", "Portugal", "Fácil"),
            DictionaryWord("Coimbra", "Cidade universitária com a Queima das Fitas e biblioteca joanina", "Portugal", "Fácil"),
            DictionaryWord("Atlântico", "Oceano que banha toda a costa de Portugal Continental e ilhas", "Portugal", "Fácil"),
            DictionaryWord("Santo António", "Santo popular festejado intensamente em Lisboa na noite de 12 para 13 de junho", "Portugal", "Fácil"),
            DictionaryWord("São João", "Santo popular celebrado com martelinhos e alho-porro na cidade do Porto", "Portugal", "Fácil"),
            DictionaryWord("Poncha", "Bebida tradicional da Madeira com aguardente de cana, mel e limão", "Portugal", "Fácil"),
            DictionaryWord("Ovos Moles", "Famosa iguaria de ovos e açúcar típica da cidade de Aveiro", "Portugal", "Fácil"),
            DictionaryWord("Azulejos", "Tradicionais painéis de cerâmica pintados que decoram monumentos em Portugal", "Portugal", "Fácil"),
            DictionaryWord("Vasco da Gama", "Navegador português que descobriu o caminho marítimo para a Índia em 1498", "Portugal", "Fácil"),
            DictionaryWord("Camões", "Poeta autor da célebre epopeia nacional 'Os Lusíadas'", "Portugal", "Fácil"),
            DictionaryWord("Benfica", "Equipa de futebol de Lisboa com símbolo de águia que joga no Estádio da Luz", "Portugal", "Fácil"),
            DictionaryWord("Sporting", "Clube de Alvalade com símbolo de leão rampante e cores verde e branca", "Portugal", "Fácil"),
            DictionaryWord("Fátima", "Localidade onde ocorreram as aparições aos três pastorinhos em 1917", "Portugal", "Fácil"),
            DictionaryWord("Castanha", "Fruto seco assado tradicionalmente nas ruas no dia de São Martinho", "Portugal", "Fácil"),
            DictionaryWord("Cabo da Roca", "Cabo que marca o ponto mais ocidental de Portugal Continental e da Europa", "Portugal", "Fácil"),
            DictionaryWord("Pena", "Palácio romântico e colorido situado no topo da Serra de Sintra", "Portugal", "Fácil"),
            DictionaryWord("Caldo Verde", "Sopa tradicional portuguesa de puré de batata com couve-galega fina", "Portugal", "Fácil"),
            DictionaryWord("Cristiano Ronaldo", "Futebolista português com cinco Bolas de Ouro nascido no Funchal", "Portugal", "Fácil"),
            DictionaryWord("Terramoto", "Grande sismo que destruiu Lisboa no ano de 1755", "Portugal", "Fácil"),
            DictionaryWord("Douro", "Grande rio vinícola que desagua entre o Porto e Vila Nova de Gaia", "Portugal", "Fácil"),
            DictionaryWord("Minho", "Região verdejante a norte famosa pelo vinho verde e folclore", "Portugal", "Fácil"),
            DictionaryWord("Algarve", "Região a sul de Portugal famosa pelas praias e falésias douradas", "Portugal", "Fácil"),
            DictionaryWord("Alentejo", "Vasta planície a sul do Tejo famosa pelo calor, azeite e montado", "Portugal", "Fácil"),
            DictionaryWord("Caravela", "Embarcação icónica e ligeira utilizada na Era dos Descobrimentos", "Portugal", "Fácil"),
            DictionaryWord("Sardinha", "Peixe assado típico dos Santos Populares e verão português", "Portugal", "Fácil"),
            DictionaryWord("Sintra", "Vila romântica e serra mística classificada património mundial pela UNESCO", "Portugal", "Fácil"),
            DictionaryWord("Évora", "Capital do Alto Alentejo com o famoso Templo Romano e Capela dos Ossos", "Portugal", "Fácil"),
            DictionaryWord("Nazaré", "Vila piscatória tradicional conhecida pelas sete saias e ondas gigantes", "Portugal", "Fácil"),
            DictionaryWord("Elétrico", "Meio de transporte histórico sobre carris emblemático de Lisboa (ex: 28)", "Portugal", "Fácil"),
            DictionaryWord("Alheira", "Enchido tradicional criado pelos cristãos-novos em Trás-os-Montes", "Portugal", "Fácil"),

            // Médio
            DictionaryWord("República", "Regime político implantado em Portugal a 5 de Outubro de 1910", "Portugal", "Médio"),
            DictionaryWord("Tratado de Zamora", "Tratado de 1143 que reconheceu a independência de Portugal face a Leão", "Portugal", "Médio"),
            DictionaryWord("Álvaro de Campos", "Heterónimo futurista e engenheiro naval de Fernando Pessoa", "Portugal", "Médio"),
            DictionaryWord("Eça de Queirós", "Escritor realista autor de romances célebres como 'Os Maias'", "Portugal", "Médio"),
            DictionaryWord("Aljubarrota", "Batalha travada em 1385 que consolidou a independência frente a Castela", "Portugal", "Médio"),
            DictionaryWord("Canhão da Nazaré", "Desfiladeiro submarino responsável pelas ondas gigantes mundiais na Nazaré", "Portugal", "Médio"),
            DictionaryWord("Rainha Santa", "Rainha D. Isabel de Aragão canonizada e lembrada pelo Milagre das Rosas", "Portugal", "Médio"),
            DictionaryWord("Salazar", "Ditador que governou o regime do Estado Novo em Portugal até 1968", "Portugal", "Médio"),
            DictionaryWord("Braga", "Cidade dos Arcebispos que alberga o santuário do Bom Jesus do Monte", "Portugal", "Médio"),
            DictionaryWord("Goa", "Antiga colónia portuguesa na Índia integrada na União Indiana em 1961", "Portugal", "Médio"),
            DictionaryWord("Macau", "Território administrado por Portugal até 1999, transferido para a China", "Portugal", "Médio"),
            DictionaryWord("Manuelino", "Estilo arquitetónico tipicamente português com motivos marítimos", "Portugal", "Médio"),
            DictionaryWord("Magalhães", "Navegador que liderou a primeira circum-navegação do globo", "Portugal", "Médio"),
            DictionaryWord("Mirandês", "Segunda língua oficial de Portugal falada no nordeste transmontano", "Portugal", "Médio"),
            DictionaryWord("Amália Rodrigues", "Fadista consagrada internacionalmente como a 'Rainha do Fado'", "Portugal", "Médio"),
            DictionaryWord("Tordesilhas", "Tratado de 1494 que dividiu as terras descobertas entre Portugal e Castela", "Portugal", "Médio"),
            DictionaryWord("Alqueva", "O maior lago artificial da Europa Ocidental situado no rio Guadiana", "Portugal", "Médio"),
            DictionaryWord("Marquês de Pombal", "Estadista que chefiou a reconstrução da Baixa de Lisboa após 1755", "Portugal", "Médio"),
            DictionaryWord("Rabanadas", "Doce tradicional natalício de pão frito com leite, ovo, canela e açúcar", "Portugal", "Médio"),
            DictionaryWord("Amadeo", "Pintor pioneiro do modernismo português (Amadeo de Souza-Cardoso)", "Portugal", "Médio"),
            DictionaryWord("Manuel II", "O último rei de Portugal antes da implantação da República em 1910", "Portugal", "Médio"),
            DictionaryWord("Saramago", "Escritor português que venceu o Prémio Nobel da Literatura em 1998", "Portugal", "Médio"),
            DictionaryWord("Tratado de Windsor", "Tratado de 1386 que estabeleceu a aliança perpétua com Inglaterra", "Portugal", "Médio"),
            DictionaryWord("Touriga Nacional", "Principal casta nobre de uva utilizada no Vinho do Porto e Douro", "Portugal", "Médio"),
            DictionaryWord("Guimarães", "Cidade Berço onde nasceu a nacionalidade e D. Afonso Henriques", "Portugal", "Médio"),
            DictionaryWord("São Jorge", "Castelo histórico no topo da colina mais alta da cidade de Lisboa", "Portugal", "Médio"),
            DictionaryWord("Nuno Álvares", "O Santo Condestável que comandou a vitória na Batalha de Aljubarrota", "Portugal", "Médio"),
            DictionaryWord("Montanha do Pico", "O ponto de maior altitude de todo o território português nos Açores", "Portugal", "Médio"),
            DictionaryWord("Infante Henrique", "O Navegador, grande impulsionador e patrono dos Descobrimentos", "Portugal", "Médio"),
            DictionaryWord("Restauração", "Revolta patriótica de 1 de Dezembro de 1640 que restaurou a coroa lusa", "Portugal", "Médio"),
            DictionaryWord("Funchal", "Capital e principal centro urbano do arquipélago da Madeira", "Portugal", "Médio"),
            DictionaryWord("PIDE", "Polícia política repressiva durante o regime do Estado Novo em Portugal", "Portugal", "Médio"),
            DictionaryWord("Almada Negreiros", "Artista multidisciplinar e figura cimeira da Geração d'Orpheu", "Portugal", "Médio"),
            DictionaryWord("D. Dinis", "O Rei Lavrador que fundou a Universidade e plantou o Pinhal de Leiria", "Portugal", "Médio"),
            DictionaryWord("Ria de Aveiro", "Vasto sistema lagunar costeiro onde navegam os barcos moliceiros", "Portugal", "Médio"),
            DictionaryWord("Mosteiro da Batalha", "Monumento erguido por D. João I em cumprimento de promessa por Aljubarrota", "Portugal", "Médio"),
            DictionaryWord("Jerónimos", "Mosteiro quinhentista em Belém jóia máxima da arquitetura manuelina", "Portugal", "Médio"),

            // Difícil
            DictionaryWord("Alcanizes", "Tratado de 1297 entre D. Dinis e Castela que fixou as fronteiras nacionais", "Portugal", "Difícil"),
            DictionaryWord("Fernão Lopes", "Pai da historiografia portuguesa e primeiro cronista-mor do Reino", "Portugal", "Difícil"),
            DictionaryWord("Regicídio", "Atentado de 1908 no Terreiro do Paço que vitimou o Rei D. Carlos I", "Portugal", "Difícil"),
            DictionaryWord("Paula Rego", "Artista plástica portuguesa célebre pela série figurativa 'Mulher Cão'", "Portugal", "Difícil"),
            DictionaryWord("São Mamede", "Batalha de 1128 em Guimarães considerada marco fundacional da pátria", "Portugal", "Difícil"),
            DictionaryWord("Ordem de Cister", "Primeira ordem monástica a fixar-se no Mosteiro de Alcobaça", "Portugal", "Difícil"),
            DictionaryWord("Eduardo Lourenço", "Ensaísta e filósofo pensador autor de 'O Labirinto da Saudade'", "Portugal", "Difícil"),
            DictionaryWord("Francisco Sanches", "Filósofo e médico renascentista autor do célebre 'Que Nada se Sabe'", "Portugal", "Difícil"),
            DictionaryWord("Inês de Castro", "Nobre galega coroada rainha postumamente pelo seu amor D. Pedro I", "Portugal", "Difícil"),
            DictionaryWord("Faial", "Ilha açoriana onde ocorreu a erupção do Vulcão dos Capelinhos em 1957", "Portugal", "Difícil"),
            DictionaryWord("Aristides", "Cônsul português em Bordéus que salvou milhares na II Guerra Mundial", "Portugal", "Difícil"),
            DictionaryWord("Torres Vedras", "Linhas militares defensivas que travaram as invasões francesas napoleónicas", "Portugal", "Difícil"),
            DictionaryWord("Mário Cesariny", "Poeta e pintor expoente do movimento surrealista em Portugal", "Portugal", "Difícil"),
            DictionaryWord("Pedro Nunes", "Matemático e cosmógrafo quinhentista português inventor do nónio", "Portugal", "Difícil"),
            DictionaryWord("Cadeia da Relação", "Antiga prisão no Porto onde Camilo Castelo Branco esteve detido", "Portugal", "Difícil"),
            DictionaryWord("Tratado de Lisboa", "Tratado de 1668 que selou a paz com Espanha após a Restauração", "Portugal", "Difícil"),
            DictionaryWord("Sagres", "Promontório e fortaleza algarvia ligada aos navegadores quinhentistas", "Portugal", "Difícil"),
            DictionaryWord("Gil Vicente", "Dramaturgo quinhentista considerado o Pai do Teatro Português", "Portugal", "Difícil"),
            DictionaryWord("Manifestis", "Bula papal Manifestis Probatum de 1179 que reconheceu o reino luso", "Portugal", "Difícil"),
            DictionaryWord("Maria da Fonte", "Revolta popular minhota de 1846 contra as leis de saúde e recrutamento", "Portugal", "Difícil"),
            DictionaryWord("Fernão Mendes Pinto", "Aventureiro autor de 'Peregrinação' sobre as suas viagens no Oriente", "Portugal", "Difícil"),
            DictionaryWord("Garcia de Orta", "Médico e botânico luso que publicou 'Colóquios dos Simples' em Goa", "Portugal", "Difícil"),
            DictionaryWord("Grão Vasco", "Mestre Vasco Fernandes, pintor renascentista insigne de Viseu", "Portugal", "Difícil"),
            DictionaryWord("Bandarra", "Sapateiro e poeta de Trancoso autor das profecias sebastianistas", "Portugal", "Difícil"),
            DictionaryWord("Cancioneiro", "Coletânea medieval de cantigas de amigo, amor e escárnio galego-portuguesas", "Portugal", "Difícil"),

            // ==================== 2. GEOGRAFIA ====================
            // Fácil
            DictionaryWord("Espanha", "País ibérico vizinho que faz fronteira terrestre com Portugal", "Geografia", "Fácil"),
            DictionaryWord("França", "País da Europa Ocidental com capital em Paris e a Torre Eiffel", "Geografia", "Fácil"),
            DictionaryWord("Brasil", "O maior país da América do Sul onde a língua oficial é o português", "Geografia", "Fácil"),
            DictionaryWord("Itália", "País da bota no sul da Europa com capital na cidade de Roma", "Geografia", "Fácil"),
            DictionaryWord("Alemanha", "Maior potência económica da União Europeia com capital em Berlim", "Geografia", "Fácil"),
            DictionaryWord("Japão", "País insular no leste da Ásia também conhecido como Terra do Sol Nascente", "Geografia", "Fácil"),
            DictionaryWord("Roma", "Capital histórica da Itália e cidade eterna banhada pelo Tibre", "Geografia", "Fácil"),
            DictionaryWord("Paris", "Capital de França célebre pela arte, moda e Museu do Louvre", "Geografia", "Fácil"),
            DictionaryWord("Londres", "Capital do Reino Unido atravessada pelo célebre rio Tamisa", "Geografia", "Fácil"),
            DictionaryWord("Madrid", "Capital de Espanha situada no centro da Península Ibérica", "Geografia", "Fácil"),
            DictionaryWord("Tóquio", "Capital hipermoderna e metrópole mais populosa do Japão", "Geografia", "Fácil"),
            DictionaryWord("Alpes", "Imponente cordilheira montanhosa no centro da Europa", "Geografia", "Fácil"),
            DictionaryWord("Andes", "A mais longa cordilheira montanhosa continental do planeta na América do Sul", "Geografia", "Fácil"),
            DictionaryWord("Amazonas", "O maior rio em volume de água do mundo e vasta floresta tropical", "Geografia", "Fácil"),
            DictionaryWord("Nilo", "Lendário rio africano vital para a civilização do Antigo Egito", "Geografia", "Fácil"),
            DictionaryWord("Pacífico", "O maior e mais profundo oceano de todo o planeta Terra", "Geografia", "Fácil"),
            DictionaryWord("Atlântico", "Oceano que separa o continente americano da Europa e África", "Geografia", "Fácil"),
            DictionaryWord("Índico", "Oceano tropical banhando a costa leste da África, Ásia e Austrália", "Geografia", "Fácil"),
            DictionaryWord("Deserto", "Região árida com escassez extrema de precipitação e vegetação", "Geografia", "Fácil"),
            DictionaryWord("Ilha", "Porção de terra totalmente cercada de água por todos os lados", "Geografia", "Fácil"),
            DictionaryWord("Vulcão", "Abertura na crosta terrestre por onde é expelido magma e gases", "Geografia", "Fácil"),
            DictionaryWord("Canadá", "Segundo maior país do mundo em área total situado na América do Norte", "Geografia", "Fácil"),

            // Médio
            DictionaryWord("Camberra", "Capital federal planeada da Austrália", "Geografia", "Médio"),
            DictionaryWord("Tamisa", "Rio histórico que serpenteia pela cidade de Londres", "Geografia", "Médio"),
            DictionaryWord("Rússia", "O país mais extenso do mundo que abrange a Europa Oriental e o Norte da Ásia", "Geografia", "Médio"),
            DictionaryWord("Saara", "O maior deserto quente do mundo situado no norte de África", "Geografia", "Médio"),
            DictionaryWord("Helsínquia", "Capital da Finlândia banhada pelas águas do mar Báltico", "Geografia", "Médio"),
            DictionaryWord("Otava", "Capital federal do Canadá localizada na província de Ontário", "Geografia", "Médio"),
            DictionaryWord("Reiquiavique", "A capital nacional mais setentrional do mundo situada na Islândia", "Geografia", "Médio"),
            DictionaryWord("Wellington", "Capital da Nova Zelândia situada na extremidade sul da Ilha do Norte", "Geografia", "Médio"),
            DictionaryWord("Buenos Aires", "Capital e maior cidade da Argentina nas margens do Rio da Prata", "Geografia", "Médio"),
            DictionaryWord("Cairo", "A maior metrópole do mundo árabe e capital do Egito junto ao Nilo", "Geografia", "Médio"),
            DictionaryWord("Sicília", "A maior ilha do Mar Mediterrâneo, pertencente ao território de Itália", "Geografia", "Médio"),
            DictionaryWord("Montes Urais", "Cordilheira montanhosa que marca a fronteira natural entre Europa e Ásia", "Geografia", "Médio"),
            DictionaryWord("Luanda", "Capital costeira e principal centro económico da República de Angola", "Geografia", "Médio"),
            DictionaryWord("Maputo", "Capital e maior cidade de Moçambique no sudeste africano", "Geografia", "Médio"),
            DictionaryWord("Danúbio", "Segundo rio mais longo da Europa que passa por quatro capitais", "Geografia", "Médio"),
            DictionaryWord("Volga", "O rio mais longo de todo o continente europeu, situado na Rússia", "Geografia", "Médio"),
            DictionaryWord("Gronelândia", "A maior ilha não-continental do planeta, território autónomo da Dinamarca", "Geografia", "Médio"),
            DictionaryWord("Madagáscar", "Grande ilha no Oceano Índico famosa pela sua fauna e biodiversidade única", "Geografia", "Médio"),
            DictionaryWord("Fiorde", "Entrada de mar longa e estreita com encostas íngremes esculpida por glaciares", "Geografia", "Médio"),
            DictionaryWord("Arquipélago", "Conjunto ou agrupamento de várias ilhas próximas no mar", "Geografia", "Médio"),
            DictionaryWord("Mar Morto", "Lago hiper-salino situado entre Israel e a Jordânia no ponto mais baixo da Terra", "Geografia", "Médio"),

            // Difícil
            DictionaryWord("Brunei", "Sultanato rico em petróleo que partilha a ilha de Bornéu com Malásia e Indonésia", "Geografia", "Difícil"),
            DictionaryWord("Suriname", "O menor e menos populoso país independente da América do Sul", "Geografia", "Difícil"),
            DictionaryWord("Chile", "País sul-americano estreito onde se situa o árido deserto de Atacama", "Geografia", "Difícil"),
            DictionaryWord("Marianas", "Fossa submarina no Pacífico que abriga o ponto mais profundo dos oceanos", "Geografia", "Difícil"),
            DictionaryWord("Ulan Bator", "Capital da Mongólia conhecida como a capital mais fria do globo", "Geografia", "Difícil"),
            DictionaryWord("Gibraltar", "Estreito marítimo estratégico que separa a Europa do norte de África", "Geografia", "Difícil"),
            DictionaryWord("Cazaquistão", "O maior país do mundo sem qualquer saída direta para o oceano", "Geografia", "Difícil"),
            DictionaryWord("Sena", "Rio histórico navegável que corre pela capital francesa Paris", "Geografia", "Difícil"),
            DictionaryWord("Monte Etna", "O vulcão ativo mais elevado de todo o continente europeu na Sicília", "Geografia", "Difícil"),
            DictionaryWord("Quirguistão", "País montanhoso da Ásia Central sem litoral com capital em Bisqueque", "Geografia", "Difícil"),
            DictionaryWord("Ouagadougou", "Capital e maior centro urbano do Burkina Faso na África Ocidental", "Geografia", "Difícil"),
            DictionaryWord("Antananarivo", "Capital de Madagáscar situada no planalto central da ilha", "Geografia", "Difícil"),
            DictionaryWord("Vaduz", "Capital alpina do pequeno principado europeu do Listenstaine", "Geografia", "Difícil"),
            DictionaryWord("Lago Baikal", "O lago de água doce mais antigo e profundo de todo o planeta na Sibéria", "Geografia", "Difícil"),
            DictionaryWord("Estreito de Bering", "Braço de mar que separa o Alasca nos EUA da Península de Chukotka na Rússia", "Geografia", "Difícil"),
            DictionaryWord("Cabo Horn", "O ponto continental e insular mais austral da América do Sul no Chile", "Geografia", "Difícil"),
            DictionaryWord("Kilimanjaro", "O estratovulcão adormecido e ponto de maior altitude de África na Tanzânia", "Geografia", "Difícil"),
            DictionaryWord("Vanuatu", "Nação insular da Melanésia no sul do Oceano Pacífico", "Geografia", "Difícil"),
            DictionaryWord("Salar de Uyuni", "O maior deserto de sal contínuo do mundo localizado na Bolívia", "Geografia", "Difícil"),
            DictionaryWord("Danakil", "Depressão etíope conhecida como um dos lugares mais quentes e inóspitos da Terra", "Geografia", "Difícil"),

            // ==================== 3. ENTRETENIMENTO ====================
            // Fácil
            DictionaryWord("Cinema", "A sétima arte de projetar imagens em movimento no grande ecrã", "Entretenimento", "Fácil"),
            DictionaryWord("Televisão", "Aparelho e sistema eletrónico de transmissão de programas e notícias", "Entretenimento", "Fácil"),
            DictionaryWord("Música", "Arte de combinar sons e melodias vocais ou instrumentais em harmonia", "Entretenimento", "Fácil"),
            DictionaryWord("Novela", "Narrativa ficcional transmitida em episódios diários na televisão", "Entretenimento", "Fácil"),
            DictionaryWord("Filme", "Obra cinematográfica de ficção ou documental exibida em salas e streaming", "Entretenimento", "Fácil"),
            DictionaryWord("Banda", "Grupo musical composto por instrumentistas e vocalistas", "Entretenimento", "Fácil"),
            DictionaryWord("Guitarra", "Instrumento musical de cordas dedilhadas clássico ou elétrico", "Entretenimento", "Fácil"),
            DictionaryWord("Piano", "Instrumento musical de cordas percutidas por teclas brancas e pretas", "Entretenimento", "Fácil"),
            DictionaryWord("Teatro", "Arte da representação dramática de atores em palco ao vivo", "Entretenimento", "Fácil"),
            DictionaryWord("Rádio", "Meio de comunicação de difusão de áudio, notícias e música por ondas", "Entretenimento", "Fácil"),
            DictionaryWord("Ator", "Artista profissional que interpreta personagens no teatro, cinema ou TV", "Entretenimento", "Fácil"),
            DictionaryWord("Ópera", "Gênero de arte cénica em que os cantores interpretam com orquestra", "Entretenimento", "Fácil"),
            DictionaryWord("Circo", "Espetáculo itinerante com acrobatas, malabaristas, palhaços e ilusionistas", "Entretenimento", "Fácil"),
            DictionaryWord("Dança", "Arte de movimentar o corpo ritmicamente ao som da música", "Entretenimento", "Fácil"),
            DictionaryWord("Comédia", "Gênero humorístico destinado a provocar riso e entretenimento", "Entretenimento", "Fácil"),
            DictionaryWord("Drama", "Gênero focado em conflitos emocionais intensos e situações comoventes", "Entretenimento", "Fácil"),

            // Médio
            DictionaryWord("James Cameron", "Cineasta que realizou filmes marcantes como 'Titanic' e 'Avatar'", "Entretenimento", "Médio"),
            DictionaryWord("Guerra dos Tronos", "Série épica de fantasia da HBO mais premiada na história dos Emmys", "Entretenimento", "Médio"),
            DictionaryWord("Johnny Depp", "Ator célebre pelo papel do Capitão Jack Sparrow em Piratas das Caraíbas", "Entretenimento", "Médio"),
            DictionaryWord("Madonna", "Cantora e ícone cultural consagrada internacionalmente como Rainha do Pop", "Entretenimento", "Médio"),
            DictionaryWord("Pink Floyd", "Banda britânica de rock progressivo do álbum 'The Dark Side of the Moon'", "Entretenimento", "Médio"),
            DictionaryWord("George Lucas", "Cineasta pioneiro e criador das míticas sagas 'Star Wars' e 'Indiana Jones'", "Entretenimento", "Médio"),
            DictionaryWord("Tom Hanks", "Ator oscarizado duas vezes por 'Philadelphia' e 'Forrest Gump'", "Entretenimento", "Médio"),
            DictionaryWord("Rihanna", "Estrela mundial da música pop e empresária natural da ilha de Barbados", "Entretenimento", "Médio"),
            DictionaryWord("Trilogia", "Conjunto de três obras artísticas interligadas (ex: O Senhor dos Anéis)", "Entretenimento", "Médio"),
            DictionaryWord("ABBA", "Quarteto pop sueco que venceu a Eurovisão em 1974 com a canção 'Waterloo'", "Entretenimento", "Médio"),
            DictionaryWord("Steven Spielberg", "Realizador de clássicos como 'E.T.', 'Tubarão' e 'A Lista de Schindler'", "Entretenimento", "Médio"),
            DictionaryWord("Quentin Tarantino", "Realizador cult conhecido por 'Pulp Fiction' e diálogos marcantes", "Entretenimento", "Médio"),
            DictionaryWord("Christopher Nolan", "Realizador de filmes complexos como 'A Origem', 'Interstellar' e 'Oppenheimer'", "Entretenimento", "Médio"),
            DictionaryWord("Michael Jackson", "Cantor e dançarino aclamado mundialmente como o eterno Rei do Pop", "Entretenimento", "Médio"),
            DictionaryWord("Queen", "Banda britânica de rock liderada pelo inesquecível vocalista Freddie Mercury", "Entretenimento", "Médio"),
            DictionaryWord("Rolling Stones", "Banda pioneira de rock britânico liderada por Mick Jagger e Keith Richards", "Entretenimento", "Médio"),
            DictionaryWord("Leonardo DiCaprio", "Ator vencedor do Óscar pelo filme 'O Renascido' e astro de 'Titanic'", "Entretenimento", "Médio"),
            DictionaryWord("Meryl Streep", "A atriz com o maior número de nomeações na história dos prémios Óscar", "Entretenimento", "Médio"),
            DictionaryWord("Óscar", "A mais prestigiada estatueta de ouro atribuída anualmente no cinema", "Entretenimento", "Médio"),
            DictionaryWord("Grammy", "O principal prémio da indústria discográfica e musical internacional", "Entretenimento", "Médio"),

            // Difícil
            DictionaryWord("Wings", "Filme mudo de 1927 vencedor do primeiríssimo Óscar de Melhor Filme em 1929", "Entretenimento", "Difícil"),
            DictionaryWord("Hitchcock", "Mestre do suspense e realizador das obras-primas 'Psicose' e 'A Mulher Que Viveu Duas Vezes'", "Entretenimento", "Difícil"),
            DictionaryWord("Buggles", "Banda de 'Video Killed the Radio Star', o primeiro videoclipe transmitido na MTV", "Entretenimento", "Difícil"),
            DictionaryWord("Springfield", "Cidade fictícia norte-americana onde habita a família de animação 'Os Simpsons'", "Entretenimento", "Difícil"),
            DictionaryWord("Audrey Hepburn", "Ícone de elegância e atriz protagonista de 'Boneca de Luxo' e 'Férias em Roma'", "Entretenimento", "Difícil"),
            DictionaryWord("Beatles", "O lendário quarteto de Liverpool formado por John, Paul, George e Ringo", "Entretenimento", "Difícil"),
            DictionaryWord("Hans Zimmer", "Compositor germânico da banda sonora de 'O Rei Leão', 'Gladiador' e 'Dune'", "Entretenimento", "Difícil"),
            DictionaryWord("La Casa de Papel", "Série espanhola sobre assaltos à Casa da Moeda com máscaras de Dalí", "Entretenimento", "Difícil"),
            DictionaryWord("Toy Story", "Primeira longa-metragem de animação digital 3D da história produzida pela Pixar", "Entretenimento", "Difícil"),
            DictionaryWord("Heath Ledger", "Ator australiano aclamado pelo seu papel póstumo como Joker em 2008", "Entretenimento", "Difícil"),
            DictionaryWord("Stanley Kubrick", "Realizador perfeccionista autor de '2001: Odisseia no Espaço' e 'The Shining'", "Entretenimento", "Difícil"),
            DictionaryWord("Akira Kurosawa", "Mestre cineasta japonês que realizou obras clássicas como 'Os Sete Samurais'", "Entretenimento", "Difícil"),
            DictionaryWord("Ennio Morricone", "Lendário maestro italiano compositor de bandas sonoras de westerns e cinema", "Entretenimento", "Difícil"),
            DictionaryWord("Orson Welles", "Cineasta genial que dirigiu e protagonizou 'Citizen Kane' aos 25 anos", "Entretenimento", "Difícil"),
            DictionaryWord("Studio Ghibli", "Estúdio de animação japonês cofundado pelo mestre Hayao Miyazaki", "Entretenimento", "Difícil"),
            DictionaryWord("Casablanca", "Clássico romântico do cinema de 1942 com Humphrey Bogart e Ingrid Bergman", "Entretenimento", "Difícil"),
            DictionaryWord("Metropolis", "Filme pioneiro de ficção científica futurista de 1927 realizado por Fritz Lang", "Entretenimento", "Difícil"),

            // ==================== 4. HISTÓRIA ====================
            // Fácil
            DictionaryWord("Império", "Vasto conjunto de nações e territórios dominados por um imperador", "História", "Fácil"),
            DictionaryWord("Coroa", "Ornamento metálico de pedras preciosas usado por monarcas e reis", "História", "Fácil"),
            DictionaryWord("Século", "Período temporal de cem anos de história", "História", "Fácil"),
            DictionaryWord("Cruzadas", "Expedições militares e religiosas medievais para recuperar a Terra Santa", "História", "Fácil"),
            DictionaryWord("Castelo", "Imponente fortaleza militar com muralhas e fosso construída na Idade Média", "História", "Fácil"),
            DictionaryWord("Rei", "Soberano masculino que governa uma monarquia vitalícia", "História", "Fácil"),
            DictionaryWord("Rainha", "Soberana feminina ou consorte de um monarca régio", "História", "Fácil"),
            DictionaryWord("Cavaleiro", "Guerreiro nobre medieval que combatia a cavalo com armadura e espada", "História", "Fácil"),
            DictionaryWord("Pirâmide", "Monumento monumental de pedra construído como túmulo pelos faraós", "História", "Fácil"),
            DictionaryWord("Faraó", "Título atribuído aos reis supremos do Antigo Egito divino", "História", "Fácil"),
            DictionaryWord("Gladiador", "Lutador armado que combatia perante multidões nas arenas do Coliseu de Roma", "História", "Fácil"),
            DictionaryWord("Trono", "Assento cerimonial suntuoso reservado aos reis e soberanos", "História", "Fácil"),
            DictionaryWord("Escudo", "Arma defensiva empunhada por guerreiros para bloquear flechas e golpes", "História", "Fácil"),
            DictionaryWord("Espada", "Arma branca laminada de corte e estocada utilizada em combates históricos", "História", "Fácil"),
            DictionaryWord("Batalha", "Combate bélico de grande escala travado entre forças militares opostas", "História", "Fácil"),
            DictionaryWord("Nobreza", "Classe social aristocrática detentora de títulos hereditários e privilégios", "História", "Fácil"),

            // Médio
            DictionaryWord("George Washington", "Primeiro Presidente eleito na história dos Estados Unidos da América", "História", "Médio"),
            DictionaryWord("Revolução dos Cravos", "Movimento militar de 25 de Abril de 1974 que restaurou a liberdade em Portugal", "História", "Médio"),
            DictionaryWord("Egípcia", "Civilização milenar do vale do Nilo célebre pela escrita hieroglífica e múmias", "História", "Médio"),
            DictionaryWord("Napoleão", "Imperador dos franceses e génio militar derrotado em Waterloo em 1815", "História", "Médio"),
            DictionaryWord("Revolução Francesa", "Marco histórico de 1789 com o lema Liberdade, Igualdade e Fraternidade", "História", "Médio"),
            DictionaryWord("Adolf Hitler", "Ditador que chefiou a Alemanha nazi responsável pela Segunda Guerra Mundial", "História", "Médio"),
            DictionaryWord("Waterloo", "Batalha decisiva de 1815 na Bélgica que selou o fim do domínio napoleónico", "História", "Médio"),
            DictionaryWord("Abraham Lincoln", "Presidente americano que aboliu a escravatura durante a Guerra Civil", "História", "Médio"),
            DictionaryWord("Winston Churchill", "Primeiro-Ministro britânico que liderou o Reino Unido na II Guerra Mundial", "História", "Médio"),
            DictionaryWord("Júlio César", "General e ditador romano assassinado nos Idos de Março de 44 a.C.", "História", "Médio"),
            DictionaryWord("Alexandre o Grande", "Rei da Macedónia que conquistou o Império Persa criando um vasto império", "História", "Médio"),
            DictionaryWord("Cleópatra", "A última rainha da dinastia ptolemaica do Antigo Egito", "História", "Médio"),
            DictionaryWord("Joana d'Arc", "Heroína e santa francesa que liderou tropas na Guerra dos Cem Anos", "História", "Médio"),
            DictionaryWord("Revolução Industrial", "Período iniciado no século XVIII com o surgimento da máquina a vapor", "História", "Médio"),
            DictionaryWord("Império Romano", "Uma das maiores potências do mundo antigo com centro em Roma", "História", "Médio"),
            DictionaryWord("Império Otomano", "Império islâmico que conquistou Constantinopla em 1453 sob Maomé II", "História", "Médio"),
            DictionaryWord("Guerra Fria", "Período de tensão geopolítica entre os blocos dos EUA e da União Soviética", "História", "Médio"),
            DictionaryWord("Muro de Berlim", "Barreira física símbolo da Guerra Fria cuja queda ocorreu em novembro de 1989", "História", "Médio"),

            // Difícil
            DictionaryWord("Rainha Vitória", "Monarca britânica cujo longo reinado marcou o apogeu da era industrial e império", "História", "Difícil"),
            DictionaryWord("Lenine", "Líder da fação bolchevique na Revolução Russa de 1917 e fundador da URSS", "História", "Difícil"),
            DictionaryWord("Carta Magna", "Documento histórico selado em 1215 que restringiu os poderes absolutos do rei inglês", "História", "Difícil"),
            DictionaryWord("Nicolau II", "O último czar da dinastia imperial Romanov deposto na Revolução Russa", "História", "Difícil"),
            DictionaryWord("Guerra Civil", "Conflito armado entre estados do Norte e do Sul dos EUA terminado em 1865", "História", "Difícil"),
            DictionaryWord("Dinastia Qin", "Primeira dinastia imperial da China que unificou o país e ergueu a Grande Muralha", "História", "Difícil"),
            DictionaryWord("Inca", "Império pré-colombiano andino que construiu a cidadela sagrada de Machu Picchu", "História", "Difícil"),
            DictionaryWord("César Augusto", "Primeiro imperador formal de Roma após a queda da República", "História", "Difícil"),
            DictionaryWord("Código de Hamurabi", "Um dos mais antigos conjuntos de leis escritas com o princípio de Talião", "História", "Difícil"),
            DictionaryWord("Batalha de Termópilas", "Célebre confronto em que 300 espartanos liderados por Leónidas travaram os persas", "História", "Difícil"),
            DictionaryWord("Péricles", "Estadista que liderou Atenas durante a Época de Ouro da democracia e Partenon", "História", "Difícil"),
            DictionaryWord("Carlos Magno", "Rei dos francos coroado Imperador do Sacro Império Romano no ano 800", "História", "Difícil"),
            DictionaryWord("Batalha de Hastings", "Batalha de 1066 que permitiu a conquista normanda de Inglaterra por Guilherme", "História", "Difícil"),
            DictionaryWord("Tratado de Vestefália", "Tratado de 1648 que encerrou a Guerra dos Trinta Anos e fundou a soberania estatal", "História", "Difícil"),
            DictionaryWord("Tratado de Versalhes", "Tratado de paz de 1919 que estabeleceu as sanções à Alemanha no pós-I Guerra", "História", "Difícil"),
            DictionaryWord("Conferência de Ialta", "Reunião de 1945 entre Churchill, Roosevelt e Estaline para reorganizar a Europa", "História", "Difícil"),

            // ==================== 5. ARTES E LITERATURA ====================
            // Fácil
            DictionaryWord("Pintura", "Arte visual de aplicar tintas e pigmentos coloridos numa superfície plana", "Artes e Literatura", "Fácil"),
            DictionaryWord("Soneto", "Estrutura poética clássica com 14 versos distribuídos em duas quadras e dois tercetos", "Artes e Literatura", "Fácil"),
            DictionaryWord("Teatro", "Arte de representação no palco de textos dramáticos perante plateia", "Artes e Literatura", "Fácil"),
            DictionaryWord("Poema", "Composição literária estruturada em versos, estrofes e ritmo poético", "Artes e Literatura", "Fácil"),
            DictionaryWord("Livro", "Conjunto de folhas encadernadas que contêm um texto literário ou científico", "Artes e Literatura", "Fácil"),
            DictionaryWord("Tela", "Superfície de tecido esticado sobre chassi usada para pintar quadros", "Artes e Literatura", "Fácil"),
            DictionaryWord("Museu", "Instituição dedicada a colecionar, preservar e expor obras de arte e história", "Artes e Literatura", "Fácil"),
            DictionaryWord("Escultura", "Arte tridimensional de modelar, esculpir em pedra, madeira ou fundir metal", "Artes e Literatura", "Fácil"),
            DictionaryWord("Conto", "Narrativa literária curta centrada num único acontecimento ou conflito", "Artes e Literatura", "Fácil"),
            DictionaryWord("Rima", "Semelhança ou identidade de sons no final de versos de uma poesia", "Artes e Literatura", "Fácil"),
            DictionaryWord("Pincel", "Instrumento formado por pelos ou cerdas preso a um cabo para pintar", "Artes e Literatura", "Fácil"),
            DictionaryWord("Estátua", "Obra escultórica figurativa representando uma figura humana ou deidade", "Artes e Literatura", "Fácil"),
            DictionaryWord("Romance", "Gênero narrativo em prosa longo e detalhado com múltiplas personagens", "Artes e Literatura", "Fácil"),
            DictionaryWord("Biblioteca", "Espaço público ou privado que reúne acervos de livros para leitura e pesquisa", "Artes e Literatura", "Fácil"),

            // Médio
            DictionaryWord("Miguel Ângelo", "Génio renascentista que esculpiu David e pintou o teto da Capela Sistina", "Artes e Literatura", "Médio"),
            DictionaryWord("Shakespeare", "Dramaturgo inglês mestre de 'Romeu e Julieta', 'Hamlet' e 'Macbeth'", "Artes e Literatura", "Médio"),
            DictionaryWord("Principezinho", "Obra-prima poética de Saint-Exupéry sobre a rosa, a raposa e o afeto", "Artes e Literatura", "Médio"),
            DictionaryWord("Leonardo da Vinci", "Polímata italiano pintor da célebre e enigmática 'Mona Lisa'", "Artes e Literatura", "Médio"),
            DictionaryWord("Cubismo", "Movimento de vanguarda que decompôs as formas em geometrias (ex: Picasso)", "Artes e Literatura", "Médio"),
            DictionaryWord("Cervantes", "Escritor espanhol autor do romance clássico 'Dom Quixote de la Mancha'", "Artes e Literatura", "Médio"),
            DictionaryWord("Edvard Munch", "Pintor expressionista norueguês que concebeu a famosa obra 'O Grito'", "Artes e Literatura", "Médio"),
            DictionaryWord("Rowling", "Escritora britânica que concebeu o universo mágico e os livros de Harry Potter", "Artes e Literatura", "Médio"),
            DictionaryWord("Vincent van Gogh", "Pintor pós-impressionista holandês autor de 'A Noite Estrelada'", "Artes e Literatura", "Médio"),
            DictionaryWord("Claude Monet", "Pintor francês pioneiro do Impressionismo célebre pelas 'Ninfeias'", "Artes e Literatura", "Médio"),
            DictionaryWord("Salvador Dalí", "Mestre do Surrealismo catalão autor dos relógios derretidos", "Artes e Literatura", "Médio"),
            DictionaryWord("Barroco", "Estilo artístico do século XVII marcado por chiaroscuro, drama e exuberância", "Artes e Literatura", "Médio"),
            DictionaryWord("Impressionismo", "Movimento focado na luz natural fugaz e pinceladas livres ao ar livre", "Artes e Literatura", "Médio"),
            DictionaryWord("Surrealismo", "Vanguarda artística e literária que explorava o inconsciente e o mundo dos sonhos", "Artes e Literatura", "Médio"),
            DictionaryWord("Victor Hugo", "Escritor do Romantismo francês autor de 'Os Miseráveis' e 'Nossa Senhora de Paris'", "Artes e Literatura", "Médio"),
            DictionaryWord("Jane Austen", "Romancista britânica autora das obras 'Orgulho e Preconceito' e 'Emma'", "Artes e Literatura", "Médio"),

            // Difícil
            DictionaryWord("Guernica", "Monumento pictórico de Picasso denunciando o bombardeamento na Guerra Civil", "Artes e Literatura", "Difícil"),
            DictionaryWord("Ricardo Reis", "Heterónimo clássico de Fernando Pessoa de filosofia pagã e estóica", "Artes e Literatura", "Difícil"),
            DictionaryWord("Dante", "Poeta florentino autor da épica 'Divina Comédia' pelo Inferno, Purgatório e Paraíso", "Artes e Literatura", "Difícil"),
            DictionaryWord("Auguste Rodin", "Escultor francês que moldou as obras monumentais 'O Pensador' e 'O Beijo'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Museu do Louvre", "Antigo palácio real em Paris e museu mais visitado com a Vénus de Milo", "Artes e Literatura", "Difícil"),
            DictionaryWord("Dostoiévski", "Romancista russo explorador da alma humana em 'Crime e Castigo' e 'Os Irmãos Karamazov'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Estilo Gótico", "Arquitetura medieval com arcos quebrados, abóbadas de cruzaria e vitrais coloridos", "Artes e Literatura", "Difícil"),
            DictionaryWord("García Márquez", "Prémio Nobel colombiano criador de Macondo em 'Cem Anos de Solidão'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Florbela Espanca", "Poetisa alentejana pioneira dos mais ardentes sonetos da língua portuguesa", "Artes e Literatura", "Difícil"),
            DictionaryWord("Lev Tolstói", "Gigante da literatura russa autor dos clássicos 'Guerra e Paz' e 'Anna Karenina'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Franz Kafka", "Escritor de Praga autor do conto surrealista 'A Metamorfose' e de 'O Processo'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Marcel Proust", "Escritor francês monumental autor de 'Em Busca do Tempo Perdido'", "Artes e Literatura", "Difícil"),
            DictionaryWord("James Joyce", "Escritor irlandês vanguardista autor do revolucionário romance 'Ulisses'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Virginia Woolf", "Escritora modernista britânica pioneira do fluxo de consciência em 'Mrs. Dalloway'", "Artes e Literatura", "Difícil"),
            DictionaryWord("Caravaggio", "Mestre barroco da pintura a óleo célebre pelo uso radical de luz e trevas", "Artes e Literatura", "Difícil"),
            DictionaryWord("Johannes Vermeer", "Pintor holandês do século de ouro mestre do quadro 'Rapariga com Brinco de Pérola'", "Artes e Literatura", "Difícil"),

            // ==================== 6. CIÊNCIAS E NATUREZA ====================
            // Fácil
            DictionaryWord("Água", "Composto químico H2O em estado líquido vital para todas as formas de vida", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Célula", "A menor unidade estrutural, funcional e biológica de todos os seres vivos", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Sol", "Estrela central de plasma incandescente em torno da qual orbitam os planetas", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Lua", "O único satélite natural rochoso em órbita do planeta Terra", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Planeta", "Corpo celeste esférico que orbita uma estrela e limpou a sua órbita", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Terra", "O terceiro planeta a contar do Sol e o único conhecido com oceanos e vida", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Estrela", "Corpo celeste massivo e luminoso de plasma que produz luz por fusão nuclear", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Planta", "Organismo vegetal fotossintético pluricelular com clorofila", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Animal", "Organismo vivo heterotrófico multicelular com capacidade de locomoção", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Árvore", "Planta lenhosa perene com tronco principal elevado e copa de ramagens", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Flor", "Estrutura reprodutiva das plantas angiospérmicas com pétalas coloridas", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Rocha", "Agregado sólido natural formado por um ou vários tipos de minerais", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Vento", "Movimento do ar atmosférico gerado por diferenças de pressão e temperatura", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Chuva", "Precipitação líquida de gotas de água a partir de nuvens condensadas", "Ciências e Natureza", "Fácil"),
            DictionaryWord("Energia", "Capacidade física de realizar trabalho, gerar calor ou produzir movimento", "Ciências e Natureza", "Fácil"),

            // Médio
            DictionaryWord("Mercúrio", "O planeta rochoso mais veloz e próximo do Sol no Sistema Solar", "Ciências e Natureza", "Médio"),
            DictionaryWord("Esqueleto", "Estrutura óssea articulada de 206 ossos que sustenta o corpo humano", "Ciências e Natureza", "Médio"),
            DictionaryWord("Oxigénio", "Elemento químico diatómico essencial à respiração aeróbia de animais e humanos", "Ciências e Natureza", "Médio"),
            DictionaryWord("Júpiter", "O maior planeta gigante gasoso com a célebre Grande Mancha Vermelha", "Ciências e Natureza", "Médio"),
            DictionaryWord("Albert Einstein", "Físico que revolucionou o pensamento humano com a Teoria da Relatividade", "Ciências e Natureza", "Médio"),
            DictionaryWord("Velocidade da Luz", "Constante universal fundamental de cerca de 300.000 km por segundo no vácuo", "Ciências e Natureza", "Médio"),
            DictionaryWord("Botânica", "Ramo científico da biologia focado na morfologia e fisiologia das plantas", "Ciências e Natureza", "Médio"),
            DictionaryWord("Atmosfera", "Camada protetora de gases retida pela gravidade em torno da Terra", "Ciências e Natureza", "Médio"),
            DictionaryWord("Vénus", "Segundo planeta do Sistema Solar com atmosfera densa de efeito de estufa", "Ciências e Natureza", "Médio"),
            DictionaryWord("Marte", "O Planeta Vermelho que possui o Monte Olimpo e vales fluviais secos", "Ciências e Natureza", "Médio"),
            DictionaryWord("Saturno", "Planeta gigante gasoso rodeado por um espetacular sistema de anéis de gelo", "Ciências e Natureza", "Médio"),
            DictionaryWord("Hidrogénio", "O elemento químico mais abundante e leve de todo o universo observável", "Ciências e Natureza", "Médio"),
            DictionaryWord("Carbono", "Elemento químico tetravalente base de toda a química orgânica e da vida", "Ciências e Natureza", "Médio"),
            DictionaryWord("Isaac Newton", "Físico e matemático inglês que formulou a Lei da Gravitação Universal", "Ciências e Natureza", "Médio"),
            DictionaryWord("Galileu Galilei", "Astrónomo que usou a luneta para descobrir as quatro luas de Júpiter", "Ciências e Natureza", "Médio"),
            DictionaryWord("Marie Curie", "Pioneira nos estudos da radioatividade e primeira mulher a vencer dois Nobéis", "Ciências e Natureza", "Médio"),
            DictionaryWord("Fotossíntese", "Processo bioquímico em que plantas convertem luz solar em energia química", "Ciências e Natureza", "Médio"),
            DictionaryWord("Ecossistema", "Comunidade de seres vivos interagindo com os elementos físicos do ambiente", "Ciências e Natureza", "Médio"),

            // Difícil
            DictionaryWord("Fígado", "A maior glândula do corpo com mais de 500 funções metabólicas e digestivas", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Tabela Periódica", "Disposição ordenada de todos os 118 elementos químicos conhecidos por número atómico", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Gravidade", "Interação fundamental da matéria descrita pela curvatura do espaço-tempo", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Fleming", "Cientista escocês que descobriu o primeiro antibiótico penicilina em 1928", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Crusta", "A camada sólida e rochosa mais externa e fina da estrutura da Terra", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Glóbulos", "Células sanguíneas especializadas no transporte de gases ou defesa imune", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Ohm", "Unidade de medida de resistência elétrica no Sistema Internacional", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Charles Darwin", "Naturalista britânico formulador da evolução das espécies por seleção natural", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Baleia-azul", "O maior mamífero marinho e o maior animal de que há registo na Terra", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Termodinâmica", "Ramo da física que estuda as relações entre calor, trabalho, energia e entropia", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Mecânica Quântica", "Teoria física que descreve o comportamento da matéria à escala subatómica", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Bóson de Higgs", "Partícula elementar que confere massa a outras partículas no Modelo Padrão", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Mitocôndria", "Organelo celular responsável pela cadeia respiratória e produção de ATP", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Ribossoma", "Complexo celular responsável pela síntese e tradução de proteínas", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Cloroplasto", "Organelo vegetal que contém clorofila onde decorre a fotossíntese", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Placas Tectónicas", "Grandes blocos rochosos da litosfera que flutuam sobre a astenosfera", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Buraco Negro", "Região do espaço-tempo com campo gravítico tão intenso que nada escapa", "Ciências e Natureza", "Difícil"),
            DictionaryWord("Supernova", "Explosão estelar colossal e luminosa no fim da vida de uma estrela massiva", "Ciências e Natureza", "Difícil"),

            // ==================== 7. DESPORTO E LAZER ====================
            // Fácil
            DictionaryWord("Golfe", "Desporto com tacos de precisão cujo objetivo é colocar a bola em 18 buracos", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Natação", "Modalidade aquática de propulsão e velocidade em piscina de estilos variados", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Ténis", "Desporto de raquete disputado individualmente ou em pares num court com rede", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Futebol", "Desporto coletivo rei jogado por duas equipas de 11 jogadores com uma bola", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Bola", "Objeto esférico essencial para a prática de múltiplos desportos mundiais", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Corrida", "Prova atlética pedestre de velocidade ou resistência em pista ou estrada", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Golo", "O ponto máximo marcado quando a bola ultrapassa a linha da baliza no futebol", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Baliza", "Estrutura retangular composta por dois postes e uma barra defendida pelo guarda-redes", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Estádio", "Grande recinto com bancadas onde decorrem jogos de futebol e atletismo", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Raquete", "Instrumento com aro e cordas cruzadas usado no ténis e badminton", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Ginásio", "Espaço equipado com aparelhos e pesos para treino físico e musculação", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Piscina", "Tanque de água construído para competições de natação e saltos para a água", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Bicicleta", "Veículo de duas rodas movido por pedais usado no ciclismo de estrada e montanha", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Xadrez", "Jogo de tabuleiro milenar de estratégia jogado com 32 peças brancas e pretas", "Desporto e Lazer", "Fácil"),
            DictionaryWord("Troféu", "Taça concedida aos vencedores de campeonatos e competições desportivas", "Desporto e Lazer", "Fácil"),

            // Médio
            DictionaryWord("Jogos Olímpicos", "O maior evento multidesportivo mundial realizado de quatro em quatro anos", "Desporto e Lazer", "Médio"),
            DictionaryWord("Badminton", "Desporto de raquete e volante de penas disputado em campo com rede alta", "Desporto e Lazer", "Médio"),
            DictionaryWord("Judô", "Arte marcial e modalidade olímpica de combate japonês com projeções", "Desporto e Lazer", "Médio"),
            DictionaryWord("Camisola Amarela", "Camisola envergada pelo líder da classificação geral no Tour de France", "Desporto e Lazer", "Médio"),
            DictionaryWord("Cinco Anéis", "Símbolo olímpico mundial que representa a união dos cinco continentes", "Desporto e Lazer", "Médio"),
            DictionaryWord("Basquetebol", "Modalidade de cesto jogada por cinco jogadores de cada lado", "Desporto e Lazer", "Médio"),
            DictionaryWord("Bowling", "Jogo de pontaria no qual se lança uma bola com furos para derrubar 10 pinos", "Desporto e Lazer", "Médio"),
            DictionaryWord("Campeonato", "Torneio ou prova competitiva regular disputada para apurar o campeão", "Desporto e Lazer", "Médio"),
            DictionaryWord("Liga dos Campeões", "A mais prestigiada competição de clubes de futebol da Europa da UEFA", "Desporto e Lazer", "Médio"),
            DictionaryWord("Tour de France", "A mais emblemática prova ciclística por etapas em território francês", "Desporto e Lazer", "Médio"),
            DictionaryWord("Fórmula 1", "Categoria rainha do desporto automóvel mundial com monolugares velozes", "Desporto e Lazer", "Médio"),
            DictionaryWord("Ginástica Artística", "Modalidade olímpica acrobática em aparelhos como solo, trave e argolas", "Desporto e Lazer", "Médio"),
            DictionaryWord("Karaté", "Arte marcial japonesa focada em golpes de percussão como socos e pontapés", "Desporto e Lazer", "Médio"),
            DictionaryWord("Voleibol", "Desporto jogado com as mãos e braços por cima de uma rede divisória", "Desporto e Lazer", "Médio"),
            DictionaryWord("Andebol", "Desporto coletivo de pavilhão onde a bola é jogada exclusivamente com as mãos", "Desporto e Lazer", "Médio"),
            DictionaryWord("Hóquei em Patins", "Modalidade sobre patins tradicional em Portugal jogada com stick e bola", "Desporto e Lazer", "Médio"),
            DictionaryWord("Lionel Messi", "Astro argentino do futebol vencedor de oito Bolas de Ouro e do Mundial 2022", "Desporto e Lazer", "Médio"),
            DictionaryWord("Pelé", "O lendário 'Rei do Futebol' tricampeão mundial com a seleção brasileira", "Desporto e Lazer", "Médio"),
            DictionaryWord("Roger Federer", "Tenista suíço recordista de elegância e 20 títulos do Grand Slam", "Desporto e Lazer", "Médio"),

            // Difícil
            DictionaryWord("Usain Bolt", "Velocista jamaicano detentor do recorde mundial dos 100 e 200 metros rasos", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Atenas", "Capital grega onde se realizaram os primeiros Jogos Olímpicos da era moderna em 1896", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Grand Slam", "Designação dos quatro maiores torneios de ténis: Austrália, Roland Garros, Wimbledon e US Open", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Larry O'Brien", "Troféu dourado entregue à franquia vencedora das finais anuais da NBA", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Maratona", "Prova de resistência máxima com a distância oficial de 42,195 quilómetros", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Taça Davis", "A mais antiga competição anual internacional por seleções de ténis masculino", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Ayrton Senna", "Piloto brasileiro tricampeão de Fórmula 1 lembrado pelo seu génio sob chuva", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Capoeira", "Expressão cultural e arte marcial acrobática brasileira acompanhada por berimbau", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Dardos", "Jogo de arremesso a alvo com pontuação máxima de 180 pontos em três tentativas", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Decatlo", "Exigente competição de atletismo masculino composta por dez disciplinas distintas", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Pentatlo Moderno", "Modalidade olímpica que junta esgrima, natação, hipismo, tiro e corrida", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Wimbledon", "O mais antigo torneio de ténis disputado em pisos de relva natural em Londres", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Roland Garros", "Torneio parisiense do Grand Slam jogado em terra batida", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Le Mans", "Célebre corrida automobilística de resistência disputada durante 24 horas consecutivas", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Spa-Francorchamps", "Histórico circuito belga de Fórmula 1 célebre pela curva Eau Rouge", "Desporto e Lazer", "Difícil"),
            DictionaryWord("Jesse Owens", "Atleta negro norte-americano que venceu quatro medalhas de ouro em Berlim 1936", "Desporto e Lazer", "Difícil"),

            // ==================== 8. SAÚDE E CORPO ====================
            // Fácil
            DictionaryWord("Dente", "Estrutura óssea dura fixada nos maxilares usada para mastigar os alimentos", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Osso", "Estrutura rígida e mineralizada constituinte do esqueleto humano", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Pele", "O maior órgão do corpo humano que funciona como barreira protetora", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Veia", "Vaso sanguíneo que transporta o sangue de volta aos átrios do coração", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Sangue", "Fluido biológico vital composto por plasma, eritrócitos, leucócitos e plaquetas", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Olho", "Órgão sensorial da visão responsável pela captação da luz e imagens", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Ouvido", "Órgão sensorial responsável pela audição e pelo equilíbrio postural", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Nariz", "Órgão da respiração e do olfato situado no centro da face", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Boca", "Cavidade inicial do aparelho digestivo com dentes e língua", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Coração", "Órgão muscular oco que funciona como bomba no sistema circulatório", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Estômago", "Órgão do aparelho digestivo onde os alimentos são misturados com ácido gástrico", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Pulmão", "Órgão torácico duplo esponjoso encarregado das trocas gasosas de oxigénio", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Cérebro", "Centro de controlo do sistema nervoso localizado no interior do crânio", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Músculo", "Tecido corporal com capacidade de contração que produz movimento", "Saúde e Corpo", "Fácil"),
            DictionaryWord("Joelho", "Maior e mais complexa articulação do corpo entre a coxa e a perna", "Saúde e Corpo", "Fácil"),

            // Médio
            DictionaryWord("Eritrócito", "Glóbulo vermelho do sangue responsável pelo transporte de oxigénio", "Saúde e Corpo", "Médio"),
            DictionaryWord("Leucócito", "Glóbulo branco do sangue responsável pela defesa e imunidade", "Saúde e Corpo", "Médio"),
            DictionaryWord("Bucinador", "Músculo da bochecha auxiliar na mastigação e no sopro", "Saúde e Corpo", "Médio"),
            DictionaryWord("Esmalte", "Camada externa altamente mineralizada e protetora da coroa do dente", "Saúde e Corpo", "Médio"),
            DictionaryWord("Gengiva", "Tecido mucoso fibroso que envolve o colo dos dentes e recobre o osso alveolar", "Saúde e Corpo", "Médio"),
            DictionaryWord("Sintoma", "Manifestação subjetiva sentida pelo doente indicadora de uma patologia", "Saúde e Corpo", "Médio"),
            DictionaryWord("Artéria", "Vaso sanguíneo que conduz o sangue oxigenado e sob pressão a partir do coração", "Saúde e Corpo", "Médio"),
            DictionaryWord("Diabetes", "Doença metabólica crónica caraterizada por níveis elevados de glicose no sangue", "Saúde e Corpo", "Médio"),
            DictionaryWord("Glucose", "Principal açúcar monossacarídeo que constitui a fonte primária de energia celular", "Saúde e Corpo", "Médio"),
            DictionaryWord("Trombócito", "Fragmento celular sanguíneo (plaqueta) essencial para a coagulação do sangue", "Saúde e Corpo", "Médio"),
            DictionaryWord("Capilar", "Vaso microscópico que permite a troca de nutrientes e gases entre sangue e tecidos", "Saúde e Corpo", "Médio"),
            DictionaryWord("Rim", "Órgão par em forma de feijão encarregado de filtrar o sangue e produzir urina", "Saúde e Corpo", "Médio"),
            DictionaryWord("Pâncreas", "Glândula mista que produz enzimas digestivas e as hormonas insulina e glucagon", "Saúde e Corpo", "Médio"),
            DictionaryWord("Neurónio", "Célula especializada do sistema nervoso encarregada de transmitir impulsos elétricos", "Saúde e Corpo", "Médio"),
            DictionaryWord("Sinapse", "Região de comunicação química ou elétrica entre dois neurónios adjacentes", "Saúde e Corpo", "Médio"),
            DictionaryWord("Hemoglobina", "Proteína presente nos eritrócitos que transporta o oxigénio dos pulmões aos tecidos", "Saúde e Corpo", "Médio"),
            DictionaryWord("Insulina", "Hormona segregada pelas células beta do pâncreas que reduz a glicemia", "Saúde e Corpo", "Médio"),
            DictionaryWord("Anticorpo", "Proteína de defesa produzida pelo sistema imunitário contra antigénios invasores", "Saúde e Corpo", "Médio"),
            DictionaryWord("Vacina", "Preparação biológica administrada para estimular imunidade adquirida contra doenças", "Saúde e Corpo", "Médio"),

            // Difícil
            DictionaryWord("Mitocôndria", "Organelo celular responsável pela fosforilação oxidativa e respiração", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Sarcoplasma", "O citoplasma especializado presente no interior das fibras musculares estriadas", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Anafilaxia", "Reação alérgica sistémica hiperaguda grave e potencialmente letal", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Idiopático", "Termo médico que designa uma doença ou distúrbio de causa desconhecida", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Miocárdio", "A espessa camada muscular média da parede cardíaca responsável pelo batimento", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Pericárdio", "Membrana serosa de camada dupla que envolve e protege externamente o coração", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Hipotálamo", "Região do encéfalo que regula a temperatura, fome, sede e o sistema endócrino", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Cerebelo", "Parte do encéfalo crucial para a coordenação motora, equilíbrio e postura corporal", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Glândula Pineal", "Pequena glândula endócrina cerebral produtora da hormona melatonina", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Tiroideia", "Glândula na base anterior do pescoço reguladora do ritmo metabólico basal", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Isquemia", "Restrição ou interrupção do suprimento sanguíneo a um determinado tecido ou órgão", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Homeostase", "Estado de equilíbrio e constância dinâmico do meio interno do organismo", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Hematopoiese", "Processo biológico contínuo de formação e maturação das células do sangue na medula", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Fagocitose", "Processo em que certas células imunitárias englobam e destroem microrganismos", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Apoptose", "Processo genético regulado de morte celular programada no organismo", "Saúde e Corpo", "Difícil"),
            DictionaryWord("Sinovial", "Fluido viscoso presente no interior das cavidades articulares que lubrifica as superfícies", "Saúde e Corpo", "Difícil"),

            // ==================== 9. CULTURA GERAL ====================
            // Fácil
            DictionaryWord("Jogo", "Atividade lúdica ou desportiva sujeita a regras com objetivo recreativo", "Cultura Geral", "Fácil"),
            DictionaryWord("Casa", "Edifício ou habitação construída para residência de pessoas", "Cultura Geral", "Fácil"),
            DictionaryWord("Luz", "Radiação eletromagnética visível que permite iluminar os objetos e ver", "Cultura Geral", "Fácil"),
            DictionaryWord("Livro", "Obra impressa ou digital com conjunto encadernado de páginas", "Cultura Geral", "Fácil"),
            DictionaryWord("Regra", "Preceito, norma ou princípio que orienta o comportamento ou o jogo", "Cultura Geral", "Fácil"),
            DictionaryWord("Família", "Grupo de pessoas unidas por laços de parentesco consanguíneo ou afetivo", "Cultura Geral", "Fácil"),
            DictionaryWord("Escola", "Instituição destinada ao ensino, aprendizagem e educação de alunos", "Cultura Geral", "Fácil"),
            DictionaryWord("Cidade", "Grande aglomerado populacional urbano com infraestruturas e serviços", "Cultura Geral", "Fácil"),
            DictionaryWord("Ponte", "Construção de engenharia que permite transpor um rio, vale ou obstáculo", "Cultura Geral", "Fácil"),
            DictionaryWord("Relógio", "Instrumento ou aparelho utilizado para medir e indicar as horas do dia", "Cultura Geral", "Fácil"),
            DictionaryWord("Dinheiro", "Meio padrão de troca legalmente aceite para compra de bens e serviços", "Cultura Geral", "Fácil"),
            DictionaryWord("Amizade", "Relação de afeto, lealdade e apreço mútuo entre seres humanos", "Cultura Geral", "Fácil"),
            DictionaryWord("Trabalho", "Atividade física ou intelectual exercida para atingir um objetivo ou remuneração", "Cultura Geral", "Fácil"),
            DictionaryWord("Paz", "Estado de tranquilidade, concórdia e ausência de conflitos bélicos", "Cultura Geral", "Fácil"),
            DictionaryWord("Verdade", "Conformidade rigorosa entre o que é afirmado e a realidade factual", "Cultura Geral", "Fácil"),

            // Médio
            DictionaryWord("Lógica", "Ramo da filosofia e matemática que estuda os princípios do raciocínio válido", "Cultura Geral", "Médio"),
            DictionaryWord("Ciência", "Corpo de conhecimento empírico sistemático obtido por observação e testes", "Cultura Geral", "Médio"),
            DictionaryWord("Política", "Arte e prática da governação, administração pública e tomada de decisões", "Cultura Geral", "Médio"),
            DictionaryWord("Economia", "Ciência social que estuda a produção, distribuição e consumo de bens escassos", "Cultura Geral", "Médio"),
            DictionaryWord("Justiça", "Princípio moral e judicial que assegura a cada um o que lhe pertence por direito", "Cultura Geral", "Médio"),
            DictionaryWord("Filosofia", "Investigação crítica sobre a existência, o conhecimento, a mente e a moral", "Cultura Geral", "Médio"),
            DictionaryWord("Democracia", "Regime político onde o poder soberano reside no povo através do voto livre", "Cultura Geral", "Médio"),
            DictionaryWord("Constituição", "Lei fundamental e suprema que rege a organização jurídica e política de um Estado", "Cultura Geral", "Médio"),
            DictionaryWord("Cidadania", "Conjunto de direitos cívicos e políticos e deveres exercidos pelos indivíduos", "Cultura Geral", "Médio"),
            DictionaryWord("Psicologia", "Ciência que estuda o comportamento, os processos mentais e as emoções humanas", "Cultura Geral", "Médio"),
            DictionaryWord("Sociologia", "Estudo científico das relações sociais, instituições e estruturas da sociedade", "Cultura Geral", "Médio"),
            DictionaryWord("Arqueologia", "Ciência que investiga o passado humano através do estudo de vestígios materiais", "Cultura Geral", "Médio"),
            DictionaryWord("Património", "Conjunto de bens culturais, históricos ou naturais herdados e transmitidos", "Cultura Geral", "Médio"),
            DictionaryWord("Arquitetura", "Arte e técnica de conceber, projetar e construir edifícios e espaços urbanos", "Cultura Geral", "Médio"),
            DictionaryWord("Linguística", "Estudo científico da linguagem humana, gramática, fonética e evolução das línguas", "Cultura Geral", "Médio"),
            DictionaryWord("Ética", "Reflexão filosófica sobre os princípios morais que regem a conduta humana", "Cultura Geral", "Médio"),
            DictionaryWord("Solidariedade", "Sentimento e atitude de entreajuda, partilha e apoio mútuo em sociedade", "Cultura Geral", "Médio"),

            // Difícil
            DictionaryWord("Pragmático", "Atitude orientada para os resultados práticos, eficácia e utilidade concreta", "Cultura Geral", "Difícil"),
            DictionaryWord("Resiliência", "Capacidade de se recuperar de situações adversas, traumas ou pressões", "Cultura Geral", "Difícil"),
            DictionaryWord("Nepotismo", "Prática ilegítima de concessão de empregos ou favores a familiares e amigos", "Cultura Geral", "Difícil"),
            DictionaryWord("Paradoxo", "Proposição ou raciocínio aparentemente contraditório que desafia o senso comum", "Cultura Geral", "Difícil"),
            DictionaryWord("Maiêutica", "Método socrático de interrogação pedagógica para fazer nascer ideias na mente", "Cultura Geral", "Difícil"),
            DictionaryWord("Silogismo", "Raciocínio dedutivo clássico estruturado com premissa maior, menor e conclusão", "Cultura Geral", "Difícil"),
            DictionaryWord("Dialética", "Método filosófico de debate e síntese a partir do confronto de ideias opostas", "Cultura Geral", "Difícil"),
            DictionaryWord("Hermenêutica", "Teoria e método filosófico de interpretação de textos literários, jurídicos ou sagrados", "Cultura Geral", "Difícil"),
            DictionaryWord("Fenomenologia", "Corrente filosófica focada no estudo das estruturas da consciência e dos fenómenos", "Cultura Geral", "Difícil"),
            DictionaryWord("Existencialismo", "Doutrina que postula que a existência precede a essência e a liberdade individual", "Cultura Geral", "Difícil"),
            DictionaryWord("Empirismo", "Teoria epistemológica que defende que todo o conhecimento provém da experiência", "Cultura Geral", "Difícil"),
            DictionaryWord("Racionalismo", "Corrente filosófica que considera a razão humana a fonte primordial do saber", "Cultura Geral", "Difícil"),
            DictionaryWord("Utilitarismo", "Doutrina ética que defende a maximização da felicidade para o maior número de seres", "Cultura Geral", "Difícil"),
            DictionaryWord("Solipsismo", "Conceção filosófica de que apenas o próprio eu e a sua mente têm existência comprovada", "Cultura Geral", "Difícil"),
            DictionaryWord("Idiossincrasia", "Caraterística comportamental, física ou temperamental peculiar de um indivíduo", "Cultura Geral", "Difícil"),
            DictionaryWord("Epifania", "Momento súbito de revelação, iluminação espiritual ou compreensão profunda", "Cultura Geral", "Difícil"),
            DictionaryWord("Catarse", "Libertação ou purificação das emoções e tensões através da arte ou experiência dramática", "Cultura Geral", "Difícil")
        )
    }

    fun getInitialPuzzles(): List<Puzzle> {
        val puzzles = mutableListOf<Puzzle>()

        fun addPrebuilt(
            id: String,
            title: String,
            difficulty: String,
            category: String,
            gridSize: Int,
            candidates: List<CandidateWord>
        ) {
            val p = CrosswordGenerator.generateCrossword(
                title = title,
                difficulty = difficulty,
                category = category,
                targetWidth = gridSize,
                targetHeight = gridSize,
                wordPool = candidates,
                customId = id
            )
            if (p != null) {
                puzzles.add(p)
            }
        }

        // ==================== 1. PORTUGAL ====================
        addPrebuilt(
            id = "portugal_facil",
            title = "Portugal - Símbolos e Tradições",
            difficulty = "Fácil",
            category = "Portugal",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Lisboa", "LISBOA", "Capital de Portugal à beira do Tejo", "Portugal"),
                CandidateWord("Porto", "PORTO", "Cidade Invicta com as famosas pontes", "Portugal"),
                CandidateWord("Fado", "FADO", "Estilo musical tradicional português", "Portugal"),
                CandidateWord("Douro", "DOURO", "Rio vinícola que desagua no Porto", "Portugal"),
                CandidateWord("Minho", "MINHO", "Região verdejante a norte de Portugal", "Portugal"),
                CandidateWord("Bacalhau", "BACALHAU", "Prato de peixe seco tradicional", "Portugal"),
                CandidateWord("Sardinha", "SARDINHA", "Peixe assado típico dos Santos Populares", "Portugal"),
                CandidateWord("Sintra", "SINTRA", "Vila e serra mágica perto de Lisboa", "Portugal")
            )
        )

        addPrebuilt(
            id = "portugal_medio",
            title = "Portugal - História e Monumentos",
            difficulty = "Médio",
            category = "Portugal",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Coimbra", "COIMBRA", "Cidade universitária com o rio Mondego", "Portugal"),
                CandidateWord("Guimarães", "GUIMARAES", "Cidade Berço onde nasceu a nação", "Portugal"),
                CandidateWord("Manuelino", "MANUELINO", "Estilo arquitetónico marítimo luso", "Portugal"),
                CandidateWord("Algarve", "ALGARVE", "Região a sul famosa pelas praias", "Portugal"),
                CandidateWord("Alentejo", "ALENTEJO", "Planície a sul do Tejo com azeite", "Portugal"),
                CandidateWord("Azulejos", "AZULEJOS", "Placas cerâmicas decorativas tradicionais", "Portugal"),
                CandidateWord("Sobreiro", "SOBREIRO", "Árvore de onde se extrai a cortiça", "Portugal"),
                CandidateWord("Caravela", "CARAVELA", "Navio ágil da Era dos Descobrimentos", "Portugal"),
                CandidateWord("Braga", "BRAGA", "Cidade dos Arcebispos com o Bom Jesus", "Portugal"),
                CandidateWord("Madeira", "MADEIRA", "Ilha do arquipélago com o Funchal", "Portugal")
            )
        )

        addPrebuilt(
            id = "portugal_dificil",
            title = "Portugal - Cultura e Herança Erudita",
            difficulty = "Difícil",
            category = "Portugal",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Vasco da Gama", "VASCO#DA#GAMA", "Navegador que descobriu o caminho marítimo para a Índia", "Portugal"),
                CandidateWord("Torre de Belém", "TORRE#DE#BELEM", "Monumento e fortaleza manuelina no rio Tejo", "Portugal"),
                CandidateWord("Aljubarrota", "ALJUBARROTA", "Batalha de 1385 que garantiu a independência", "Portugal"),
                CandidateWord("Francesinha", "FRANCESINHA", "Iguaria portuense de carnes e molho picante", "Portugal"),
                CandidateWord("Tordesilhas", "TORDESILHAS", "Tratado de 1494 que dividiu o Novo Mundo", "Portugal"),
                CandidateWord("Saramago", "SARAMAGO", "Prémio Nobel da Literatura português de 1998", "Portugal"),
                CandidateWord("Eça de Queirós", "ECA#DE#QUEIROS", "Escritor realista autor de romances célebres", "Portugal"),
                CandidateWord("Regicídio", "REGICIDIO", "Atentado de 1908 que vitimou o Rei D. Carlos I", "Portugal"),
                CandidateWord("Alcanizes", "ALCANIZES", "Tratado de 1297 que fixou as fronteiras de Portugal", "Portugal"),
                CandidateWord("Fernão Lopes", "FERNAO#LOPES", "Primeiro grande cronista da história lusa", "Portugal")
            )
        )

        // ==================== 2. GEOGRAFIA ====================
        addPrebuilt(
            id = "geografia_facil",
            title = "Geografia - Países e Capitais",
            difficulty = "Fácil",
            category = "Geografia",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Espanha", "ESPANHA", "País ibérico vizinho de Portugal", "Geografia"),
                CandidateWord("França", "FRANCA", "País europeu com capital em Paris", "Geografia"),
                CandidateWord("Brasil", "BRASIL", "Maior país lusófono da América do Sul", "Geografia"),
                CandidateWord("Roma", "ROMA", "Capital histórica da Itália", "Geografia"),
                CandidateWord("Alpes", "ALPES", "Cordilheira montanhosa no centro da Europa", "Geografia"),
                CandidateWord("Londres", "LONDRES", "Capital do Reino Unido no Tamisa", "Geografia"),
                CandidateWord("Tóquio", "TOQUIO", "Capital e metrópole do Japão", "Geografia"),
                CandidateWord("Nilo", "NILO", "Rio emblemático do Antigo Egito", "Geografia")
            )
        )

        addPrebuilt(
            id = "geografia_medio",
            title = "Geografia - Mares, Rios e Continentes",
            difficulty = "Médio",
            category = "Geografia",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Camberra", "CAMBERRA", "Capital federal da Austrália", "Geografia"),
                CandidateWord("Pacífico", "PACIFICO", "O maior e mais profundo oceano do mundo", "Geografia"),
                CandidateWord("Tamisa", "TAMISA", "Rio que atravessa a cidade de Londres", "Geografia"),
                CandidateWord("Rússia", "RUSSIA", "O país mais extenso da Europa e Ásia", "Geografia"),
                CandidateWord("Saara", "SAARA", "Maior deserto quente no continente africano", "Geografia"),
                CandidateWord("Sicília", "SICILIA", "A maior ilha do Mar Mediterrâneo", "Geografia"),
                CandidateWord("Canadá", "CANADA", "País com a maior linha de costa do mundo", "Geografia"),
                CandidateWord("Luanda", "LUANDA", "Capital e porto principal de Angola", "Geografia"),
                CandidateWord("Danúbio", "DANUBIO", "Rio europeu que atravessa quatro capitais", "Geografia"),
                CandidateWord("Andes", "ANDES", "Longa cordilheira na América do Sul", "Geografia")
            )
        )

        addPrebuilt(
            id = "geografia_dificil",
            title = "Geografia - Extremos e Relevos Globais",
            difficulty = "Difícil",
            category = "Geografia",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Cazaquistão", "CAZAQUISTAO", "Maior país do mundo sem acesso ao mar", "Geografia"),
                CandidateWord("Gibraltar", "GIBRALTAR", "Estreito que separa Espanha de Marrocos", "Geografia"),
                CandidateWord("Marianas", "MARIANAS", "Fossa mais profunda conhecida nos oceanos", "Geografia"),
                CandidateWord("Suriname", "SURINAME", "País menos populoso da América do Sul", "Geografia"),
                CandidateWord("Brunei", "BRUNEI", "País que partilha a ilha de Bornéu", "Geografia"),
                CandidateWord("Atacama", "ATACAMA", "Deserto árido situado no norte do Chile", "Geografia"),
                CandidateWord("Helsínquia", "HELSINQUIA", "Capital da Finlândia banhada pelo Báltico", "Geografia"),
                CandidateWord("Ulan Bator", "ULAN#BATOR", "Capital da Mongólia no planalto asiático", "Geografia"),
                CandidateWord("Kilimanjaro", "KILIMANJARO", "O ponto de maior altitude de África na Tanzânia", "Geografia"),
                CandidateWord("Monte Etna", "MONTE#ETNA", "Vulcão ativo mais alto da Europa na Sicília", "Geografia")
            )
        )

        // ==================== 3. HISTÓRIA ====================
        addPrebuilt(
            id = "historia_facil",
            title = "História - Civilizações e Reis",
            difficulty = "Fácil",
            category = "História",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Império", "IMPERIO", "Conjunto de povos governados por imperador", "História"),
                CandidateWord("Coroa", "COROA", "Símbolo e ornamento real de soberania", "História"),
                CandidateWord("Século", "SECULO", "Período histórico de cem anos", "História"),
                CandidateWord("Cruzadas", "CRUZADAS", "Expedições medievais à Terra Santa", "História"),
                CandidateWord("Castelo", "CASTELO", "Fortificação militar defensiva medieval", "História"),
                CandidateWord("Faraó", "FARAO", "Soberano supremo do Antigo Egito", "História"),
                CandidateWord("Espada", "ESPADA", "Arma branca clássica de guerreiros", "História"),
                CandidateWord("Cavaleiro", "CAVALEIRO", "Guerreiro nobre a cavalo na Idade Média", "História")
            )
        )

        addPrebuilt(
            id = "historia_medio",
            title = "História - Grandes Revoluções e Líderes",
            difficulty = "Médio",
            category = "História",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Napoleão", "NAPOLEAO", "Imperador francês derrotado em Waterloo", "História"),
                CandidateWord("Egípcia", "EGIPCIA", "Civilização que construiu as pirâmides de Gizé", "História"),
                CandidateWord("Waterloo", "WATERLOO", "Batalha decisiva de 1815 na Bélgica", "História"),
                CandidateWord("Cravos", "CRAVOS", "Símbolo da Revolução portuguesa de 1974", "História"),
                CandidateWord("Washington", "WASHINGTON", "Primeiro Presidente dos Estados Unidos", "História"),
                CandidateWord("Henriques", "HENRIQUES", "Primeiro rei de Portugal (D. Afonso)", "História"),
                CandidateWord("Revolução", "REVOLUCAO", "Transformação radical política e social", "História"),
                CandidateWord("Júlio César", "JULIO#CESAR", "Ditador romano célebre nos Idos de Março", "História"),
                CandidateWord("Cleópatra", "CLEOPATRA", "Última rainha da dinastia ptolemaica", "História"),
                CandidateWord("Renascimento", "RENASCIMENTO", "Período cultural de renovação europeia", "História")
            )
        )

        addPrebuilt(
            id = "historia_dificil",
            title = "História - Documentos e Dinastias Mundiais",
            difficulty = "Difícil",
            category = "História",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Carta Magna", "CARTA#MAGNA", "Documento de 1215 que limitou o poder real", "História"),
                CandidateWord("César Augusto", "CESAR#AUGUSTO", "Primeiro imperador do Império Romano", "História"),
                CandidateWord("Nicolau II", "NICOLAU#II", "Último czar da dinastia Romanov na Rússia", "História"),
                CandidateWord("Rainha Vitória", "RAINHA#VITORIA", "Monarca britânica no auge do Império no séc. XIX", "História"),
                CandidateWord("Lenine", "LENINE", "Líder da Revolução Russa e da URSS", "História"),
                CandidateWord("Dinastia Qin", "DINASTIA#QIN", "Dinastia que iniciou a Grande Muralha", "História"),
                CandidateWord("Inca", "INCA", "Civilização que ergueu Machu Picchu", "História"),
                CandidateWord("Carlos Magno", "CARLOS#MAGNO", "Imperador coroado no ano 800 em Roma", "História"),
                CandidateWord("Péricles", "PERICLES", "Líder da Época de Ouro de Atenas", "História"),
                CandidateWord("Versalhes", "VERSALHES", "Tratado de paz de 1919 após a I Guerra", "História")
            )
        )

        // ==================== 4. ARTES E LITERATURA ====================
        addPrebuilt(
            id = "artes_facil",
            title = "Artes - Expressão e Criatividade",
            difficulty = "Fácil",
            category = "Artes e Literatura",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Poema", "POEMA", "Obra literária composta em versos", "Artes e Literatura"),
                CandidateWord("Pintura", "PINTURA", "Arte visual de aplicação de cor na tela", "Artes e Literatura"),
                CandidateWord("Teatro", "TEATRO", "Arte performativa de representação dramática", "Artes e Literatura"),
                CandidateWord("Soneto", "SONETO", "Poema clássico estruturado em 14 versos", "Artes e Literatura"),
                CandidateWord("Música", "MUSICA", "Arte de combinar sons e melodias", "Artes e Literatura"),
                CandidateWord("Livro", "LIVRO", "Conjunto de páginas com texto literário", "Artes e Literatura"),
                CandidateWord("Tela", "TELA", "Superfície para pintura a óleo ou acrílico", "Artes e Literatura"),
                CandidateWord("Escultura", "ESCULTURA", "Arte tridimensional em pedra ou bronze", "Artes e Literatura")
            )
        )

        addPrebuilt(
            id = "artes_medio",
            title = "Artes - Grandes Mestres e Escritores",
            difficulty = "Médio",
            category = "Artes e Literatura",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Shakespeare", "SHAKESPEARE", "Dramaturgo inglês autor de 'Romeu e Julieta'", "Artes e Literatura"),
                CandidateWord("Camões", "CAMOES", "Maior poeta épico português de 'Os Lusíadas'", "Artes e Literatura"),
                CandidateWord("Cubismo", "CUBISMO", "Vanguarda artística celebrizada por Picasso", "Artes e Literatura"),
                CandidateWord("Cervantes", "CERVANTES", "Autor de 'Dom Quixote de la Mancha'", "Artes e Literatura"),
                CandidateWord("Edvard Munch", "EDVARD#MUNCH", "Pintor expressionista autor de 'O Grito'", "Artes e Literatura"),
                CandidateWord("Rowling", "ROWLING", "Autora britânica criadora de Harry Potter", "Artes e Literatura"),
                CandidateWord("Van Gogh", "VAN#GOGH", "Pintor holandês de 'A Noite Estrelada'", "Artes e Literatura"),
                CandidateWord("Salvador Dalí", "SALVADOR#DALI", "Pintor surrealista dos relógios derretidos", "Artes e Literatura"),
                CandidateWord("Monet", "MONET", "Mestre do impressionismo francês das Ninfeias", "Artes e Literatura"),
                CandidateWord("Romance", "ROMANCE", "Narrativa literária longa com enredo rico", "Artes e Literatura")
            )
        )

        addPrebuilt(
            id = "artes_dificil",
            title = "Artes - Obras-Primas e Estética",
            difficulty = "Difícil",
            category = "Artes e Literatura",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Guernica", "GUERNICA", "Célebre pintura de Picasso sobre a guerra", "Artes e Literatura"),
                CandidateWord("Dostoiévski", "DOSTOIEVSKI", "Romancista russo de 'Crime e Castigo'", "Artes e Literatura"),
                CandidateWord("Estilo Gótico", "ESTILO#GOTICO", "Estilo arquitetónico de Notre-Dame de Paris", "Artes e Literatura"),
                CandidateWord("Florbela Espanca", "FLORBELA#ESPANCA", "Poetisa alentejana dos célebres sonetos", "Artes e Literatura"),
                CandidateWord("Museu do Louvre", "MUSEU#DO#LOUVRE", "Museu parisiense da Vénus de Milo e Gioconda", "Artes e Literatura"),
                CandidateWord("Dante Alighieri", "DANTE#ALIGHIERI", "Poeta florentino autor da 'Divina Comédia'", "Artes e Literatura"),
                CandidateWord("Auguste Rodin", "AUGUSTE#RODIN", "Escultor francês da estátua 'O Pensador'", "Artes e Literatura"),
                CandidateWord("García Márquez", "GARCIA#MARQUEZ", "Nobel colombiano autor de 'Cem Anos de Solidão'", "Artes e Literatura"),
                CandidateWord("Caravaggio", "CARAVAGGIO", "Mestre barroco da luz e sombra dramática", "Artes e Literatura"),
                CandidateWord("Franz Kafka", "FRANZ#KAFKA", "Escritor de Praga autor de 'A Metamorfose'", "Artes e Literatura")
            )
        )

        // ==================== 5. CIÊNCIAS E NATUREZA ====================
        addPrebuilt(
            id = "ciencias_facil",
            title = "Ciências - O Universo e a Vida",
            difficulty = "Fácil",
            category = "Ciências e Natureza",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Água", "AGUA", "Fórmula H2O indispensável a todas as vidas", "Ciências e Natureza"),
                CandidateWord("Célula", "CELULA", "Unidade estrutural fundamental da vida", "Ciências e Natureza"),
                CandidateWord("Sol", "SOL", "Estrela central brilhante do nosso sistema", "Ciências e Natureza"),
                CandidateWord("Lua", "LUA", "O satélite natural que orbita a Terra", "Ciências e Natureza"),
                CandidateWord("Planeta", "PLANETA", "Corpo celeste que orbita em torno do Sol", "Ciências e Natureza"),
                CandidateWord("Terra", "TERRA", "Planeta onde vivemos com vida abundante", "Ciências e Natureza"),
                CandidateWord("Planta", "PLANTA", "Ser vivo vegetal que realiza fotossíntese", "Ciências e Natureza"),
                CandidateWord("Energia", "ENERGIA", "Capacidade física de produzir trabalho", "Ciências e Natureza")
            )
        )

        addPrebuilt(
            id = "ciencias_medio",
            title = "Ciências - Sistema Solar e Elementos",
            difficulty = "Médio",
            category = "Ciências e Natureza",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Mercúrio", "MERCURIO", "Planeta mais próximo do Sol no Sistema Solar", "Ciências e Natureza"),
                CandidateWord("Oxigénio", "OXIGENIO", "Gás vital para a respiração humana", "Ciências e Natureza"),
                CandidateWord("Júpiter", "JUPITER", "O maior planeta de todo o Sistema Solar", "Ciências e Natureza"),
                CandidateWord("Einstein", "EINSTEIN", "Físico que formulou a Teoria da Relatividade", "Ciências e Natureza"),
                CandidateWord("Botânica", "BOTANICA", "Ciência biológica dedicada ao estudo das plantas", "Ciências e Natureza"),
                CandidateWord("Esqueleto", "ESQUELETO", "Estrutura de 206 ossos do corpo humano", "Ciências e Natureza"),
                CandidateWord("Atmosfera", "ATMOSFERA", "Camada gasosa protetora da Terra", "Ciências e Natureza"),
                CandidateWord("Hidrogénio", "HIDROGENIO", "O elemento químico mais abundante do cosmos", "Ciências e Natureza"),
                CandidateWord("Fotossíntese", "FOTOSSINTESE", "Conversão de luz solar em energia vegetal", "Ciências e Natureza"),
                CandidateWord("Newton", "NEWTON", "Físico inglês que formulou a lei da gravidade", "Ciências e Natureza")
            )
        )

        addPrebuilt(
            id = "ciencias_dificil",
            title = "Ciências - Fisiologia e Descobertas",
            difficulty = "Difícil",
            category = "Ciências e Natureza",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Baleia Azul", "BALEIA#AZUL", "O maior animal e mamífero vivo do planeta Terra", "Ciências e Natureza"),
                CandidateWord("Gravidade", "GRAVIDADE", "Força atrativa que mantém órbitas planetárias", "Ciências e Natureza"),
                CandidateWord("Fleming", "FLEMING", "Descobriu o antibiótico penicilina em 1928", "Ciências e Natureza"),
                CandidateWord("Saturno", "SATURNO", "Planeta conhecido pelo sistema de anéis", "Ciências e Natureza"),
                CandidateWord("Charles Darwin", "CHARLES#DARWIN", "Propôs a evolução por seleção natural", "Ciências e Natureza"),
                CandidateWord("Fígado", "FIGADO", "A maior glândula metabólica do corpo humano", "Ciências e Natureza"),
                CandidateWord("Tabela Periódica", "TABELA#PERIODICA", "Quadro com todos os 118 elementos químicos", "Ciências e Natureza"),
                CandidateWord("Mitocôndria", "MITOCONDRIA", "Organelo produtor de energia e respiração", "Ciências e Natureza"),
                CandidateWord("Buraco Negro", "BURACO#NEGRO", "Região cósmica de gravidade extrema infinita", "Ciências e Natureza"),
                CandidateWord("Termodinâmica", "TERMODINAMICA", "Física do calor, energia e entropia", "Ciências e Natureza")
            )
        )

        // ==================== 6. ENTRETENIMENTO ====================
        addPrebuilt(
            id = "entretenimento_facil",
            title = "Entretenimento - Cinema e TV",
            difficulty = "Fácil",
            category = "Entretenimento",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Cinema", "CINEMA", "A sétima arte da exibição de filmes", "Entretenimento"),
                CandidateWord("Música", "MUSICA", "Arte de combinar ritmos e canções", "Entretenimento"),
                CandidateWord("Televisão", "TELEVISAO", "Aparelho de emissão de séries e notícias", "Entretenimento"),
                CandidateWord("Novela", "NOVELA", "Trama ficcional televisiva em episódios", "Entretenimento"),
                CandidateWord("Filme", "FILME", "Obra cinematográfica para tela ou streaming", "Entretenimento"),
                CandidateWord("Piano", "PIANO", "Instrumento de teclas brancas e pretas", "Entretenimento"),
                CandidateWord("Guitarra", "GUITARRA", "Instrumento de cordas dedilhadas no rock", "Entretenimento"),
                CandidateWord("Ator", "ATOR", "Artista que representa personagens", "Entretenimento")
            )
        )

        addPrebuilt(
            id = "entretenimento_medio",
            title = "Entretenimento - Estrelas e Séries",
            difficulty = "Médio",
            category = "Entretenimento",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("James Cameron", "JAMES#CAMERON", "Realizou o clássico oscarizado 'Titanic'", "Entretenimento"),
                CandidateWord("Madonna", "MADONNA", "Consagrada mundialmente como Rainha do Pop", "Entretenimento"),
                CandidateWord("Pink Floyd", "PINK#FLOYD", "Banda de 'The Dark Side of the Moon'", "Entretenimento"),
                CandidateWord("George Lucas", "GEORGE#LUCAS", "Cineasta criador da saga 'Star Wars'", "Entretenimento"),
                CandidateWord("Tom Hanks", "TOM#HANKS", "Ator que protagonizou 'Forrest Gump'", "Entretenimento"),
                CandidateWord("Rihanna", "RIHANNA", "Cantora pop mundial natural de Barbados", "Entretenimento"),
                CandidateWord("Trilogia", "TRILOGIA", "Série de 3 filmes em 'O Senhor dos Anéis'", "Entretenimento"),
                CandidateWord("ABBA", "ABBA", "Grupo sueco vencedor da Eurovisão com 'Waterloo'", "Entretenimento"),
                CandidateWord("Spielberg", "SPIELBERG", "Realizador de 'E.T.' e 'Parque Jurássico'", "Entretenimento"),
                CandidateWord("Michael Jackson", "MICHAEL#JACKSON", "O eterno Rei do Pop de 'Thriller'", "Entretenimento")
            )
        )

        addPrebuilt(
            id = "entretenimento_dificil",
            title = "Entretenimento - Clássicos e Prémios de Culto",
            difficulty = "Difícil",
            category = "Entretenimento",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Hitchcock", "HITCHCOCK", "Realizador do clássico de suspense 'Psicose'", "Entretenimento"),
                CandidateWord("Beatles", "BEATLES", "Banda de rock britânica com 4 membros", "Entretenimento"),
                CandidateWord("Toy Story", "TOY#STORY", "Primeira longa-metragem animada da Pixar", "Entretenimento"),
                CandidateWord("Springfield", "SPRINGFIELD", "Cidade fictícia onde se passa 'Os Simpsons'", "Entretenimento"),
                CandidateWord("Heath Ledger", "HEATH#LEDGER", "Ator que interpretou o Joker em 2008", "Entretenimento"),
                CandidateWord("Hans Zimmer", "HANS#ZIMMER", "Compositor da banda sonora de 'O Rei Leão'", "Entretenimento"),
                CandidateWord("Wings", "WINGS", "Filme vencedor do 1º Óscar de Melhor Filme", "Entretenimento"),
                CandidateWord("Stanley Kubrick", "STANLEY#KUBRICK", "Realizador genial de '2001: Odisseia no Espaço'", "Entretenimento"),
                CandidateWord("Casablanca", "CASABLANCA", "Clássico do cinema com Humphrey Bogart", "Entretenimento"),
                CandidateWord("Studio Ghibli", "STUDIO#GHIBLI", "Estúdio japonês de animação de Miyazaki", "Entretenimento")
            )
        )

        // ==================== 7. DESPORTO E LAZER ====================
        addPrebuilt(
            id = "desporto_facil",
            title = "Desporto - Jogos e Modalidades",
            difficulty = "Fácil",
            category = "Desporto e Lazer",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Golfe", "GOLFE", "Desporto jogado com tacos e bolas no relvado", "Desporto e Lazer"),
                CandidateWord("Natação", "NATACAO", "Desporto aquático de deslocação em piscina", "Desporto e Lazer"),
                CandidateWord("Ténis", "TENIS", "Modalidade de raquete jogada em court", "Desporto e Lazer"),
                CandidateWord("Futebol", "FUTEBOL", "Desporto de 11 jogadores por equipa", "Desporto e Lazer"),
                CandidateWord("Bola", "BOLA", "Objeto esférico essencial a vários desportos", "Desporto e Lazer"),
                CandidateWord("Corrida", "CORRIDA", "Prova de velocidade a pé em pista", "Desporto e Lazer"),
                CandidateWord("Golo", "GOLO", "Ponto máximo quando a bola entra na baliza", "Desporto e Lazer"),
                CandidateWord("Xadrez", "XADREZ", "Jogo de estratégia com rei, rainha e peões", "Desporto e Lazer")
            )
        )

        addPrebuilt(
            id = "desporto_medio",
            title = "Desporto - Campeonatos e Atletas",
            difficulty = "Médio",
            category = "Desporto e Lazer",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Jogos Olímpicos", "JOGOS#OLIMPICOS", "Jogos mundiais disputados de 4 em 4 anos", "Desporto e Lazer"),
                CandidateWord("Cristiano Ronaldo", "CRISTIANO#RONALDO", "Astro português vencedor de 5 Bolas de Ouro", "Desporto e Lazer"),
                CandidateWord("Badminton", "BADMINTON", "Desporto de raquete onde se usa um volante", "Desporto e Lazer"),
                CandidateWord("Judô", "JUDO", "Arte marcial japonesa de combate", "Desporto e Lazer"),
                CandidateWord("Basquetebol", "BASQUETEBOL", "Desporto de cesto do astro LeBron James", "Desporto e Lazer"),
                CandidateWord("Bowling", "BOWLING", "Jogo de precisão para derrubar 10 pinos", "Desporto e Lazer"),
                CandidateWord("Fórmula 1", "FORMULA#1", "Categoria máxima do automobilismo mundial", "Desporto e Lazer"),
                CandidateWord("Tour de France", "TOUR#DE#FRANCE", "Mítica volta ciclista à França", "Desporto e Lazer"),
                CandidateWord("Voleibol", "VOLEIBOL", "Desporto de rede jogado com mãos e braços", "Desporto e Lazer"),
                CandidateWord("Andebol", "ANDEBOL", "Desporto de pavilhão jogado com as mãos", "Desporto e Lazer")
            )
        )

        addPrebuilt(
            id = "desporto_dificil",
            title = "Desporto - Recordes e Lendas Globais",
            difficulty = "Difícil",
            category = "Desporto e Lazer",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Maratona", "MARATONA", "Prova de corrida oficial com 42,195 km", "Desporto e Lazer"),
                CandidateWord("Ayrton Senna", "AYRTON#SENNA", "Piloto brasileiro tricampeão de Fórmula 1", "Desporto e Lazer"),
                CandidateWord("Usain Bolt", "USAIN#BOLT", "Recordista mundial nos 100 metros rasos", "Desporto e Lazer"),
                CandidateWord("Capoeira", "CAPOEIRA", "Arte marcial e dança acrobática do Brasil", "Desporto e Lazer"),
                CandidateWord("Grand Slam", "GRAND#SLAM", "Conjunto dos 4 maiores torneios de ténis", "Desporto e Lazer"),
                CandidateWord("Atenas", "ATENAS", "Cidade dos primeiros Jogos Olímpicos modernos", "Desporto e Lazer"),
                CandidateWord("Taça Davis", "TACA#DAVIS", "Prestigiada taça entre seleções de ténis", "Desporto e Lazer"),
                CandidateWord("Wimbledon", "WIMBLEDON", "Torneio de ténis em relva natural em Londres", "Desporto e Lazer"),
                CandidateWord("Roland Garros", "ROLAND#GARROS", "Torneio de terra batida em Paris", "Desporto e Lazer"),
                CandidateWord("Decatlo", "DECATLO", "Competição de atletismo de 10 provas", "Desporto e Lazer")
            )
        )

        // ==================== 8. SAÚDE E CORPO ====================
        addPrebuilt(
            id = "saude_facil",
            title = "Saúde - Corpo e Órgãos Vitais",
            difficulty = "Fácil",
            category = "Saúde e Corpo",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Dente", "DENTE", "Estrutura dura da boca usada para mastigar", "Saúde e Corpo"),
                CandidateWord("Osso", "OSSO", "Parte rígida do esqueleto", "Saúde e Corpo"),
                CandidateWord("Pele", "PELE", "O maior órgão do corpo humano", "Saúde e Corpo"),
                CandidateWord("Veia", "VEIA", "Vaso que transporta o sangue para o coração", "Saúde e Corpo"),
                CandidateWord("Sangue", "SANGUE", "Líquido vital de cor vermelha", "Saúde e Corpo"),
                CandidateWord("Coração", "CORACAO", "Músculo que bombeia o sangue no corpo", "Saúde e Corpo"),
                CandidateWord("Cérebro", "CEREBRO", "Centro de comando do sistema nervoso", "Saúde e Corpo"),
                CandidateWord("Olho", "OLHO", "Órgão sensorial da visão", "Saúde e Corpo")
            )
        )

        addPrebuilt(
            id = "saude_medio",
            title = "Saúde - Anatomia e Fisiologia",
            difficulty = "Médio",
            category = "Saúde e Corpo",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Eritrócito", "ERITROCITO", "Glóbulo vermelho do sangue que transporta oxigénio", "Saúde e Corpo"),
                CandidateWord("Leucócito", "LEUCOCITO", "Glóbulo branco do sangue de defesa e imunidade", "Saúde e Corpo"),
                CandidateWord("Bucinador", "BUCINADOR", "Músculo da bochecha auxiliar na mastigação", "Saúde e Corpo"),
                CandidateWord("Esmalte", "ESMALTE", "Camada externa protetora do dente", "Saúde e Corpo"),
                CandidateWord("Gengiva", "GENGIVA", "Tecido mole que envolve a base dos dentes", "Saúde e Corpo"),
                CandidateWord("Sintoma", "SINTOMA", "Sinal indicador de uma patologia", "Saúde e Corpo"),
                CandidateWord("Artéria", "ARTERIA", "Vaso que leva o sangue oxigenado", "Saúde e Corpo"),
                CandidateWord("Diabetes", "DIABETES", "Distúrbio metabólico de glicemia", "Saúde e Corpo"),
                CandidateWord("Glucose", "GLUCOSE", "Principal açúcar simples de energia", "Saúde e Corpo"),
                CandidateWord("Pulmão", "PULMAO", "Órgão responsável pelas trocas gasosas", "Saúde e Corpo"),
                CandidateWord("Neurónio", "NEURONIO", "Célula transmissora de impulsos nervosos", "Saúde e Corpo"),
                CandidateWord("Insulina", "INSULINA", "Hormona pancreática reguladora de açúcar", "Saúde e Corpo")
            )
        )

        addPrebuilt(
            id = "saude_dificil",
            title = "Saúde - Medicina e Bioquímica",
            difficulty = "Difícil",
            category = "Saúde e Corpo",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Eritrócito", "ERITROCITO", "Glóbulo vermelho do sangue que transporta oxigénio", "Saúde e Corpo"),
                CandidateWord("Leucócito", "LEUCOCITO", "Glóbulo branco do sangue responsável pela defesa imunitária", "Saúde e Corpo"),
                CandidateWord("Mitocôndria", "MITOCONDRIA", "Organelo responsável pela respiração celular", "Saúde e Corpo"),
                CandidateWord("Sarcoplasma", "SARCOPLASMA", "O citoplasma das células musculares", "Saúde e Corpo"),
                CandidateWord("Anafilaxia", "ANAFILAXIA", "Reação alérgica sistémica grave", "Saúde e Corpo"),
                CandidateWord("Idiopático", "IDIOPATICO", "Diz-se de afeição de causa desconhecida", "Saúde e Corpo"),
                CandidateWord("Miocárdio", "MIOCARDIO", "Músculo espesso da parede do coração", "Saúde e Corpo"),
                CandidateWord("Hipotálamo", "HIPOTALAMO", "Região cerebral reguladora do corpo", "Saúde e Corpo"),
                CandidateWord("Homeostase", "HOMEOSTASE", "Equilíbrio do meio interno do organismo", "Saúde e Corpo"),
                CandidateWord("Hematopoiese", "HEMATOPOIESE", "Formação de células do sangue na medula", "Saúde e Corpo")
            )
        )

        // ==================== 9. CULTURA GERAL ====================
        addPrebuilt(
            id = "geral_facil",
            title = "Cultura Geral - Conceitos Fundamentais",
            difficulty = "Fácil",
            category = "Cultura Geral",
            gridSize = 8,
            candidates = listOf(
                CandidateWord("Jogo", "JOGO", "Atividade lúdica sujeita a regras", "Cultura Geral"),
                CandidateWord("Casa", "CASA", "Edifício destinado a habitação", "Cultura Geral"),
                CandidateWord("Luz", "LUZ", "Radiação eletromagnética visível", "Cultura Geral"),
                CandidateWord("Livro", "LIVRO", "Conjunto encadernado de páginas", "Cultura Geral"),
                CandidateWord("Regra", "REGRA", "Preceito que dita como agir", "Cultura Geral"),
                CandidateWord("Família", "FAMILIA", "Grupo de parentes unidos por afeto", "Cultura Geral"),
                CandidateWord("Escola", "ESCOLA", "Instituição de ensino e aprendizagem", "Cultura Geral"),
                CandidateWord("Paz", "PAZ", "Tranquilidade e ausência de guerra", "Cultura Geral")
            )
        )

        addPrebuilt(
            id = "geral_medio",
            title = "Cultura Geral - Sociedade e Saberes",
            difficulty = "Médio",
            category = "Cultura Geral",
            gridSize = 10,
            candidates = listOf(
                CandidateWord("Lógica", "LOGICA", "Ramo da filosofia sobre o raciocínio", "Cultura Geral"),
                CandidateWord("Ciência", "CIENCIA", "Conhecimento baseado em testes e factos", "Cultura Geral"),
                CandidateWord("História", "HISTORIA", "Estudo e registo das ações humanas", "Cultura Geral"),
                CandidateWord("Política", "POLITICA", "Arte da governação e organização social", "Cultura Geral"),
                CandidateWord("Economia", "ECONOMIA", "Estudo da produção e distribuição de bens", "Cultura Geral"),
                CandidateWord("Justiça", "JUSTICA", "Princípio moral de equidade e direito", "Cultura Geral"),
                CandidateWord("Filosofia", "FILOSOFIA", "Investigação sobre conhecimento e existência", "Cultura Geral"),
                CandidateWord("Democracia", "DEMOCRACIA", "Regime onde o poder emana do povo pelo voto", "Cultura Geral"),
                CandidateWord("Cidadania", "CIDADANIA", "Conjunto de direitos e deveres do cidadão", "Cultura Geral"),
                CandidateWord("Ética", "ETICA", "Reflexão sobre os princípios morais", "Cultura Geral")
            )
        )

        addPrebuilt(
            id = "geral_dificil",
            title = "Cultura Geral - Vocabulário e Conceitos Eruditos",
            difficulty = "Difícil",
            category = "Cultura Geral",
            gridSize = 12,
            candidates = listOf(
                CandidateWord("Pragmático", "PRAGMATICO", "Focado nos objetivos práticos e utilidade", "Cultura Geral"),
                CandidateWord("Resiliência", "RESILIENCIA", "Capacidade de superar a adversidade", "Cultura Geral"),
                CandidateWord("Nepotismo", "NEPOTISMO", "Favorecimento ilegal de familiares em cargos", "Cultura Geral"),
                CandidateWord("Paradoxo", "PARADOXO", "Contradição aparente que desafia a lógica", "Cultura Geral"),
                CandidateWord("Maiêutica", "MAIEUTICA", "Método socrático para fazer nascer ideias", "Cultura Geral"),
                CandidateWord("Silogismo", "SILOGISMO", "Raciocínio dedutivo com premissas e conclusão", "Cultura Geral"),
                CandidateWord("Dialética", "DIALETICA", "Confronto e síntese de ideias opostas", "Cultura Geral"),
                CandidateWord("Hermenêutica", "HERMENEUTICA", "Teoria da interpretação de textos", "Cultura Geral"),
                CandidateWord("Existencialismo", "EXISTENCIALISMO", "Doutrina de que a existência precede a essência", "Cultura Geral"),
                CandidateWord("Empirismo", "EMPIRISMO", "Conhecimento fundado na experiência prática", "Cultura Geral")
            )
        )

        return puzzles
    }
}
