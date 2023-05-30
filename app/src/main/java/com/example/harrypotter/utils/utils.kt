package com.example.harrypotter.utils

import android.app.Activity
import android.widget.Toast

fun Activity.message(text: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, text, length).show()
}