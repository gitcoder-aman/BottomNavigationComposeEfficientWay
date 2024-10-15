package com.tech.bottomnavigationefficientway.navigtion

import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Serializable
object SearchScreenRoute

@Serializable
object ProfileScreenRoute

@Serializable
object BottomNavigationRoute

@Serializable
data class BottomNavigationScreenRoute(
    val id: String
)

//sealed class Route(
//    val route : String
//){
//    object HomeScreen : Route(route = "homeScreen")
//    object SearchScreen : Route(route = "searchScreen")
//    object ProfileScreen : Route(route = "bookmarkScreen")
//    object MedicalNavigation : Route(route = "newsNavigation")
//    object OtherScreen : Route(route = "otherScreen")
//    object NextScreen : Route(route = "nextScreen")
//}

@Serializable
data object HomeScreen {
    val route: String = "home"
}

@Serializable
data class OtherScreen(val userId: String) {
    val route: String = "others/$userId"
}

@Serializable
data object ProfileScreen {
    val route: String = "profile"
}

@Serializable
data object SearchScreen {
    const val route: String = "search"
}

@Serializable
data object NextScreen {
    const val route: String = "next"
}


