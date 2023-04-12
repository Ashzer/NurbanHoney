package com.devjj.platform.nurbanhoney.feature.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devjj.platform.nurbanhoney.domain.board.model.Board

@Composable
fun BoardsTab(
	tabs: List<Board>,
	selectedTabIndex: Int,
	onTabClick: (Int) -> Unit
) {
    Log.d("Tap_test", "$tabs")
    ScrollableTabRow(selectedTabIndex = selectedTabIndex, edgePadding = 0.dp, indicator = {}) {
        tabs.forEachIndexed { tabIndex, tab ->
            Log.d("Tap_test", "$tabIndex : $tab")
            val selected = selectedTabIndex == tabIndex
            Tab(
                selected = selected,
                onClick = { onTabClick(tabIndex) },
                text = {
                    Text(
                        text = tab.name,
                        color = if (selected) Color(0xFFF6B748) else Color(0xFFD4D4D4),
                        fontSize = 15.sp
                    )
                },
                modifier = if (selected) {
                    Modifier
                        .padding(1.dp)
                        .wrapContentSize()
                        .clip(shape = RoundedCornerShape(50))
                        .border(width = 2.dp, color = Color(0xFFF6B748), shape = RoundedCornerShape(50))
                        .background(Color.Transparent)
                } else {
                    Modifier
                        .padding(1.dp)
                        .wrapContentSize()
                        .clip(RoundedCornerShape(50))
                        .border(width = 2.dp, color = Color(0xFFD4D4D4), shape = RoundedCornerShape(50))
                        .background(Color.Transparent)
                }
            )
        }
    }
}
