package com.example.retrofit_pokemon.retrofit2

import retrofit.Callback
import retrofit.http.GET

interface Urls {
    @GET("/api/information")
    fun wsEmergencias(cb: Callback<String?>?)

    /*@GET("/api/news/{uno}")
    void wsNoticias(@Path("uno") String uno, Callback<String> cb);*/
    @GET("/api/news")
    fun wsNoticias(cb: Callback<String?>?)

    @GET("/api/covid")
    fun wsCovid(cb: Callback<String?>?)

    @GET("/api/centres")
    fun wsCentros(cb: Callback<String?>?)
}