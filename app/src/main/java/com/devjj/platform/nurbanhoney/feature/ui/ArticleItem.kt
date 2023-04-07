package com.devjj.platform.nurbanhoney.feature.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ArticleItem(order: String, imageURL: String) {
    Row(
        modifier = Modifier
            .width(360.dp)
            .height(90.dp)
            .padding(20.dp, 22.dp, 30.dp, 22.dp)
            .background(Color.Green),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = order, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(10.dp))
        if (imageURL.isNotEmpty()) {
            AsyncImage(
                model = imageURL,
                contentDescription = null,
                modifier = Modifier.size(46.dp, 46.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "제목", fontSize = 14.sp)
            Row(modifier = Modifier.fillMaxWidth(1f), horizontalArrangement = Arrangement.Start) {
                Text(text = "작성자", fontSize = 10.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "작성일", fontSize = 10.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "추천", fontSize = 10.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "추천수", fontSize = 10.sp)
            }
        }
    }
}

@Preview
@Composable
fun ArticleItemPre() {
    LazyColumn() {
        for (i in 0..10) {
            item {
                ArticleItem(
                    order = (i * 2 + 1).toString(),
                    imageURL = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
                )
                Divider(color = Color.Red, thickness = 1.dp)
            }

            item {
                ArticleItem(
                    order = (i * 2 + 2).toString(),
                    imageURL = ""
                )
                Divider(color = Color.Red, thickness = 1.dp)
            }
        }
    }
}
