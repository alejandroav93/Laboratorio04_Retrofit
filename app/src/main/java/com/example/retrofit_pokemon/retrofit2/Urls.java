package com.example.retrofit_pokemon.retrofit2;


import retrofit2.Callback;
import retrofit2.http.GET;

public interface Urls {

    @GET("/api/information")
        void wsEmergencias(Callback<String> cb);

    @GET("/api/news")
    void wsNoticias(Callback<String> cb);

    @GET("/api/covid")
    void wsCovid(Callback<String> cb);

    @GET("/api/centros")
    void wsCentros(Callback<String> cb);
}
