package com.devjj.platform.nurbanhoney.feature.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devjj.platform.nurbanhoney.feature.ui.home.HomeState

@Composable
fun BoardsTab(
	state: HomeState,
	onTabSelected: (Int) -> Unit
) {
	Log.d("BoardsTab", "${state.boards}")
	state.selectedBoardIndex?.let {
		ScrollableTabRow(
			selectedTabIndex = it,
			edgePadding = 0.dp,
			indicator = { tabPositions ->
				TabRowDefaults.Indicator(
					modifier = Modifier.tabIndicatorOffset(
						currentTabPosition = tabPositions[it],
					), color = Color(0xFFF6B748)
				)
			}
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
							color = Color(
								if (selected) 0xFFF6B748
								else 0xFFD4D4D4
							),
							fontSize = 15.sp
						)
					},
					modifier = Modifier.wrapContentWidth(align = Alignment.CenterHorizontally)
				)
			}
		}
	}
}

@Preview
@Composable
fun TabPreview() {
	ScrollableTabRow(
		selectedTabIndex = 0,
		edgePadding = 0.dp,
		indicator = {}
	) {
		Tab(
			selected = true,
			onClick = { },
			text = {
				Text(
					text = "tab.name",
					color = Color(0xFFF6B748),
					fontSize = 15.sp
				)
			}
		)

		Tab(
			selected = false,
			onClick = { },
			text = {
				Text(
					text = "tab.name2",
					color = Color(0xFFF6B748),
					fontSize = 15.sp
				)
			}
		)
	}
}

