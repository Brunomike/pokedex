package com.michaelbruno.tech.pokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.coil.CoilImage
import com.michaelbruno.tech.pokedex.presentation.pokemondetail.PokemonDetailScreen
import com.michaelbruno.tech.pokedex.presentation.pokemonlist.PokemonList
import com.michaelbruno.tech.pokedex.presentation.pokemonlist.PokemonListScreen
import com.michaelbruno.tech.pokedex.presentation.pokemonlist.SearchBar
import java.util.*


@Composable
fun Navigation(navController: NavHostController, scaffoldState: ScaffoldState) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState,
    ) {
        NavHost(navController = navController, startDestination = Screen.PokemonListScreen.route) {
            composable(route = Screen.PokemonListScreen.route) {
                PokemonListScreen(navController = navController)
            }
            composable(
                route = "${Screen.PokemonDetailScreen.route}/{dominantColor}/{pokemonName}",
                arguments = listOf(
                    navArgument("dominantColor") {
                        type = NavType.IntType
                    },
                    navArgument("pokemonName") {
                        type = NavType.StringType
                    }
                )
            ) {
                val dominantColor = remember {
                    val color = it.arguments?.getInt("dominantColor")
                    color?.let { Color(it) } ?: Color.White
                }
                val pokemonName = remember {
                    it.arguments?.getString("pokemonName")
                }
                PokemonDetailScreen(
                    dominantColor = dominantColor,
                    pokemonName = pokemonName?.toLowerCase(Locale.ROOT) ?: "",
                    navController = navController
                )
            }
            composable(route = Screen.TestScreen.route) {
                CoilImage(
                        data = R.drawable.ic_international_pok_mon_logo,
                        contentDescription ="Pokemon logo",
                        fadeIn = true,
                        modifier = Modifier
                            .size(120.dp)

                    )
            }
        }
    }
}
