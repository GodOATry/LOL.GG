package com.example.lol_gg.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.lol_gg.R
import com.example.lol_gg.screen.calculator.CalculatorViewModel
import com.example.lol_gg.ui.theme.*
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.systemBarsPadding

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalculatorScreen(calculatorViewModel: CalculatorViewModel) {
    LaunchedEffect(key1 = true, block = {
        calculatorViewModel.initialize()
    })
    val currentGrid = calculatorViewModel.currentGrid.value
    val listOfChampions = calculatorViewModel.champList
    val listOfItems = calculatorViewModel.itemList
    val mythicListOfItems = calculatorViewModel.mythicItemList
    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .systemBarsPadding()
            .padding(start = 10.dp, end = 10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Calculator", color = WhiteAlpha08, fontWeight = FontWeight.Bold, fontSize = 30.sp, modifier = Modifier.padding(bottom = 5.dp))
        Box(
            modifier = Modifier
                .fillMaxHeight(0.4f)
        ) {
            CalculatorData(calculatorViewModel = calculatorViewModel)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MainBackground2),
            contentAlignment = Alignment.Center
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                contentPadding = PaddingValues(
                    start = 10.dp,
                    top = 5.dp,
                    end = 10.dp,
                    bottom = 5.dp
                ),
                content = {
                    when (currentGrid) {
                        0 -> {
                            itemsIndexed(
                                items = listOfChampions
                            ) { index, item ->
                                item?.name?.let {
                                    item.image?.full?.let { it1 ->
                                        CalculatorChampionGridItem(
                                            it1,
                                            it,
                                            calculatorViewModel
                                        )
                                    }
                                }
                            }
                        }
                        1 -> {
                            itemsIndexed(
                                items = mythicListOfItems
                            ) { index, item ->
                                item.name?.let {
                                    item.id?.let { it1 ->
                                        CalculatorItemGridItem(
                                            itemId = it1,
                                            itemName = it,
                                            calculatorViewModel = calculatorViewModel
                                        )
                                    }
                                }
                            }
                        }
                        else -> {
                            itemsIndexed(
                                items = listOfItems
                            ) { index, item ->
                                item.name?.let {
                                    item.id?.let { it1 ->
                                        CalculatorItemGridItem(
                                            itemId = it1,
                                            itemName = it,
                                            calculatorViewModel = calculatorViewModel
                                        )
                                    }
                                }
                            }
                        }

                    }
                }
            )
        }
    }
}

@Composable
fun CalculatorData(
    calculatorViewModel: CalculatorViewModel
) {
    val currentGrid = calculatorViewModel.currentGrid.value
    val chosenChamp = calculatorViewModel.chosenChamp.value
    val chosenItem1 = calculatorViewModel.chosenItem1.value
    val chosenItem2 = calculatorViewModel.chosenItem2.value
    val chosenItem3 = calculatorViewModel.chosenItem3.value
    val chosenItem4 = calculatorViewModel.chosenItem4.value
    val chosenItem5 = calculatorViewModel.chosenItem5.value
    val chosenItem6 = calculatorViewModel.chosenItem6.value
    val calculatorBuildStats = calculatorViewModel.calculatedAllStats.value


    val modifier = Modifier
        .padding(end = 5.dp)
        .size(50.dp)
        .clip(CircleShape)
        .background(Color.Black)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = rememberAsyncImagePainter(model = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/${chosenChamp.name}_0.jpg"),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            alpha = 0.1f
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
        ) {
            Row(modifier = Modifier
                .fillMaxHeight(0.7f)) {
                Column() {
                    Image(
                        modifier = Modifier
                            .padding(5.dp)
                            .clickable { calculatorViewModel.chaneGrid(0) }
                            .fillMaxWidth(0.3f),
                        painter = rememberAsyncImagePainter(model = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/${chosenChamp.name}_0.jpg"),
                        contentDescription = null
                    )
                }
                Column(modifier = Modifier.padding(10.dp)
                    ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.health),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp)
                        )
                        Text(text = calculatorBuildStats.health.toString(), color = WhiteAlpha08)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ad),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                        )
                        Text(text = calculatorBuildStats.attackDamage.toString(), color = WhiteAlpha08)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.armor),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                        )
                        Text(text = calculatorBuildStats.armor.toString(), color = WhiteAlpha08)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.`as`),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                        )
                        Text(text = calculatorBuildStats.attackSpeed.toString(), color = WhiteAlpha08)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.csc),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                        )
                        Text(text = calculatorBuildStats.criticalStrikeChance.toString(), color = WhiteAlpha08)
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(modifier = Modifier.padding(10.dp)) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.mana),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp).padding(end = 5.dp),
                        )
                        Text(text = calculatorBuildStats.mana.toString(), color = WhiteAlpha08)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ap),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                        )
                        Text(text = calculatorBuildStats.abilityPower.toString(), color = WhiteAlpha08)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.magicres),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                        )
                        Text(text = calculatorBuildStats.magicResist.toString(), color = WhiteAlpha08)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.abilityheist),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                        )
                        Text(text = calculatorBuildStats.cooldownReduction.toString(), color = WhiteAlpha08)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.movemnetspeed),
                            contentDescription = "",
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(text = calculatorBuildStats.movementSpeed.toString(), color = WhiteAlpha08)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    modifier = if (currentGrid == 1) modifier
                        .border(
                            BorderStroke(
                                2.dp,
                                WhiteAlpha06
                            ), shape = CircleShape
                        )
                        .padding(start = 5.dp)
                        .clickable { calculatorViewModel.chaneGrid(1) } else modifier
                        .padding(start = 5.dp)
                        .clickable { calculatorViewModel.chaneGrid(1) },
                    model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/${chosenItem1.id}.png",
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(1f))
                AsyncImage(
                    modifier = if (currentGrid == 2) modifier
                        .border(
                            BorderStroke(
                                2.dp,
                                WhiteAlpha06
                            ), shape = CircleShape
                        )
                        .clickable { calculatorViewModel.chaneGrid(2) } else modifier.clickable {
                        calculatorViewModel.chaneGrid(
                            2
                        )
                    },
                    model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/${chosenItem2.id}.png",
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(1f))
                AsyncImage(
                    modifier = if (currentGrid == 3) modifier
                        .border(
                            BorderStroke(
                                2.dp,
                                WhiteAlpha06
                            ), shape = CircleShape
                        )
                        .clickable { calculatorViewModel.chaneGrid(3) } else modifier.clickable {
                        calculatorViewModel.chaneGrid(
                            3
                        )
                    },
                    model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/${chosenItem3.id}.png",
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(1f))
                AsyncImage(
                    modifier = if (currentGrid == 4) modifier
                        .border(
                            BorderStroke(
                                2.dp,
                                WhiteAlpha06
                            ), shape = CircleShape
                        )
                        .clickable { calculatorViewModel.chaneGrid(5) } else modifier.clickable {
                        calculatorViewModel.chaneGrid(
                            4
                        )
                    },
                    model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/${chosenItem4.id}.png",
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(1f))
                AsyncImage(
                    modifier = if (currentGrid == 5) modifier
                        .border(
                            BorderStroke(
                                2.dp,
                                WhiteAlpha06
                            ), shape = CircleShape
                        )
                        .clickable { calculatorViewModel.chaneGrid(4) } else modifier.clickable {
                        calculatorViewModel.chaneGrid(
                            5
                        )
                    },
                    model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/${chosenItem5.id}.png",
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(1f))
                AsyncImage(
                    modifier = if (currentGrid == 6) modifier
                        .border(
                            BorderStroke(
                                2.dp,
                                WhiteAlpha06
                            ), shape = CircleShape
                        )
                        .padding(end = 5.dp)
                        .clickable { calculatorViewModel.chaneGrid(6) } else modifier
                        .padding(end = 5.dp)
                        .clickable { calculatorViewModel.chaneGrid(6) },
                    model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/${chosenItem6.id}.png",
                    contentDescription = null
                )
            }
        }
    }
}


@Composable
fun CalculatorChampionGridItem(
    championImage: String,
    championName: String,
    calculatorViewModel: CalculatorViewModel
) {
    val chosenChamp = calculatorViewModel.chosenChamp.value
    val modifier = if (chosenChamp.name == championName) Modifier.border(
        BorderStroke(
            4.dp,
            WhiteAlpha06
        )
    ) else Modifier
    Box(
        modifier = modifier
            .padding(5.dp)
            .background(SecondaryColor)
    ) {
        Column(
            modifier = Modifier
                .clickable { calculatorViewModel.chooseChamp(championName) }
                .padding(5.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(WhiteAlpha01),
                painter = rememberAsyncImagePainter(model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/champion/$championImage"),
                contentDescription = null
            )
            Text(
                text = championName,
                color = WhiteAlpha08,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
        }
    }
}

@Composable
fun CalculatorItemGridItem(
    itemId: Int,
    itemName: String,
    calculatorViewModel: CalculatorViewModel
) {

    val itemSelected = calculatorViewModel.returnItemForGrid()
    val modifier = if (itemSelected.id == itemId) Modifier.border(
        BorderStroke(
            4.dp,
            WhiteAlpha06
        )
    ) else Modifier
    Box(
        modifier = modifier
            .padding(5.dp)
            .background(SecondaryColor)
    ) {
        Column(
            modifier = Modifier
                .clickable { calculatorViewModel.chooseItem(itemId) }
                .padding(5.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(WhiteAlpha01),
                painter = rememberAsyncImagePainter(model = "http://ddragon.leagueoflegends.com/cdn/12.20.1/img/item/$itemId.png"),
                contentDescription = null
            )
            Text(
                text = itemName,
                color = WhiteAlpha08,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
        }
    }
}