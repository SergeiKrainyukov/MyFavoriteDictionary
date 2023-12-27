package com.sergeikrainyukov.myfavoritedictionary

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
import com.sergeikrainyukov.myfavoritedictionary.screens.AddWordScreen
import com.sergeikrainyukov.myfavoritedictionary.screens.DictionaryScreen
import com.sergeikrainyukov.myfavoritedictionary.screens.MenuScreen
import com.sergeikrainyukov.myfavoritedictionary.screens.PracticeScreen
import com.sergeikrainyukov.myfavoritedictionary.ui.theme.MyFavoriteDictionaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFavoriteDictionaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MenuScreen(navController) }
        composable("add_word") { AddWordScreen() }
        composable("practice") { PracticeScreen() }
        composable("dictionary") { DictionaryScreen() }
    }
}