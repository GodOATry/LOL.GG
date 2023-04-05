package com.example.example

import com.google.gson.annotations.SerializedName


data class StatsChamp (

  @SerializedName("hp"                   ) var hp                   : Float?    = null,
  @SerializedName("hpperlevel"           ) var hpperlevel           : Float?    = null,
  @SerializedName("mp"                   ) var mp                   : Float?    = null,
  @SerializedName("mpperlevel"           ) var mpperlevel           : Float?    = null,
  @SerializedName("movespeed"            ) var movespeed            : Float?    = null,
  @SerializedName("armor"                ) var armor                : Float?    = null,
  @SerializedName("armorperlevel"        ) var armorperlevel        : Float? = null,
  @SerializedName("spellblock"           ) var spellblock           : Float?    = null,
  @SerializedName("spellblockperlevel"   ) var spellblockperlevel   : Float? = null,
  @SerializedName("attackrange"          ) var attackrange          : Float?    = null,
  @SerializedName("hpregen"              ) var hpregen              : Float? = null,
  @SerializedName("hpregenperlevel"      ) var hpregenperlevel      : Float? = null,
  @SerializedName("mpregen"              ) var mpregen              : Float?    = null,
  @SerializedName("mpregenperlevel"      ) var mpregenperlevel      : Float? = null,
  @SerializedName("crit"                 ) var crit                 : Float?    = null,
  @SerializedName("critperlevel"         ) var critperlevel         : Float?    = null,
  @SerializedName("attackdamage"         ) var attackdamage         : Float?    = null,
  @SerializedName("attackdamageperlevel" ) var attackdamageperlevel : Float? = null,
  @SerializedName("attackspeedperlevel"  ) var attackspeedperlevel  : Float? = null,
  @SerializedName("attackspeed"          ) var attackspeed          : Float? = null

)