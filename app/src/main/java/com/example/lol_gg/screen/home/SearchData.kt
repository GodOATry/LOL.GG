package com.example.lol_gg.screen.home

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lol_gg.ui.theme.SecondaryColor
import com.example.lol_gg.ui.theme.WhiteAlpha01
import com.example.lol_gg.ui.theme.WhiteAlpha04
import com.example.lol_gg.ui.theme.WhiteAlpha08

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchData(homeViewModel: HomeViewModel, regionOnClickUnit: () -> Unit) {
    val context = LocalContext.current
    var userSummonerName by remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val chosenServer = homeViewModel.chosenRegion.value

    Row(
        modifier = Modifier
            .height(85.dp)
            .padding(start = 5.dp)
    ) {
        OutlinedTextField(
            value = userSummonerName,
            modifier = Modifier
                .fillMaxHeight()
                .width(300.dp),
            label = { Text("Summoner name", fontSize = 20.sp) },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = SecondaryColor,
                focusedIndicatorColor = WhiteAlpha08,
                textColor = WhiteAlpha08,
                cursorColor = WhiteAlpha08,
                unfocusedIndicatorColor = WhiteAlpha04,
                placeholderColor = WhiteAlpha08,
                focusedLabelColor = WhiteAlpha08,
                unfocusedLabelColor = WhiteAlpha08

            ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            singleLine = true,
            onValueChange = { enteredSummonerName -> userSummonerName = enteredSummonerName },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    tint = WhiteAlpha08,
                    contentDescription = ""
                )
            }

        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .padding(top = 7.dp, start = 5.dp)
                    .wrapContentWidth()
                    .border(
                        BorderStroke(1.dp, WhiteAlpha04),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(SecondaryColor)
                    .clickable { regionOnClickUnit() }
            ) {
                Row(modifier = Modifier.align(Alignment.Center)) {
                    Text(
                        text = chosenServer,
                        color = WhiteAlpha08,
                        modifier = Modifier.padding(5.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        tint = WhiteAlpha08,
                        contentDescription = null
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp, top = 7.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Download,
                    tint = if (userSummonerName.text.isNotEmpty()) WhiteAlpha08 else WhiteAlpha01,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .background(SecondaryColor)
                        .border(
                            BorderStroke(1.dp, WhiteAlpha04),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .then(
                            if (userSummonerName.text.isNotEmpty()) {
                                Modifier.clickable {
                                    homeViewModel.downloadStatistics(userSummonerName.text)
                                    focusManager.clearFocus()
                                }
                            } else {
                                Modifier
                            }
                        )
                )
                Icon(
                    imageVector = Icons.Filled.Save,
                    tint = WhiteAlpha08,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp)
                        .background(SecondaryColor)
                        .border(
                            BorderStroke(1.dp, WhiteAlpha04),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clickable {
                            homeViewModel.saveSummonerName(userSummonerName.text)
//                            Toast
//                                .makeText(
//                                    context,
//                                    "Opcja będzie dostępna w przyszłości",
//                                    Toast.LENGTH_LONG
//                                )
//                                .show()
                        }
                )
            }
        }
    }
}
