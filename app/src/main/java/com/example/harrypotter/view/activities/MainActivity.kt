package com.example.harrypotter.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.harrypotter.databinding.ActivityMainBinding
import com.example.harrypotter.utils.message
import com.example.harrypotter.model.Magician
import com.example.harrypotter.network.HarryPotterAPI
import com.example.harrypotter.network.RetrofitService
import com.example.harrypotter.utils.Constants
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

        //val data = ArrayList<Magician>()


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

                override fun onResponse(
                    call: Call<ArrayList<Magician>>,
                    response: Response<ArrayList<Magician>>
                ) {
                    binding.pbConnection.visibility = View.GONE //Se quita el símbolo de cargando.
                    Log.d("LOGTAG", "Respuesta del servidor: ${response.toString()}")
                    Log.d("LOGTAG", response.body().toString())
                }

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





        /*
        for (i in 1 .. 10) {
            val magicianTmp = Magician(i + Random.nextLong(1000),
                "Personaje $i", "Actor $i", "PPPPPPPP")
            data.add(magicianTmp)
        }*/

        //val my_adapter = Adapter(this, data)

        //binding.rvItems.adapter = my_adapter


    }
}