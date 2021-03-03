package com.example.retrofit_pokemon.retrofit2

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {
    @GET("pokemon/id{id}")
    fun getPokemonById(@Path("id") id: String?): Call<List<JsonObject?>?>?
}