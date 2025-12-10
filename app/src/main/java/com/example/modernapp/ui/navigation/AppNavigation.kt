package com.example.modernapp.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.setValue // <-- أضف هذا
import androidx.compose.runtime.getValue // <-- أضف هذا
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable


import androidx.navigation.compose.rememberNavController
import com.example.modernapp.R
import com.example.modernapp.ui.components.BottomNavigationBar
import com.example.modernapp.ui.screens.HomeScreen
import com.example.modernapp.ui.screens.IntroScreen
import com.example.modernapp.ui.screens.PlaceholderScreen
import com.example.modernapp.ui.screens.ProfileScreen
import com.example.modernapp.ui.theme.DarkBlue


@Composable
@Preview
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "intro") {
        composable("intro") {
            IntroScreen(
                onGetSatedClick = {
                    navController.navigate("main_app") {
                        popUpTo("intro") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("main_app") {
            MainAppContainer()
        }
    }
}

@Composable
@Preview
fun MainAppContainer() {
    var selectedTap by remember { mutableStateOf("Home") }

    Scaffold(

        contentWindowInsets = WindowInsets.navigationBars,
        bottomBar = {
            BottomNavigationBar(
                selectedTap = selectedTap,
                onTabSelected = { newTap -> selectedTap = newTap },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = DarkBlue,
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier
                    .offset(y = 50.dp)
                    .size(60.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.float_icon),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),

                    )

            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = Color.White
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            when (selectedTap) {
                "Home" -> {
                    HomeScreen()
                }

                "Wallet" -> {
                    PlaceholderScreen(name = "Wallet Screen")
                }

                "Profile" -> {
                    ProfileScreen { selectedTap = "Home" }
                }

                "Settings" -> {
                    PlaceholderScreen(name = "Settings Screen")
                }

                else -> HomeScreen()
            }
        }

    }


}

