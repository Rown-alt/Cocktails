package com.example.domain.api.repository

import com.example.domain.api.models.DrinksByFilterResponse
import com.example.domain.api.models.RandomDrinkResponse
import retrofit2.http.Query

interface Repository {
    suspend fun getRandom(): Result<RandomDrinkResponse>
    suspend fun getDrinkByFilter(@Query("i") filter: String): Result<DrinksByFilterResponse>
    suspend fun getDrink(@Query("i") id: Int): Result<RandomDrinkResponse>
}