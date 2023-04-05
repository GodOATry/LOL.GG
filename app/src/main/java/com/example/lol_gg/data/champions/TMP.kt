package com.example.example

import com.google.gson.annotations.SerializedName


data class TMP (

  @SerializedName("type"    ) var type    : String? = null,
  @SerializedName("format"  ) var format  : String? = null,
  @SerializedName("version" ) var version : String? = null,
  @SerializedName("data"    ) var data    : Data?   = Data()

)