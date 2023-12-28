package com.example.foodapp.apiMinuman

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.foodapp.api.MealResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.http.Query
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(private var repository: DrinkRepository
, private var savedStateHandle: SavedStateHandle):ViewModel() {

    fun searchDrink(query: String):LiveData<DrinkResponse>{
        return repository.searchDrink(query)
    }

}