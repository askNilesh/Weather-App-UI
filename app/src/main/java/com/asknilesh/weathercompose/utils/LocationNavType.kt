package com.asknilesh.weathercompose.utils

import android.os.Bundle
import androidx.navigation.NavType
import com.asknilesh.weathercompose.model.Location
import com.google.gson.Gson

class LocationParamType : NavType<Location>(isNullableAllowed = false) {
  override fun get(bundle: Bundle, key: String): Location? {
    return bundle.parcelable(key)
  }

  override fun parseValue(value: String): Location {
    return Gson().fromJson(value, Location::class.java)
  }

  override fun put(bundle: Bundle, key: String, value: Location) {
    bundle.putParcelable(key, value)
  }
}
