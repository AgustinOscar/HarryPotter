package com.example.harrypotter.network

import com.example.harrypotter.model.Magician
import com.example.harrypotter.model.MagicianDetail
import com.example.harrypotter.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

//Interfaz para colocar todos los end-points.
interface HarryPotterAPI {

    //Obtención de personaje por medio del ID.
    @GET("api/character/{id}")
    fun getCharacterDetailApiary(
        @Path("id") id: String?
    ): Call<ArrayList<MagicianDetail>>

    //Obtención de estudiantes.
    @GET(Constants.STUDENTS_END_POINT)
    fun getStudentsListApiary(): Call<ArrayList<Magician>>

    //Obtención de staff.
    @GET(Constants.STAFF_END_POINT)
    fun getStaffListApiary(): Call<ArrayList<Magician>>
}