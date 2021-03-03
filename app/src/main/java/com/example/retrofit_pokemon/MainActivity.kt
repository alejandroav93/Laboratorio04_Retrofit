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
        val editUser: EditText
        val btn_ingresar: TextView
        val pokemon: TextView
        btn_ingresar = findViewById(R.id.btn_ingresar)
        editUser = findViewById(R.id.edit_user)
        pokemon = findViewById(R.id.mostrar)
        btn_ingresar.setOnClickListener { v: View? ->

            //------------------------- RETROFIT 2 -----------------------------------
            val retrofit2 = Retrofit2()
            val call = retrofit2.service.getPokemonById(editUser.text.toString().toLowerCase())
            if (call != null) {
                call.enqueue(object : Callback<JsonObject?> {
                    override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                        if (response.isSuccessful) {
                            val data: JsonObject?
                            data = response.body()
                            assert(data != null)
                            val imprimirInfo = ("\n\nHabilidad: " +
                                    data!!.getAsJsonArray("abilities")[1].asJsonObject
                                            .getAsJsonObject("ability")["name"]
                                    + "\nNombre: " + data["name"]
                                    + "\nExperiencia Base: " + data["base_experience"] +
                                    "\nAltura: " + data["height"] + " cm"
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
}