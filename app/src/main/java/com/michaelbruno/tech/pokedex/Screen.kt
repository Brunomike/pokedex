package com.michaelbruno.tech.pokedex

sealed class Screen(val route:String){
    object PokemonListScreen:Screen("pokemon_list_screen")
    object PokemonDetailScreen:Screen("pokemon_detail_screen")
    object TestScreen:Screen("test_screen")
}
