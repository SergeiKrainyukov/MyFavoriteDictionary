package com.sergeikrainyukov.myfavoritedictionary.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sergeikrainyukov.myfavoritedictionary.ui.screens.AddWordScreen
import com.sergeikrainyukov.myfavoritedictionary.ui.screens.DictionaryScreen
import com.sergeikrainyukov.myfavoritedictionary.ui.screens.MenuScreen
import com.sergeikrainyukov.myfavoritedictionary.ui.screens.PracticeScreen
import com.sergeikrainyukov.myfavoritedictionary.ui.theme.MyFavoriteDictionaryTheme
import com.sergeikrainyukov.myfavoritedictionary.ui.viewModels.PracticeScreenViewModel
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    private val practiceScreenViewModel: PracticeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFavoriteDictionaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(practiceScreenViewModel = practiceScreenViewModel)
                }
            }
        }
    }
}

@Composable
fun App(practiceScreenViewModel: PracticeScreenViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MenuScreen(navController) }
        composable("add_word") { AddWordScreen() }
        composable("practice") { PracticeScreen(practiceScreenViewModel) }
        composable("dictionary") { DictionaryScreen() }
    }
}