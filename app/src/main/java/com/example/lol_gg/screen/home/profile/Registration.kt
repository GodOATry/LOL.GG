package com.example.lol_gg.screen.home.profile

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lol_gg.R
import com.example.lol_gg.navigation.BottomNavItem
import com.example.lol_gg.ui.theme.*
import com.google.accompanist.insets.navigationBarsPadding


@Composable
fun Registration(navController: NavController, profileViewModel: ProfileViewModel) {
    val context = LocalContext.current
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, MainBackground),
        startY = 0F,
        endY = 600F
    )
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

    val isProgressBarVisible = profileViewModel.isProgressBarVisible

    var userName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    val validateUserName = profileViewModel.validateUserName
    val validateEmail = profileViewModel.validateEmail
    val validateArePasswordsEqual = profileViewModel.validateArePasswordsEqual
    val validatePassword = profileViewModel.validatePassword
    val validateConfirmPassword = profileViewModel.validateConfirmPassword
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
    var isConfirmPasswordVisible by rememberSaveable { mutableStateOf(false) }



    LaunchedEffect(key1 = context) {
        profileViewModel.registrationEvent.collect { event ->
            when (event) {
                is ProfileEvents.HttpException -> {
                    Toast
                        .makeText(context, context.getString(event.messageId), Toast.LENGTH_SHORT)
                        .show()
                }
                is ProfileEvents.RegistrationSuccessful -> {
                    Toast
                        .makeText(context, context.getString(event.messageId), Toast.LENGTH_SHORT)
                        .show()
                }
                is ProfileEvents.RegistrationUnSuccessful -> {
                    Toast
                        .makeText(context, context.getString(event.messageId), Toast.LENGTH_SHORT)
                        .show()
                }
                is ProfileEvents.SignInSuccessful -> {
                    Toast
                        .makeText(context, context.getString(event.messageId), Toast.LENGTH_SHORT)
                        .show()
                    navController.popBackStack(
                        BottomNavItem.Profile.screen_route,
                        inclusive = false
                    )
                }
                is ProfileEvents.SignInUnSuccessful -> {
                    Toast
                        .makeText(context, context.getString(event.messageId), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(start = 5.dp, end = 5.dp)
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
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
                Column(modifier = Modifier.align(Alignment.BottomCenter)) {


                    Text(
                        text = stringResource(id = R.string.createAnAccount),
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .align(Alignment.CenterHorizontally),
                        color = WhiteAlpha08
                    )

                }
            }
            CustomOutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = stringResource(id = R.string.userName),
                showError = !validateUserName.value,
                errorMessage = stringResource(id = R.string.validateUserNameError),
                leadingIconImageVector = Icons.Default.PermIdentity,
                keyboardOption = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                checkValidation = { profileViewModel.validateUsername(it) }
            )

            CustomOutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = stringResource(id = R.string.email),
                showError = !validateEmail.value,
                errorMessage = stringResource(id = R.string.validateEmailError),
                leadingIconImageVector = Icons.Default.AlternateEmail,
                keyboardOption = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                checkValidation = { profileViewModel.validateEmail(it) }
            )
            CustomOutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = stringResource(id = R.string.password),
                showError = !validatePassword.value,
                errorMessage = stringResource(id = R.string.validatePasswordError),
                isPasswordField = true,
                isPasswordVisible = isPasswordVisible,
                onVisibilityChange = { isPasswordVisible = it },
                leadingIconImageVector = Icons.Default.Password,
                keyboardOption = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                checkValidation = { profileViewModel.validatePassword(it) }
            )
            CustomOutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = stringResource(id = R.string.confirmPassword),
                showError = !validateConfirmPassword.value || !validateArePasswordsEqual.value,
                errorMessage = if (!validateConfirmPassword.value) stringResource(id = R.string.validatePasswordError) else stringResource(
                    id = R.string.validateConfirmPasswordError
                ),
                isPasswordField = true,
                isPasswordVisible = isConfirmPasswordVisible,
                onVisibilityChange = { isConfirmPasswordVisible = it },
                leadingIconImageVector = Icons.Default.Password,
                keyboardOption = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                checkValidation = { profileViewModel.validateConfirmPassword(it) }
            )

            Button(
                onClick = {
                    profileViewModel.register(userName, email, password, confirmPassword)
                },
                enabled = profileViewModel.validateAllFields(
                    userName,
                    email,
                    password,
                    confirmPassword
                ),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = win,
                    contentColor = WhiteAlpha08
                )

            ) {
                Text(text = stringResource(id = R.string.register), fontSize = 20.sp)
            }
            Row {
                Text(text = stringResource(id = R.string.have_account), color = WhiteAlpha08)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = stringResource(id = R.string.go_to_login),
                    color = win,
                    modifier = Modifier.clickable {
                        navController.popBackStack(
                            BottomNavItem.Profile.screen_route,
                            inclusive = false
                        )
                    })
            }

        }
        if (isProgressBarVisible.value) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}
