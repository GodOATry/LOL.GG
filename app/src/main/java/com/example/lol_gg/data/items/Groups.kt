package com.example.example

import com.google.gson.annotations.SerializedName


data class Groups (

  @SerializedName("id"              ) var id              : String? = null,
  @SerializedName("MaxGroupOwnable" ) var MaxGroupOwnable : String? = null

)