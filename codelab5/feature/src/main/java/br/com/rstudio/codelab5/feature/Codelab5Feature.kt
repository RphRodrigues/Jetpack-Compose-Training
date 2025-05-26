package br.com.rstudio.codelab5.feature

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Codelab5Feature(
  modifier: Modifier = Modifier,
  closeCodelab5: () -> Unit = {}
) {
  Scaffold { innerPadding ->
    Column(
      modifier.padding(innerPadding),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      BackHandler {
        closeCodelab5()
      }

      Text("Codelab 5")
    }
  }
}
