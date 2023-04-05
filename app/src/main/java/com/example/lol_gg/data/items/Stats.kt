package com.example.example

import com.google.gson.annotations.SerializedName


data class Stats (

  @SerializedName("FlatHPPoolMod"     ) var FlatHPPoolMod     : Int? = null,
  @SerializedName("FlatSpellBlockMod" ) var FlatSpellBlockMod : Int? = null,
  @SerializedName("FlatMPPoolMod"     ) var FlatMPPoolMod     : Int? = null

)