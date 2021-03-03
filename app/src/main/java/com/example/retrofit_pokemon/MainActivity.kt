package com.example.retrofit_pokemon

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_pokemon.R
import com.example.retrofit_pokemon.retrofit2.Retrofit2
import retrofit2.Call

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
                call.enqueue()
            }
        }
    }
}

private fun <T> Call<T>?.enqueue() {

}
