package com.example.foodapp.apiMinuman

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApi {
    companion object{
        const val BASE_URL="https://www.thecocktaildb.com/api/json/v1/1/"
    }

    @GET("search.php?")
    fun searchDrink(
        @Query("s")s:String
    ): Call<DrinkResponse>

    @GET("lookup.php?")
    fun detailDrink(
        @Query("i")i:String
    ): Call<DrinkResponse>
}