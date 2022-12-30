package com.example.cocktails.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.cocktails.databinding.FragmentSecondBinding
import com.example.cocktails.fragments.abstractions.DrinkDetailsAbstract
import com.example.cocktails.viewmodels.CocktailDetailsViewModel
import com.example.domain.api.models.RandomDrinkResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomDrinkFragment : DrinkDetailsAbstract() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getRandomDrink()
    }
}