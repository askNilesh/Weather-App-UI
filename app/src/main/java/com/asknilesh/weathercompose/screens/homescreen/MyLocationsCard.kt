package com.asknilesh.weathercompose.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.weathercompose.R
import com.asknilesh.weathercompose.model.Location
import com.asknilesh.weathercompose.model.WeatherType.CLOUDY
import com.asknilesh.weathercompose.model.WeatherType.RAINING
import com.asknilesh.weathercompose.model.WeatherType.STORM
import com.asknilesh.weathercompose.model.WeatherType.SUNNY

@Composable fun MyLocationCard(
  location: Location
) {
  val shape = RoundedCornerShape(20.dp)
  Box(
    modifier = Modifier.clip(shape)
  ) {
    Image(
      painter = painterResource(id = location.imageRes),
      contentDescription = "City Image",
      contentScale = ContentScale.FillHeight
    )
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .clip(shape)
        .background(color = Color.Black.copy(alpha = 0.6f)),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Column(
        modifier = Modifier
          .wrapContentWidth()
          .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = location.cityName,
          color = Color.White,
          style = MaterialTheme.typography.titleLarge,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = location.time,
          color = Color.White,
          style = MaterialTheme.typography.titleMedium,
        )
      }
      Text(
        text = buildAnnotatedString {
          append(location.temp)

          withStyle(
            SpanStyle(
              baselineShift = BaselineShift.Superscript, fontSize = 10.sp, color = Color.White
            )
          ) {
            append("C")
          }
        },
        color = Color.White,
        style = MaterialTheme.typography.titleSmall,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
      )

      Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 10.dp)
      ) {
        val imageModifier = Modifier.size(30.dp)
        when (location.weather) {
          CLOUDY -> Image(
            painter = painterResource(id = R.drawable.clouds),
            contentDescription = "CLOUDY",
            modifier = imageModifier
          )
          RAINING -> Image(
            painter = painterResource(id = R.drawable.rainy),
            contentDescription = "RAINING",
            modifier = imageModifier
          )
          SUNNY -> Image(
            painter = painterResource(id = R.drawable.sunny),
            contentDescription = "SUNNY",
            modifier = imageModifier
          )
          STORM -> Image(
            painter = painterResource(id = R.drawable.storm),
            contentDescription = "STORM",
            modifier = imageModifier
          )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = location.weather.name, color = Color.White)
      }
    }
  }
}