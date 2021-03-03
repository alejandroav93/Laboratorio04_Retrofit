package com.example.retrofit_pokemon.retrofit2

import com.google.gson.JsonObject
import retrofit.Callback
import retrofit.http.GET
import retrofit2.Call

interface Urls {
    @retrofit2.http.GET("/api/news")
    fun wsNoticias(): Call<List<JsonObject?>?>? /*@GET("/api/information")
    Call<JSONArray> wsEmergencias();

    @GET("/api/covid")
    Call<JSONArray> wsCovid();

    @GET("/api/centres")
    Call<JSONArray> wsCentros();*/
}