package com.example.agrieyes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.agrieyes.ui.MainLayout
import com.example.agrieyes.ui.theme.AgriEyesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgriEyesTheme {
                MainLayout()
            }
        }
    }
}

