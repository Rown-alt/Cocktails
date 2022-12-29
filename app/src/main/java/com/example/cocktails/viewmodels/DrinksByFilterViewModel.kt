package com.example.cocktails.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.api.models.DrinksByFilterResponse
import com.example.domain.api.repository.Repository
import kotlinx.coroutines.launch

class DrinksByFilterViewModel(private val repository: Repository): ViewModel() {
    val drinks = MutableLiveData<DrinksByFilterResponse>()

    fun getDrinks(filter: String){
        viewModelScope.launch {
            try{
                val request = repository.getDrinkByFilter(filter)
                request.onSuccess {
                    drinks.value = it
                }
            }
            catch (_: Exception){}
        }
    }
}