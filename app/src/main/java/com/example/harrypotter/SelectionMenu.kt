package com.example.harrypotter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class SelectionMenu : AppCompatActivity() {

    private lateinit var selection: String //Estudiantes ó staff.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_menu)
    }

    fun click_students(view: View) {
        selection = "students"
        Log.d("LOGTAG", "Students")

    }

    fun click_staff(view: View) {
        selection = "staff"
        Log.d("LOGTAG", "Staff")
    }
}