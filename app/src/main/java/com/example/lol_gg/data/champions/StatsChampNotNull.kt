package com.example.lol_gg.data.champions

import com.google.gson.annotations.SerializedName

data class StatsChampNotNull(

@SerializedName("hp"                   ) var hp                   : Float    = 0f,
@SerializedName("hpperlevel"           ) var hpperlevel           : Float    = 0f,
@SerializedName("mp"                   ) var mp                   : Float    = 0f,
@SerializedName("mpperlevel"           ) var mpperlevel           : Float    = 0f,
@SerializedName("movespeed"            ) var movespeed            : Float    = 0f,
@SerializedName("armor"                ) var armor                : Float    = 0f,
@SerializedName("armorperlevel"        ) var armorperlevel        : Float = 0f,
@SerializedName("spellblock"           ) var spellblock           : Float    = 0f,
@SerializedName("spellblockperlevel"   ) var spellblockperlevel   : Float = 0f,
@SerializedName("attackrange"          ) var attackrange          : Float    = 0f,
@SerializedName("hpregen"              ) var hpregen              : Float = 0f,
@SerializedName("hpregenperlevel"      ) var hpregenperlevel      : Float = 0f,
@SerializedName("mpregen"              ) var mpregen              : Float    = 0f,
@SerializedName("mpregenperlevel"      ) var mpregenperlevel      : Float = 0f,
@SerializedName("crit"                 ) var crit                 : Float    = 0f,
@SerializedName("critperlevel"         ) var critperlevel         : Float    = 0f,
@SerializedName("attackdamage"         ) var attackdamage         : Float    = 0f,
@SerializedName("attackdamageperlevel" ) var attackdamageperlevel : Float = 0f,
@SerializedName("attackspeedperlevel"  ) var attackspeedperlevel  : Float = 0f,
@SerializedName("attackspeed"          ) var attackspeed          : Float = 0f

)
