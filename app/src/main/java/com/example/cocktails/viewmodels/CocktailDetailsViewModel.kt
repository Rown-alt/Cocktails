package com.example.cocktails.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.api.models.RandomDrinkResponse
import com.example.domain.api.repository.Repository
import kotlinx.coroutines.launch

class CocktailDetailsViewModel(private val repository: Repository): ViewModel() {
    var drink = MutableLiveData<RandomDrinkResponse>()


    fun getRandomDrink(){
        viewModelScope.launch {
            try{
                val request = repository.getRandom()
                request.onSuccess {
                    drink.value = it
                }
                request.onFailure {
                    Log.e("RandomDrink", it.localizedMessage!!)
                }
            }
            catch (_: Exception){}
        }
    }

    fun getDrink(id: Int){
        viewModelScope.launch {
            try{
                val request = repository.getDrink(id)
                request.onSuccess {
                    drink.value = it
                }
            }
            catch (_: Exception){}
        }
    }
}