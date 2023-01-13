package com.example.cocktails.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.marginStart
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktails.DrinkByFilterFragment
import com.example.cocktails.DrinkByFilterFragmentDirections
import com.example.cocktails.databinding.DrinkItemBinding
import com.example.cocktails.databinding.FilterAlcoholBinding
import com.example.cocktails.models.Filter
import com.example.domain.api.models.Drinks

class DrinksAdapter: RecyclerView.Adapter<DrinksAdapter.FilterViewHolder>() {
    private var drinks: ArrayList<Drinks> = arrayListOf()

    class FilterViewHolder(binding: DrinkItemBinding): RecyclerView.ViewHolder(binding.root) {
        private val filterImage = binding.drinkImage
        private val filterName = binding.drinkName
        fun bind(drink: Drinks){
            Glide.with(itemView).load(drink.strDrinkThumb).into(filterImage)
            filterName.text = drink.strDrink
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = DrinkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val width = (parent.width * 0.5).toInt() - 15
//        val height = ViewGroup.LayoutParams.WRAP_CONTENT - 150
//
//        view.root.layoutParams = ViewGroup.LayoutParams(width, height)
        view.root.minWidth = width
        return  FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(drinks[position])

        holder.itemView.setOnClickListener {
            val action = DrinkByFilterFragmentDirections.actionDrinkByFilterFragmentToDrinkDetails(drinks[position].idDrink!!)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDrinks(drinks: ArrayList<Drinks>){
        this.drinks = drinks
        notifyDataSetChanged()
    }
}