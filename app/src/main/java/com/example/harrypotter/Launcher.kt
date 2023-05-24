package com.example.harrypotter

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.harrypotter.databinding.ActivityLauncherBinding

import kotlin.concurrent.thread
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log

class Launcher : AppCompatActivity() {

    //Vinculación entre la activity y el layout.
    private lateinit var binding: ActivityLauncherBinding

    //Música.
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        //Vinculación con layout.
        binding = ActivityLauncherBinding.inflate(layoutInflater)

        //Reproducción de música.
        mp = MediaPlayer.create(this, R.raw.its_eviosa)
        mp.start()

        //Hilo para realizar el cambio de pantalla.
        thread {

            //Tiempo que dura la visualización de la pantalla inicial.
            Thread.sleep(4500)

            //Mensajería hacia la otra pantalla.
            val intent = Intent(this, SelectionMenu::class.java)
            startActivity(intent)

            //Elimina la pantalla inicial del stack.
            finish()
        }
    }

    //Métodos del ciclo de vida.

    //onStart.
    override fun onStart() {
        super.onStart()
        Log.d("CICLO", "Ejecutando el método onStart()")
    }

    //onResume.
    override fun onResume() {
        super.onResume()
        Log.d("CICLO", "Ejecutando el método onResume()")
    }

    //onPause.
    override fun onPause() {
        super.onPause()
        Log.d("CICLO", "Ejecutando el método onPause()")
        mp.pause()
    }

    //onStop.
    override fun onStop() {
        super.onStop()
        Log.d("CICLO", "Ejecutando el método onStop()")
    }

    //onDestroy.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("CICLO", "Ejecutando el método onDestroy()")
    }

    //onRestart.
    override fun onRestart() {
        super.onRestart()
        Log.d("CICLO", "Ejecutando el método onRestart()")
        mp.start()
    }
}