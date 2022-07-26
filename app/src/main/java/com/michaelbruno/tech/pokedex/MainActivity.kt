package com.michaelbruno.tech.pokedex

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.michaelbruno.tech.pokedex.presentation.pokemonlist.PokemonListScreen
import com.michaelbruno.tech.pokedex.presentation.pokemonlist.SearchBar
import com.michaelbruno.tech.pokedex.ui.theme.JetpackComposePokedexTheme
import com.michaelbruno.tech.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                Navigation(
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
        }
    }
}

