package com.devjj.platform.nurbanhoney.feature.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoardsTab(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {
    ScrollableTabRow(selectedTabIndex = selectedTabIndex, edgePadding = 0.dp, containerColor = Color(0xFFFFFFFF),indicator = {}) {
        tabs.forEachIndexed { tabIndex, tab ->
            val selected = selectedTabIndex == tabIndex
            Tab(
                selected = selected,
                onClick = { onTabClick(tabIndex) },
                text = {
                    Text(
                        text = tab,
                        color = if (selected) Color(0xFFF6B748) else Color(0xFFD4D4D4),
                        fontSize = 15.sp
                    )
                },
                modifier = if (selected) Modifier
                    .padding(1.dp)
                    .wrapContentSize()
                    .clip(shape = RoundedCornerShape(50))
                    .border(width = 2.dp, color = Color(0xFFF6B748), shape = RoundedCornerShape(50))
                    .background(Color.Transparent)
                else Modifier
                    .padding(1.dp)
                    .wrapContentSize()
                    .clip(RoundedCornerShape(50))
                    .border(width = 2.dp, color = Color(0xFFD4D4D4), shape = RoundedCornerShape(50))
                    .background(Color.Transparent)
            )
        }
    }
}
