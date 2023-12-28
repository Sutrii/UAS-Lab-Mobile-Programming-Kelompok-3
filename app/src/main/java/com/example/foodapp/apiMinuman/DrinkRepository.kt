package com.example.foodapp.apiMinuman

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.foodapp.api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkRepository @Inject constructor(private var drinkApi: DrinkApi) {
    fun searchDrink(query:String):LiveData<DrinkResponse>{
        var search=MutableLiveData<DrinkResponse>()
        drinkApi.searchDrink(query).enqueue(object :Callback<DrinkResponse>{
            override fun onResponse(call: Call<DrinkResponse>, response: Response<DrinkResponse>) {
                if(response.isSuccessful){
                    search.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<DrinkResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return search
    }
}