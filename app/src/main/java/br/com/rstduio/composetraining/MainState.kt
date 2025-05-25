package br.com.rstduio.composetraining

sealed class MainState {
  object Codelab1 : MainState()
  object Codelab2 : MainState()
  object Codelab3 : MainState()
  object Codelab4 : MainState()
  object Home: MainState()
}
