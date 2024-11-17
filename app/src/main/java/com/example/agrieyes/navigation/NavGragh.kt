package com.example.agrieyes.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.agrieyes.ui.screens.DiseaseRecord.DiseaseRecordScreen
import com.example.agrieyes.ui.screens.home.HomeScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = Destinations.HOME_ROUTE,
    navActions: TodoNavigationActions = remember(navController) {
        TodoNavigationActions(navController)
    },

) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable( Destinations.HOME_ROUTE) { entry ->
            HomeScreen()
        }

        composable(
            Destinations.RECORD_ROUTE + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { entry ->
            // Lấy id từ NavBackStackEntry
            val id = entry.arguments?.getString("id") ?: ""
            DiseaseRecordScreen(id = id)
        }

    }
}

// Keys for navigation
const val ADD_EDIT_RESULT_OK = Activity.RESULT_FIRST_USER + 1
const val DELETE_RESULT_OK = Activity.RESULT_FIRST_USER + 2
const val EDIT_RESULT_OK = Activity.RESULT_FIRST_USER + 3