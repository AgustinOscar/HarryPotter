package com.example.harrypotter.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.harrypotter.R
import com.example.harrypotter.databinding.ActivityDetailsBinding
import com.example.harrypotter.model.MagicianDetail
import com.example.harrypotter.network.HarryPotterAPI
import com.example.harrypotter.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class Details : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val id = bundle?.getString("id", "")

        if (id != null) {
            Log.d("LOGTAG", "ID recibido: $id")

            val call = RetrofitService.getRetrofit().create(HarryPotterAPI::class.java)
                .getCharacterDetailApiary(id)

            call.enqueue(object: Callback<ArrayList<MagicianDetail>> {
                override fun onResponse(
                    call: Call<ArrayList<MagicianDetail>>,
                    response: Response<ArrayList<MagicianDetail>>
                ) {
                    Log.d("LOGTAG", response.body()?.get(0).toString())
                    binding.pbConexion.visibility = View.GONE
                    binding.tvTitle.text = response.body()!![0].name ?: ""
                    binding.tvLongDesc.text = response.body()!![0].actor ?: ""
                    Glide.with(this@Details)
                        .load(response.body()!![0].image)
                        .into(binding.ivImage)

                }

                override fun onFailure(call: Call<ArrayList<MagicianDetail>>, t: Throwable) {
                    binding.pbConexion.visibility = View.GONE
                    Toast.makeText(this@Details, "No hay conexión", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}

