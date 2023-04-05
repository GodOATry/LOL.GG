package com.example.lol_gg.screen.calculator

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Champ
import com.example.example.TMP
import com.example.lol_gg.Dictionary
import com.example.lol_gg.data.CalculatorBuildStats
import com.example.lol_gg.data.items.Item
import com.example.lol_gg.data.items.SpecificItemData
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel(){

    val dictionary = Dictionary()
    val champList = mutableStateListOf<Champ>()
    val itemList = mutableStateListOf<SpecificItemData>()
    val mythicItemList = mutableStateListOf<SpecificItemData>()
    val chosenChamp = mutableStateOf<Champ>(Champ())
    val currentGrid = mutableStateOf<Int>(0)
    val chosenItem1 = mutableStateOf<SpecificItemData>(SpecificItemData())
    val chosenItem2 = mutableStateOf<SpecificItemData>(SpecificItemData())
    val chosenItem3 = mutableStateOf<SpecificItemData>(SpecificItemData())
    val chosenItem4 = mutableStateOf<SpecificItemData>(SpecificItemData())
    val chosenItem5 = mutableStateOf<SpecificItemData>(SpecificItemData())
    val chosenItem6 = mutableStateOf<SpecificItemData>(SpecificItemData())
    val calculatedAllStats = mutableStateOf<CalculatorBuildStats>(CalculatorBuildStats())
    val chosenChampionStats = mutableStateOf<CalculatorBuildStats>(CalculatorBuildStats())
    val chosenItemStats1 = mutableStateOf<CalculatorBuildStats>(CalculatorBuildStats())
    val chosenItemStats2 = mutableStateOf<CalculatorBuildStats>(CalculatorBuildStats())
    val chosenItemStats3 = mutableStateOf<CalculatorBuildStats>(CalculatorBuildStats())
    val chosenItemStats4 = mutableStateOf<CalculatorBuildStats>(CalculatorBuildStats())
    val chosenItemStats5 = mutableStateOf<CalculatorBuildStats>(CalculatorBuildStats())
    val chosenItemStats6 = mutableStateOf<CalculatorBuildStats>(CalculatorBuildStats())


    fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun initialize() {
        viewModelScope.launch {
            champList.clear()
            itemList.clear()
            val gson = Gson()
            val championsJson = getJsonDataFromAsset("data.json")
            val itemJson = getJsonDataFromAsset("item.json")
            val championsObjectStructure = gson.fromJson(championsJson, TMP::class.java)
            val itemsObjectStructure = gson.fromJson(itemJson, Item::class.java)
            championsObjectStructure.data?.let { dictionary.championConverter(it) }
                ?.let { champList.addAll(it) }
            itemsObjectStructure.data?.let { dictionary.itemsConverter(it) }
                ?.let { itemList.addAll(it) }
            chosenChamp.value = champList[0]
            itemList.removeIf { it.maps?.x11 == false }
            mythicItemList.addAll( itemList)
            mythicItemList.removeIf { it.description?.contains("Mythic") == false}
            getStatsFromChampion()
            calculateAll()
        }
    }

    fun chooseChamp(championName:String){
        for (champ in champList){
            if(champ.name == championName){
                chosenChamp.value = champ
                getStatsFromChampion()
                calculateAll()
            }
            currentGrid.value = 1
        }
    }

    fun chaneGrid(gridNumber:Int){
        currentGrid.value = gridNumber
    }

    fun returnItemForGrid():SpecificItemData{
        return when(currentGrid.value){
            1->{
                chosenItem1.value
            }
            2->{
                chosenItem2.value
            }
            3->{
                chosenItem3.value
            }
            4->{
                chosenItem4.value
            }
            5->{
                chosenItem5.value
            }
            6->{
                chosenItem6.value
            }
            else -> {
                SpecificItemData()
            }
        }
    }

    fun calculateAll(){
        calculatedAllStats.value.attackDamage = chosenChampionStats.value.attackDamage + chosenItemStats1.value.attackDamage+ chosenItemStats2.value.attackDamage+ chosenItemStats3.value.attackDamage+ chosenItemStats4.value.attackDamage+ chosenItemStats5.value.attackDamage+ chosenItemStats6.value.attackDamage
        calculatedAllStats.value.abilityPower = chosenChampionStats.value.abilityPower + chosenItemStats1.value.abilityPower + chosenItemStats2.value.abilityPower + chosenItemStats3.value.abilityPower + chosenItemStats4.value.abilityPower + chosenItemStats5.value.abilityPower + chosenItemStats6.value.abilityPower
        calculatedAllStats.value.health = chosenChampionStats.value.health + chosenItemStats1.value.health + chosenItemStats2.value.health + chosenItemStats3.value.health + chosenItemStats4.value.health + chosenItemStats5.value.health + chosenItemStats6.value.health
        calculatedAllStats.value.mana = chosenChampionStats.value.mana + chosenItemStats1.value.mana + chosenItemStats2.value.mana + chosenItemStats3.value.mana + chosenItemStats4.value.mana + chosenItemStats5.value.mana + chosenItemStats6.value.mana
        calculatedAllStats.value.armor = chosenChampionStats.value.armor + chosenItemStats1.value.armor + chosenItemStats2.value.armor + chosenItemStats3.value.armor + chosenItemStats4.value.armor + chosenItemStats5.value.armor + chosenItemStats6.value.armor
        calculatedAllStats.value.magicResist = chosenChampionStats.value.magicResist + chosenItemStats1.value.magicResist + chosenItemStats2.value.magicResist + chosenItemStats3.value.magicResist + chosenItemStats4.value.magicResist + chosenItemStats5.value.magicResist + chosenItemStats6.value.magicResist
        calculatedAllStats.value.cooldownReduction = chosenChampionStats.value.cooldownReduction + chosenItemStats1.value.cooldownReduction + chosenItemStats3.value.cooldownReduction + chosenItemStats3.value.cooldownReduction + chosenItemStats4.value.cooldownReduction + chosenItemStats5.value.cooldownReduction + chosenItemStats6.value.cooldownReduction
        calculatedAllStats.value.attackSpeed = chosenChampionStats.value.attackSpeed + chosenItemStats1.value.attackSpeed + chosenItemStats2.value.attackSpeed + chosenItemStats3.value.attackSpeed + chosenItemStats4.value.attackSpeed + chosenItemStats5.value.attackSpeed + chosenItemStats6.value.attackSpeed
        calculatedAllStats.value.movementSpeed = chosenChampionStats.value.movementSpeed + chosenItemStats1.value.movementSpeed + chosenItemStats2.value.movementSpeed + chosenItemStats3.value.movementSpeed + chosenItemStats4.value.movementSpeed + chosenItemStats5.value.movementSpeed + chosenItemStats6.value.movementSpeed
        calculatedAllStats.value.criticalStrikeChance = chosenChampionStats.value.criticalStrikeChance + chosenItemStats1.value.criticalStrikeChance + chosenItemStats2.value.criticalStrikeChance + chosenItemStats3.value.criticalStrikeChance + chosenItemStats4.value.criticalStrikeChance + chosenItemStats5.value.criticalStrikeChance + chosenItemStats6.value.criticalStrikeChance
    }


    fun getStatsFromChampion(){
        chosenChamp.value.stats?.let { it.hp?.let { it1->
            chosenChampionStats.value.health = it1.toInt()
        }.apply {  it.hpperlevel?.let { it2 -> chosenChampionStats.value.health = chosenChampionStats.value.health + (18*it2).toInt() } }
        }
        chosenChamp.value.stats?.let { it.mp?.let { it1->
            chosenChampionStats.value.mana = it1.toInt()
        }.apply {  it.mpperlevel?.let { it2 -> chosenChampionStats.value.mana = chosenChampionStats.value.mana + (18*it2).toInt() } }
        }
        chosenChamp.value.stats?.let { it.armor?.let { it1->
            chosenChampionStats.value.armor = it1.toInt()
        }.apply {  it.armorperlevel?.let { it2 -> chosenChampionStats.value.armor = chosenChampionStats.value.armor + (18*it2).toInt() } }
        }
        chosenChamp.value.stats?.let { it.spellblock?.let { it1->
            chosenChampionStats.value.magicResist = it1.toInt()
        }.apply {  it.spellblockperlevel?.let { it2 -> chosenChampionStats.value.magicResist = chosenChampionStats.value.magicResist + (18*it2).toInt() } }
        }
        chosenChamp.value.stats?.let { it.attackdamage?.let { it1->
            chosenChampionStats.value.attackDamage = it1.toInt()
        }.apply {  it.attackdamageperlevel?.let { it2 -> chosenChampionStats.value.attackDamage = chosenChampionStats.value.attackDamage + (18*it2).toInt() } }
        }
        chosenChamp.value.stats?.let { it.attackspeed?.let { it1->
            chosenChampionStats.value.attackSpeed = it1.toInt()
        }.apply {  it.attackspeedperlevel?.let { it2 -> chosenChampionStats.value.attackSpeed = chosenChampionStats.value.attackSpeed + (18*it2).toInt() } }
        }
        chosenChamp.value.stats?.let { it.movespeed?.let { it1->
            chosenChampionStats.value.movementSpeed = it1.toInt()
        }
        }
        chosenChamp.value.stats?.let { it.crit?.let { it1->
            chosenChampionStats.value.criticalStrikeChance = it1.toInt()
        }.apply {  it.critperlevel?.let { it2 -> chosenChampionStats.value.criticalStrikeChance = chosenChampionStats.value.criticalStrikeChance + (18*it2).toInt() } }
        }
    }


    fun chooseItem(itemId:Int){
        val selectedItem = itemList.find { it.id == itemId }
        if(selectedItem != null){
            when(currentGrid.value){
                1 ->{
                    chosenItem1.value = selectedItem
                    currentGrid.value = 2
                    chosenItemStats1.value = CalculatorBuildStats()
                    var jsoup = Jsoup.parse(chosenItem1.value.description).select("MainText").first().children().first().text()

                    val regex = Regex("""\d+|\D+""")
                    val input = "Buy these 2 products and get 100 off"
                    val result = regex.findAll(jsoup).map { it.groupValues.first() }.toList()
                    val xd =2





//                    var jsoup = Jsoup.parse(chosenItem1.value.description).select("MainText").first().children().first().text().filterNot { it.isWhitespace() }
//                    if (jsoup.contains("AttackDamage")){
//                        val tmpList = jsoup.split("AttackDamage")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.attackDamage = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("AbilityPower")){
//                        val tmpList = jsoup.split("AbilityPower")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.abilityPower = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("%AttackSpeed")){
//                        val tmpList = jsoup.split("%AttackSpeed")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.attackSpeed = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("CriticalStrikeChance")){
//                        val tmpList = jsoup.split("CriticalStrikeChance")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.criticalStrikeChance = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("Health")){
//                        val tmpList = jsoup.split("Health")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.health = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("Armor")){
//                        val tmpList = jsoup.split("Armor")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.armor = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("MagicResist")){
//                        val tmpList = jsoup.split("MagicResist")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.magicResist = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("Mana")){
//                        val tmpList = jsoup.split("Mana")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.mana = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("AbilityHaste")){
//                        val tmpList = jsoup.split("AbilityHaste")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.cooldownReduction = tmpList[0].toInt()
//                    }
//                    if (jsoup.contains("%MoveSpeed")){
//                        val tmpList = jsoup.split("%MoveSpeed")
//                        jsoup = tmpList[1]
//                        chosenItemStats1.value.movementSpeed = tmpList[0].toInt()
//                    }
                    calculateAll()
                }
                2 ->{
                    chosenItem2.value = selectedItem
                    currentGrid.value = 3
                    chosenItemStats2.value = CalculatorBuildStats()
                    var jsoup = Jsoup.parse(chosenItem2.value.description).select("MainText").first().children().first().text().filterNot { it.isWhitespace() }
                    if (jsoup.contains("AttackDamage")){
                        val tmpList = jsoup.split("AttackDamage")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.attackDamage = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityPower")){
                        val tmpList = jsoup.split("AbilityPower")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.abilityPower = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%AttackSpeed")){
                        val tmpList = jsoup.split("%AttackSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.attackSpeed = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%CriticalStrikeChance")){
                        val tmpList = jsoup.split("%CriticalStrikeChance")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.criticalStrikeChance = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Health")){
                        val tmpList = jsoup.split("Health")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.health = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Armor")){
                        val tmpList = jsoup.split("Armor")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.armor = tmpList[0].toInt()
                    }
                    if (jsoup.contains("MagicResist")){
                        val tmpList = jsoup.split("MagicResist")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.magicResist = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Mana")){
                        val tmpList = jsoup.split("Mana")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.mana = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityHaste")){
                        val tmpList = jsoup.split("AbilityHaste")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.cooldownReduction = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%MoveSpeed")){
                        val tmpList = jsoup.split("%MoveSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats2.value.movementSpeed = tmpList[0].toInt()
                    }
                    calculateAll()
                }
                3 ->{
                    chosenItem3.value = selectedItem
                    currentGrid.value = 4
                    chosenItemStats3.value = CalculatorBuildStats()
                    var jsoup = Jsoup.parse(chosenItem3.value.description).select("MainText").first().children().first().text().filterNot { it.isWhitespace() }
                    if (jsoup.contains("AttackDamage")){
                        val tmpList = jsoup.split("AttackDamage")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.attackDamage = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityPower")){
                        val tmpList = jsoup.split("AbilityPower")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.abilityPower = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%AttackSpeed")){
                        val tmpList = jsoup.split("%AttackSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.attackSpeed = tmpList[0].toInt()
                    }
                    if (jsoup.contains("CriticalStrikeChance")){
                        val tmpList = jsoup.split("CriticalStrikeChance")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.criticalStrikeChance = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Health")){
                        val tmpList = jsoup.split("Health")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.health = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Armor")){
                        val tmpList = jsoup.split("Armor")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.armor = tmpList[0].toInt()
                    }
                    if (jsoup.contains("MagicResist")){
                        val tmpList = jsoup.split("MagicResist")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.magicResist = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Mana")){
                        val tmpList = jsoup.split("Mana")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.mana = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityHaste")){
                        val tmpList = jsoup.split("AbilityHaste")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.cooldownReduction = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%MoveSpeed")){
                        val tmpList = jsoup.split("%MoveSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats3.value.movementSpeed = tmpList[0].toInt()
                    }
                    calculateAll()
                }
                4 ->{
                    chosenItem4.value = selectedItem
                    currentGrid.value = 5
                    chosenItemStats4.value = CalculatorBuildStats()
                    var jsoup = Jsoup.parse(chosenItem4.value.description).select("MainText").first().children().first().text().filterNot { it.isWhitespace() }
                    if (jsoup.contains("AttackDamage")){
                        val tmpList = jsoup.split("AttackDamage")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.attackDamage = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityPower")){
                        val tmpList = jsoup.split("AbilityPower")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.abilityPower = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%AttackSpeed")){
                        val tmpList = jsoup.split("%AttackSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.attackSpeed = tmpList[0].toInt()
                    }
                    if (jsoup.contains("CriticalStrikeChance")){
                        val tmpList = jsoup.split("CriticalStrikeChance")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.criticalStrikeChance = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Health")){
                        val tmpList = jsoup.split("Health")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.health = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Armor")){
                        val tmpList = jsoup.split("Armor")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.armor = tmpList[0].toInt()
                    }
                    if (jsoup.contains("MagicResist")){
                        val tmpList = jsoup.split("MagicResist")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.magicResist = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Mana")){
                        val tmpList = jsoup.split("Mana")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.mana = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityHaste")){
                        val tmpList = jsoup.split("AbilityHaste")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.cooldownReduction = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%MoveSpeed")){
                        val tmpList = jsoup.split("%MoveSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats4.value.movementSpeed = tmpList[0].toInt()
                    }
                    calculateAll()
                }
                5 ->{
                    chosenItem5.value = selectedItem
                    currentGrid.value = 6
                    chosenItemStats5.value = CalculatorBuildStats()
                    var jsoup = Jsoup.parse(chosenItem5.value.description).select("MainText").first().children().first().text().filterNot { it.isWhitespace() }
                    if (jsoup.contains("AttackDamage")){
                        val tmpList = jsoup.split("AttackDamage")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.attackDamage = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityPower")){
                        val tmpList = jsoup.split("AbilityPower")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.abilityPower = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%AttackSpeed")){
                        val tmpList = jsoup.split("%AttackSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.attackSpeed = tmpList[0].toInt()
                    }
                    if (jsoup.contains("CriticalStrikeChance")){
                        val tmpList = jsoup.split("CriticalStrikeChance")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.criticalStrikeChance = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Health")){
                        val tmpList = jsoup.split("Health")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.health = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Armor")){
                        val tmpList = jsoup.split("Armor")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.armor = tmpList[0].toInt()
                    }
                    if (jsoup.contains("MagicResist")){
                        val tmpList = jsoup.split("MagicResist")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.magicResist = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Mana")){
                        val tmpList = jsoup.split("Mana")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.mana = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityHaste")){
                        val tmpList = jsoup.split("AbilityHaste")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.cooldownReduction = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%MoveSpeed")){
                        val tmpList = jsoup.split("%MoveSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats5.value.movementSpeed = tmpList[0].toInt()
                    }
                    calculateAll()
                }
                6 ->{
                    chosenItem6.value = selectedItem
                    currentGrid.value = 0
                    chosenItemStats6.value = CalculatorBuildStats()
                    var jsoup = Jsoup.parse(chosenItem6.value.description).select("MainText").first().children().first().text().filterNot { it.isWhitespace() }
                    if (jsoup.contains("AttackDamage")){
                        val tmpList = jsoup.split("AttackDamage")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.attackDamage = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityPower")){
                        val tmpList = jsoup.split("AbilityPower")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.abilityPower = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%AttackSpeed")){
                        val tmpList = jsoup.split("%AttackSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.attackSpeed = tmpList[0].toInt()
                    }
                    if (jsoup.contains("CriticalStrikeChance")){
                        val tmpList = jsoup.split("CriticalStrikeChance")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.criticalStrikeChance = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Health")){
                        val tmpList = jsoup.split("Health")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.health = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Armor")){
                        val tmpList = jsoup.split("Armor")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.armor = tmpList[0].toInt()
                    }
                    if (jsoup.contains("MagicResist")){
                        val tmpList = jsoup.split("MagicResist")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.magicResist = tmpList[0].toInt()
                    }
                    if (jsoup.contains("Mana")){
                        val tmpList = jsoup.split("Mana")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.mana = tmpList[0].toInt()
                    }
                    if (jsoup.contains("AbilityHaste")){
                        val tmpList = jsoup.split("AbilityHaste")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.cooldownReduction = tmpList[0].toInt()
                    }
                    if (jsoup.contains("%MoveSpeed")){
                        val tmpList = jsoup.split("%MoveSpeed")
                        jsoup = tmpList[1]
                        chosenItemStats6.value.movementSpeed = tmpList[0].toInt()
                    }
                    calculateAll()
                }
                else ->{
                }
            }
        }
    }

}