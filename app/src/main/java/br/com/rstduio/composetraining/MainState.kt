package br.com.rstduio.composetraining

sealed class MainState {
  object Home: MainState()
  object Codelab1 : MainState()
  object Codelab2 : MainState()
  object Codelab3 : MainState()
  object Codelab4 : MainState()
}
