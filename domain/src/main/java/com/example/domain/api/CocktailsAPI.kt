package com.example.domain.api

import com.example.domain.api.models.DrinksByFilterResponse
import com.example.domain.api.models.RandomDrinkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsAPI {
    @GET("random.php")
    suspend fun getRandom(): Result<RandomDrinkResponse>
    @GET("filter.php")
    suspend fun getDrinkByFilter(@Query("i") filter: String): Result<DrinksByFilterResponse>
}