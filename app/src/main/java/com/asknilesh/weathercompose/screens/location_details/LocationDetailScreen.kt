package com.asknilesh.weathercompose.screens.location_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.asknilesh.weathercompose.R
import com.asknilesh.weathercompose.R.drawable
import com.asknilesh.weathercompose.model.Location
import com.asknilesh.weathercompose.model.WeatherType

@Composable
fun LocationDetailScreen(
  navController: NavHostController, location: Location = Location(
    cityName = "New York",
    time = "11:44 AM",
    temp = "15",
    weather = WeatherType.CLOUDY,
    imageRes = R.drawable.new_york
  )
) {

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
  ) {
    Image(
      painter = painterResource(id = drawable.night_bg),
      contentDescription = null,
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
      contentScale = ContentScale.FillHeight
    )
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      BuildHomeScreenActionBar(onProfilePicClicked = {

      },
        onBackClicked = {
          navController.popBackStack()
        })
      LocationDetails(location)
    }
  }
}
