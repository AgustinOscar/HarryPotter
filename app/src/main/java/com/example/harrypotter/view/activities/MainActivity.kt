package com.example.harrypotter.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypotter.adapters.MagicianAdapter
import com.example.harrypotter.databinding.ActivityMainBinding

import com.example.harrypotter.model.Magician
import com.example.harrypotter.network.HarryPotterAPI
import com.example.harrypotter.network.RetrofitService
import com.example.harrypotter.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //Vinculación con elementos de la GUI.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Vinculación con elementos del layout.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Transición de información entre activities.
        val bundle = intent.extras

        if (bundle != null) {
            //Se obtiene el valor de "students" ó "staff"
            val selection = bundle.getString("selection", "")
            Log.d("LOGTAG", selection)

            val call: Call<ArrayList<Magician>>

            call = when (selection) {
                "students" -> {
                    RetrofitService.getRetrofit().create(HarryPotterAPI::class.java)
                        .getStudentsListApiary()
                }
                "staff" -> {
                    RetrofitService.getRetrofit().create(HarryPotterAPI::class.java)
                        .getStaffListApiary()
                }
                else -> {
                    return
                }
            }

            call.enqueue(object: Callback<ArrayList<Magician>> {

                //Función de conexión a la API exitosa.
                override fun onResponse(
                    call: Call<ArrayList<Magician>>,
                    response: Response<ArrayList<Magician>>
                ) {
                    binding.pbConnection.visibility = View.GONE //Se quita el símbolo de cargando.
                    Log.d("LOGTAG", "Respuesta del servidor: ${response.toString()}")
                    Log.d("LOGTAG", response.body().toString())

                    //Llenado de los datos del response.
                    binding.rvItems.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvItems.adapter = MagicianAdapter(this@MainActivity,
                        response.body()!!
                    ) { characterSelected: Magician ->
                        characterClick(characterSelected)
                    }
                }

                //Función de conexión a la API no exitosa.
                override fun onFailure(call: Call<ArrayList<Magician>>, t: Throwable) {
                    Toast.makeText(this@MainActivity,
                        "No hay conexión...", Toast.LENGTH_SHORT).show()
                    binding.pbConnection.visibility = View.GONE //Se quita el símbolo de cargando.
                    Log.d("LOGTAG", "Error")
                }
            })

        } else {
            Log.d("LOGTAG", "No se recibió nada...")
        }
        
    }
    
    private  fun characterClick(magician: Magician) {
        val bundle = Bundle()
        bundle.putString("id", magician.id)

        val intent = Intent(this, Details::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}