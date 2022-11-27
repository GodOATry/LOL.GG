package com.example.lol_gg

class Dictionary {

    fun rankIconDictionary(userRank: String): Int {
        when (userRank) {
            "IRON" -> {
                return R.drawable.iron
            }
            "BRONZE" -> {
                return R.drawable.bronze
            }
            "SILVER" -> {
                return R.drawable.silver
            }
            "GOLD" -> {
                return R.drawable.gold
            }
            "PLATINUM" -> {
                return R.drawable.platinum
            }
            "DIAMOND" -> {
                return R.drawable.diamond
            }
            "MASTER" -> {
                return R.drawable.master
            }
            "GRANDMASTER" -> {
                return R.drawable.grandmaster
            }
            "CHALLENGER" -> {
                return R.drawable.challenger
            }
        }
        return 0
    }

    fun rankSmallLettersDictionary(userRank: String): Int {
        when (userRank) {
            "IRON" -> {
                return R.string.Iron
            }
            "BRONZE" -> {
                return R.string.Bronze
            }
            "SILVER" -> {
                return R.string.Silver
            }
            "GOLD" -> {
                return R.string.Gold
            }
            "PLATINUM" -> {
                return R.string.Platinum
            }
            "DIAMOND" -> {
                return R.string.Diamond
            }
            "MASTER" -> {
                return R.string.Master
            }
            "GRANDMASTER" -> {
                return R.string.Grandmaster
            }
            "CHALLENGER" -> {
                return R.string.Challenger
            }
        }
        return R.string.Iron
    }

    fun summonerSpellIdDictionary(summonerSpellID: Int): String {
        when (summonerSpellID) {
            21 -> return "SummonerBarrier.png"
            1 -> return "SummonerCleanse.png"
            14 -> return "SummonerDot.png"
            3 -> return "SummonerExhaust.png"
            4 -> return "SummonerFlash.png"
            6 -> return "SummonerGhost.png"
            7 -> return "SummonerHeal.png"
            13 -> return "SummonerClarity.png"
            11 -> return "SummonerSmite.png"
            12 -> return "SummonerTeleport.png"
        }
        return ""
    }

    fun winDictionary(isWon: Boolean): String {
        return when (isWon) {
            true -> "Win"
            false -> "Lose"
        }
    }

    fun perkDictionary(id: Int): Int {
        when(id){
            8000 -> return R.drawable.precision
            8100 -> return R.drawable.domination
            8200 -> return R.drawable.sorcery
            8300 -> return R.drawable.inspiration
            8400 -> return R.drawable.resolve
        }
        return R.drawable.precision
    }
    fun typeOfGameDictionary(gameType:String) : String{
        when(gameType){
            "CLASSIC" -> return "5V5"
        }
        return gameType
    }

}