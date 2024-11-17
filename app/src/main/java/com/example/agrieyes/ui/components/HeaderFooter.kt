package com.example.agrieyes.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material.icons.outlined.LocalFlorist
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agrieyes.navigation.Destinations
import com.example.agrieyes.ui.theme.BackGroundPrimary
import com.example.agrieyes.ui.theme.BackGroundSecondary
import com.example.agrieyes.ui.theme.GreenishColor
import com.example.agrieyes.ui.theme.TextPrimary
import com.example.agrieyes.ui.theme.TextSecondary


data class NavItem(
    val title: String,
    val icon: ImageVector? = null,
    val route: String
)

object NavItems {

    val bottomNavItems = listOf(
        NavItem(
            title = "Home",
            icon = Icons.Filled.Home,
            route = Destinations.HOME_ROUTE
        ),
        NavItem(
            title = "My Farm",
            icon = Icons.Outlined.LocalFlorist,
            route = Destinations.DESEASES_ROUTE //
        ),
        NavItem(
            title = "Drone",
            icon = Icons.Outlined.Camera,
            route = Destinations.DESEASES_ROUTE
        ),
        NavItem(
            title = "Search",
            icon = Icons.Outlined.Search,
            route = Destinations.DESEASES_ROUTE
        ),
    )
    val topNavItems = listOf(
        NavItem(
            title = "Account",
            icon = Icons.Outlined.Search,
            route = Destinations.DESEASES_ROUTE
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavHostController
) {
    TopAppBar(
        modifier = Modifier.height(56.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = TextPrimary,

        ),
        title = {
            Text(
                "asd",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile"
                )
            }
        },
    )
}


@Composable
fun BottomBar(
    navController: NavHostController,
) {
    var selectedRoute by remember {
        mutableStateOf(Destinations.HOME_ROUTE)
    }
    NavigationBar(
        containerColor = BackGroundPrimary,
        contentColor = TextSecondary,
        modifier = Modifier.height(56.dp)

    ) {
        NavItems.bottomNavItems.forEach { navItem ->
            NavigationBarItem(
                selected = selectedRoute == navItem.route,
                onClick = {
                    selectedRoute = navItem.route
                    navController.navigate(navItem.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    if (selectedRoute == navItem.route) {
                        Icon(
                            imageVector = navItem.icon!!,
                            contentDescription = navItem.title,
                            tint = GreenishColor
                        )
                    } else {
                        Icon(
                            imageVector = navItem.icon!!,
                            contentDescription = navItem.title,
                            tint = Color.White
                        )
                    }
                }
            )
        }
    }
}


@Preview
@Composable
fun previewBottomBar() {
    val navController = rememberNavController()
    BottomBar(navController = navController)
}