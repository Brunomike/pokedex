package com.michaelbruno.tech.pokedex.presentation.pokemondetail

import androidx.lifecycle.ViewModel
import com.michaelbruno.tech.pokedex.data.remote.responses.Pokemon
import com.michaelbruno.tech.pokedex.respository.PokemonRepository
import com.michaelbruno.tech.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName:String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}