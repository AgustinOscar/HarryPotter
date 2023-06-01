package com.example.harrypotter.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.harrypotter.R

class SelectionMenu : AppCompatActivity() {

    private lateinit var selection: String //Estudiantes ó staff.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_menu)
    }

    fun click_students(view: View) {
        selection = "students"
        viewCharacters()
    }

    fun click_staff(view: View) {
        selection = "staff"
        viewCharacters()
    }

    fun viewCharacters() {
        val intent = Intent(this, MainActivity::class.java)
        val bundle = Bundle()
        bundle.putString("selection", selection)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}