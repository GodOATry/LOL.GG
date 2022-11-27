package com.example.lol_gg.data

import com.google.gson.annotations.SerializedName


data class Participants (

	@SerializedName("assists") val assists : Int = 0,
	@SerializedName("baronKills") val baronKills : Int = 0,
	@SerializedName("basicPings") val basicPings : Int = 0,
	@SerializedName("bountyLevel") val bountyLevel : Int = 0,
	@SerializedName("champExperience") val champExperience : Int = 0,
	@SerializedName("champLevel") val champLevel : Int = 0,
	@SerializedName("championId") val championId : Int = 0,
	@SerializedName("championName") val championName : String = "",
	@SerializedName("championTransform") val championTransform : Int = 0,
	@SerializedName("consumablesPurchased") val consumablesPurchased : Int = 0,
	@SerializedName("damageDealtToBuildings") val damageDealtToBuildings : Int = 0,
	@SerializedName("damageDealtToObjectives") val damageDealtToObjectives : Int = 0,
	@SerializedName("damageDealtToTurrets") val damageDealtToTurrets : Int = 0,
	@SerializedName("damageSelfMitigated") val damageSelfMitigated : Int = 0,
	@SerializedName("deaths") val deaths : Int = 0,
	@SerializedName("detectorWardsPlaced") val detectorWardsPlaced : Int = 0,
	@SerializedName("doubleKills") val doubleKills : Int = 0,
	@SerializedName("dragonKills") val dragonKills : Int = 0,
	@SerializedName("eligibleForProgression") val eligibleForProgression : Boolean = false,
	@SerializedName("firstBloodAssist") val firstBloodAssist : Boolean = false,
	@SerializedName("firstBloodKill") val firstBloodKill : Boolean = false,
	@SerializedName("firstTowerAssist") val firstTowerAssist : Boolean = false,
	@SerializedName("firstTowerKill") val firstTowerKill : Boolean = false,
	@SerializedName("gameEndedInEarlySurrender") val gameEndedInEarlySurrender : Boolean = false,
	@SerializedName("gameEndedInSurrender") val gameEndedInSurrender : Boolean = false,
	@SerializedName("goldEarned") val goldEarned : Int = 0,
	@SerializedName("goldSpent") val goldSpent : Int = 0,
	@SerializedName("individualPosition") val individualPosition : String = "",
	@SerializedName("inhibitorKills") val inhibitorKills : Int = 0,
	@SerializedName("inhibitorTakedowns") val inhibitorTakedowns : Int = 0,
	@SerializedName("inhibitorsLost") val inhibitorsLost : Int = 0,
	@SerializedName("item0") val item0 : Int = 0,
	@SerializedName("item1") val item1 : Int = 0,
	@SerializedName("item2") val item2 : Int = 0,
	@SerializedName("item3") val item3 : Int = 0,
	@SerializedName("item4") val item4 : Int = 0,
	@SerializedName("item5") val item5 : Int = 0,
	@SerializedName("item6") val item6 : Int = 0,
	@SerializedName("itemsPurchased") val itemsPurchased : Int = 0,
	@SerializedName("killingSprees") val killingSprees : Int = 0,
	@SerializedName("kills") val kills : Int = 0,
	@SerializedName("lane") val lane : String = "",
	@SerializedName("largestCriticalStrike") val largestCriticalStrike : Int = 0,
	@SerializedName("largestKillingSpree") val largestKillingSpree : Int = 0,
	@SerializedName("largestMultiKill") val largestMultiKill : Int = 0,
	@SerializedName("longestTimeSpentLiving") val longestTimeSpentLiving : Int = 0,
	@SerializedName("magicDamageDealt") val magicDamageDealt : Int = 0,
	@SerializedName("magicDamageDealtToChampions") val magicDamageDealtToChampions : Int = 0,
	@SerializedName("magicDamageTaken") val magicDamageTaken : Int = 0,
	@SerializedName("neutralMinionsKilled") val neutralMinionsKilled : Int = 0,
	@SerializedName("nexusKills") val nexusKills : Int = 0,
	@SerializedName("nexusLost") val nexusLost : Int = 0,
	@SerializedName("nexusTakedowns") val nexusTakedowns : Int = 0,
	@SerializedName("objectivesStolen") val objectivesStolen : Int = 0,
	@SerializedName("objectivesStolenAssists") val objectivesStolenAssists : Int = 0,
	@SerializedName("participantId") val participantId : Int = 0,
	@SerializedName("pentaKills") val pentaKills : Int = 0,
	@SerializedName("perks") val perks : Perks = Perks(
		statPerks = StatPerks(
			defense = 0,
			flex = 0,
			offense = 0
		), styles = listOf()
	),
	@SerializedName("physicalDamageDealt") val physicalDamageDealt : Int = 0,
	@SerializedName("physicalDamageDealtToChampions") val physicalDamageDealtToChampions : Int = 0,
	@SerializedName("physicalDamageTaken") val physicalDamageTaken : Int = 0,
	@SerializedName("profileIcon") val profileIcon : Int = 0,
	@SerializedName("puuid") val puuid : String = "",
	@SerializedName("quadraKills") val quadraKills : Int = 0,
	@SerializedName("riotIdName") val riotIdName : String ="",
	@SerializedName("riotIdTagline") val riotIdTagline : String ="",
	@SerializedName("role") val role : String ="",
	@SerializedName("sightWardsBoughtInGame") val sightWardsBoughtInGame : Int = 0,
	@SerializedName("spell1Casts") val spell1Casts : Int = 0,
	@SerializedName("spell2Casts") val spell2Casts : Int = 0,
	@SerializedName("spell3Casts") val spell3Casts : Int = 0,
	@SerializedName("spell4Casts") val spell4Casts : Int = 0,
	@SerializedName("summoner1Casts") val summoner1Casts : Int = 0,
	@SerializedName("summoner1Id") val summoner1Id : Int = 0,
	@SerializedName("summoner2Casts") val summoner2Casts : Int = 0,
	@SerializedName("summoner2Id") val summoner2Id : Int = 0,
	@SerializedName("summonerId") val summonerId : String = "",
	@SerializedName("summonerLevel") val summonerLevel : Int = 0,
	@SerializedName("summonerName") val summonerName : String ="",
	@SerializedName("teamEarlySurrendered") val teamEarlySurrendered : Boolean = false,
	@SerializedName("teamId") val teamId : Int = 0,
	@SerializedName("teamPosition") val teamPosition : String="",
	@SerializedName("timeCCingOthers") val timeCCingOthers : Int = 0,
	@SerializedName("timePlayed") val timePlayed : Int = 0,
	@SerializedName("totalDamageDealt") val totalDamageDealt : Int = 0,
	@SerializedName("totalDamageDealtToChampions") val totalDamageDealtToChampions : Int = 0,
	@SerializedName("totalDamageShieldedOnTeammates") val totalDamageShieldedOnTeammates : Int = 0,
	@SerializedName("totalDamageTaken") val totalDamageTaken : Int = 0,
	@SerializedName("totalHeal") val totalHeal : Int = 0,
	@SerializedName("totalHealsOnTeammates") val totalHealsOnTeammates : Int = 0,
	@SerializedName("totalMinionsKilled") val totalMinionsKilled : Int = 0,
	@SerializedName("totalTimeCCDealt") val totalTimeCCDealt : Int = 0,
	@SerializedName("totalTimeSpentDead") val totalTimeSpentDead : Int = 0,
	@SerializedName("totalUnitsHealed") val totalUnitsHealed : Int = 0,
	@SerializedName("tripleKills") val tripleKills : Int = 0,
	@SerializedName("trueDamageDealt") val trueDamageDealt : Int = 0,
	@SerializedName("trueDamageDealtToChampions") val trueDamageDealtToChampions : Int = 0,
	@SerializedName("trueDamageTaken") val trueDamageTaken : Int = 0,
	@SerializedName("turretKills") val turretKills : Int = 0,
	@SerializedName("turretTakedowns") val turretTakedowns : Int = 0,
	@SerializedName("turretsLost") val turretsLost : Int = 0,
	@SerializedName("unrealKills") val unrealKills : Int = 0,
	@SerializedName("visionScore") val visionScore : Int = 0,
	@SerializedName("visionWardsBoughtInGame") val visionWardsBoughtInGame : Int = 0,
	@SerializedName("wardsKilled") val wardsKilled : Int = 0,
	@SerializedName("wardsPlaced") val wardsPlaced : Int = 0,
	@SerializedName("win") val win : Boolean = false
)