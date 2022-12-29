package com.example.cocktails.di

import com.example.cocktails.viewmodels.CocktailDetailsViewModel
import com.example.cocktails.viewmodels.DrinksByFilterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel {
        CocktailDetailsViewModel(get())
    }
    viewModel {
        DrinksByFilterViewModel(get())
    }
}