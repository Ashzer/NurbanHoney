package com.devjj.platform.nurbanhoney.feature.ui.rank

import com.devjj.platform.nurbanhoney.domain.rank.model.Rank

data class RankState(
	val state: RankUiState = RankUiState.Init,
	val ranks: List<Rank>? = null
)