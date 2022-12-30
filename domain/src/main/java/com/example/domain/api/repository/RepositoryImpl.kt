package com.example.domain.api.repository

import com.example.domain.api.CocktailsAPI
import com.example.domain.api.models.DrinksByFilterResponse
import com.example.domain.api.models.RandomDrinkResponse

class RepositoryImpl(private val api: CocktailsAPI): Repository {
    override suspend fun getRandom(): Result<RandomDrinkResponse> {
        return api.getRandom()
    }

    override suspend fun getDrinkByFilter(filter: String): Result<DrinksByFilterResponse> {
        return api.getDrinkByFilter(filter)
    }

    override suspend fun getDrink(id: Int): Result<RandomDrinkResponse> {
        return api.getDrink(id)
    }
}