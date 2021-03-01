package com.example.retrofit_pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit_pokemon.retrofit2.ApiRest;
import com.example.retrofit_pokemon.retrofit2.Retrofit2;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editUser, editPassword;
        TextView btn_Ingresar;
        btn_Ingresar = findViewById(R.id.btn_ingresar);
        editPassword = findViewById(R.id.edit_password);
        editUser = findViewById(R.id.edit_user);

        Usuario.jsonArrayRubros = new JSONArray();
        btn_Ingresar.setOnClickListener(c->{

        });

/*
        btn_1.setOnClickListener(v -> {
            ApiRest apiRest = new ApiRest();
            Call<JsonArray> call = apiRest.getService().getNoticias();

            call.enqueue(new Callback<JsonArray>() {*/
            Retrofit2 retrofit2 = new Retrofit2();
            Call<JsonObject> call = retrofit2.getService().getPokemonById("ditto");
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if(response.isSuccessful()) {
                        JsonObject pokemon = response.body();
                        JsonArray habilidades = pokemon.getAsJsonArray("abilities");
                        Log.i("pokemon", habilidades.toString());
                    }
                    else{
                        Log.e("error", "Hubo un error inesperado!");
                    }
                }
                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {

                }
            });


        };
    }
