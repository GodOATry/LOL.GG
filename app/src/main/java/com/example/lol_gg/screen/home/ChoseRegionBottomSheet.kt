package com.example.lol_gg.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lol_gg.R
import com.example.lol_gg.ui.theme.SecondaryColor
import com.example.lol_gg.ui.theme.WhiteAlpha01
import com.example.lol_gg.ui.theme.WhiteAlpha08
import com.google.accompanist.insets.navigationBarsPadding


@Composable
fun ChoseRegionBottomSheet(homeViewModel: HomeViewModel, hideBottomSheet: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(SecondaryColor)
            .padding(32.dp)
            .navigationBarsPadding()
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Top)
                        .clickable { hideBottomSheet() })

            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.Select_Region),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = WhiteAlpha08
                )
            }
        }
        itemsIndexed(
            items = homeViewModel.listOfRegionsFullNames,
            key = { _, item -> item.hashCode() }) { index, item ->
            Column(
                modifier = Modifier
                    .height(50.dp)
                    .clickable {
                        homeViewModel.chooseRegion(index)
                        hideBottomSheet()
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(WhiteAlpha01)
                ) {}
                Text(
                    text = item,
                    color = WhiteAlpha08,
                    modifier = Modifier
                        .padding(top = 15.dp)

                )

            }

        }

    }
}