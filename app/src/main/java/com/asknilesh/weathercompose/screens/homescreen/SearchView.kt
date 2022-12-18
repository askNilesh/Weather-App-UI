package com.asknilesh.weathercompose.screens.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview @Composable fun BuildSearchView(
  searchHint: String = "Search city", onSearchClick: () -> Unit = {}
) {
  TextField(modifier = Modifier
    .padding(20.dp)
    .fillMaxWidth()
    .clip(shape = RoundedCornerShape(30.dp))
    .border(
      border = BorderStroke(width = 1.dp, color = Color.Gray),
      shape = RoundedCornerShape(30.dp),
    )
    .clickable { },
    value = "",
    onValueChange = {},
    readOnly = true,
    singleLine = true,
    enabled = false,
    shape = RoundedCornerShape(30.dp),
    colors = TextFieldDefaults.textFieldColors(
      containerColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
      focusedIndicatorColor = Color.Transparent,
    ),
    trailingIcon = {
      Icon(
        imageVector = Icons.Default.Search, contentDescription = "Search", tint = Color.White
      )
    },
    label = {
      Text(
        text = searchHint, style = TextStyle(
          color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold
        ), textAlign = TextAlign.Center
      )
    })
}