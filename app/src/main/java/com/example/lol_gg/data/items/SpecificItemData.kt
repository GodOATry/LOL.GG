package com.example.lol_gg.data.items

import com.example.example.Gold
import com.example.example.ImageItem
import com.example.example.Maps
import com.example.example.Stats
import com.google.gson.annotations.SerializedName

data class SpecificItemData (
    var id : Int?=0,
    @SerializedName("name"        ) var name        : String?           = null,
    @SerializedName("description" ) var description : String?           = null,
    @SerializedName("colloq"      ) var colloq      : String?           = null,
    @SerializedName("plaintext"   ) var plaintext   : String?           = null,
    @SerializedName("into"        ) var into        : List<String> = listOf(),
    @SerializedName("image"       ) var image       : ImageItem?         = ImageItem(),
    @SerializedName("gold"        ) var gold        : Gold?             = Gold(),
    @SerializedName("tags"        ) var tags        : List<String> = listOf(),
    @SerializedName("maps"        ) var maps        : Maps?             = Maps(),
    @SerializedName("stats"       ) var stats       : Stats?            = Stats()
)