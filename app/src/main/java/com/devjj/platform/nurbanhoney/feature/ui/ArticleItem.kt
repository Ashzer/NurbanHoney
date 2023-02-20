package com.devjj.platform.nurbanhoney.feature.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ArticleItem(order : String, imageURL : String) {
    Box(
        modifier = Modifier.border(
            width = 10.dp,
            color = Color.Magenta,
            shape = RoundedCornerShape(10)
        )
    ) {
        Row{
            Text(text = order)
            AsyncImage(model = imageURL, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun ArticleItemPre(){
    ArticleItem(order = "1", imageURL = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg")
}