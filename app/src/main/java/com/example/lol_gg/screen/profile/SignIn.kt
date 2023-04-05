package com.example.lol_gg.screen.home.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lol_gg.R
import com.example.lol_gg.navigation.Screen
import com.example.lol_gg.ui.theme.*
import com.google.accompanist.insets.navigationBarsPadding

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignIn(navController: NavController, profileViewModel: ProfileViewModel) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp
    val isProgressBarVisible = profileViewModel.isProgressBarVisible
    var isPasswordVisible by remember { mutableStateOf(false) }

    val colorsForTextField = TextFieldDefaults.textFieldColors(
        backgroundColor = SecondaryColor,
        focusedIndicatorColor = WhiteAlpha08,
        textColor = WhiteAlpha08,
        cursorColor = WhiteAlpha08,
        unfocusedIndicatorColor = WhiteAlpha04,
        placeholderColor = WhiteAlpha08,
        focusedLabelColor = WhiteAlpha08,
        unfocusedLabelColor = WhiteAlpha08
    )

    LaunchedEffect(key1 = context) {
        profileViewModel.signInEvent.collect { event ->
            when (event) {
                is ProfileEvents.HttpException -> {
                    Toast
                        .makeText(context, context.getString(event.messageId), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.kindred_image),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        Card(
            modifier = Modifier
                .width((screenWidth * 0.8).dp)
                .height((screenHeight * 0.4).dp)
                .align(Alignment.Center),
            elevation = 5.dp,
            backgroundColor = MainBackground,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.sign_in),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = WhiteAlpha08,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
                OutlinedTextField(
                    value = email,
                    modifier = Modifier
                        .width(300.dp)
                        .padding(bottom = 8.dp),
                    label = { Text(stringResource(id = R.string.email), fontSize = 20.sp) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    ),
                    colors = colorsForTextField,
                    textStyle = TextStyle.Default.copy(fontSize = 20.sp),
                    singleLine = true,
                    onValueChange = { enteredSummonerName -> email = enteredSummonerName },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.AlternateEmail,
                            tint = WhiteAlpha08,
                            contentDescription = ""
                        )
                    }

                )
                OutlinedTextField(
                    value = password,
                    modifier = Modifier
                        .width(300.dp)
                        .padding(bottom = 8.dp),
                    label = { Text(stringResource(id = R.string.password), fontSize = 20.sp) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    ),
                    colors = colorsForTextField,
                    textStyle = TextStyle.Default.copy(fontSize = 20.sp),
                    singleLine = true,
                    visualTransformation = when {
                        isPasswordVisible -> PasswordVisualTransformation()
                        else -> {
                            VisualTransformation.None
                        }
                    },

                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "",
                                tint = WhiteAlpha08
                            )
                        }
                    },
                    onValueChange = { enteredSummonerName -> password = enteredSummonerName },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Password,
                            contentDescription = "",
                            tint = WhiteAlpha08
                        )
                    }

                )
                Button(
                    enabled = email.text.isNotEmpty() && password.text.isNotEmpty(),
                    onClick = {
                        profileViewModel.signIn(email = email.text, password.text)
                    },
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_in_button)

                    )
                }
                Row {
                    Text(
                        text = stringResource(id = R.string.do_not_have_account),
                        color = WhiteAlpha08
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.go_to_register),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        color = win,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.RegistrationScreen.route)
                        }
                    )
                }
            }
        }
        if (isProgressBarVisible.value) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
