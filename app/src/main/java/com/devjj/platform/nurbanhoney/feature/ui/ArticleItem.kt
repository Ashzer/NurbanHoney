package com.devjj.platform.nurbanhoney.feature.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.devjj.platform.nurbanhoney.domain.article.model.ArticlePreview

@Composable
fun ArticleItem(articlePreview: ArticlePreview, onClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .width(360.dp)
            .height(90.dp)
            .padding(20.dp, 22.dp, 30.dp, 22.dp)
            .background(Color.Green)
            .clickable { onClick(articlePreview.id) },
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = articlePreview.id.toString(), fontSize = 14.sp)
        Spacer(modifier = Modifier.width(10.dp))
        if (articlePreview.thumbnail.isNotEmpty()) {
            AsyncImage(model = articlePreview.thumbnail, contentDescription = null, modifier = Modifier.size(46.dp, 46.dp))
            Spacer(modifier = Modifier.width(10.dp))
        }

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
            Text(text = articlePreview.title, fontSize = 14.sp)
            Row(modifier = Modifier.fillMaxWidth(1f), horizontalArrangement = Arrangement.Start) {
                Text(text = articlePreview.author, fontSize = 10.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = articlePreview.createdAt, fontSize = 10.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "추천", fontSize = 10.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = articlePreview.likeCount.toString(), fontSize = 10.sp)
            }
        }
    }
}
