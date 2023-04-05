package com.example.example

import com.google.gson.annotations.SerializedName


data class Basic (

  @SerializedName("name"             ) var name             : String?           = null,
  @SerializedName("rune"             ) var rune             : Rune?             = Rune(),
  @SerializedName("gold"             ) var gold             : Gold?             = Gold(),
  @SerializedName("group"            ) var group            : String?           = null,
  @SerializedName("description"      ) var description      : String?           = null,
  @SerializedName("colloq"           ) var colloq           : String?           = null,
  @SerializedName("plaintext"        ) var plaintext        : String?           = null,
  @SerializedName("consumed"         ) var consumed         : Boolean?          = null,
  @SerializedName("stacks"           ) var stacks           : Int?              = null,
  @SerializedName("depth"            ) var depth            : Int?              = null,
  @SerializedName("consumeOnFull"    ) var consumeOnFull    : Boolean?          = null,
  @SerializedName("from"             ) var from             : List<String> = listOf(),
  @SerializedName("into"             ) var into             : List<String> = listOf(),
  @SerializedName("specialRecipe"    ) var specialRecipe    : Int?              = null,
  @SerializedName("inStore"          ) var inStore          : Boolean?          = null,
  @SerializedName("hideFromAll"      ) var hideFromAll      : Boolean?          = null,
  @SerializedName("requiredChampion" ) var requiredChampion : String?           = null,
  @SerializedName("requiredAlly"     ) var requiredAlly     : String?           = null,
  @SerializedName("stats"            ) var stats            : Stats?            = Stats(),
  @SerializedName("tags"             ) var tags             : List<String> = listOf(),
  @SerializedName("maps"             ) var maps             : Maps?             = Maps()

)