package com.example.agrieyes.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.agrieyes.navigation.DestinationsArgs.DESEASE_ID_ARG
import com.example.agrieyes.navigation.Screens.DESEASES_SCREEN
import com.example.agrieyes.navigation.Screens.DESEASE_DETAIL_SCREEN
import com.example.agrieyes.navigation.Screens.FARM_SCREEN
import com.example.agrieyes.navigation.Screens.HOME_SCREEN
import com.example.agrieyes.navigation.Screens.RECORDS_SCREEN
import com.example.agrieyes.navigation.Screens.RECORD_SCREEN

/**
 * Screens used in [Destinations]
 */
private object Screens {
    const val HOME_SCREEN = "home"
    const val FARM_SCREEN = "farm"
    const val DESEASES_SCREEN = "deseases"
    const val DESEASE_DETAIL_SCREEN = "desease"
    const val RECORDS_SCREEN = "records"
    const val RECORD_SCREEN = "record"
    const val SOLUTIONS_SCREEN = "solutions"
    const val SOLUTION_DETAIL_SCREEN = "solution"
}

/**
 * Arguments used in [Destinations] routes
 */
object DestinationsArgs {
    const val USER_MESSAGE_ARG = "userMessage"
    const val DESEASE_ID_ARG = "deseaseId"
    const val TITLE_ARG = "title"
}

/**
 * Destinations used in the [AgriActivity]
 */
object Destinations {
    const val HOME_ROUTE = HOME_SCREEN
    const val DESEASES_ROUTE = DESEASES_SCREEN
    const val DESEASE_DETAIL_ROUTE = "$DESEASE_DETAIL_SCREEN/{$DESEASE_ID_ARG}"
    const val RECORD_ROUTE = RECORD_SCREEN
    const val RECORDS_ROUTE = RECORDS_SCREEN
    const val FARM_ROUTE = FARM_SCREEN
}

/**
 * Models the navigation actions in the app.
 */
class TodoNavigationActions(private val navController: NavHostController) {

    fun navigateToHome(userMessage: Int = 0) {
        val navigatesFromDrawer = userMessage == 0
        navController.navigate(
            HOME_SCREEN
        ) {
            popUpTo(navController.graph.findStartDestination().id) {
                inclusive = !navigatesFromDrawer
                saveState = navigatesFromDrawer
            }
            launchSingleTop = true
            restoreState = navigatesFromDrawer
        }
    }




    fun navigateToRecordDetail(recordId: String) {
        navController.navigate("${Destinations.RECORD_ROUTE}/$recordId")
    }

}