package com.example.example

import com.google.gson.annotations.SerializedName


data class Tree (

  @SerializedName("header" ) var header : String?           = null,
  @SerializedName("tags"   ) var tags   : List<String> = listOf()

)