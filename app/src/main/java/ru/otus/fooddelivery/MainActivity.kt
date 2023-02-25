package ru.otus.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.otus.fooddelivery.navigation.Destination
import ru.otus.fooddelivery.ui.screen.CartScreen
import ru.otus.fooddelivery.ui.screen.FoodDeliveryDetailScreen
import ru.otus.fooddelivery.ui.screen.FoodDeliveryScreen
import ru.otus.fooddelivery.ui.screen.ProfileScreen
import ru.otus.fooddelivery.ui.theme.FoodDeliveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                val navController = rememberNavController()
                val selectedItemIndexMenu = remember { mutableStateOf(0) }
                NavHost(
                    navController = navController,
                    startDestination = Destination.FoodList.route
                ) {
                    composable(
                        route = Destination.FoodList.route
                    ) {
                        FoodDeliveryScreen(
                            onItemClick = { foodId ->
                                navController.navigate(
                                    Destination.FoodDetail.route + "/${foodId}"
                                )
                            },
                            selectedItemIndexMenu = selectedItemIndexMenu,
                            navController = navController
                        )
                    }
                    composable(
                        route = Destination.FoodDetail.route + "/{foodId}",
                        arguments = Destination.FoodDetail.arguments
                    ) {
                        val foodId = it.arguments?.getString("foodId") ?: ""
                        FoodDeliveryDetailScreen(
                            foodId = foodId,
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable(
                        route = Destination.Cart.route
                    ) {
                        CartScreen(navController, selectedItemIndexMenu = selectedItemIndexMenu)
                    }
                    composable(
                        route = Destination.Profile.route
                    ) {
                        ProfileScreen(navController, selectedItemIndexMenu = selectedItemIndexMenu)
                    }
                }
            }
        }
    }
}