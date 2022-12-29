package com.example.domain.api.models

import com.google.gson.annotations.SerializedName

data class RandomDrinkResponse(
    @SerializedName("drinks" ) var drinks : ArrayList<Drinks> = arrayListOf()
)