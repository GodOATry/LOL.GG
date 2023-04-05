package com.example.example

import com.google.gson.annotations.SerializedName


data class Jhin (

    @SerializedName("version" ) var version : String?           = null,
    @SerializedName("id"      ) var id      : String?           = null,
    @SerializedName("key"     ) var key     : String?           = null,
    @SerializedName("name"    ) var name    : String?           = null,
    @SerializedName("title"   ) var title   : String?           = null,
    @SerializedName("blurb"   ) var blurb   : String?           = null,
    @SerializedName("info"    ) var info    : Info?             = Info(),
    @SerializedName("image"   ) var image   : ImageItem?            = ImageItem(),
    @SerializedName("tags"    ) var tags    : List<String> = listOf(),
    @SerializedName("partype" ) var partype : String?           = null,
    @SerializedName("stats"   ) var stats   : StatsChamp?            = StatsChamp()

)