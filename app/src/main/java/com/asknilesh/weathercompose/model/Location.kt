package com.asknilesh.weathercompose.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.asknilesh.weathercompose.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
  val cityName: String,
  val time: String,
  val temp: String,
  val weather: WeatherType,
  @DrawableRes val imageRes: Int
): Parcelable

enum class WeatherType(val weatherType : String) {
  CLOUDY("Cloudy"),
  RAINING("Raining"),
  SUNNY("Sunny"),
  STORM("Storm"),
}

fun getMyLocations() = mutableListOf(
  Location(
    cityName = "New York",
    time = "11:44 AM",
    temp = "15",
    weather = WeatherType.CLOUDY,
    imageRes = R.drawable.new_york
  ),
  Location(
    cityName = "San Francisco",
    time = "7:44 AM",
    temp = "6",
    weather = WeatherType.RAINING,
    imageRes = R.drawable.san_francisco
  ),
  Location(
    cityName = "Perth",
    time = "09:44 AM",
    temp = "40",
    weather = WeatherType.SUNNY,
    imageRes = R.drawable.perth
  ),
  Location(
    cityName = "Toronto",
    time = "09:44 AM",
    temp = "39",
    weather = WeatherType.STORM,
    imageRes = R.drawable.toronto
  ),
  Location(
    cityName = "Los Angeles",
    time = "5:44 AM",
    temp = "23",
    weather = WeatherType.CLOUDY,
    imageRes = R.drawable.los_angeles
  ),
  Location(
    cityName = "Sydney",
    time = "11:44 AM",
    temp = "22",
    weather = WeatherType.STORM,
    imageRes = R.drawable.sydney
  ),
  Location(
    cityName = "London",
    time = "09:44 AM",
    temp = "34",
    weather = WeatherType.SUNNY,
    imageRes = R.drawable.london
  ),
  Location(
    cityName = "London",
    time = "09:44 AM",
    temp = "33",
    weather = WeatherType.SUNNY,
    imageRes = R.drawable.london
  ),

  )