package com.example.example

import com.google.gson.annotations.SerializedName


data class Rune (

  @SerializedName("isrune" ) var isrune : Boolean? = null,
  @SerializedName("tier"   ) var tier   : Int?     = null,
  @SerializedName("type"   ) var type   : String?  = null

)