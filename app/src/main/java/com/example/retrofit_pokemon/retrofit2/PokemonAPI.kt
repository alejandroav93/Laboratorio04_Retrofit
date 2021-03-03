package com.example.retrofit_pokemon.retrofit2;

import android.util.JsonReader;

import com.google.gson.JsonObject;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {

    @GET("pokemon/id{id}")
    Call<List<JsonObject>> getPokemonById(@Path("id") String id);

}
