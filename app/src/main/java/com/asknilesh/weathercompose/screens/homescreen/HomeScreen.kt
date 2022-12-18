package com.asknilesh.weathercompose.screens.homescreen

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavHostController
import com.asknilesh.weathercompose.R
import com.asknilesh.weathercompose.components.PageIndicator
import com.asknilesh.weathercompose.model.getMyLocations
import com.asknilesh.weathercompose.navigation.AppScreens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.google.gson.Gson
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") @Composable
fun HomeScreen(navController: NavHostController) {
  val coroutineScope = rememberCoroutineScope()
  val snackBarHostState = remember {
    SnackbarHostState()
  }
  val pagerState = rememberPagerState(initialPage = 1)

  val myLocationsList = remember {
    getMyLocations().toMutableList()
  }
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
    Scaffold(topBar = {
      BuildHomeScreenActionBar(onDrawerClicked = {
        coroutineScope.launch {
          snackBarHostState.showSnackbar("This feature will be implemented in future.")
        }
      }, onProfilePicClicked = {
        coroutineScope.launch {
          snackBarHostState.showSnackbar("This feature will be implemented in future.")
        }
      })
    },
      containerColor = Color.Black.copy(alpha = 0.6f),
      snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { paddingValues ->
      Column(
        modifier = Modifier
          .padding(paddingValues)
          .fillMaxSize()
      ) {

        Spacer(modifier = Modifier.height(30.dp))
        Text(
          text = "Hello Nilesh", style = MaterialTheme.typography.headlineLarge.copy(
            color = Color.White, fontWeight = FontWeight.Bold
          ), modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
          text = "Check the weather by the city", style = MaterialTheme.typography.bodyLarge.copy(
            color = Color.White, fontWeight = FontWeight.Bold
          ), modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        BuildSearchView("Search city") {}
        Spacer(modifier = Modifier.height(40.dp))

        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "My locations", style = MaterialTheme.typography.bodyLarge.copy(
              color = Color.White, fontWeight = FontWeight.Bold
            ), modifier = Modifier.padding(horizontal = 20.dp)
          )

          IconButton(onClick = { /*TODO*/ }) {
            Icon(
              imageVector = Icons.Rounded.MoreHoriz,
              contentDescription = "Menu",
              tint = Color.White,
              modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .border(
                  BorderStroke(1.dp, color = Color.LightGray), shape = CircleShape
                )
            )
          }

        }

        Spacer(modifier = Modifier.height(20.dp))

        HorizontalPager(
          count = myLocationsList.size,
          state = pagerState,
          contentPadding = PaddingValues(horizontal = 100.dp),
          modifier = Modifier.fillMaxWidth()
        ) { page ->
          Card(modifier = Modifier
            .width(150.dp)
            .height(250.dp)
            .graphicsLayer {
              val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

              lerp(
                start = 0.85f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
              ).also { scale ->
                scaleX = scale
                scaleY = scale
              }
              alpha = lerp(
                start = 0.5f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
              )
            }, shape = RoundedCornerShape(20.dp), onClick = {
            val json = Uri.encode(Gson().toJson(myLocationsList[page]))
            navController.navigate(AppScreens.LOCATION_DETAIL_SCREEN.name + "/${json}")
          }) {
            MyLocationCard(myLocationsList[page])

          }

        }

        Spacer(modifier = Modifier.height(20.dp))

        PageIndicator(
          numberOfPages = myLocationsList.size,
          selectedPage = pagerState.currentPage,
          defaultRadius = 10.dp,
          selectedLength = 10.dp,
          space = 10.dp,
          animationDurationInMillis = 300,
          defaultColor = Color.DarkGray,
          selectedColor = Color.White,
          modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

      }
    }
  }
}