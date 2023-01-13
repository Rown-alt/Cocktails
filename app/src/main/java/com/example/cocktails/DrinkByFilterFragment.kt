package com.example.cocktails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.cocktails.adapter.DrinksAdapter
import com.example.cocktails.databinding.FragmentDrinkByFilterBinding
import com.example.cocktails.viewmodels.DrinksByFilterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DrinkByFilterFragment : Fragment() {
    private var _binding: FragmentDrinkByFilterBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<DrinksByFilterViewModel>()
    private val filter: DrinkByFilterFragmentArgs by navArgs()
    private val drinksAdapter = DrinksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDrinks(filter.filterName)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDrinkByFilterBinding.inflate(inflater, container, false)
        viewModel.drinks.observe(viewLifecycleOwner){
            drinksAdapter.setDrinks(it.drinks)
        }
        binding.drinks.adapter = drinksAdapter
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}