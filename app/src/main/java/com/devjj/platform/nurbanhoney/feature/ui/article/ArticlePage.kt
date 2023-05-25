package com.devjj.platform.nurbanhoney.feature.ui.article

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devjj.platform.nurbanhoney.core.extension.AlignLeft
import com.devjj.platform.nurbanhoney.core.extension.AlignRight
import com.devjj.platform.nurbanhoney.core.platform.MainToolBar
import com.mohamedrejeb.richeditor.model.RichTextValue
import com.mohamedrejeb.richeditor.ui.material3.RichText
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import kotlinx.coroutines.CoroutineScope

@Composable
fun ArticlePage(state: ArticleState, navController: NavController) {
	val scaffoldState = rememberScaffoldState()
	val coroutineScope = rememberCoroutineScope()
	val context = LocalContext.current.applicationContext
	val drawerState = scaffoldState.drawerState


	AlignRight {
		MaterialTheme {
			androidx.compose.material.Scaffold(
				scaffoldState = scaffoldState,
				backgroundColor = Color.Transparent,
				topBar = {
					AlignLeft {
						ArticleTopBar(scaffoldState, coroutineScope)
					}
				},
				content = { paddingValues ->
					paddingValues
					AlignLeft {
						Column {
							ArticleTitle(state.article.title, state.article.nickname)
							if(state.board == "nurban") ArticleLossCut(state.article.lossCut)
							ArticleBody(state.article.content)
						}
					}
				}

			)
		}
	}
}

@Composable
fun ArticleTopBar(scaffoldState: ScaffoldState, coroutineScope: CoroutineScope) {
	MainToolBar(
		scaffoldState.drawerState,
		coroutineScope
	)
}

@Composable
fun ArticleTitle(title: String, writer: String) {

	Column() {
		Row {
			Text(text = "제목")
			Spacer(modifier = Modifier.size(10.dp))
			Text(text = title)
		}
		Row {
			Text(text = "작성자")
			Spacer(modifier = Modifier.size(10.dp))
			Text(text = writer)
			LazyRow(content = {

			})
		}
	}
}

@Composable
fun ArticleLossCut(lossCut: Int?) {
	Row {
		Text(text = "손절")
		Spacer(modifier = Modifier.size(10.dp))
		Text(lossCut.toString())
	}

}

@Composable
fun ArticleBody(content: String) {
	RichText(richText = RichTextValue(content))
}

@Preview
@Composable
fun ArticlePagePreview() {
	ArticleTitle("제목 샘플", "작성자 샘플")
}
