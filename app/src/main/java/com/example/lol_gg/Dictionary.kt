package com.example.lol_gg

import com.example.example.Champ
import com.example.example.Data
import com.example.example.DataItem
import com.example.lol_gg.data.items.SpecificItemData

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
            "ARAM" -> return "ARM"
            "CLASSIC" -> return "5V5"
        }
        return gameType
    }
    fun regionDictionary(region:String):Int{
        return when(region){
            "WORLD" -> R.drawable.worlds
            "LCK" -> R.drawable.lck
            "LCS" -> R.drawable.lcs
            "LEC" -> R.drawable.lec
            else -> R.drawable.worlds
        }
    }

    fun teamsDictionary(team:String):Int{
        return when(team){
            "G2" -> R.drawable.g2
            "FNC" -> R.drawable.fnc
            "RGE" -> R.drawable.rg
            "MAD" -> R.drawable.ml
            "VIT" -> R.drawable.vit
            "SK" -> R.drawable.sk
            "AST" -> R.drawable.ast
            "BDS" -> R.drawable.bds
            "XL" -> R.drawable.excel
            "MSF" -> R.drawable.mf
            "T1"->R.drawable.t1
            "KTR"->R.drawable.ktr
            "DWG"->R.drawable.dwg
            "GG"->R.drawable.gg
            "FRD"->R.drawable.frd
            "HLE"->R.drawable.hle
            "KWA"->R.drawable.kwa
            "NON"->R.drawable.non
            "LIV"->R.drawable.liv
            "DRX"->R.drawable.drx
            "100"->R.drawable.one
            "C9"->R.drawable.c9
            "CLG"->R.drawable.clg
            "DG"->R.drawable.dg
            "EG"->R.drawable.eg
            "FQ"->R.drawable.fq
            "GOG"->R.drawable.gog
            "IM"->R.drawable.im
            "TL"->R.drawable.tl
            "TSM"->R.drawable.tsm

            else -> {R.drawable.g2}
        }
    }

    fun championConverter(champs: Data):List<Champ>{
        var list = mutableListOf<Champ>()
        list.add(Champ(id=champs.Aatrox?.id,stats=champs.Aatrox?.stats,title=champs.Aatrox?.title,name=champs.Aatrox?.name,image=champs.Aatrox?.image))
        list.add(Champ(id=champs.Ahri?.id,stats=champs.Ahri?.stats,title=champs.Ahri?.title,name=champs.Ahri?.name,image=champs.Ahri?.image))
        list.add(Champ(id=champs.Akali?.id,stats=champs.Akali?.stats,title=champs.Akali?.title,name=champs.Akali?.name,image=champs.Akali?.image))
        list.add(Champ(id=champs.Akshan?.id,stats=champs.Akshan?.stats,title=champs.Akshan?.title,name=champs.Akshan?.name,image=champs.Akshan?.image))
        list.add(Champ(id=champs.Alistar?.id,stats=champs.Alistar?.stats,title=champs.Alistar?.title,name=champs.Alistar?.name,image=champs.Alistar?.image))
        list.add(Champ(id=champs.Amumu?.id,stats=champs.Amumu?.stats,title=champs.Amumu?.title,name=champs.Amumu?.name,image=champs.Amumu?.image))
        list.add(Champ(id=champs.Anivia?.id,stats=champs.Anivia?.stats,title=champs.Anivia?.title,name=champs.Anivia?.name,image=champs.Anivia?.image))
        list.add(Champ(id=champs.Annie?.id,stats=champs.Annie?.stats,title=champs.Annie?.title,name=champs.Annie?.name,image=champs.Annie?.image))
        list.add(Champ(id=champs.Aphelios?.id,stats=champs.Aphelios?.stats,title=champs.Aphelios?.title,name=champs.Aphelios?.name,image=champs.Aphelios?.image))
        list.add(Champ(id=champs.Ashe?.id,stats=champs.Ashe?.stats,title=champs.Ashe?.title,name=champs.Ashe?.name,image=champs.Ashe?.image))
        list.add(Champ(id=champs.AurelionSol?.id,stats=champs.AurelionSol?.stats,title=champs.AurelionSol?.title,name=champs.AurelionSol?.name,image=champs.AurelionSol?.image))
        list.add(Champ(id=champs.Azir?.id,stats=champs.Azir?.stats,title=champs.Azir?.title,name=champs.Azir?.name,image=champs.Azir?.image))
        list.add(Champ(id=champs.Bard?.id,stats=champs.Bard?.stats,title=champs.Bard?.title,name=champs.Bard?.name,image=champs.Bard?.image))
        list.add(Champ(id=champs.Belveth?.id,stats=champs.Belveth?.stats,title=champs.Belveth?.title,name=champs.Belveth?.name,image=champs.Belveth?.image))
        list.add(Champ(id=champs.Blitzcrank?.id,stats=champs.Blitzcrank?.stats,title=champs.Blitzcrank?.title,name=champs.Blitzcrank?.name,image=champs.Blitzcrank?.image))
        list.add(Champ(id=champs.Brand?.id,stats=champs.Brand?.stats,title=champs.Brand?.title,name=champs.Brand?.name,image=champs.Brand?.image))
        list.add(Champ(id=champs.Braum?.id,stats=champs.Braum?.stats,title=champs.Braum?.title,name=champs.Braum?.name,image=champs.Braum?.image))
        list.add(Champ(id=champs.Caitlyn?.id,stats=champs.Caitlyn?.stats,title=champs.Caitlyn?.title,name=champs.Caitlyn?.name,image=champs.Caitlyn?.image))
        list.add(Champ(id=champs.Camille?.id,stats=champs.Camille?.stats,title=champs.Camille?.title,name=champs.Camille?.name,image=champs.Camille?.image))
        list.add(Champ(id=champs.Cassiopeia?.id,stats=champs.Cassiopeia?.stats,title=champs.Cassiopeia?.title,name=champs.Cassiopeia?.name,image=champs.Cassiopeia?.image))
        list.add(Champ(id=champs.Chogath?.id,stats=champs.Chogath?.stats,title=champs.Chogath?.title,name=champs.Chogath?.name,image=champs.Chogath?.image))
        list.add(Champ(id=champs.Corki?.id,stats=champs.Corki?.stats,title=champs.Corki?.title,name=champs.Corki?.name,image=champs.Corki?.image))
        list.add(Champ(id=champs.Darius?.id,stats=champs.Darius?.stats,title=champs.Darius?.title,name=champs.Darius?.name,image=champs.Darius?.image))
        list.add(Champ(id=champs.Diana?.id,stats=champs.Diana?.stats,title=champs.Diana?.title,name=champs.Diana?.name,image=champs.Diana?.image))
        list.add(Champ(id=champs.Draven?.id,stats=champs.Draven?.stats,title=champs.Draven?.title,name=champs.Draven?.name,image=champs.Draven?.image))
        list.add(Champ(id=champs.DrMundo?.id,stats=champs.DrMundo?.stats,title=champs.DrMundo?.title,name=champs.DrMundo?.name,image=champs.DrMundo?.image))
        list.add(Champ(id=champs.Ekko?.id,stats=champs.Ekko?.stats,title=champs.Ekko?.title,name=champs.Ekko?.name,image=champs.Ekko?.image))
        list.add(Champ(id=champs.Elise?.id,stats=champs.Elise?.stats,title=champs.Elise?.title,name=champs.Elise?.name,image=champs.Elise?.image))
        list.add(Champ(id=champs.Evelynn?.id,stats=champs.Evelynn?.stats,title=champs.Evelynn?.title,name=champs.Evelynn?.name,image=champs.Evelynn?.image))
        list.add(Champ(id=champs.Ezreal?.id,stats=champs.Ezreal?.stats,title=champs.Ezreal?.title,name=champs.Ezreal?.name,image=champs.Ezreal?.image))
        list.add(Champ(id=champs.Fiddlesticks?.id,stats=champs.Fiddlesticks?.stats,title=champs.Fiddlesticks?.title,name=champs.Fiddlesticks?.name,image=champs.Fiddlesticks?.image))
        list.add(Champ(id=champs.Fiora?.id,stats=champs.Fiora?.stats,title=champs.Fiora?.title,name=champs.Fiora?.name,image=champs.Fiora?.image))
        list.add(Champ(id=champs.Fizz?.id,stats=champs.Fizz?.stats,title=champs.Fizz?.title,name=champs.Fizz?.name,image=champs.Fizz?.image))
        list.add(Champ(id=champs.Galio?.id,stats=champs.Galio?.stats,title=champs.Galio?.title,name=champs.Galio?.name,image=champs.Galio?.image))
        list.add(Champ(id=champs.Gangplank?.id,stats=champs.Gangplank?.stats,title=champs.Gangplank?.title,name=champs.Gangplank?.name,image=champs.Gangplank?.image))
        list.add(Champ(id=champs.Garen?.id,stats=champs.Garen?.stats,title=champs.Garen?.title,name=champs.Garen?.name,image=champs.Garen?.image))
        list.add(Champ(id=champs.Gnar?.id,stats=champs.Gnar?.stats,title=champs.Gnar?.title,name=champs.Gnar?.name,image=champs.Gnar?.image))
        list.add(Champ(id=champs.Gragas?.id,stats=champs.Gragas?.stats,title=champs.Gragas?.title,name=champs.Gragas?.name,image=champs.Gragas?.image))
        list.add(Champ(id=champs.Graves?.id,stats=champs.Graves?.stats,title=champs.Graves?.title,name=champs.Graves?.name,image=champs.Graves?.image))
        list.add(Champ(id=champs.Gwen?.id,stats=champs.Gwen?.stats,title=champs.Gwen?.title,name=champs.Gwen?.name,image=champs.Gwen?.image))
        list.add(Champ(id=champs.Hecarim?.id,stats=champs.Hecarim?.stats,title=champs.Hecarim?.title,name=champs.Hecarim?.name,image=champs.Hecarim?.image))
        list.add(Champ(id=champs.Heimerdinger?.id,stats=champs.Heimerdinger?.stats,title=champs.Heimerdinger?.title,name=champs.Heimerdinger?.name,image=champs.Heimerdinger?.image))
        list.add(Champ(id=champs.Illaoi?.id,stats=champs.Illaoi?.stats,title=champs.Illaoi?.title,name=champs.Illaoi?.name,image=champs.Illaoi?.image))
        list.add(Champ(id=champs.Irelia?.id,stats=champs.Irelia?.stats,title=champs.Irelia?.title,name=champs.Irelia?.name,image=champs.Irelia?.image))
        list.add(Champ(id=champs.Ivern?.id,stats=champs.Ivern?.stats,title=champs.Ivern?.title,name=champs.Ivern?.name,image=champs.Ivern?.image))
        list.add(Champ(id=champs.Janna?.id,stats=champs.Janna?.stats,title=champs.Janna?.title,name=champs.Janna?.name,image=champs.Janna?.image))
        list.add(Champ(id=champs.JarvanIV?.id,stats=champs.JarvanIV?.stats,title=champs.JarvanIV?.title,name=champs.JarvanIV?.name,image=champs.JarvanIV?.image))
        list.add(Champ(id=champs.Jax?.id,stats=champs.Jax?.stats,title=champs.Jax?.title,name=champs.Jax?.name,image=champs.Jax?.image))
        list.add(Champ(id=champs.Jayce?.id,stats=champs.Jayce?.stats,title=champs.Jayce?.title,name=champs.Jayce?.name,image=champs.Jayce?.image))
        list.add(Champ(id=champs.Jhin?.id,stats=champs.Jhin?.stats,title=champs.Jhin?.title,name=champs.Jhin?.name,image=champs.Jhin?.image))
        list.add(Champ(id=champs.Jinx?.id,stats=champs.Jinx?.stats,title=champs.Jinx?.title,name=champs.Jinx?.name,image=champs.Jinx?.image))
        list.add(Champ(id=champs.Kaisa?.id,stats=champs.Kaisa?.stats,title=champs.Kaisa?.title,name=champs.Kaisa?.name,image=champs.Kaisa?.image))
        list.add(Champ(id=champs.Kalista?.id,stats=champs.Kalista?.stats,title=champs.Kalista?.title,name=champs.Kalista?.name,image=champs.Kalista?.image))
        list.add(Champ(id=champs.Karma?.id,stats=champs.Karma?.stats,title=champs.Karma?.title,name=champs.Karma?.name,image=champs.Karma?.image))
        list.add(Champ(id=champs.Karthus?.id,stats=champs.Karthus?.stats,title=champs.Karthus?.title,name=champs.Karthus?.name,image=champs.Karthus?.image))
        list.add(Champ(id=champs.Kassadin?.id,stats=champs.Kassadin?.stats,title=champs.Kassadin?.title,name=champs.Kassadin?.name,image=champs.Kassadin?.image))
        list.add(Champ(id=champs.Katarina?.id,stats=champs.Katarina?.stats,title=champs.Katarina?.title,name=champs.Katarina?.name,image=champs.Katarina?.image))
        list.add(Champ(id=champs.Kayle?.id,stats=champs.Kayle?.stats,title=champs.Kayle?.title,name=champs.Kayle?.name,image=champs.Kayle?.image))
        list.add(Champ(id=champs.Kayn?.id,stats=champs.Kayn?.stats,title=champs.Kayn?.title,name=champs.Kayn?.name,image=champs.Kayn?.image))
        list.add(Champ(id=champs.Kennen?.id,stats=champs.Kennen?.stats,title=champs.Kennen?.title,name=champs.Kennen?.name,image=champs.Kennen?.image))
        list.add(Champ(id=champs.Khazix?.id,stats=champs.Khazix?.stats,title=champs.Khazix?.title,name=champs.Khazix?.name,image=champs.Khazix?.image))
        list.add(Champ(id=champs.Kindred?.id,stats=champs.Kindred?.stats,title=champs.Kindred?.title,name=champs.Kindred?.name,image=champs.Kindred?.image))
        list.add(Champ(id=champs.Kled?.id,stats=champs.Kled?.stats,title=champs.Kled?.title,name=champs.Kled?.name,image=champs.Kled?.image))
        list.add(Champ(id=champs.KogMaw?.id,stats=champs.KogMaw?.stats,title=champs.KogMaw?.title,name=champs.KogMaw?.name,image=champs.KogMaw?.image))
        list.add(Champ(id=champs.KSante?.id,stats=champs.KSante?.stats,title=champs.KSante?.title,name=champs.KSante?.name,image=champs.KSante?.image))
        list.add(Champ(id=champs.Leblanc?.id,stats=champs.Leblanc?.stats,title=champs.Leblanc?.title,name=champs.Leblanc?.name,image=champs.Leblanc?.image))
        list.add(Champ(id=champs.LeeSin?.id,stats=champs.LeeSin?.stats,title=champs.LeeSin?.title,name=champs.LeeSin?.name,image=champs.LeeSin?.image))
        list.add(Champ(id=champs.Leona?.id,stats=champs.Leona?.stats,title=champs.Leona?.title,name=champs.Leona?.name,image=champs.Leona?.image))
        list.add(Champ(id=champs.Lillia?.id,stats=champs.Lillia?.stats,title=champs.Lillia?.title,name=champs.Lillia?.name,image=champs.Lillia?.image))
        list.add(Champ(id=champs.Lissandra?.id,stats=champs.Lissandra?.stats,title=champs.Lissandra?.title,name=champs.Lissandra?.name,image=champs.Lissandra?.image))
        list.add(Champ(id=champs.Lucian?.id,stats=champs.Lucian?.stats,title=champs.Lucian?.title,name=champs.Lucian?.name,image=champs.Lucian?.image))
        list.add(Champ(id=champs.Lulu?.id,stats=champs.Lulu?.stats,title=champs.Lulu?.title,name=champs.Lulu?.name,image=champs.Lulu?.image))
        list.add(Champ(id=champs.Lux?.id,stats=champs.Lux?.stats,title=champs.Lux?.title,name=champs.Lux?.name,image=champs.Lux?.image))
        list.add(Champ(id=champs.Malphite?.id,stats=champs.Malphite?.stats,title=champs.Malphite?.title,name=champs.Malphite?.name,image=champs.Malphite?.image))
        list.add(Champ(id=champs.Malzahar?.id,stats=champs.Malzahar?.stats,title=champs.Malzahar?.title,name=champs.Malzahar?.name,image=champs.Malzahar?.image))
        list.add(Champ(id=champs.Maokai?.id,stats=champs.Maokai?.stats,title=champs.Maokai?.title,name=champs.Maokai?.name,image=champs.Maokai?.image))
        list.add(Champ(id=champs.MasterYi?.id,stats=champs.MasterYi?.stats,title=champs.MasterYi?.title,name=champs.MasterYi?.name,image=champs.MasterYi?.image))
        list.add(Champ(id=champs.MissFortune?.id,stats=champs.MissFortune?.stats,title=champs.MissFortune?.title,name=champs.MissFortune?.name,image=champs.MissFortune?.image))
        list.add(Champ(id=champs.MonkeyKing?.id,stats=champs.MonkeyKing?.stats,title=champs.MonkeyKing?.title,name=champs.MonkeyKing?.name,image=champs.MonkeyKing?.image))
        list.add(Champ(id=champs.Mordekaiser?.id,stats=champs.Mordekaiser?.stats,title=champs.Mordekaiser?.title,name=champs.Mordekaiser?.name,image=champs.Mordekaiser?.image))
        list.add(Champ(id=champs.Morgana?.id,stats=champs.Morgana?.stats,title=champs.Morgana?.title,name=champs.Morgana?.name,image=champs.Morgana?.image))
        list.add(Champ(id=champs.Nami?.id,stats=champs.Nami?.stats,title=champs.Nami?.title,name=champs.Nami?.name,image=champs.Nami?.image))
        list.add(Champ(id=champs.Nasus?.id,stats=champs.Nasus?.stats,title=champs.Nasus?.title,name=champs.Nasus?.name,image=champs.Nasus?.image))
        list.add(Champ(id=champs.Nautilus?.id,stats=champs.Nautilus?.stats,title=champs.Nautilus?.title,name=champs.Nautilus?.name,image=champs.Nautilus?.image))
        list.add(Champ(id=champs.Neeko?.id,stats=champs.Neeko?.stats,title=champs.Neeko?.title,name=champs.Neeko?.name,image=champs.Neeko?.image))
        list.add(Champ(id=champs.Nidalee?.id,stats=champs.Nidalee?.stats,title=champs.Nidalee?.title,name=champs.Nidalee?.name,image=champs.Nidalee?.image))
        list.add(Champ(id=champs.Nilah?.id,stats=champs.Nilah?.stats,title=champs.Nilah?.title,name=champs.Nilah?.name,image=champs.Nilah?.image))
        list.add(Champ(id=champs.Nocturne?.id,stats=champs.Nocturne?.stats,title=champs.Nocturne?.title,name=champs.Nocturne?.name,image=champs.Nocturne?.image))
        list.add(Champ(id=champs.Nunu?.id,stats=champs.Nunu?.stats,title=champs.Nunu?.title,name=champs.Nunu?.name,image=champs.Nunu?.image))
        list.add(Champ(id=champs.Olaf?.id,stats=champs.Olaf?.stats,title=champs.Olaf?.title,name=champs.Olaf?.name,image=champs.Olaf?.image))
        list.add(Champ(id=champs.Orianna?.id,stats=champs.Orianna?.stats,title=champs.Orianna?.title,name=champs.Orianna?.name,image=champs.Orianna?.image))
        list.add(Champ(id=champs.Ornn?.id,stats=champs.Ornn?.stats,title=champs.Ornn?.title,name=champs.Ornn?.name,image=champs.Ornn?.image))
        list.add(Champ(id=champs.Pantheon?.id,stats=champs.Pantheon?.stats,title=champs.Pantheon?.title,name=champs.Pantheon?.name,image=champs.Pantheon?.image))
        list.add(Champ(id=champs.Poppy?.id,stats=champs.Poppy?.stats,title=champs.Poppy?.title,name=champs.Poppy?.name,image=champs.Poppy?.image))
        list.add(Champ(id=champs.Pyke?.id,stats=champs.Pyke?.stats,title=champs.Pyke?.title,name=champs.Pyke?.name,image=champs.Pyke?.image))
        list.add(Champ(id=champs.Qiyana?.id,stats=champs.Qiyana?.stats,title=champs.Qiyana?.title,name=champs.Qiyana?.name,image=champs.Qiyana?.image))
        list.add(Champ(id=champs.Quinn?.id,stats=champs.Quinn?.stats,title=champs.Quinn?.title,name=champs.Quinn?.name,image=champs.Quinn?.image))
        list.add(Champ(id=champs.Rakan?.id,stats=champs.Rakan?.stats,title=champs.Rakan?.title,name=champs.Rakan?.name,image=champs.Rakan?.image))
        list.add(Champ(id=champs.Rammus?.id,stats=champs.Rammus?.stats,title=champs.Rammus?.title,name=champs.Rammus?.name,image=champs.Rammus?.image))
        list.add(Champ(id=champs.RekSai?.id,stats=champs.RekSai?.stats,title=champs.RekSai?.title,name=champs.RekSai?.name,image=champs.RekSai?.image))
        list.add(Champ(id=champs.Rell?.id,stats=champs.Rell?.stats,title=champs.Rell?.title,name=champs.Rell?.name,image=champs.Rell?.image))
        list.add(Champ(id=champs.Renata?.id,stats=champs.Renata?.stats,title=champs.Renata?.title,name=champs.Renata?.name,image=champs.Renata?.image))
        list.add(Champ(id=champs.Renekton?.id,stats=champs.Renekton?.stats,title=champs.Renekton?.title,name=champs.Renekton?.name,image=champs.Renekton?.image))
        list.add(Champ(id=champs.Rengar?.id,stats=champs.Rengar?.stats,title=champs.Rengar?.title,name=champs.Rengar?.name,image=champs.Rengar?.image))
        list.add(Champ(id=champs.Riven?.id,stats=champs.Riven?.stats,title=champs.Riven?.title,name=champs.Riven?.name,image=champs.Riven?.image))
        list.add(Champ(id=champs.Rumble?.id,stats=champs.Rumble?.stats,title=champs.Rumble?.title,name=champs.Rumble?.name,image=champs.Rumble?.image))
        list.add(Champ(id=champs.Ryze?.id,stats=champs.Ryze?.stats,title=champs.Ryze?.title,name=champs.Ryze?.name,image=champs.Ryze?.image))
        list.add(Champ(id=champs.Samira?.id,stats=champs.Samira?.stats,title=champs.Samira?.title,name=champs.Samira?.name,image=champs.Samira?.image))
        list.add(Champ(id=champs.Sejuani?.id,stats=champs.Sejuani?.stats,title=champs.Sejuani?.title,name=champs.Sejuani?.name,image=champs.Sejuani?.image))
        list.add(Champ(id=champs.Senna?.id,stats=champs.Senna?.stats,title=champs.Senna?.title,name=champs.Senna?.name,image=champs.Senna?.image))
        list.add(Champ(id=champs.Seraphine?.id,stats=champs.Seraphine?.stats,title=champs.Seraphine?.title,name=champs.Seraphine?.name,image=champs.Seraphine?.image))
        list.add(Champ(id=champs.Sett?.id,stats=champs.Sett?.stats,title=champs.Sett?.title,name=champs.Sett?.name,image=champs.Sett?.image))
        list.add(Champ(id=champs.Shaco?.id,stats=champs.Shaco?.stats,title=champs.Shaco?.title,name=champs.Shaco?.name,image=champs.Shaco?.image))
        list.add(Champ(id=champs.Shen?.id,stats=champs.Shen?.stats,title=champs.Shen?.title,name=champs.Shen?.name,image=champs.Shen?.image))
        list.add(Champ(id=champs.Shyvana?.id,stats=champs.Shyvana?.stats,title=champs.Shyvana?.title,name=champs.Shyvana?.name,image=champs.Shyvana?.image))
        list.add(Champ(id=champs.Singed?.id,stats=champs.Singed?.stats,title=champs.Singed?.title,name=champs.Singed?.name,image=champs.Singed?.image))
        list.add(Champ(id=champs.Sion?.id,stats=champs.Sion?.stats,title=champs.Sion?.title,name=champs.Sion?.name,image=champs.Sion?.image))
        list.add(Champ(id=champs.Sivir?.id,stats=champs.Sivir?.stats,title=champs.Sivir?.title,name=champs.Sivir?.name,image=champs.Sivir?.image))
        list.add(Champ(id=champs.Skarner?.id,stats=champs.Skarner?.stats,title=champs.Skarner?.title,name=champs.Skarner?.name,image=champs.Skarner?.image))
        list.add(Champ(id=champs.Sona?.id,stats=champs.Sona?.stats,title=champs.Sona?.title,name=champs.Sona?.name,image=champs.Sona?.image))
        list.add(Champ(id=champs.Soraka?.id,stats=champs.Soraka?.stats,title=champs.Soraka?.title,name=champs.Soraka?.name,image=champs.Soraka?.image))
        list.add(Champ(id=champs.Swain?.id,stats=champs.Swain?.stats,title=champs.Swain?.title,name=champs.Swain?.name,image=champs.Swain?.image))
        list.add(Champ(id=champs.Sylas?.id,stats=champs.Sylas?.stats,title=champs.Sylas?.title,name=champs.Sylas?.name,image=champs.Sylas?.image))
        list.add(Champ(id=champs.Syndra?.id,stats=champs.Syndra?.stats,title=champs.Syndra?.title,name=champs.Syndra?.name,image=champs.Syndra?.image))
        list.add(Champ(id=champs.TahmKench?.id,stats=champs.TahmKench?.stats,title=champs.TahmKench?.title,name=champs.TahmKench?.name,image=champs.TahmKench?.image))
        list.add(Champ(id=champs.Taliyah?.id,stats=champs.Taliyah?.stats,title=champs.Taliyah?.title,name=champs.Taliyah?.name,image=champs.Taliyah?.image))
        list.add(Champ(id=champs.Talon?.id,stats=champs.Talon?.stats,title=champs.Talon?.title,name=champs.Talon?.name,image=champs.Talon?.image))
        list.add(Champ(id=champs.Taric?.id,stats=champs.Taric?.stats,title=champs.Taric?.title,name=champs.Taric?.name,image=champs.Taric?.image))
        list.add(Champ(id=champs.Teemo?.id,stats=champs.Teemo?.stats,title=champs.Teemo?.title,name=champs.Teemo?.name,image=champs.Teemo?.image))
        list.add(Champ(id=champs.Thresh?.id,stats=champs.Thresh?.stats,title=champs.Thresh?.title,name=champs.Thresh?.name,image=champs.Thresh?.image))
        list.add(Champ(id=champs.Tristana?.id,stats=champs.Tristana?.stats,title=champs.Tristana?.title,name=champs.Tristana?.name,image=champs.Tristana?.image))
        list.add(Champ(id=champs.Trundle?.id,stats=champs.Trundle?.stats,title=champs.Trundle?.title,name=champs.Trundle?.name,image=champs.Trundle?.image))
        list.add(Champ(id=champs.Tryndamere?.id,stats=champs.Tryndamere?.stats,title=champs.Tryndamere?.title,name=champs.Tryndamere?.name,image=champs.Tryndamere?.image))
        list.add(Champ(id=champs.TwistedFate?.id,stats=champs.TwistedFate?.stats,title=champs.TwistedFate?.title,name=champs.TwistedFate?.name,image=champs.TwistedFate?.image))
        list.add(Champ(id=champs.Twitch?.id,stats=champs.Twitch?.stats,title=champs.Twitch?.title,name=champs.Twitch?.name,image=champs.Twitch?.image))
        list.add(Champ(id=champs.Udyr?.id,stats=champs.Udyr?.stats,title=champs.Udyr?.title,name=champs.Udyr?.name,image=champs.Udyr?.image))
        list.add(Champ(id=champs.Urgot?.id,stats=champs.Urgot?.stats,title=champs.Urgot?.title,name=champs.Urgot?.name,image=champs.Urgot?.image))
        list.add(Champ(id=champs.Varus?.id,stats=champs.Varus?.stats,title=champs.Varus?.title,name=champs.Varus?.name,image=champs.Varus?.image))
        list.add(Champ(id=champs.Vayne?.id,stats=champs.Vayne?.stats,title=champs.Vayne?.title,name=champs.Vayne?.name,image=champs.Vayne?.image))
        list.add(Champ(id=champs.Veigar?.id,stats=champs.Veigar?.stats,title=champs.Veigar?.title,name=champs.Veigar?.name,image=champs.Veigar?.image))
        list.add(Champ(id=champs.Velkoz?.id,stats=champs.Velkoz?.stats,title=champs.Velkoz?.title,name=champs.Velkoz?.name,image=champs.Velkoz?.image))
        list.add(Champ(id=champs.Vex?.id,stats=champs.Vex?.stats,title=champs.Vex?.title,name=champs.Vex?.name,image=champs.Vex?.image))
        list.add(Champ(id=champs.Vi?.id,stats=champs.Vi?.stats,title=champs.Vi?.title,name=champs.Vi?.name,image=champs.Vi?.image))
        list.add(Champ(id=champs.Viego?.id,stats=champs.Viego?.stats,title=champs.Viego?.title,name=champs.Viego?.name,image=champs.Viego?.image))
        list.add(Champ(id=champs.Viktor?.id,stats=champs.Viktor?.stats,title=champs.Viktor?.title,name=champs.Viktor?.name,image=champs.Viktor?.image))
        list.add(Champ(id=champs.Vladimir?.id,stats=champs.Vladimir?.stats,title=champs.Vladimir?.title,name=champs.Vladimir?.name,image=champs.Vladimir?.image))
        list.add(Champ(id=champs.Volibear?.id,stats=champs.Volibear?.stats,title=champs.Volibear?.title,name=champs.Volibear?.name,image=champs.Volibear?.image))
        list.add(Champ(id=champs.Warwick?.id,stats=champs.Warwick?.stats,title=champs.Warwick?.title,name=champs.Warwick?.name,image=champs.Warwick?.image))
        list.add(Champ(id=champs.Xayah?.id,stats=champs.Xayah?.stats,title=champs.Xayah?.title,name=champs.Xayah?.name,image=champs.Xayah?.image))
        list.add(Champ(id=champs.Xerath?.id,stats=champs.Xerath?.stats,title=champs.Xerath?.title,name=champs.Xerath?.name,image=champs.Xerath?.image))
        list.add(Champ(id=champs.XinZhao?.id,stats=champs.XinZhao?.stats,title=champs.XinZhao?.title,name=champs.XinZhao?.name,image=champs.XinZhao?.image))
        list.add(Champ(id=champs.Yasuo?.id,stats=champs.Yasuo?.stats,title=champs.Yasuo?.title,name=champs.Yasuo?.name,image=champs.Yasuo?.image))
        list.add(Champ(id=champs.Yone?.id,stats=champs.Yone?.stats,title=champs.Yone?.title,name=champs.Yone?.name,image=champs.Yone?.image))
        list.add(Champ(id=champs.Yorick?.id,stats=champs.Yorick?.stats,title=champs.Yorick?.title,name=champs.Yorick?.name,image=champs.Yorick?.image))
        list.add(Champ(id=champs.Yuumi?.id,stats=champs.Yuumi?.stats,title=champs.Yuumi?.title,name=champs.Yuumi?.name,image=champs.Yuumi?.image))
        list.add(Champ(id=champs.Zac?.id,stats=champs.Zac?.stats,title=champs.Zac?.title,name=champs.Zac?.name,image=champs.Zac?.image))
        list.add(Champ(id=champs.Zed?.id,stats=champs.Zed?.stats,title=champs.Zed?.title,name=champs.Zed?.name,image=champs.Zed?.image))
        list.add(Champ(id=champs.Zeri?.id,stats=champs.Zeri?.stats,title=champs.Zeri?.title,name=champs.Zeri?.name,image=champs.Zeri?.image))
        list.add(Champ(id=champs.Ziggs?.id,stats=champs.Ziggs?.stats,title=champs.Ziggs?.title,name=champs.Ziggs?.name,image=champs.Ziggs?.image))
        list.add(Champ(id=champs.Zilean?.id,stats=champs.Zilean?.stats,title=champs.Zilean?.title,name=champs.Zilean?.name,image=champs.Zilean?.image))
        list.add(Champ(id=champs.Zoe?.id,stats=champs.Zoe?.stats,title=champs.Zoe?.title,name=champs.Zoe?.name,image=champs.Zoe?.image))
        list.add(Champ(id=champs.Zyra?.id,stats=champs.Zyra?.stats,title=champs.Zyra?.title,name=champs.Zyra?.name,image=champs.Zyra?.image))

        return list

    }
    fun itemsConverter(items: DataItem):List<SpecificItemData>{
        var list = mutableListOf<SpecificItemData>()
        list.add(SpecificItemData(id=1001,gold=items.x1001?.gold,stats=items.x1001?.stats,image=items.x1001?.image,name=items.x1001?.name,description=items.x1001?.description))
        list.add(SpecificItemData(id=3006,gold=items.x3006?.gold,stats=items.x3006?.stats,image=items.x3006?.image,name=items.x3006?.name,description=items.x3006?.description))
        list.add(SpecificItemData(id=3009,gold=items.x3009?.gold,stats=items.x3009?.stats,image=items.x3009?.image,name=items.x3009?.name,description=items.x3009?.description))
        list.add(SpecificItemData(id=3020,gold=items.x3020?.gold,stats=items.x3020?.stats,image=items.x3020?.image,name=items.x3020?.name,description=items.x3020?.description))
        list.add(SpecificItemData(id=3047,gold=items.x3047?.gold,stats=items.x3047?.stats,image=items.x3047?.image,name=items.x3047?.name,description=items.x3047?.description))
//        //list.add(SpecificItemData(id=1004,gold=items.x1004?.gold,stats=items.x1004?.stats,image=items.x1004?.image,name=items.x1004?.name,description=items.x1004?.description))
//        list.add(SpecificItemData(id=1006,gold=items.x1006?.gold,stats=items.x1006?.stats,image=items.x1006?.image,name=items.x1006?.name,description=items.x1006?.description))
//        list.add(SpecificItemData(id=1011,gold=items.x1011?.gold,stats=items.x1011?.stats,image=items.x1011?.image,name=items.x1011?.name,description=items.x1011?.description))
//        list.add(SpecificItemData(id=1018,gold=items.x1018?.gold,stats=items.x1018?.stats,image=items.x1018?.image,name=items.x1018?.name,description=items.x1018?.description))
//        list.add(SpecificItemData(id=1026,gold=items.x1026?.gold,stats=items.x1026?.stats,image=items.x1026?.image,name=items.x1026?.name,description=items.x1026?.description))
//        list.add(SpecificItemData(id=1027,gold=items.x1027?.gold,stats=items.x1027?.stats,image=items.x1027?.image,name=items.x1027?.name,description=items.x1027?.description))
//        list.add(SpecificItemData(id=1028,gold=items.x1028?.gold,stats=items.x1028?.stats,image=items.x1028?.image,name=items.x1028?.name,description=items.x1028?.description))
//        list.add(SpecificItemData(id=1029,gold=items.x1029?.gold,stats=items.x1029?.stats,image=items.x1029?.image,name=items.x1029?.name,description=items.x1029?.description))
//        list.add(SpecificItemData(id=1031,gold=items.x1031?.gold,stats=items.x1031?.stats,image=items.x1031?.image,name=items.x1031?.name,description=items.x1031?.description))
//        list.add(SpecificItemData(id=1033,gold=items.x1033?.gold,stats=items.x1033?.stats,image=items.x1033?.image,name=items.x1033?.name,description=items.x1033?.description))
////        list.add(SpecificItemData(id=1035,gold=items.x1035?.gold,stats=items.x1035?.stats,image=items.x1035?.image,name=items.x1035?.name,description=items.x1035?.description))
//        list.add(SpecificItemData(id=1036,gold=items.x1036?.gold,stats=items.x1036?.stats,image=items.x1036?.image,name=items.x1036?.name,description=items.x1036?.description))
//        list.add(SpecificItemData(id=1037,gold=items.x1037?.gold,stats=items.x1037?.stats,image=items.x1037?.image,name=items.x1037?.name,description=items.x1037?.description))
//        list.add(SpecificItemData(id=1038,gold=items.x1038?.gold,stats=items.x1038?.stats,image=items.x1038?.image,name=items.x1038?.name,description=items.x1038?.description))
////        list.add(SpecificItemData(id=1039,gold=items.x1039?.gold,stats=items.x1039?.stats,image=items.x1039?.image,name=items.x1039?.name,description=items.x1039?.description))
////        list.add(SpecificItemData(id=1040,gold=items.x1040?.gold,stats=items.x1040?.stats,image=items.x1040?.image,name=items.x1040?.name,description=items.x1040?.description))
//        list.add(SpecificItemData(id=1042,gold=items.x1042?.gold,stats=items.x1042?.stats,image=items.x1042?.image,name=items.x1042?.name,description=items.x1042?.description))
//        list.add(SpecificItemData(id=1043,gold=items.x1043?.gold,stats=items.x1043?.stats,image=items.x1043?.image,name=items.x1043?.name,description=items.x1043?.description))
//        list.add(SpecificItemData(id=1052,gold=items.x1052?.gold,stats=items.x1052?.stats,image=items.x1052?.image,name=items.x1052?.name,description=items.x1052?.description))
//        list.add(SpecificItemData(id=1053,gold=items.x1053?.gold,stats=items.x1053?.stats,image=items.x1053?.image,name=items.x1053?.name,description=items.x1053?.description))
//        list.add(SpecificItemData(id=1054,gold=items.x1054?.gold,stats=items.x1054?.stats,image=items.x1054?.image,name=items.x1054?.name,description=items.x1054?.description))
//        list.add(SpecificItemData(id=1055,gold=items.x1055?.gold,stats=items.x1055?.stats,image=items.x1055?.image,name=items.x1055?.name,description=items.x1055?.description))
//        list.add(SpecificItemData(id=1056,gold=items.x1056?.gold,stats=items.x1056?.stats,image=items.x1056?.image,name=items.x1056?.name,description=items.x1056?.description))
//        list.add(SpecificItemData(id=1057,gold=items.x1057?.gold,stats=items.x1057?.stats,image=items.x1057?.image,name=items.x1057?.name,description=items.x1057?.description))
//        list.add(SpecificItemData(id=1058,gold=items.x1058?.gold,stats=items.x1058?.stats,image=items.x1058?.image,name=items.x1058?.name,description=items.x1058?.description))
//        list.add(SpecificItemData(id=1082,gold=items.x1082?.gold,stats=items.x1082?.stats,image=items.x1082?.image,name=items.x1082?.name,description=items.x1082?.description))
//        list.add(SpecificItemData(id=1083,gold=items.x1083?.gold,stats=items.x1083?.stats,image=items.x1083?.image,name=items.x1083?.name,description=items.x1083?.description))
//        list.add(SpecificItemData(id=1101,gold=items.x1101?.gold,stats=items.x1101?.stats,image=items.x1101?.image,name=items.x1101?.name,description=items.x1101?.description))
//        list.add(SpecificItemData(id=1102,gold=items.x1102?.gold,stats=items.x1102?.stats,image=items.x1102?.image,name=items.x1102?.name,description=items.x1102?.description))
//        list.add(SpecificItemData(id=1103,gold=items.x1103?.gold,stats=items.x1103?.stats,image=items.x1103?.image,name=items.x1103?.name,description=items.x1103?.description))
//        list.add(SpecificItemData(id=1104,gold=items.x1104?.gold,stats=items.x1104?.stats,image=items.x1104?.image,name=items.x1104?.name,description=items.x1104?.description))
//        list.add(SpecificItemData(id=1500,gold=items.x1500?.gold,stats=items.x1500?.stats,image=items.x1500?.image,name=items.x1500?.name,description=items.x1500?.description))
//        list.add(SpecificItemData(id=1501,gold=items.x1501?.gold,stats=items.x1501?.stats,image=items.x1501?.image,name=items.x1501?.name,description=items.x1501?.description))
//        list.add(SpecificItemData(id=1502,gold=items.x1502?.gold,stats=items.x1502?.stats,image=items.x1502?.image,name=items.x1502?.name,description=items.x1502?.description))
//        list.add(SpecificItemData(id=1503,gold=items.x1503?.gold,stats=items.x1503?.stats,image=items.x1503?.image,name=items.x1503?.name,description=items.x1503?.description))
//        list.add(SpecificItemData(id=1504,gold=items.x1504?.gold,stats=items.x1504?.stats,image=items.x1504?.image,name=items.x1504?.name,description=items.x1504?.description))
//        list.add(SpecificItemData(id=1505,gold=items.x1505?.gold,stats=items.x1505?.stats,image=items.x1505?.image,name=items.x1505?.name,description=items.x1505?.description))
//        list.add(SpecificItemData(id=1506,gold=items.x1506?.gold,stats=items.x1506?.stats,image=items.x1506?.image,name=items.x1506?.name,description=items.x1506?.description))
//        list.add(SpecificItemData(id=1507,gold=items.x1507?.gold,stats=items.x1507?.stats,image=items.x1507?.image,name=items.x1507?.name,description=items.x1507?.description))
//        list.add(SpecificItemData(id=1508,gold=items.x1508?.gold,stats=items.x1508?.stats,image=items.x1508?.image,name=items.x1508?.name,description=items.x1508?.description))
//        list.add(SpecificItemData(id=1509,gold=items.x1509?.gold,stats=items.x1509?.stats,image=items.x1509?.image,name=items.x1509?.name,description=items.x1509?.description))
//        list.add(SpecificItemData(id=1510,gold=items.x1510?.gold,stats=items.x1510?.stats,image=items.x1510?.image,name=items.x1510?.name,description=items.x1510?.description))
//        list.add(SpecificItemData(id=1511,gold=items.x1511?.gold,stats=items.x1511?.stats,image=items.x1511?.image,name=items.x1511?.name,description=items.x1511?.description))
//        list.add(SpecificItemData(id=1512,gold=items.x1512?.gold,stats=items.x1512?.stats,image=items.x1512?.image,name=items.x1512?.name,description=items.x1512?.description))
//        list.add(SpecificItemData(id=1515,gold=items.x1515?.gold,stats=items.x1515?.stats,image=items.x1515?.image,name=items.x1515?.name,description=items.x1515?.description))
//        list.add(SpecificItemData(id=1516,gold=items.x1516?.gold,stats=items.x1516?.stats,image=items.x1516?.image,name=items.x1516?.name,description=items.x1516?.description))
//        list.add(SpecificItemData(id=1517,gold=items.x1517?.gold,stats=items.x1517?.stats,image=items.x1517?.image,name=items.x1517?.name,description=items.x1517?.description))
//        list.add(SpecificItemData(id=1518,gold=items.x1518?.gold,stats=items.x1518?.stats,image=items.x1518?.image,name=items.x1518?.name,description=items.x1518?.description))
//        list.add(SpecificItemData(id=1519,gold=items.x1519?.gold,stats=items.x1519?.stats,image=items.x1519?.image,name=items.x1519?.name,description=items.x1519?.description))
//        list.add(SpecificItemData(id=1520,gold=items.x1520?.gold,stats=items.x1520?.stats,image=items.x1520?.image,name=items.x1520?.name,description=items.x1520?.description))
//        list.add(SpecificItemData(id=2003,gold=items.x2003?.gold,stats=items.x2003?.stats,image=items.x2003?.image,name=items.x2003?.name,description=items.x2003?.description))
//        list.add(SpecificItemData(id=2010,gold=items.x2010?.gold,stats=items.x2010?.stats,image=items.x2010?.image,name=items.x2010?.name,description=items.x2010?.description))
//        list.add(SpecificItemData(id=2015,gold=items.x2015?.gold,stats=items.x2015?.stats,image=items.x2015?.image,name=items.x2015?.name,description=items.x2015?.description))
//        list.add(SpecificItemData(id=2031,gold=items.x2031?.gold,stats=items.x2031?.stats,image=items.x2031?.image,name=items.x2031?.name,description=items.x2031?.description))
//        list.add(SpecificItemData(id=2033,gold=items.x2033?.gold,stats=items.x2033?.stats,image=items.x2033?.image,name=items.x2033?.name,description=items.x2033?.description))
//        list.add(SpecificItemData(id=2051,gold=items.x2051?.gold,stats=items.x2051?.stats,image=items.x2051?.image,name=items.x2051?.name,description=items.x2051?.description))
//        list.add(SpecificItemData(id=2052,gold=items.x2052?.gold,stats=items.x2052?.stats,image=items.x2052?.image,name=items.x2052?.name,description=items.x2052?.description))
//        list.add(SpecificItemData(id=2055,gold=items.x2055?.gold,stats=items.x2055?.stats,image=items.x2055?.image,name=items.x2055?.name,description=items.x2055?.description))
        list.add(SpecificItemData(id=2065,gold=items.x2065?.gold,stats=items.x2065?.stats,image=items.x2065?.image,name=items.x2065?.name,description=items.x2065?.description))
//        list.add(SpecificItemData(id=2138,gold=items.x2138?.gold,stats=items.x2138?.stats,image=items.x2138?.image,name=items.x2138?.name,description=items.x2138?.description))
//        list.add(SpecificItemData(id=2139,gold=items.x2139?.gold,stats=items.x2139?.stats,image=items.x2139?.image,name=items.x2139?.name,description=items.x2139?.description))
//        list.add(SpecificItemData(id=2140,gold=items.x2140?.gold,stats=items.x2140?.stats,image=items.x2140?.image,name=items.x2140?.name,description=items.x2140?.description))
//        list.add(SpecificItemData(id=2403,gold=items.x2403?.gold,stats=items.x2403?.stats,image=items.x2403?.image,name=items.x2403?.name,description=items.x2403?.description))
//        list.add(SpecificItemData(id=2419,gold=items.x2419?.gold,stats=items.x2419?.stats,image=items.x2419?.image,name=items.x2419?.name,description=items.x2419?.description))
//        list.add(SpecificItemData(id=2420,gold=items.x2420?.gold,stats=items.x2420?.stats,image=items.x2420?.image,name=items.x2420?.name,description=items.x2420?.description))
//        list.add(SpecificItemData(id=2421,gold=items.x2421?.gold,stats=items.x2421?.stats,image=items.x2421?.image,name=items.x2421?.name,description=items.x2421?.description))
//        list.add(SpecificItemData(id=2422,gold=items.x2422?.gold,stats=items.x2422?.stats,image=items.x2422?.image,name=items.x2422?.name,description=items.x2422?.description))
//        list.add(SpecificItemData(id=2423,gold=items.x2423?.gold,stats=items.x2423?.stats,image=items.x2423?.image,name=items.x2423?.name,description=items.x2423?.description))
//        list.add(SpecificItemData(id=2424,gold=items.x2424?.gold,stats=items.x2424?.stats,image=items.x2424?.image,name=items.x2424?.name,description=items.x2424?.description))
//        list.add(SpecificItemData(id=3001,gold=items.x3001?.gold,stats=items.x3001?.stats,image=items.x3001?.image,name=items.x3001?.name,description=items.x3001?.description))
        list.add(SpecificItemData(id=3003,gold=items.x3003?.gold,stats=items.x3003?.stats,image=items.x3003?.image,name=items.x3003?.name,description=items.x3003?.description))
        list.add(SpecificItemData(id=3004,gold=items.x3004?.gold,stats=items.x3004?.stats,image=items.x3004?.image,name=items.x3004?.name,description=items.x3004?.description))
        list.add(SpecificItemData(id=3011,gold=items.x3011?.gold,stats=items.x3011?.stats,image=items.x3011?.image,name=items.x3011?.name,description=items.x3011?.description))

//        list.add(SpecificItemData(id=3024,gold=items.x3024?.gold,stats=items.x3024?.stats,image=items.x3024?.image,name=items.x3024?.name,description=items.x3024?.description))
        list.add(SpecificItemData(id=3026,gold=items.x3026?.gold,stats=items.x3026?.stats,image=items.x3026?.image,name=items.x3026?.name,description=items.x3026?.description))
        list.add(SpecificItemData(id=3031,gold=items.x3031?.gold,stats=items.x3031?.stats,image=items.x3031?.image,name=items.x3031?.name,description=items.x3031?.description))
        list.add(SpecificItemData(id=3033,gold=items.x3033?.gold,stats=items.x3033?.stats,image=items.x3033?.image,name=items.x3033?.name,description=items.x3033?.description))
//        list.add(SpecificItemData(id=3035,gold=items.x3035?.gold,stats=items.x3035?.stats,image=items.x3035?.image,name=items.x3035?.name,description=items.x3035?.description))
        list.add(SpecificItemData(id=3036,gold=items.x3036?.gold,stats=items.x3036?.stats,image=items.x3036?.image,name=items.x3036?.name,description=items.x3036?.description))
        list.add(SpecificItemData(id=3040,gold=items.x3040?.gold,stats=items.x3040?.stats,image=items.x3040?.image,name=items.x3040?.name,description=items.x3040?.description))
        list.add(SpecificItemData(id=3041,gold=items.x3041?.gold,stats=items.x3041?.stats,image=items.x3041?.image,name=items.x3041?.name,description=items.x3041?.description))
        list.add(SpecificItemData(id=3042,gold=items.x3042?.gold,stats=items.x3042?.stats,image=items.x3042?.image,name=items.x3042?.name,description=items.x3042?.description))
//        list.add(SpecificItemData(id=3044,gold=items.x3044?.gold,stats=items.x3044?.stats,image=items.x3044?.image,name=items.x3044?.name,description=items.x3044?.description))
        list.add(SpecificItemData(id=3046,gold=items.x3046?.gold,stats=items.x3046?.stats,image=items.x3046?.image,name=items.x3046?.name,description=items.x3046?.description))
//
        list.add(SpecificItemData(id=3050,gold=items.x3050?.gold,stats=items.x3050?.stats,image=items.x3050?.image,name=items.x3050?.name,description=items.x3050?.description))
//        list.add(SpecificItemData(id=3051,gold=items.x3051?.gold,stats=items.x3051?.stats,image=items.x3051?.image,name=items.x3051?.name,description=items.x3051?.description))
        list.add(SpecificItemData(id=3053,gold=items.x3053?.gold,stats=items.x3053?.stats,image=items.x3053?.image,name=items.x3053?.name,description=items.x3053?.description))
        list.add(SpecificItemData(id=3057,gold=items.x3057?.gold,stats=items.x3057?.stats,image=items.x3057?.image,name=items.x3057?.name,description=items.x3057?.description))
        list.add(SpecificItemData(id=3065,gold=items.x3065?.gold,stats=items.x3065?.stats,image=items.x3065?.image,name=items.x3065?.name,description=items.x3065?.description))
        list.add(SpecificItemData(id=3066,gold=items.x3066?.gold,stats=items.x3066?.stats,image=items.x3066?.image,name=items.x3066?.name,description=items.x3066?.description))
        list.add(SpecificItemData(id=3067,gold=items.x3067?.gold,stats=items.x3067?.stats,image=items.x3067?.image,name=items.x3067?.name,description=items.x3067?.description))
        list.add(SpecificItemData(id=3068,gold=items.x3068?.gold,stats=items.x3068?.stats,image=items.x3068?.image,name=items.x3068?.name,description=items.x3068?.description))
        list.add(SpecificItemData(id=3070,gold=items.x3070?.gold,stats=items.x3070?.stats,image=items.x3070?.image,name=items.x3070?.name,description=items.x3070?.description))
        list.add(SpecificItemData(id=3071,gold=items.x3071?.gold,stats=items.x3071?.stats,image=items.x3071?.image,name=items.x3071?.name,description=items.x3071?.description))
        list.add(SpecificItemData(id=3072,gold=items.x3072?.gold,stats=items.x3072?.stats,image=items.x3072?.image,name=items.x3072?.name,description=items.x3072?.description))
        list.add(SpecificItemData(id=3074,gold=items.x3074?.gold,stats=items.x3074?.stats,image=items.x3074?.image,name=items.x3074?.name,description=items.x3074?.description))
        list.add(SpecificItemData(id=3075,gold=items.x3075?.gold,stats=items.x3075?.stats,image=items.x3075?.image,name=items.x3075?.name,description=items.x3075?.description))
        list.add(SpecificItemData(id=3076,gold=items.x3076?.gold,stats=items.x3076?.stats,image=items.x3076?.image,name=items.x3076?.name,description=items.x3076?.description))
        list.add(SpecificItemData(id=3077,gold=items.x3077?.gold,stats=items.x3077?.stats,image=items.x3077?.image,name=items.x3077?.name,description=items.x3077?.description))
        list.add(SpecificItemData(id=3078,gold=items.x3078?.gold,stats=items.x3078?.stats,image=items.x3078?.image,name=items.x3078?.name,description=items.x3078?.description))
        list.add(SpecificItemData(id=3082,gold=items.x3082?.gold,stats=items.x3082?.stats,image=items.x3082?.image,name=items.x3082?.name,description=items.x3082?.description))
        list.add(SpecificItemData(id=3083,gold=items.x3083?.gold,stats=items.x3083?.stats,image=items.x3083?.image,name=items.x3083?.name,description=items.x3083?.description))
        list.add(SpecificItemData(id=3084,gold=items.x3084?.gold,stats=items.x3084?.stats,image=items.x3084?.image,name=items.x3084?.name,description=items.x3084?.description))
        list.add(SpecificItemData(id=3085,gold=items.x3085?.gold,stats=items.x3085?.stats,image=items.x3085?.image,name=items.x3085?.name,description=items.x3085?.description))
        list.add(SpecificItemData(id=3086,gold=items.x3086?.gold,stats=items.x3086?.stats,image=items.x3086?.image,name=items.x3086?.name,description=items.x3086?.description))
        list.add(SpecificItemData(id=3089,gold=items.x3089?.gold,stats=items.x3089?.stats,image=items.x3089?.image,name=items.x3089?.name,description=items.x3089?.description))
        list.add(SpecificItemData(id=3091,gold=items.x3091?.gold,stats=items.x3091?.stats,image=items.x3091?.image,name=items.x3091?.name,description=items.x3091?.description))
        list.add(SpecificItemData(id=3094,gold=items.x3094?.gold,stats=items.x3094?.stats,image=items.x3094?.image,name=items.x3094?.name,description=items.x3094?.description))
        list.add(SpecificItemData(id=3095,gold=items.x3095?.gold,stats=items.x3095?.stats,image=items.x3095?.image,name=items.x3095?.name,description=items.x3095?.description))
        list.add(SpecificItemData(id=3100,gold=items.x3100?.gold,stats=items.x3100?.stats,image=items.x3100?.image,name=items.x3100?.name,description=items.x3100?.description))
        list.add(SpecificItemData(id=3102,gold=items.x3102?.gold,stats=items.x3102?.stats,image=items.x3102?.image,name=items.x3102?.name,description=items.x3102?.description))
        list.add(SpecificItemData(id=3105,gold=items.x3105?.gold,stats=items.x3105?.stats,image=items.x3105?.image,name=items.x3105?.name,description=items.x3105?.description))
        list.add(SpecificItemData(id=3107,gold=items.x3107?.gold,stats=items.x3107?.stats,image=items.x3107?.image,name=items.x3107?.name,description=items.x3107?.description))
        list.add(SpecificItemData(id=3108,gold=items.x3108?.gold,stats=items.x3108?.stats,image=items.x3108?.image,name=items.x3108?.name,description=items.x3108?.description))
        list.add(SpecificItemData(id=3109,gold=items.x3109?.gold,stats=items.x3109?.stats,image=items.x3109?.image,name=items.x3109?.name,description=items.x3109?.description))
        list.add(SpecificItemData(id=3110,gold=items.x3110?.gold,stats=items.x3110?.stats,image=items.x3110?.image,name=items.x3110?.name,description=items.x3110?.description))
        list.add(SpecificItemData(id=3111,gold=items.x3111?.gold,stats=items.x3111?.stats,image=items.x3111?.image,name=items.x3111?.name,description=items.x3111?.description))
        list.add(SpecificItemData(id=3112,gold=items.x3112?.gold,stats=items.x3112?.stats,image=items.x3112?.image,name=items.x3112?.name,description=items.x3112?.description))
        list.add(SpecificItemData(id=3113,gold=items.x3113?.gold,stats=items.x3113?.stats,image=items.x3113?.image,name=items.x3113?.name,description=items.x3113?.description))
        list.add(SpecificItemData(id=3114,gold=items.x3114?.gold,stats=items.x3114?.stats,image=items.x3114?.image,name=items.x3114?.name,description=items.x3114?.description))
        list.add(SpecificItemData(id=3115,gold=items.x3115?.gold,stats=items.x3115?.stats,image=items.x3115?.image,name=items.x3115?.name,description=items.x3115?.description))
        list.add(SpecificItemData(id=3116,gold=items.x3116?.gold,stats=items.x3116?.stats,image=items.x3116?.image,name=items.x3116?.name,description=items.x3116?.description))
        list.add(SpecificItemData(id=3117,gold=items.x3117?.gold,stats=items.x3117?.stats,image=items.x3117?.image,name=items.x3117?.name,description=items.x3117?.description))
        list.add(SpecificItemData(id=3119,gold=items.x3119?.gold,stats=items.x3119?.stats,image=items.x3119?.image,name=items.x3119?.name,description=items.x3119?.description))
        list.add(SpecificItemData(id=3121,gold=items.x3121?.gold,stats=items.x3121?.stats,image=items.x3121?.image,name=items.x3121?.name,description=items.x3121?.description))
        list.add(SpecificItemData(id=3123,gold=items.x3123?.gold,stats=items.x3123?.stats,image=items.x3123?.image,name=items.x3123?.name,description=items.x3123?.description))
        list.add(SpecificItemData(id=3124,gold=items.x3124?.gold,stats=items.x3124?.stats,image=items.x3124?.image,name=items.x3124?.name,description=items.x3124?.description))
        list.add(SpecificItemData(id=3133,gold=items.x3133?.gold,stats=items.x3133?.stats,image=items.x3133?.image,name=items.x3133?.name,description=items.x3133?.description))
        list.add(SpecificItemData(id=3134,gold=items.x3134?.gold,stats=items.x3134?.stats,image=items.x3134?.image,name=items.x3134?.name,description=items.x3134?.description))
        list.add(SpecificItemData(id=3135,gold=items.x3135?.gold,stats=items.x3135?.stats,image=items.x3135?.image,name=items.x3135?.name,description=items.x3135?.description))
        list.add(SpecificItemData(id=3139,gold=items.x3139?.gold,stats=items.x3139?.stats,image=items.x3139?.image,name=items.x3139?.name,description=items.x3139?.description))
        list.add(SpecificItemData(id=3140,gold=items.x3140?.gold,stats=items.x3140?.stats,image=items.x3140?.image,name=items.x3140?.name,description=items.x3140?.description))
        list.add(SpecificItemData(id=3142,gold=items.x3142?.gold,stats=items.x3142?.stats,image=items.x3142?.image,name=items.x3142?.name,description=items.x3142?.description))
        list.add(SpecificItemData(id=3143,gold=items.x3143?.gold,stats=items.x3143?.stats,image=items.x3143?.image,name=items.x3143?.name,description=items.x3143?.description))
        list.add(SpecificItemData(id=3145,gold=items.x3145?.gold,stats=items.x3145?.stats,image=items.x3145?.image,name=items.x3145?.name,description=items.x3145?.description))
        list.add(SpecificItemData(id=3152,gold=items.x3152?.gold,stats=items.x3152?.stats,image=items.x3152?.image,name=items.x3152?.name,description=items.x3152?.description))
        list.add(SpecificItemData(id=3153,gold=items.x3153?.gold,stats=items.x3153?.stats,image=items.x3153?.image,name=items.x3153?.name,description=items.x3153?.description))
        list.add(SpecificItemData(id=3155,gold=items.x3155?.gold,stats=items.x3155?.stats,image=items.x3155?.image,name=items.x3155?.name,description=items.x3155?.description))
        list.add(SpecificItemData(id=3156,gold=items.x3156?.gold,stats=items.x3156?.stats,image=items.x3156?.image,name=items.x3156?.name,description=items.x3156?.description))
        list.add(SpecificItemData(id=3157,gold=items.x3157?.gold,stats=items.x3157?.stats,image=items.x3157?.image,name=items.x3157?.name,description=items.x3157?.description))
        list.add(SpecificItemData(id=3158,gold=items.x3158?.gold,stats=items.x3158?.stats,image=items.x3158?.image,name=items.x3158?.name,description=items.x3158?.description))
        list.add(SpecificItemData(id=3161,gold=items.x3161?.gold,stats=items.x3161?.stats,image=items.x3161?.image,name=items.x3161?.name,description=items.x3161?.description))
        list.add(SpecificItemData(id=3165,gold=items.x3165?.gold,stats=items.x3165?.stats,image=items.x3165?.image,name=items.x3165?.name,description=items.x3165?.description))
//        list.add(SpecificItemData(id=3177,gold=items.x3177?.gold,stats=items.x3177?.stats,image=items.x3177?.image,name=items.x3177?.name,description=items.x3177?.description))
        list.add(SpecificItemData(id=3179,gold=items.x3179?.gold,stats=items.x3179?.stats,image=items.x3179?.image,name=items.x3179?.name,description=items.x3179?.description))
        list.add(SpecificItemData(id=3181,gold=items.x3181?.gold,stats=items.x3181?.stats,image=items.x3181?.image,name=items.x3181?.name,description=items.x3181?.description))
//        list.add(SpecificItemData(id=3184,gold=items.x3184?.gold,stats=items.x3184?.stats,image=items.x3184?.image,name=items.x3184?.name,description=items.x3184?.description))
        list.add(SpecificItemData(id=3190,gold=items.x3190?.gold,stats=items.x3190?.stats,image=items.x3190?.image,name=items.x3190?.name,description=items.x3190?.description))
        list.add(SpecificItemData(id=3191,gold=items.x3191?.gold,stats=items.x3191?.stats,image=items.x3191?.image,name=items.x3191?.name,description=items.x3191?.description))
        list.add(SpecificItemData(id=3193,gold=items.x3193?.gold,stats=items.x3193?.stats,image=items.x3193?.image,name=items.x3193?.name,description=items.x3193?.description))
        list.add(SpecificItemData(id=3211,gold=items.x3211?.gold,stats=items.x3211?.stats,image=items.x3211?.image,name=items.x3211?.name,description=items.x3211?.description))
        list.add(SpecificItemData(id=3222,gold=items.x3222?.gold,stats=items.x3222?.stats,image=items.x3222?.image,name=items.x3222?.name,description=items.x3222?.description))
//        list.add(SpecificItemData(id=3330,gold=items.x3330?.gold,stats=items.x3330?.stats,image=items.x3330?.image,name=items.x3330?.name,description=items.x3330?.description))
//        list.add(SpecificItemData(id=3340,gold=items.x3340?.gold,stats=items.x3340?.stats,image=items.x3340?.image,name=items.x3340?.name,description=items.x3340?.description))
//        list.add(SpecificItemData(id=3363,gold=items.x3363?.gold,stats=items.x3363?.stats,image=items.x3363?.image,name=items.x3363?.name,description=items.x3363?.description))
//        list.add(SpecificItemData(id=3364,gold=items.x3364?.gold,stats=items.x3364?.stats,image=items.x3364?.image,name=items.x3364?.name,description=items.x3364?.description))
//        list.add(SpecificItemData(id=3400,gold=items.x3400?.gold,stats=items.x3400?.stats,image=items.x3400?.image,name=items.x3400?.name,description=items.x3400?.description))
        list.add(SpecificItemData(id=3504,gold=items.x3504?.gold,stats=items.x3504?.stats,image=items.x3504?.image,name=items.x3504?.name,description=items.x3504?.description))
        list.add(SpecificItemData(id=3508,gold=items.x3508?.gold,stats=items.x3508?.stats,image=items.x3508?.image,name=items.x3508?.name,description=items.x3508?.description))
//        list.add(SpecificItemData(id=3513,gold=items.x3513?.gold,stats=items.x3513?.stats,image=items.x3513?.image,name=items.x3513?.name,description=items.x3513?.description))
//        list.add(SpecificItemData(id=3599,gold=items.x3599?.gold,stats=items.x3599?.stats,image=items.x3599?.image,name=items.x3599?.name,description=items.x3599?.description))
//        list.add(SpecificItemData(id=3600,gold=items.x3600?.gold,stats=items.x3600?.stats,image=items.x3600?.image,name=items.x3600?.name,description=items.x3600?.description))
        list.add(SpecificItemData(id=3742,gold=items.x3742?.gold,stats=items.x3742?.stats,image=items.x3742?.image,name=items.x3742?.name,description=items.x3742?.description))
        list.add(SpecificItemData(id=3748,gold=items.x3748?.gold,stats=items.x3748?.stats,image=items.x3748?.image,name=items.x3748?.name,description=items.x3748?.description))
        list.add(SpecificItemData(id=3801,gold=items.x3801?.gold,stats=items.x3801?.stats,image=items.x3801?.image,name=items.x3801?.name,description=items.x3801?.description))
        list.add(SpecificItemData(id=3802,gold=items.x3802?.gold,stats=items.x3802?.stats,image=items.x3802?.image,name=items.x3802?.name,description=items.x3802?.description))
//        list.add(SpecificItemData(id=3803,gold=items.x3803?.gold,stats=items.x3803?.stats,image=items.x3803?.image,name=items.x3803?.name,description=items.x3803?.description))
//        list.add(SpecificItemData(id=3814,gold=items.x3814?.gold,stats=items.x3814?.stats,image=items.x3814?.image,name=items.x3814?.name,description=items.x3814?.description))
//        list.add(SpecificItemData(id=3850,gold=items.x3850?.gold,stats=items.x3850?.stats,image=items.x3850?.image,name=items.x3850?.name,description=items.x3850?.description))
//        list.add(SpecificItemData(id=3851,gold=items.x3851?.gold,stats=items.x3851?.stats,image=items.x3851?.image,name=items.x3851?.name,description=items.x3851?.description))
//        list.add(SpecificItemData(id=3853,gold=items.x3853?.gold,stats=items.x3853?.stats,image=items.x3853?.image,name=items.x3853?.name,description=items.x3853?.description))
//        list.add(SpecificItemData(id=3854,gold=items.x3854?.gold,stats=items.x3854?.stats,image=items.x3854?.image,name=items.x3854?.name,description=items.x3854?.description))
//        list.add(SpecificItemData(id=3855,gold=items.x3855?.gold,stats=items.x3855?.stats,image=items.x3855?.image,name=items.x3855?.name,description=items.x3855?.description))
//        list.add(SpecificItemData(id=3857,gold=items.x3857?.gold,stats=items.x3857?.stats,image=items.x3857?.image,name=items.x3857?.name,description=items.x3857?.description))
//        list.add(SpecificItemData(id=3858,gold=items.x3858?.gold,stats=items.x3858?.stats,image=items.x3858?.image,name=items.x3858?.name,description=items.x3858?.description))
//        list.add(SpecificItemData(id=3859,gold=items.x3859?.gold,stats=items.x3859?.stats,image=items.x3859?.image,name=items.x3859?.name,description=items.x3859?.description))
//        list.add(SpecificItemData(id=3860,gold=items.x3860?.gold,stats=items.x3860?.stats,image=items.x3860?.image,name=items.x3860?.name,description=items.x3860?.description))
//        list.add(SpecificItemData(id=3862,gold=items.x3862?.gold,stats=items.x3862?.stats,image=items.x3862?.image,name=items.x3862?.name,description=items.x3862?.description))
//        list.add(SpecificItemData(id=3863,gold=items.x3863?.gold,stats=items.x3863?.stats,image=items.x3863?.image,name=items.x3863?.name,description=items.x3863?.description))
//        list.add(SpecificItemData(id=3864,gold=items.x3864?.gold,stats=items.x3864?.stats,image=items.x3864?.image,name=items.x3864?.name,description=items.x3864?.description))
//        list.add(SpecificItemData(id=3901,gold=items.x3901?.gold,stats=items.x3901?.stats,image=items.x3901?.image,name=items.x3901?.name,description=items.x3901?.description))
//        list.add(SpecificItemData(id=3902,gold=items.x3902?.gold,stats=items.x3902?.stats,image=items.x3902?.image,name=items.x3902?.name,description=items.x3902?.description))
//        list.add(SpecificItemData(id=3903,gold=items.x3903?.gold,stats=items.x3903?.stats,image=items.x3903?.image,name=items.x3903?.name,description=items.x3903?.description))
        list.add(SpecificItemData(id=3916,gold=items.x3916?.gold,stats=items.x3916?.stats,image=items.x3916?.image,name=items.x3916?.name,description=items.x3916?.description))
        list.add(SpecificItemData(id=4005,gold=items.x4005?.gold,stats=items.x4005?.stats,image=items.x4005?.image,name=items.x4005?.name,description=items.x4005?.description))
        list.add(SpecificItemData(id=4401,gold=items.x4401?.gold,stats=items.x4401?.stats,image=items.x4401?.image,name=items.x4401?.name,description=items.x4401?.description))
//        list.add(SpecificItemData(id=4403,gold=items.x4403?.gold,stats=items.x4403?.stats,image=items.x4403?.image,name=items.x4403?.name,description=items.x4403?.description))
        list.add(SpecificItemData(id=4628,gold=items.x4628?.gold,stats=items.x4628?.stats,image=items.x4628?.image,name=items.x4628?.name,description=items.x4628?.description))
        list.add(SpecificItemData(id=4629,gold=items.x4629?.gold,stats=items.x4629?.stats,image=items.x4629?.image,name=items.x4629?.name,description=items.x4629?.description))
        list.add(SpecificItemData(id=4630,gold=items.x4630?.gold,stats=items.x4630?.stats,image=items.x4630?.image,name=items.x4630?.name,description=items.x4630?.description))
        list.add(SpecificItemData(id=4632,gold=items.x4632?.gold,stats=items.x4632?.stats,image=items.x4632?.image,name=items.x4632?.name,description=items.x4632?.description))
        list.add(SpecificItemData(id=4633,gold=items.x4633?.gold,stats=items.x4633?.stats,image=items.x4633?.image,name=items.x4633?.name,description=items.x4633?.description))
        list.add(SpecificItemData(id=4635,gold=items.x4635?.gold,stats=items.x4635?.stats,image=items.x4635?.image,name=items.x4635?.name,description=items.x4635?.description))
        list.add(SpecificItemData(id=4636,gold=items.x4636?.gold,stats=items.x4636?.stats,image=items.x4636?.image,name=items.x4636?.name,description=items.x4636?.description))
        list.add(SpecificItemData(id=4637,gold=items.x4637?.gold,stats=items.x4637?.stats,image=items.x4637?.image,name=items.x4637?.name,description=items.x4637?.description))
//        list.add(SpecificItemData(id=4638,gold=items.x4638?.gold,stats=items.x4638?.stats,image=items.x4638?.image,name=items.x4638?.name,description=items.x4638?.description))
//        list.add(SpecificItemData(id=4641,gold=items.x4641?.gold,stats=items.x4641?.stats,image=items.x4641?.image,name=items.x4641?.name,description=items.x4641?.description))
        list.add(SpecificItemData(id=4642,gold=items.x4642?.gold,stats=items.x4642?.stats,image=items.x4642?.image,name=items.x4642?.name,description=items.x4642?.description))
//        list.add(SpecificItemData(id=4643,gold=items.x4643?.gold,stats=items.x4643?.stats,image=items.x4643?.image,name=items.x4643?.name,description=items.x4643?.description))
        list.add(SpecificItemData(id=4644,gold=items.x4644?.gold,stats=items.x4644?.stats,image=items.x4644?.image,name=items.x4644?.name,description=items.x4644?.description))
        list.add(SpecificItemData(id=4645,gold=items.x4645?.gold,stats=items.x4645?.stats,image=items.x4645?.image,name=items.x4645?.name,description=items.x4645?.description))
        list.add(SpecificItemData(id=6029,gold=items.x6029?.gold,stats=items.x6029?.stats,image=items.x6029?.image,name=items.x6029?.name,description=items.x6029?.description))
        list.add(SpecificItemData(id=6035,gold=items.x6035?.gold,stats=items.x6035?.stats,image=items.x6035?.image,name=items.x6035?.name,description=items.x6035?.description))
        list.add(SpecificItemData(id=6333,gold=items.x6333?.gold,stats=items.x6333?.stats,image=items.x6333?.image,name=items.x6333?.name,description=items.x6333?.description))
        list.add(SpecificItemData(id=6609,gold=items.x6609?.gold,stats=items.x6609?.stats,image=items.x6609?.image,name=items.x6609?.name,description=items.x6609?.description))
        list.add(SpecificItemData(id=6616,gold=items.x6616?.gold,stats=items.x6616?.stats,image=items.x6616?.image,name=items.x6616?.name,description=items.x6616?.description))
        list.add(SpecificItemData(id=6617,gold=items.x6617?.gold,stats=items.x6617?.stats,image=items.x6617?.image,name=items.x6617?.name,description=items.x6617?.description))
        list.add(SpecificItemData(id=6630,gold=items.x6630?.gold,stats=items.x6630?.stats,image=items.x6630?.image,name=items.x6630?.name,description=items.x6630?.description))
        list.add(SpecificItemData(id=6631,gold=items.x6631?.gold,stats=items.x6631?.stats,image=items.x6631?.image,name=items.x6631?.name,description=items.x6631?.description))
        list.add(SpecificItemData(id=6632,gold=items.x6632?.gold,stats=items.x6632?.stats,image=items.x6632?.image,name=items.x6632?.name,description=items.x6632?.description))
        list.add(SpecificItemData(id=6653,gold=items.x6653?.gold,stats=items.x6653?.stats,image=items.x6653?.image,name=items.x6653?.name,description=items.x6653?.description))
        list.add(SpecificItemData(id=6655,gold=items.x6655?.gold,stats=items.x6655?.stats,image=items.x6655?.image,name=items.x6655?.name,description=items.x6655?.description))
        list.add(SpecificItemData(id=6656,gold=items.x6656?.gold,stats=items.x6656?.stats,image=items.x6656?.image,name=items.x6656?.name,description=items.x6656?.description))
        list.add(SpecificItemData(id=6657,gold=items.x6657?.gold,stats=items.x6657?.stats,image=items.x6657?.image,name=items.x6657?.name,description=items.x6657?.description))
        list.add(SpecificItemData(id=6660,gold=items.x6660?.gold,stats=items.x6660?.stats,image=items.x6660?.image,name=items.x6660?.name,description=items.x6660?.description))
        list.add(SpecificItemData(id=6662,gold=items.x6662?.gold,stats=items.x6662?.stats,image=items.x6662?.image,name=items.x6662?.name,description=items.x6662?.description))
        list.add(SpecificItemData(id=6664,gold=items.x6664?.gold,stats=items.x6664?.stats,image=items.x6664?.image,name=items.x6664?.name,description=items.x6664?.description))
        list.add(SpecificItemData(id=6665,gold=items.x6665?.gold,stats=items.x6665?.stats,image=items.x6665?.image,name=items.x6665?.name,description=items.x6665?.description))
//        list.add(SpecificItemData(id=6667,gold=items.x6667?.gold,stats=items.x6667?.stats,image=items.x6667?.image,name=items.x6667?.name,description=items.x6667?.description))
        list.add(SpecificItemData(id=6670,gold=items.x6670?.gold,stats=items.x6670?.stats,image=items.x6670?.image,name=items.x6670?.name,description=items.x6670?.description))
        list.add(SpecificItemData(id=6671,gold=items.x6671?.gold,stats=items.x6671?.stats,image=items.x6671?.image,name=items.x6671?.name,description=items.x6671?.description))
        list.add(SpecificItemData(id=6672,gold=items.x6672?.gold,stats=items.x6672?.stats,image=items.x6672?.image,name=items.x6672?.name,description=items.x6672?.description))
        list.add(SpecificItemData(id=6673,gold=items.x6673?.gold,stats=items.x6673?.stats,image=items.x6673?.image,name=items.x6673?.name,description=items.x6673?.description))
        list.add(SpecificItemData(id=6675,gold=items.x6675?.gold,stats=items.x6675?.stats,image=items.x6675?.image,name=items.x6675?.name,description=items.x6675?.description))
        list.add(SpecificItemData(id=6676,gold=items.x6676?.gold,stats=items.x6676?.stats,image=items.x6676?.image,name=items.x6676?.name,description=items.x6676?.description))
        list.add(SpecificItemData(id=6677,gold=items.x6677?.gold,stats=items.x6677?.stats,image=items.x6677?.image,name=items.x6677?.name,description=items.x6677?.description))
        list.add(SpecificItemData(id=6691,gold=items.x6691?.gold,stats=items.x6691?.stats,image=items.x6691?.image,name=items.x6691?.name,description=items.x6691?.description))
        list.add(SpecificItemData(id=6692,gold=items.x6692?.gold,stats=items.x6692?.stats,image=items.x6692?.image,name=items.x6692?.name,description=items.x6692?.description))
        list.add(SpecificItemData(id=6693,gold=items.x6693?.gold,stats=items.x6693?.stats,image=items.x6693?.image,name=items.x6693?.name,description=items.x6693?.description))
        list.add(SpecificItemData(id=6694,gold=items.x6694?.gold,stats=items.x6694?.stats,image=items.x6694?.image,name=items.x6694?.name,description=items.x6694?.description))
        list.add(SpecificItemData(id=6695,gold=items.x6695?.gold,stats=items.x6695?.stats,image=items.x6695?.image,name=items.x6695?.name,description=items.x6695?.description))
        list.add(SpecificItemData(id=6696,gold=items.x6696?.gold,stats=items.x6696?.stats,image=items.x6696?.image,name=items.x6696?.name,description=items.x6696?.description))
        list.add(SpecificItemData(id=7000,gold=items.x7000?.gold,stats=items.x7000?.stats,image=items.x7000?.image,name=items.x7000?.name,description=items.x7000?.description))
        list.add(SpecificItemData(id=7001,gold=items.x7001?.gold,stats=items.x7001?.stats,image=items.x7001?.image,name=items.x7001?.name,description=items.x7001?.description))
        list.add(SpecificItemData(id=7002,gold=items.x7002?.gold,stats=items.x7002?.stats,image=items.x7002?.image,name=items.x7002?.name,description=items.x7002?.description))
        list.add(SpecificItemData(id=7005,gold=items.x7005?.gold,stats=items.x7005?.stats,image=items.x7005?.image,name=items.x7005?.name,description=items.x7005?.description))
        list.add(SpecificItemData(id=7006,gold=items.x7006?.gold,stats=items.x7006?.stats,image=items.x7006?.image,name=items.x7006?.name,description=items.x7006?.description))
        list.add(SpecificItemData(id=7007,gold=items.x7007?.gold,stats=items.x7007?.stats,image=items.x7007?.image,name=items.x7007?.name,description=items.x7007?.description))

        list.add(SpecificItemData(id=7008,gold=items.x7008?.gold,stats=items.x7008?.stats,image=items.x7008?.image,name=items.x7008?.name,description=items.x7008?.description))
        list.add(SpecificItemData(id=7009,gold=items.x7009?.gold,stats=items.x7009?.stats,image=items.x7009?.image,name=items.x7009?.name,description=items.x7009?.description))
        list.add(SpecificItemData(id=7010,gold=items.x7010?.gold,stats=items.x7010?.stats,image=items.x7010?.image,name=items.x7010?.name,description=items.x7010?.description))
        list.add(SpecificItemData(id=7011,gold=items.x7011?.gold,stats=items.x7011?.stats,image=items.x7011?.image,name=items.x7011?.name,description=items.x7011?.description))
        list.add(SpecificItemData(id=7012,gold=items.x7012?.gold,stats=items.x7012?.stats,image=items.x7012?.image,name=items.x7012?.name,description=items.x7012?.description))
        list.add(SpecificItemData(id=7013,gold=items.x7013?.gold,stats=items.x7013?.stats,image=items.x7013?.image,name=items.x7013?.name,description=items.x7013?.description))
        list.add(SpecificItemData(id=7014,gold=items.x7014?.gold,stats=items.x7014?.stats,image=items.x7014?.image,name=items.x7014?.name,description=items.x7014?.description))
        list.add(SpecificItemData(id=7015,gold=items.x7015?.gold,stats=items.x7015?.stats,image=items.x7015?.image,name=items.x7015?.name,description=items.x7015?.description))
        list.add(SpecificItemData(id=7016,gold=items.x7016?.gold,stats=items.x7016?.stats,image=items.x7016?.image,name=items.x7016?.name,description=items.x7016?.description))
        list.add(SpecificItemData(id=7017,gold=items.x7017?.gold,stats=items.x7017?.stats,image=items.x7017?.image,name=items.x7017?.name,description=items.x7017?.description))
        list.add(SpecificItemData(id=7018,gold=items.x7018?.gold,stats=items.x7018?.stats,image=items.x7018?.image,name=items.x7018?.name,description=items.x7018?.description))
        list.add(SpecificItemData(id=7019,gold=items.x7019?.gold,stats=items.x7019?.stats,image=items.x7019?.image,name=items.x7019?.name,description=items.x7019?.description))
        list.add(SpecificItemData(id=7020,gold=items.x7020?.gold,stats=items.x7020?.stats,image=items.x7020?.image,name=items.x7020?.name,description=items.x7020?.description))
        list.add(SpecificItemData(id=7021,gold=items.x7021?.gold,stats=items.x7021?.stats,image=items.x7021?.image,name=items.x7021?.name,description=items.x7021?.description))
        list.add(SpecificItemData(id=7022,gold=items.x7022?.gold,stats=items.x7022?.stats,image=items.x7022?.image,name=items.x7022?.name,description=items.x7022?.description))
//        list.add(SpecificItemData(id=7023,gold=items.x7023?.gold,stats=items.x7023?.stats,image=items.x7023?.image,name=items.x7023?.name,description=items.x7023?.description))
        list.add(SpecificItemData(id=7024,gold=items.x7024?.gold,stats=items.x7024?.stats,image=items.x7024?.image,name=items.x7024?.name,description=items.x7024?.description))
//        list.add(SpecificItemData(id=7025,gold=items.x7025?.gold,stats=items.x7025?.stats,image=items.x7025?.image,name=items.x7025?.name,description=items.x7025?.description))
//        list.add(SpecificItemData(id=7026,gold=items.x7026?.gold,stats=items.x7026?.stats,image=items.x7026?.image,name=items.x7026?.name,description=items.x7026?.description))
//        list.add(SpecificItemData(id=7027,gold=items.x7027?.gold,stats=items.x7027?.stats,image=items.x7027?.image,name=items.x7027?.name,description=items.x7027?.description))
//        list.add(SpecificItemData(id=7028,gold=items.x7028?.gold,stats=items.x7028?.stats,image=items.x7028?.image,name=items.x7028?.name,description=items.x7028?.description))
//        list.add(SpecificItemData(id=7050,gold=items.x7050?.gold,stats=items.x7050?.stats,image=items.x7050?.image,name=items.x7050?.name,description=items.x7050?.description))
        list.add(SpecificItemData(id=8001,gold=items.x8001?.gold,stats=items.x8001?.stats,image=items.x8001?.image,name=items.x8001?.name,description=items.x8001?.description))
        list.add(SpecificItemData(id=8020,gold=items.x8020?.gold,stats=items.x8020?.stats,image=items.x8020?.image,name=items.x8020?.name,description=items.x8020?.description))

        return list

    }

}