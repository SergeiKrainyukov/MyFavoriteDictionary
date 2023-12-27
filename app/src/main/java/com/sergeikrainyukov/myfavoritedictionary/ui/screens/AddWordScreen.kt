package com.sergeikrainyukov.myfavoritedictionary.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sergeikrainyukov.myfavoritedictionary.ui.viewModels.AddWordScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWordScreen(viewModel: AddWordScreenViewModel, navController: NavController) {
    // Состояния для текстовых полей
    var word by remember { mutableStateOf("") }
    var translation by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(16.dp))
    ) {
        OutlinedTextField(
            value = word,
            onValueChange = { word = it },
            label = { Text("Введите слово (англ.)") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = translation,
            onValueChange = { translation = it },
            label = { Text("Введите перевод(рус.)") },
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                viewModel.saveWord(word, translation)
                navController.popBackStack()
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Сохранить")
        }
    }
}