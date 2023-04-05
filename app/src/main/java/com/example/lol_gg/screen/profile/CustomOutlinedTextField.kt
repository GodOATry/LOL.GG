package com.example.lol_gg.screen.home.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.lol_gg.ui.theme.SecondaryColor
import com.example.lol_gg.ui.theme.WhiteAlpha04
import com.example.lol_gg.ui.theme.WhiteAlpha08

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    leadingIconImageVector: ImageVector,
    isPasswordField: Boolean = false,
    isPasswordVisible: Boolean = false,
    onVisibilityChange: (Boolean) -> Unit = {},
    keyboardOption: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    showError: Boolean = false,
    errorMessage: String = "",
    checkValidation: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
                checkValidation(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            label = { Text(text = label) },
            leadingIcon = {
                Icon(
                    imageVector = leadingIconImageVector,
                    contentDescription = "",
                    tint = if (showError) MaterialTheme.colors.error else WhiteAlpha08
                )
            },
            isError = showError,
            trailingIcon = {
                if (showError && !isPasswordField) {
                    Icon(
                        imageVector = Icons.Filled.Error,
                        contentDescription = ""
                    )
                }
                if (isPasswordField) {
                    IconButton(onClick = { onVisibilityChange(!isPasswordVisible) }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "",
                            tint = WhiteAlpha08
                        )
                    }
                }
            },
            visualTransformation = when {
                isPasswordField && isPasswordVisible -> VisualTransformation.None
                isPasswordField -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            },
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
            keyboardOptions = keyboardOption,
            keyboardActions = keyboardActions,
            singleLine = true
        )
        if (showError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .offset(y = (-8).dp)
                    .fillMaxWidth(0.9f)
            )
        }
    }
}
