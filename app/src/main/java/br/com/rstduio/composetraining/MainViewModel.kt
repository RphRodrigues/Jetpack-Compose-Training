package br.com.rstduio.composetraining

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

  private var _uiState: MutableStateFlow<MainState> = MutableStateFlow(MainState.Home)
  val uiState = _uiState

  fun navigateTo(state: MainState) {
    _uiState.value = state
  }
}
