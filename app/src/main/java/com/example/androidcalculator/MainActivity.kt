package com.example.androidcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidcalculator.view.MainView
import com.example.androidcalculator.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val mainViewModel = MainViewModel()

        super.onCreate(savedInstanceState)
        setContent {
            MainView(mainViewModel)
        }
    }
}
