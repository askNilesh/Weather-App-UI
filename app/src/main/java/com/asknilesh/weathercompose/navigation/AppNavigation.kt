package com.asknilesh.weathercompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.asknilesh.weathercompose.model.Location
import com.asknilesh.weathercompose.screens.homescreen.HomeScreen
import com.asknilesh.weathercompose.screens.location_details.LocationDetailScreen
import com.asknilesh.weathercompose.screens.spash.SplashScreen
import com.asknilesh.weathercompose.utils.LocationParamType
import com.asknilesh.weathercompose.utils.parcelable

@Composable fun BuildNavigation() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = AppScreens.SPLASH_SCREEN.name) {
    composable(AppScreens.HOME_SCREEN.name) {
      HomeScreen(navController)
    }
    composable(AppScreens.SPLASH_SCREEN.name) {
      SplashScreen(navController)
    }

    composable(
      AppScreens.LOCATION_DETAIL_SCREEN.name + "/{location}",
      arguments = listOf(navArgument(name = "location") {
        type = LocationParamType()
      })
    ) { backStackEntry ->
      val location =
        backStackEntry.arguments?.parcelable<Location>("location") ?: return@composable
      LocationDetailScreen(navController, location)
    }

  }
}