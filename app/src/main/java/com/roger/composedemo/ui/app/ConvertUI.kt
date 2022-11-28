package com.roger.composedemo.ui.app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roger.composedemo.helper.convertTemp
import com.roger.composedemo.helper.convertValue

/*
* UI for converting Standard to Metric and back again
* */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview
fun Convert() {
    Column() {
        LengthUI()
        TempUI()
    }

}


@Composable
fun LengthUI() {
    var inch by remember { mutableStateOf("") }
    var centimeter by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(), content = {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(
                    value = inch,
                    onValueChange = {inch = it},
                    label = { Text("Inches") },
                    maxLines = 1,
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            centimeter = ""
                            var entry = inch.toDouble()
                            result = convertValue(true, entry, .39370) + " centimeters"
                        }
                    )
                )
                OutlinedTextField(
                    value = centimeter,
                    onValueChange = {centimeter = it},
                    label = { Text("Centimeters") },
                    maxLines = 1,
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            inch = ""
                            var entry = centimeter.toDouble()
                            result = convertValue(false, entry, .39370) + " inches"
                        }
                    )
                )
            }
            if(inch.isNotEmpty()) {
                Text(text = result, fontSize = 21.sp)
            } else {
                Text(text = result, fontSize = 21.sp)
            }

        }
    )
}

@Composable
fun TempUI() {
    var fahrenheit by remember { mutableStateOf("") }
    var celsius by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(), content = {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(
                    value = fahrenheit,
                    onValueChange = {fahrenheit = it},
                    label = { Text("Fahrenheit") },
                    maxLines = 1,
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            celsius = ""
                            var entry = fahrenheit.toDouble()
                            result = convertTemp(true, entry) + '\u2103'
                        }
                    )
                )
                OutlinedTextField(
                    value = celsius,
                    onValueChange = {celsius = it},
                    label = { Text("Celsius") },
                    maxLines = 1,
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            fahrenheit = ""
                            var entry = celsius.toDouble()
                            result = convertTemp(false, entry) + '\u2109'
                        }
                    )
                )
            }
            if(fahrenheit.isNotEmpty()) {
                Text(text = result, fontSize = 21.sp)
            } else {
                Text(text = result, fontSize = 21.sp)
            }

        }
    )
}
