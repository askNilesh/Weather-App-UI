package com.asknilesh.weathercompose.screens.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asknilesh.weathercompose.R

@Preview() @Composable fun BuildHomeScreenActionBar(
  onDrawerClicked: () -> Unit = {}, onProfilePicClicked: () -> Unit = {}
) {
  CenterAlignedTopAppBar(title = { Text(text = "") }, actions = {
    Image(
      painter = painterResource(id = R.drawable.nilesh),
      contentDescription = "User",
      contentScale = ContentScale.FillBounds,
      modifier = Modifier
        .clickable {
          onProfilePicClicked()
        }
        .padding(end = 10.dp)
        .size(40.dp)
        .clip(CircleShape)
        .border(BorderStroke(width = 1.dp, color = Color.White), shape = CircleShape),
    )

  }, navigationIcon = {
    IconButton(onClick = {
      onDrawerClicked()
    }) {
      Icon(
        imageVector = Icons.Default.Menu,
        contentDescription = "Menu", tint = Color.White,
      )
    }
  },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent))
}