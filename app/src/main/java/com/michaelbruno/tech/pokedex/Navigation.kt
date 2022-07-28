package com.michaelbruno.tech.pokedex

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.google.accompanist.coil.CoilImage
import com.michaelbruno.tech.pokedex.presentation.pokemondetail.PokemonDetailScreen
import com.michaelbruno.tech.pokedex.presentation.pokemonlist.PokemonListScreen

import java.util.*


@OptIn(ExperimentalCoilApi::class)
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
                val request = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.example.com/image.jpg")
                    .target { drawable ->
                        // Handle the result.
                    }
                    .build()

                val painter = rememberImagePainter(
                    data = "https://source.unsplash.com/100x100/?nature",
                    //builder = request.newBuilder(LocalContext.current).()
//                    builder = {
//                            target {
//
//                            }
//                    }
                )
                val painterState = painter.state

                if (painterState is ImagePainter.State.Loading) {
                    CircularProgressIndicator()
                }
                Image(painter = painter, contentDescription = "Logo")


            }
        }
    }
}
