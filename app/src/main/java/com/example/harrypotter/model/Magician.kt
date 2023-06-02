package com.example.harrypotter.model

import com.google.gson.annotations.SerializedName

//Presentación del item.
data class Magician(

    //Adecuaciones (cómo lo leo y cómo lo utilizaré en el código)
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("actor")
    val actor: String?,

    @SerializedName("image")
    val image: String?
)
