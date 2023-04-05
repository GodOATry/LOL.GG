package com.example.example

import com.google.gson.annotations.SerializedName


data class Info (

  @SerializedName("attack"     ) var attack     : Int? = null,
  @SerializedName("defense"    ) var defense    : Int? = null,
  @SerializedName("magic"      ) var magic      : Int? = null,
  @SerializedName("difficulty" ) var difficulty : Int? = null

)