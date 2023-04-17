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
import com.devjj.platform.nurbanhoney.feature.ui.home.HomeState

@Composable
fun BoardsTab(
	state: HomeState,
	onTabSelected: (Int) -> Unit
) {
	Log.d("BoardsTab", "${state.boards}")
	ScrollableTabRow(
		selectedTabIndex = state.selectedBoardIndex,
		edgePadding = 0.dp,
		indicator = {}
	) {
		state.boards?.forEachIndexed { tabIndex, tab ->
			Log.d("BoardsTab", "$tabIndex : $tab")
			val selected = state.selectedBoardIndex == tabIndex
			Tab(
				selected = selected,
				onClick = { onTabSelected(tabIndex) },
				text = {
					Text(
						text = tab.name,
						color = Color(if (selected) 0xFFF6B748 else 0xFFD4D4D4),
						fontSize = 15.sp
					)
				},
				modifier = Modifier
					.padding(1.dp)
					.wrapContentSize()
					.clip(shape = RoundedCornerShape(50))
					.border(
						width = 2.dp,
						color = Color(if (selected) 0xFFF6B748 else 0xFFD4D4D4),
						shape = RoundedCornerShape(50)
					)
					.background(Color.Transparent)
			)
		}
	}
}
