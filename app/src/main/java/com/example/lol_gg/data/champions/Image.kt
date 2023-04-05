package com.example.example

import com.google.gson.annotations.SerializedName


data class Image (

  @SerializedName("full"   ) var full   : String? = null,
  @SerializedName("sprite" ) var sprite : String? = null,
  @SerializedName("group"  ) var group  : String? = null,
  @SerializedName("x"      ) var x      : Int?    = null,
  @SerializedName("y"      ) var y      : Int?    = null,
  @SerializedName("w"      ) var w      : Int?    = null,
  @SerializedName("h"      ) var h      : Int?    = null

)