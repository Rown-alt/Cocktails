package com.example.domain.api

import com.example.domain.api.repository.Repository
import com.example.domain.api.repository.RepositoryImpl
import com.example.domain.api.resultCall.ResultCallAdapterFactory
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val domainModule = module{
    val  gson = GsonBuilder()
        .setLenient()
        .create()
    single{
        Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .build()
            .create(CocktailsAPI::class.java)
    }
    single<Repository>{
        RepositoryImpl(get())
    }
}