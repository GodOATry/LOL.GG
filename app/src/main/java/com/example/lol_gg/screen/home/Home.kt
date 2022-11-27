package com.example.lol_gg.screen.home

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lol_gg.R
import com.example.lol_gg.ui.theme.*
import com.google.accompanist.insets.navigationBarsPadding
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val context = LocalContext.current
    val isProgressBarVisible = homeViewModel.isProgressBarVisible
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, MainBackground2),
        startY = sizeImage.height.toFloat() / 4,
        endY = sizeImage.height.toFloat()
    )
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val coroutineScope = rememberCoroutineScope()
    val summonerName = homeViewModel.userStatistics.value.summonerName

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }

    fun hideBottomSheet() {
        if (sheetState.isVisible) {
            coroutineScope.launch { sheetState.hide() }
        }
    }
    LaunchedEffect(key1 = context) {
        homeViewModel.homeEvent.collect { event ->
            when (event) {
                is HomeEvents.HttpException -> {
                    Toast
                        .makeText(context, context.getString(event.messageId), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }



    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = { ChoseRegionBottomSheet(homeViewModel) { hideBottomSheet() } },
        modifier = Modifier
            .fillMaxSize()
            .background(MainBackground2)
    ) {
        Box() {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding()
            ) {
                item {
                    Box {
                        Image(
                            painterResource(R.drawable.kayle),
                            "Kayle image",
                            modifier = Modifier.onGloballyPositioned {
                                sizeImage = it.size
                            })
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(gradient)
                        )
                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(bottom = 8.dp, start = 8.dp)
                        ) {
                            if (summonerName.isNotEmpty()) {
                                Image(
                                    painter = painterResource(R.drawable.g2_icon),
                                    contentDescription = "icon",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(CircleShape)
                                )
                                Text(
                                    text = summonerName,
                                    fontSize = 38.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                    }

                }
                item {
                    SearchData(homeViewModel) {
                        coroutineScope.launch {
                            if (sheetState.isVisible) sheetState.hide()
                            else sheetState.show()
                        }
                    }
                }
                item {
                    HomeStatistics(homeViewModel = homeViewModel)
                }
                items(homeViewModel.gameInfo.value.size) { listPosition ->
                    HomeMatchHistory(homeViewModel = homeViewModel, listPosition)
                }
                item {
                    Spacer(modifier = Modifier.height(50.dp))
                }


            }

            if (isProgressBarVisible.value) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

        }
    }
}




