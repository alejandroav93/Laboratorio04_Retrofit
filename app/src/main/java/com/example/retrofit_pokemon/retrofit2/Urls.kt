package com.example.retrofit_pokemon.retrofit2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface Urls {


    @GET("/api/information")
    void wsEmergencias(Callback<String> cb);

    /*@GET("/api/news/{uno}")
    void wsNoticias(@Path("uno") String uno, Callback<String> cb);*/
    @GET("/api/news")
    void wsNoticias(Callback<String> cb);

    @GET("/api/covid")
    void wsCovid(Callback<String> cb);

    @GET("/api/centres")
    void wsCentros(Callback<String> cb);

}
