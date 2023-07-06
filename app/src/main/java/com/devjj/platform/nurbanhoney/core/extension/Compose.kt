package com.devjj.platform.nurbanhoney.core.extension

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

@Composable
fun alignRight(content: @Composable () -> Unit): @Composable() (ColumnScope.() -> Unit)? = @Composable{ ->
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) { content() }
}


@Composable
fun AlignLeft(content: @Composable () -> Unit) =
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) { content() }


@Composable
fun AlignRight(content: @Composable () -> Unit) =
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) { content() }


