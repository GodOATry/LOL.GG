package com.example.lol_gg.screen.home.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.lol_gg.R

@Composable
fun AlertDialog(
    color: Color,
    title: String,
    description: String,
    actionString: String,
    changeDialogVisibility: (Boolean, Boolean) -> Unit
) {
    Dialog(
        onDismissRequest = {
            changeDialogVisibility(false, false)
        }
    ) {
        Card(elevation = 8.dp, shape = RoundedCornerShape(12.dp)) {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = color)
                ) {
                    Row(modifier = Modifier.align(Alignment.Center).padding(start = 5.dp)) {
                        Text(
                            text = title,
                            color = Color.White,
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        )
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 15.dp, end = 8.dp),
                            tint = Color.White
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(top = 50.dp)
                        .background(color = Color.White)
                ) {
                    Column(modifier = Modifier.padding(all = 8.dp)) {
                        Text(text = description)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Button(

                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color(44, 39, 39)
                                ),
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier.padding(start = 50.dp),
                                onClick = { changeDialogVisibility(false, false) }
                            ) {
                                Text(
                                    stringResource(id = R.string.cancel),
                                    color = Color.White,
                                    fontSize = 15.sp
                                )
                            }

                            Button(
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = color
                                ),
                                shape = RoundedCornerShape(24.dp),
                                modifier = Modifier.padding(end = 50.dp),
                                onClick = {
                                    changeDialogVisibility(false, true)
                                }
                            ) {
                                Text(actionString, color = Color.White, fontSize = 15.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}
