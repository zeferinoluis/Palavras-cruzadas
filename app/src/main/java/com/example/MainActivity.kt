package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cruzadas.data.db.AppDatabase
import com.example.cruzadas.data.repository.PuzzleRepository
import com.example.cruzadas.data.viewmodel.DictionaryViewModel
import com.example.cruzadas.data.viewmodel.GameViewModel
import com.example.cruzadas.data.viewmodel.HomeViewModel
import com.example.cruzadas.ui.screens.DictionaryScreen
import com.example.cruzadas.ui.screens.GameScreen
import com.example.cruzadas.ui.screens.GeneratorScreen
import com.example.cruzadas.ui.screens.HomeScreen
import com.example.cruzadas.ui.screens.StatsScreen
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainAppEntry()
            }
        }
    }
}

@Composable
fun MainAppEntry() {
    val context = LocalContext.current
    val database = remember { AppDatabase.getDatabase(context) }
    val repository = remember { PuzzleRepository(database.puzzleDao(), database.dictionaryDao()) }

    val homeViewModel: HomeViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HomeViewModel(repository) as T
            }
        }
    )

    val gameViewModel: GameViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return GameViewModel(repository) as T
            }
        }
    )

    val dictionaryViewModel: DictionaryViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DictionaryViewModel(repository) as T
            }
        }
    )

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val isGameScreen = currentRoute?.startsWith("game/") == true

    Scaffold(
        bottomBar = {
            if (!isGameScreen) {
                NavigationBar(
                    containerColor = Color(0xFFF3EDF7),
                    contentColor = Color(0xFF1D1B20)
                ) {
                    NavigationBarItem(
                        selected = currentRoute == "home" || currentRoute == null,
                        onClick = {
                            navController.navigate("home") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(Icons.Default.GridOn, contentDescription = "Desafios", modifier = Modifier.size(20.dp)) },
                        label = { Text("Desafios", fontWeight = FontWeight.SemiBold) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF21005D),
                            selectedTextColor = Color(0xFF6750A4),
                            indicatorColor = Color(0xFFEADDFF),
                            unselectedIconColor = Color(0xFF49454F),
                            unselectedTextColor = Color(0xFF49454F)
                        ),
                        modifier = Modifier.testTag("nav_item_home")
                    )

                    NavigationBarItem(
                        selected = currentRoute == "generator",
                        onClick = {
                            navController.navigate("generator") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(Icons.Default.AutoAwesome, contentDescription = "Gerador IA", modifier = Modifier.size(20.dp)) },
                        label = { Text("Gerador IA", fontWeight = FontWeight.SemiBold) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF21005D),
                            selectedTextColor = Color(0xFF6750A4),
                            indicatorColor = Color(0xFFEADDFF),
                            unselectedIconColor = Color(0xFF49454F),
                            unselectedTextColor = Color(0xFF49454F)
                        ),
                        modifier = Modifier.testTag("nav_item_generator")
                    )

                    NavigationBarItem(
                        selected = currentRoute == "dictionary",
                        onClick = {
                            navController.navigate("dictionary") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(Icons.Default.Book, contentDescription = "Dicionário", modifier = Modifier.size(20.dp)) },
                        label = { Text("Dicionário", fontWeight = FontWeight.SemiBold) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF21005D),
                            selectedTextColor = Color(0xFF6750A4),
                            indicatorColor = Color(0xFFEADDFF),
                            unselectedIconColor = Color(0xFF49454F),
                            unselectedTextColor = Color(0xFF49454F)
                        ),
                        modifier = Modifier.testTag("nav_item_dictionary")
                    )

                    NavigationBarItem(
                        selected = currentRoute == "stats",
                        onClick = {
                            navController.navigate("stats") {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(Icons.Default.BarChart, contentDescription = "Estatísticas", modifier = Modifier.size(20.dp)) },
                        label = { Text("Estatísticas", fontWeight = FontWeight.SemiBold) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF21005D),
                            selectedTextColor = Color(0xFF6750A4),
                            indicatorColor = Color(0xFFEADDFF),
                            unselectedIconColor = Color(0xFF49454F),
                            unselectedTextColor = Color(0xFF49454F)
                        ),
                        modifier = Modifier.testTag("nav_item_stats")
                    )
                }
            }
        },
        containerColor = Color(0xFFF7F2FA),
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(
                    viewModel = homeViewModel,
                    onPlayPuzzle = { puzzleId -> navController.navigate("game/$puzzleId") },
                    onNavigateToGenerator = { navController.navigate("generator") }
                )
            }

            composable("generator") {
                GeneratorScreen(
                    viewModel = homeViewModel,
                    onPuzzleCreated = { puzzleId -> navController.navigate("game/$puzzleId") }
                )
            }

            composable("dictionary") {
                DictionaryScreen(
                    viewModel = dictionaryViewModel,
                    onPuzzleCreated = { puzzleId -> navController.navigate("game/$puzzleId") }
                )
            }

            composable("stats") {
                StatsScreen(viewModel = homeViewModel)
            }

            composable(
                route = "game/{puzzleId}",
                arguments = listOf(navArgument("puzzleId") { type = NavType.StringType })
            ) { backStackEntry ->
                val puzzleId = backStackEntry.arguments?.getString("puzzleId") ?: ""
                GameScreen(
                    puzzleId = puzzleId,
                    viewModel = gameViewModel,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
