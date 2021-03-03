package com.example.retrofit_pokemon.retrofit2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit2 {
    val service: PokemonAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(Utils.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(PokemonAPI::class.java)
    }
}