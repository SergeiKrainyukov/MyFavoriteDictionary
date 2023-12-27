package com.sergeikrainyukov.myfavoritedictionary.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sergeikrainyukov.myfavoritedictionary.ui.theme.MyFavoriteDictionaryTheme

@Composable
fun MenuScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val buttonModifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

            Button(
                onClick = { navController.navigate("practice") },
                modifier = buttonModifier
            ) {
                Text("Практика", fontSize = 22.sp)
            }

            Button(
                onClick = { navController.navigate("add_word") },
                modifier = buttonModifier
            ) {
                Text("Добавить слово", fontSize = 22.sp)
            }

            Button(
                onClick = { navController.navigate("dictionary") },
                modifier = buttonModifier
            ) {
                Text("Словарь", fontSize = 22.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MyFavoriteDictionaryTheme {
        MenuScreen(navController = rememberNavController())
    }
}