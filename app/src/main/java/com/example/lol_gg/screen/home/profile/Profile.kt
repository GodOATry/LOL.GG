package com.example.lol_gg.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lol_gg.navigation.Screen
import com.example.lol_gg.screen.home.profile.ProfileViewModel
import com.example.lol_gg.ui.theme.*

//TODO in LG-28
@Composable
fun ProfileScreen(navController:NavController, profileViewModel: ProfileViewModel) {
   LaunchedEffect(key1 = true, block ={
       profileViewModel.isUserSignedIn()
   } )
    val isUserLoggedIn = profileViewModel.isUser
    if(isUserLoggedIn.value){
        Profile()
    }else{
        SignIn(navController)
    }
}

@Composable
fun Profile(){
    Text(text = "Jesteś w profilu")
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignIn(navController: NavController) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var a by remember { mutableStateOf(TextFieldValue("")) }
    var b by remember { mutableStateOf(TextFieldValue("")) }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .width((screenWidth * 0.8).dp)
                .height((screenHeight * 0.8).dp)
                .align(Alignment.Center),
            elevation = 15.dp,
            backgroundColor = SecondaryColor
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "Sign In") //TODO make it in string resource
                OutlinedTextField(
                    value = a,
                    modifier = Modifier
                        .width(300.dp),
                    label = { Text("Summoner name", fontSize = 20.sp) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = SecondaryColor,
                        focusedIndicatorColor = WhiteAlpha08,
                        textColor = WhiteAlpha08,
                        cursorColor = WhiteAlpha08,
                        unfocusedIndicatorColor = WhiteAlpha04,
                        placeholderColor = WhiteAlpha08,
                        focusedLabelColor = WhiteAlpha08,
                        unfocusedLabelColor = WhiteAlpha08,

                        ),
                    textStyle = TextStyle.Default.copy(fontSize = 20.sp),
                    singleLine = true,
                    onValueChange = { enteredSummonerName -> a = enteredSummonerName },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            tint = WhiteAlpha08,
                            contentDescription = ""
                        )
                    },

                    )
                OutlinedTextField(
                    value = b,
                    modifier = Modifier
                        .width(300.dp),
                    label = { Text("Summoner name", fontSize = 20.sp) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = SecondaryColor,
                        focusedIndicatorColor = WhiteAlpha08,
                        textColor = WhiteAlpha08,
                        cursorColor = WhiteAlpha08,
                        unfocusedIndicatorColor = WhiteAlpha04,
                        placeholderColor = WhiteAlpha08,
                        focusedLabelColor = WhiteAlpha08,
                        unfocusedLabelColor = WhiteAlpha08,

                        ),
                    textStyle = TextStyle.Default.copy(fontSize = 20.sp),
                    singleLine = true,
                    onValueChange = { enteredSummonerName -> b = enteredSummonerName },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            tint = WhiteAlpha08,
                            contentDescription = ""
                        )
                    },

                    )
                Button(onClick = { navController.navigate(Screen.RegistrationScreen.route) }) {
                    Text(text = "CLICK ME GO TO REGISTER")
                }
            }

        }
    }
}