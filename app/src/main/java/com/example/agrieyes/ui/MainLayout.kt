package com.example.agrieyes.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.agrieyes.navigation.NavGraph
import com.example.agrieyes.ui.components.BottomBar
import com.example.agrieyes.ui.components.TopBar


@Composable
fun MainLayout() {
    val navController = rememberNavController()
    val currentScreen by remember {
        derivedStateOf {
            navController.currentBackStackEntry?.destination?.route
        }
    }
    val showHeaderFooter = currentScreen !in listOf("SignUp", "SignIn")

    Scaffold(
        topBar = {
            if ( showHeaderFooter ) {
                TopBar(navController = navController)
            }
        },

        bottomBar = {
            if ( showHeaderFooter ) {
                BottomBar(navController = navController)
            }
        },

        floatingActionButton = {

        },

    ) { paddingValues ->
        NavGraph(navController = navController, modifier = Modifier.padding(paddingValues))
    }
}

@Preview
@Composable
fun PreviewMain() {
    MainLayout()
}