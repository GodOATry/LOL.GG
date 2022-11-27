package com.example.lol_gg.data

import com.google.gson.annotations.SerializedName

data class Match (

	@SerializedName("metadata") val metadata : Metadata,
	@SerializedName("info") val info : Info
)