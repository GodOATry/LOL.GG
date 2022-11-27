package com.example.lol_gg.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun CalculatorScreen(){
    Text(text = "Calculator", modifier = Modifier.statusBarsPadding())
}