package com.example.cocktails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.cocktails.databinding.FragmentSecondBinding
import com.example.cocktails.viewmodels.CocktailDetailsViewModel
import com.example.domain.api.models.RandomDrinkResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<CocktailDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getRandomDrink()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModel.randomDrink.observe(viewLifecycleOwner){
            binding.name.text = it.drinks[0].strDrink
            Glide.with(this).load(it.drinks[0].strDrinkThumb).into(binding.drinkImage)
            binding.instructions.text = it.drinks[0].strInstructions
            binding.ingredients.text = getIngredients(it)
        }
        binding.backPressBtn.setOnClickListener {
            it.findNavController().popBackStack()
        }
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getIngredients(drink: RandomDrinkResponse): String{
        var ingredients = ""
        if (drink.drinks[0].strIngredient1!=null){
            ingredients = "${drink.drinks[0].strIngredient1},"
        }
        if (drink.drinks[0].strIngredient2!=null){
            ingredients = "$ingredients ${drink.drinks[0].strIngredient2},"
        }
        if (drink.drinks[0].strIngredient3!=null){
            ingredients = "$ingredients ${drink.drinks[0].strIngredient3},"
        }
        if (drink.drinks[0].strIngredient4!=null){
            ingredients = "$ingredients ${drink.drinks[0].strIngredient4},"
        }
        if (drink.drinks[0].strIngredient5!=null){
            ingredients = "$ingredients ${drink.drinks[0].strIngredient5},"
        }
        if (drink.drinks[0].strIngredient6!=null){
            ingredients = "$ingredients ${drink.drinks[0].strIngredient6},"
        }
        return ingredients
    }
}