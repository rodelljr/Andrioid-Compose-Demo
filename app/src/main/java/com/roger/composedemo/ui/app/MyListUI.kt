package com.roger.composedemo.ui.app

import android.app.Application
import android.content.Context
import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roger.composedemo.helper.Dessert
import com.roger.composedemo.helper.deserts

/* A generic list of sample items */
@Preview(showBackground = true)
@Composable
fun MyList() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState(0))
    ) {
        deserts.forEach{ myDessert -> ListItemUI(dessert = myDessert)}
    }
}


@Composable
fun ListItemUI(dessert: Dessert) {

    val mContext = LocalContext.current;

    Card(modifier = Modifier
        .padding(all = 16.dp)
        .fillMaxWidth()
        .clickable {
            mToast(mContext, dessert.name)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(dessert.icon, contentDescription = dessert.name, modifier = Modifier.size(32.dp))
            Spacer(Modifier.width(10.dp))
            Column(modifier = Modifier.padding(all = 6.dp)) {
                Text(dessert.name, fontSize = 25.sp, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp))
                Text(dessert.desertType, color = Color.Gray, modifier = Modifier.padding(10.dp))
            }
        }

    }
}

private fun mToast(context: Context, name: String) {
    Toast.makeText(context, name, Toast.LENGTH_LONG).show()
}