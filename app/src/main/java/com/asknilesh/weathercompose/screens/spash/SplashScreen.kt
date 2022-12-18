package com.asknilesh.weathercompose.screens.spash

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.asknilesh.weathercompose.R
import com.asknilesh.weathercompose.navigation.AppScreens
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") @Composable
fun SplashScreen(navController: NavHostController) {

  val scale = remember {
    Animatable(0f)
  }

  LaunchedEffect(key1 = true, block = {
    scale.animateTo(targetValue = 0.9f, tween(durationMillis = 2000, easing = {
      OvershootInterpolator(2f).getInterpolation(it)
    }))
    delay(2000)
    navController.navigate(AppScreens.HOME_SCREEN.name) {
      popUpTo(AppScreens.SPLASH_SCREEN.name) {
        inclusive = true
      }
    }
  })
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
  ) {
    Image(
      painter = painterResource(id = R.drawable.night_bg),
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
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Card(
        shape = CircleShape,
        modifier = Modifier
          .width(200.dp)
          .height(200.dp)
          .scale(scale.value),
        colors = CardDefaults.cardColors(containerColor = Color(0xffFCFFE7)),
        border = BorderStroke(width = 2.dp, color = Color.LightGray)
      ) {
        Box(
          contentAlignment = Alignment.Center, modifier = Modifier
            .width(200.dp)
            .height(200.dp)
        ) {
          Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
              .size(150.dp)
              .clip(CircleShape),
            contentScale = ContentScale.Inside
          )

        }

      }
    }
  }
}