package com.example.retrofit_pokemon.retrofit2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface Urls {


    @GET("/api/news")
    Call<JsonArray> getNoticias();

    @GET("/api/covid")
    Call<JsonObject> getCovid();

    @GET("/api/centros")
    Call<JsonObject> getCentros();

   /* @GET("/api/news")
    void wsNoticias(Callback<String> cb);

    @GET("/api/covid")
    void wsCovid(Callback<String> cb);

    @GET("/api/centros")
    void wsCentros(Callback<String> cb);*/

}
