package com.example.example

import com.google.gson.annotations.SerializedName


data class Gold (

  @SerializedName("base"        ) var base        : Int?     = null,
  @SerializedName("purchasable" ) var purchasable : Boolean? = null,
  @SerializedName("total"       ) var total       : Int?     = null,
  @SerializedName("sell"        ) var sell        : Int?     = null

)