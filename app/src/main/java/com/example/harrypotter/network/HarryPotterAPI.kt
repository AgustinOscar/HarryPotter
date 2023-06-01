package com.example.harrypotter.network

import com.example.harrypotter.model.Magician
import com.example.harrypotter.model.MagicianDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

//Interfaz para colocar todos los end-points.
interface HarryPotterAPI {

    //Obtención de personaje por medio del ID.
    @GET("api/characters/{id}")
    fun getCharacterDetailApiary(
        @Path("id") id: String?
    ): Call<MagicianDetail>

    //Obtención de estudiantes.
    @GET("api/characters/students")
    fun getStudentsListApiary(): Call<ArrayList<Magician>>

    //Obtención de staff.
    @GET("api/characters/staff")
    fun getStaffListApiary(): Call<ArrayList<Magician>>
}
    /*

    @GET("api/characters/students") //getCharacterListApiary("students") ==> Trae todos los estudiantes.
        fun getCharacterListApiary(
        //@Path("type") id: String?
    ): Call<ArrayList<Magician>>

    //Obtención de personaje por medio del ID.
    @GET("api/characters/{id}") //getCharacterDetailApiary("554654654") ==> Trae el elemento con el ID.
    fun getCharacterDetailApiary(
        @Path("id") id: String?
    ): Call<MagicianDetail>



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
