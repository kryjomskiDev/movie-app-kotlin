package com.example.movieapp.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieapp.R
import com.example.movieapp.presentation.navigation.BottomBarNavItem

@Composable
fun BottomBar(
    navigationController: NavHostController,
    modifier: Modifier = Modifier
) {
    val bottomBarItems = listOf(
        BottomBarNavItem.Home,
        BottomBarNavItem.Settings
    )

    NavigationBar(modifier = modifier) {
        val navBackStackEntry by navigationController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomBarItems.forEach {
            NavigationBarItem(
                label = { Text(
                    when(it) {
                        is BottomBarNavItem.Home -> stringResource(R.string.home)
                        is BottomBarNavItem.Settings -> stringResource(R.string.settings)
                    }
                ) },
                icon = { Icon(imageVector = it.icon, contentDescription = null) },
                selected =  currentDestination?.hierarchy?.any {navDestination -> navDestination.hasRoute(it.route::class)  } == true,
                onClick = {
                    navigationController.navigate(it.route) {
                        popUpTo(navigationController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }

}

