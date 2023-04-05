package com.example.example

import com.google.gson.annotations.SerializedName


data class Effect (

  @SerializedName("Effect1Amount" ) var Effect1Amount : String? = null,
  @SerializedName("Effect2Amount" ) var Effect2Amount : String? = null,
  @SerializedName("Effect3Amount" ) var Effect3Amount : String? = null,
  @SerializedName("Effect4Amount" ) var Effect4Amount : String? = null,
  @SerializedName("Effect5Amount" ) var Effect5Amount : String? = null

)