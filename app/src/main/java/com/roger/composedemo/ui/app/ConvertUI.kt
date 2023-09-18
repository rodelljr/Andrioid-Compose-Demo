package com.roger.composedemo.ui.app

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roger.composedemo.R
import com.roger.composedemo.helper.convertTemp
import com.roger.composedemo.helper.convertValue

/*
* UI for converting Standard to Metric and back again
* */

var cardNum = 0;

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun Convert() {
    Column {
        LengthCardUI()
        TempCardUI()
    }

}

// Length Card
@Composable
fun LengthCardUI(){
    var result by remember { mutableStateOf("") }
    var radioChoice by remember { mutableStateOf(true)}
    var label1 by remember { mutableIntStateOf(R.string.inches_to)    }
   Card(
       modifier = Modifier
           .padding(all = 16.dp)
           .fillMaxWidth()
           .height(220.dp)
           .shadow(16.dp),
        backgroundColor = MaterialTheme.colors.primary
   ) {
        Column(
        ) {
            Row( modifier = Modifier
                .weight(.8f)
                .height(50.dp)){
                Text(text = stringResource(id = label1),Modifier.padding(16.dp) ,
                    color = MaterialTheme.colors.secondary)
            }

            Row(
                modifier = Modifier
                    .selectableGroup()
                    .weight(.4f)
                    .height(50.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = radioChoice,
                    onClick = {
                        radioChoice = true
                        label1 = R.string.inches_to
                    })
                Text(
                    text = "inches",
                    color = MaterialTheme.colors.secondary
                )
                RadioButton(
                    selected = !radioChoice,
                    onClick = {
                        radioChoice = false
                        label1 = R.string.cent_to
                    })
                Text(
                    text = "centimeters",
                    color = MaterialTheme.colors.secondary
                )
            }

            Row( modifier = Modifier
                .weight(1.4f)
                .fillMaxWidth()
            ){  result = demoEntry1(entryChoice = radioChoice, 0)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary)
                    .height(75.dp)
                    .weight(.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = result, fontSize = 21.sp)
            }
        }
   }
}

@Composable
fun demoEntry1(entryChoice: Boolean, cardNum: Int): String {
    var entry1 by remember { mutableStateOf("") }
    var myResult by remember { mutableStateOf("") }
    OutlinedTextField(
        value = entry1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primaryVariant,
            unfocusedBorderColor = MaterialTheme.colors.secondary),
        onValueChange = { entry1 = it },
        maxLines = 1,
        textStyle =  TextStyle(color = MaterialTheme.colors.secondary),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                val entry = entry1.toDouble()
                myResult = resultToString(entryChoice, cardNum,entry)
            }
        )
    )
    return myResult
}

@Composable
fun TempCardUI() {
    var result by remember { mutableStateOf("") }
    var radioChoice by remember { mutableStateOf(true)}
    var label2 by remember { mutableIntStateOf(R.string.fah_to) }
    Card(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .height(220.dp)
            .shadow(16.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column(
        ) {
            Row( modifier = Modifier
                .weight(.8f)
                .height(50.dp)){
                Text(text = stringResource(id = label2),Modifier.padding(16.dp) ,
                    color = MaterialTheme.colors.secondary)
            }

            Row(
                modifier = Modifier
                    .selectableGroup()
                    .weight(.4f)
                    .height(50.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = radioChoice,
                    onClick = {
                        radioChoice = true
                        label2 = R.string.fah_to
                    })
                Text(
                    text = "fahrenheit",
                    color = MaterialTheme.colors.secondary
                )
                RadioButton(
                    selected = !radioChoice,
                    onClick = {
                        radioChoice = false
                        label2 = R.string.cel_to
                    })
                Text(
                    text = "celsius",
                    color = MaterialTheme.colors.secondary
                )
            }

            Row( modifier = Modifier
                .weight(1.4f)
                .fillMaxWidth()
            ){  result = demoEntry1(entryChoice = radioChoice, 1)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary)
                    .height(75.dp)
                    .weight(.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = result, fontSize = 21.sp)
            }
        }

    }
}

fun resultToString(choice: Boolean, cardNum: Int, entry: Double): String {
    if(cardNum == 0) {
        return if(choice) {
            convertValue(true, entry, .39370) + " centimeters"
        } else {
            convertValue(false, entry, .39370) + " inches"
        }
    } else {
        return if(choice) {
            convertTemp(true, entry) + '\u2103'
        } else {
            convertTemp(false, entry) + '\u2109'
        }
    }
}


