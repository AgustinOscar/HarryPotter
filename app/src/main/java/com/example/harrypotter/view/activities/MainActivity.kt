package com.example.harrypotter.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.harrypotter.Adapter
import com.example.harrypotter.databinding.ActivityMainBinding
import com.example.harrypotter.utils.message
import com.example.harrypotter.model.Magician
import com.example.harrypotter.utils.Constants
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //Vinculación con elementos de la GUI.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Vinculación con elementos del layout.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        message("Prubando archivo utils")

        val data = ArrayList<Magician>()

        Constants.BASE_URL

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