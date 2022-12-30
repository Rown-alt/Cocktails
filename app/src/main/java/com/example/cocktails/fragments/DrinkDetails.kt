package com.example.cocktails.fragments

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.cocktails.fragments.abstractions.DrinkDetailsAbstract

class DrinkDetails: DrinkDetailsAbstract() {
    private val drink: DrinkDetailsArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDrink(drink.drinkId)
    }
}