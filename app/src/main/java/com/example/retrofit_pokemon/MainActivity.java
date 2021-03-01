package com.example.retrofit_pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit_pokemon.retrofit2.ApiRest;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView btn_1 = findViewById(R.id.btn_1);

        btn_1.setOnClickListener(v -> {
            ApiRest apiRest = new ApiRest();
            Call<JsonObject> call = apiRest.getService().getNoticias();

            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if(response.isSuccessful()){
                        Log.i("information", "");
                    }
                    else{
                        Toast.makeText(MainActivity.this,"correcto", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {

                }
            });
        });
    }
}