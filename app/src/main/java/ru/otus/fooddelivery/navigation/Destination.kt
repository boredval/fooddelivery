package ru.otus.fooddelivery.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object FoodList: Destination("ru.otus.fooddelivery.getFoods", emptyList())
    object FoodDetail: Destination(
        "foodDetail",
        arguments = listOf(
            navArgument("foodId"){
                type = NavType.StringType
                defaultValue = "0"
            }
        )
    )
    object Profile: Destination("profile", emptyList())
    object Cart: Destination("cart", emptyList())
}
