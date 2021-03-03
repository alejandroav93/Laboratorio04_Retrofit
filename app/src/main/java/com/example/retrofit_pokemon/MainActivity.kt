package com.example.retrofit_pokemon

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_pokemon.retrofit2.Retrofit2
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_ingresar: TextView = findViewById(R.id.btn_ingresar)
        val editUser: EditText = findViewById(R.id.edit_user)
        val pokemon: TextView = findViewById(R.id.mostrar)
        btn_ingresar.setOnClickListener { v: View? ->

            val retrofit2 = Retrofit2()
            retrofit2.service.getPokemonById(editUser.text.toString().toLowerCase())?.enqueue(object : Callback<JsonObject?> {
                override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                    if (response.isSuccessful) {
                        val data: JsonObject? = response.body()
                        assert(data != null)
                        val imprimirInfo = ("\n\nHabilidad: " +
                                data!!.getAsJsonArray("abilities")[1].asJsonObject
                                        .getAsJsonObject("ability")["name"]
                                + "\nNombre: " + data["name"]
                                + "\nExperiencia Base: " + data["base_experience"] +
                                "\nAltura: " + data["height"] + "0 cm"
                                + "\nPeso: " + data["weight"] + " gramos")
                        pokemon.text = imprimirInfo
                        Log.i("detalle", data.toString())
                    } else {
                        Log.e("error", "Hubo un error inesperado!")
                    }
                }

                override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                    Log.e("error", t.toString())
                }
            })
        }
    }
}