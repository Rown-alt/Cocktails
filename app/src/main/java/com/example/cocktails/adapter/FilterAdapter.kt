package com.example.cocktails.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktails.FirstFragmentDirections
import com.example.cocktails.databinding.FilterAlcoholBinding
import com.example.cocktails.models.Filter

class FilterAdapter: RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {
    val filters: ArrayList<Filter> = arrayListOf()

    class FilterViewHolder(binding: FilterAlcoholBinding): RecyclerView.ViewHolder(binding.root) {
        private val filterImage = binding.filterImage
        private val filterName = binding.filterName
        fun bind(filter: Filter){
            Glide.with(itemView).load(filter.image).into(filterImage)
            filterName.text = filter.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = FilterAlcoholBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(filters[position])

        holder.itemView.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToDrinkByFilterFragment(filters[position].name)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return filters.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFilters(){
        filters.add(Filter("Tequila", "https://www.thecocktaildb.com/images/ingredients/tequila.png"))
        filters.add(Filter("Vodka", "https://www.thecocktaildb.com/images/ingredients/vodka.png"))
        filters.add(Filter("Gin", "https://www.thecocktaildb.com/images/ingredients/gin.png"))
        filters.add(Filter("Whisky", "https://www.thecocktaildb.com/images/ingredients/whisky.png"))
        filters.add(Filter("Rum", "https://www.thecocktaildb.com/images/ingredients/rum.png"))
        notifyDataSetChanged()
    }
}