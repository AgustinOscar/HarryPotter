package com.example.harrypotter.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

//Interfaz para colocar todos los end-points.
interface HarryPotterAPI {

    //Obtención de personaje por medio del ID.
    @GET("{id}")
    fun getCharacterDetailApiary(
        @Path("id") id: String?
    ) //getCharacterDetailApiary("554654654") ==> Trae el elemento con el ID.

    //Obtención de personajes por medio del tipo.
    @GET("{type}")
    fun getCharacterListApiary(
        @Path("type") id: String?
    ) //getCharacterListApiary("students") ==> Trae todos los estudiantes.


    /*
    @GET
    fun getStudents(
        @Url url: String? = null //getStudents("students")
    )

    //Otra forma de obtener los elementos.
    @GET("students/")
    fun getSpecificStudent(
        @Query("id") id:String? = null,
        @Query("name")  //getSpecificStudent("456545272", "Óscar") => "students/456545272/Óscar"
    )*/
}