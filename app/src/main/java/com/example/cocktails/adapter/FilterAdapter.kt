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
        filters.add(Filter("Tequila", "https://www.svo-dutyfree.ru/medias/23222-527Wx527H?context=bWFzdGVyfGltYWdlc3w2ODQxOXxpbWFnZS9qcGVnfGhiOS9oOTUvOTY3Njg4MDgzODY4Ni8yMzIyMl81MjdXeDUyN0h8MTA4YzlmZTMwOTM0ODc4ZDU5YjFjODQ5ZTI3ZTZiOGFhM2IwMGQxYzEwM2ZlMmFmZTExMzk2ZGUyZmYyMjdmYg&v=1650904520671"))
        filters.add(Filter("Vodka", "https://wine-shopper.ru/image/cache/catalog/224753%201-600x600.jpg"))
        filters.add(Filter("Gin", "https://veld21.ru/image/cache/catalog/product/2812-100X6-470x610.jpg"))
        filters.add(Filter("Whisky", "https://wine-shopper.ru/image/cache/catalog/jopa/23-600x600.jpg"))
        filters.add(Filter("Rum", "https://dydza6t6xitx6.cloudfront.net/ci-captain-morgan-original-spiced-rum-50b42d45bcd74a31.jpeg"))
        notifyDataSetChanged()
    }
}