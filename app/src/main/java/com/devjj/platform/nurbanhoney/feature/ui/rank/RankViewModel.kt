package com.devjj.platform.nurbanhoney.feature.ui.rank

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.devjj.platform.nurbanhoney.core.platform.BaseViewModel
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.rank.GetRanksUseCase
import com.devjj.platform.nurbanhoney.domain.rank.model.Rank
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class RankViewModel
@Inject constructor(
	private val getRanksUseCase: GetRanksUseCase
) : ContainerHost<RankState, RankSideEffect>, BaseViewModel() {
	override val container = container<RankState, RankSideEffect>(RankState())

	init {
		fetchData()
	}

	private fun fetchData() {
		getRanks()
	}
	private fun getRanks(){
		intent {
			viewModelScope.launch(Dispatchers.IO){
				reduce { state.copy(state = RankUiState.RankLoading) }
				getRanksUseCase(UseCase.None()) { it.fold(::handleRanks, ::handleFailure) }
			}
		}
	}

	private fun handleRanks(ranks: List<Rank>) {
		intent {
			reduce {
				Log.d("RankViewmodel", "RankViewModel / handleRanks / ranks : $ranks")
				state.copy(
					state = RankUiState.RankSuccess,
					ranks = ranks
				)
			}
		}
	}

	private fun handleFailure(failure: Throwable) {
		intent {
			postSideEffect(RankSideEffect.ShowToast(failure.message ?: "Error"))
		}
	}
}
