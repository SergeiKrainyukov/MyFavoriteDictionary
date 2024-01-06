package com.sergeikrainyukov.myfavoritedictionary.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergeikrainyukov.myfavoritedictionary.ui.theme.MyFavoriteDictionaryTheme

@Composable
fun TestScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        for (i in 1..9)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                for (j in 1..9)
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .border(width = 1.dp, color = Color.DarkGray)
                            .background(color = if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) Color.Yellow else Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "${j * i}")
                    }
            }
    }
}

@Composable
fun TestScreen2() {
    Card(
        shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.Yellow)
            )
            TwoBoxes()
            TwoBoxes()
            TwoBoxes()
        }
    }
}

@Composable
private fun TwoBoxes() {
    Column(
        modifier = Modifier.height(80.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(color = Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(color = Color.Red)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MyFavoriteDictionaryTheme {
        TestScreen2()
    }
}