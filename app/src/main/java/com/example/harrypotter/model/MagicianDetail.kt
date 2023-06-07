package com.example.harrypotter.model

import com.google.gson.annotations.SerializedName

data class MagicianDetail(

    //Adecuaciones (cómo lo leo y cómo lo utilizaré en el código)
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("actor")
    val actor: String?,

    @SerializedName("image")
    val image: String?,

    @SerializedName("alternate_names")
    var alternateNames: ArrayList<String> = arrayListOf(),

    @SerializedName("species")
    var species: String? = null,

    @SerializedName("gender")
    var gender: String? = null,

    @SerializedName("house")
    var house: String? = null,

    @SerializedName("dateOfBirth")
    var dateOfBirth: String? = null,

    @SerializedName("yearOfBirth")
    var yearOfBirth: Int? = null,

    @SerializedName("wizard")
    var wizard: Boolean? = null,

    @SerializedName("ancestry")
    var ancestry: String? = null,

    @SerializedName("eyeColour")
    var eyeColour: String? = null,

    @SerializedName("hairColour")
    var hairColour: String? = null,

    //@SerializedName("wand")
    //var wand: Wand? = Wand(),

    @SerializedName("patronus")
    var patronus: String? = null,

    @SerializedName("hogwartsStudent"  )
    var hogwartsStudent : Boolean? = null,

    @SerializedName("hogwartsStaff")
    var hogwartsStaff: Boolean? = null,

    @SerializedName("alternate_actors" )
    var alternateActors: ArrayList<String> = arrayListOf(),

    @SerializedName("alive")
    var alive: Boolean? = null,
)

/*
data class Wand (

    @SerializedName("wood")
    var wood: String? = null,

    @SerializedName("core")
    var core   : String? = null,

    @SerializedName("length")
    var length : Int? = null
)*/