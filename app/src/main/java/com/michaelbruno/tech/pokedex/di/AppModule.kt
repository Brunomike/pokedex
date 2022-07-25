package com.michaelbruno.tech.pokedex.di

import com.michaelbruno.tech.pokedex.data.remote.PokeApi
import com.michaelbruno.tech.pokedex.respository.PokemonRepository
import com.michaelbruno.tech.pokedex.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)


    @Provides
    @Singleton
    fun providePokeApi(): PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }

}