package com.asknilesh.weathercompose.screens.location_details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.weathercompose.R.drawable
import com.asknilesh.weathercompose.model.Location
import com.asknilesh.weathercompose.model.WeatherType
import com.asknilesh.weathercompose.model.WeatherType.CLOUDY
import com.asknilesh.weathercompose.model.WeatherType.RAINING
import com.asknilesh.weathercompose.model.WeatherType.STORM
import com.asknilesh.weathercompose.model.WeatherType.SUNNY

@Composable
fun LocationDetails(
  location: Location = Location(
    cityName = "New York",
    time = "11:44 AM",
    temp = "15",
    weather = CLOUDY,
    imageRes = drawable.new_york
  )
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween
  ) {
    BuildCityDetails(
      cityName = location.cityName,
      weather = location.weather,
      time = location.time,
    )
    BuildTempText(location.temp)

    Column(modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp)) {
      BuildDetails()
      Spacer(modifier = Modifier.height(10.dp))
      BuildWeatherRow(header = "Cloudy", body = "93%")
      Divider()
      Spacer(modifier = Modifier.height(5.dp))
      BuildWeatherRow(header = "Precipitation", body = "0%")
      Divider()
      Spacer(modifier = Modifier.height(5.dp))
      BuildWeatherRow(header = "Humidity", body = "65%")
      Divider()
      Spacer(modifier = Modifier.height(5.dp))
      BuildWeatherRow(header = "Wind", body = "5 km/h")
      Divider()
      Spacer(modifier = Modifier.height(5.dp))
    }
  }
}

@Composable
fun BuildCityDetails(
  cityName: String = "New York",
  weather: WeatherType = SUNNY,
  time: String = " 11:00 AM"
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    val imageModifier = Modifier.size(50.dp)
    when (weather) {
      CLOUDY -> Image(
        painter = painterResource(id = drawable.clouds),
        contentDescription = "CLOUDY",
        modifier = imageModifier
      )
      RAINING -> Image(
        painter = painterResource(id = drawable.rainy),
        contentDescription = "RAINING",
        modifier = imageModifier
      )
      SUNNY -> Image(
        painter = painterResource(id = drawable.sunny),
        contentDescription = "SUNNY",
        modifier = imageModifier
      )
      STORM -> Image(
        painter = painterResource(id = drawable.storm),
        contentDescription = "STORM",
        modifier = imageModifier
      )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Text(
      text = cityName,
      color = Color.White,
      style = MaterialTheme.typography.titleLarge,
      fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(10.dp))
    Row(modifier = Modifier) {
      Text(
        text = time,
        color = Color.White,
        style = MaterialTheme.typography.titleMedium,
      )
      Spacer(modifier = Modifier.width(10.dp))
      Text(
        text = weather.weatherType,
        color = Color.White,
        style = MaterialTheme.typography.titleMedium
      )
    }
  }
}

@Composable
fun BuildTempText(temp: String = "15") {
  Row(
    modifier = Modifier.fillMaxWidth()
      .padding(horizontal = 20.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start
  ) {
    Box(
      modifier = Modifier
        .padding(top = 25.dp)
        .size(40.dp)
        .clip(CircleShape)
        .border(BorderStroke(width = 1.dp, color = Color.LightGray), shape = CircleShape)
        .align(alignment = Alignment.Top)
    ) {
      IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add", tint = Color.White)
      }

    }

    Text(
      text = buildAnnotatedString {
        append(temp)

        withStyle(
          SpanStyle(
            baselineShift = BaselineShift.Superscript, fontSize = 45.sp, color = Color.White
          )
        ) {
          append("c")
        }
      },
      color = Color.White,
      style = MaterialTheme.typography.titleSmall,
      fontSize = 70.sp,
      fontWeight = FontWeight.Bold,
      textAlign = TextAlign.Center,
      modifier = Modifier.fillMaxWidth()
    )

  }
}

@Composable
fun BuildDetails() {
  Column(modifier = Modifier.fillMaxWidth()) {
    Text(
      text = "Weather details",
      style = MaterialTheme.typography.titleLarge,
      color = Color.White,
      fontWeight = FontWeight.Bold
    )
  }
}

@Composable
fun BuildWeatherRow(header: String = "Cloudy", body: String = "93%") {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      header,
      style = MaterialTheme.typography.titleMedium,
      color = Color.LightGray
    )
    Text(
      body,
      style = MaterialTheme.typography.titleLarge,
      color = Color.White,
      fontWeight = FontWeight.Bold
    )
  }
}