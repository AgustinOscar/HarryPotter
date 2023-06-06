package com.example.harrypotter.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
                    binding.pbConexion.visibility = View.GONE

                    if (response.body()!![0].name != "")
                        binding.tvTitle.text = response.body()!![0].name ?: ""
                    else
                        binding.tvTitle.text = getString(R.string.nameNull)

                    if (response.body()!![0].actor != "")
                        binding.tvNameActorValue.text = response.body()!![0].actor ?: ""
                    else
                        binding.tvNameActorValue.text = getString(R.string.actorNull)

                    if (response.body()!![0].house != "")
                        binding.tvHouseValue.text = response.body()!![0].house ?: ""
                    else
                        binding.tvHouseValue.text = getString(R.string.houseNull)

                    if (response.body()!![0].patronus != "")
                        binding.tvPatronusValue.text = response.body()!![0].patronus ?: ""
                    else
                        binding.tvPatronusValue.text = getString(R.string.patronusNull)

                    if (response.body()!![0].alternateNames.size != 0)
                        binding.tvAlternativeNamesValues.text = response.body()!![0].alternateNames.joinToString(", ")
                    else
                        binding.tvAlternativeNamesValues.text = getString(R.string.alternativeNamesNull)

                    if (response.body()!![0].yearOfBirth.toString() != "")
                        binding.tvYearOfBirthValue.text = response.body()!![0].yearOfBirth.toString()
                    else
                        binding.tvYearOfBirthValue.text = getString(R.string.yearOfBirthNull)

                    if (response.body()!![0].wizard.toString() != "") {
                        if (response.body()!![0].wizard.toString() == "true")
                            binding.tvWizzardValue.text = getString(R.string.wizzarValueYes)
                        else
                            binding.tvWizzardValue.text = getString(R.string.wizzarValueNo)
                    }

                    else
                        binding.tvWizzardValue.text = getString(R.string.genericValueNull)

                    if (response.body()!![0].gender.toString() != "")
                        binding.tvGenderValue.text = response.body()!![0].gender.toString()
                    else
                        binding.tvGenderValue.text = getString(R.string.genderNull)


                    Glide.with(this@Details)
                        .load(response.body()!![0].image)
                        .into(binding.ivImage)

                }

                override fun onFailure(call: Call<ArrayList<MagicianDetail>>, t: Throwable) {
                    binding.pbConexion.visibility = View.GONE
                    Toast.makeText(this@Details,
                        "No se puede consultar este personaje de momento",
                        Toast.LENGTH_LONG).show()
                }

            })
        }
    }
}

