package com.example.lol_gg.data

import com.google.gson.annotations.SerializedName

data class Champion (

	@SerializedName("first") val isFirst : Boolean,
	@SerializedName("kills") val kills : Int
)