package com.asknilesh.weathercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.asknilesh.weathercompose.navigation.BuildNavigation
import com.asknilesh.weathercompose.ui.theme.WeatherComposeAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      WeatherComposeAppTheme {
        BuildNavigation()
      }
    }
  }
}

