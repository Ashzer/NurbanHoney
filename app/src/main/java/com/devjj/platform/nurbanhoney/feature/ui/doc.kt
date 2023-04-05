package com.devjj.platform.nurbanhoney.feature.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class doc {

    sealed class ScreenState {
        object Loading : ScreenState()
        data class TabData(val content: String) : ScreenState()
    }

    data class AppState(val tabStates: List<ScreenState> = emptyList())

    sealed class AppIntent {
        data class TabSelected(val index: Int) : AppIntent()
    }

    class MyViewModel : ViewModel() {
        private val _state = MutableLiveData<AppState>(AppState())

        val state: LiveData<AppState>
            get() = _state

        fun processIntent(intent: AppIntent) {
            when (intent) {
                is AppIntent.TabSelected -> {
                    // Update the selected tab state
                    val selectedTab = intent.index
                    val currentTabStates = _state.value?.tabStates.orEmpty()
                    if (selectedTab < currentTabStates.size) {
                        // The tab state already exists, so update it
                        val newTabStates = currentTabStates.mapIndexed { index, tabState ->
                            if (index == selectedTab) {
                                ScreenState.TabData("new content")
                            } else {
                                tabState
                            }
                        }
                        _state.value = AppState(newTabStates)
                    } else {
                        // The tab state doesn't exist yet, so add a new one
                        val newTabStates = currentTabStates.toMutableList()
                        repeat(selectedTab - currentTabStates.size) {
                            newTabStates.add(ScreenState.Loading)
                        }
                        newTabStates.add(ScreenState.TabData("new content"))
                        _state.value = AppState(newTabStates)
                    }
                }
            }
        }
    }
}
