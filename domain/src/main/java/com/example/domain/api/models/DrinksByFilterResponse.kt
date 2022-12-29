package com.example.domain.api.models

import com.google.gson.annotations.SerializedName

class DrinksByFilterResponse {
    @SerializedName("drinks") val drinks: ArrayList<Drinks> = arrayListOf()
}