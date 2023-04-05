package com.example.lol_gg.data.items

import com.example.example.Basic
import com.example.example.DataItem
import com.example.example.Groups
import com.example.example.Tree
import com.google.gson.annotations.SerializedName


data class Item (
  @SerializedName("type"    ) var type    : String?           = null,
  @SerializedName("version" ) var version : String?           = null,
  @SerializedName("basic"   ) var basic   : Basic?            = Basic(),
  @SerializedName("data"    ) var data    : DataItem?         = DataItem(),
  @SerializedName("groups"  ) var groups  : List<Groups>      = listOf(),
  @SerializedName("tree"    ) var tree    : List<Tree>        = listOf()

)