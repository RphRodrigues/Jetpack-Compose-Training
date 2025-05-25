package br.com.rstudio.codelab3.feature.ui.wellness

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.rstudio.codelab3.feature.ui.watercounter.StatefulWaterCounter
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

@Composable
fun Codelab3Feature(
  modifier: Modifier = Modifier,
  closeCodelab3: () -> Unit = {}
) {
  Scaffold { innerPadding ->
    WellnessScreen(
      closeCodelab3 = closeCodelab3,
      modifier = modifier.padding(innerPadding)
    )
  }
}

@Composable
private fun WellnessScreen(
  modifier: Modifier = Modifier,
  closeCodelab3: () -> Unit,
  wellnessViewModel: WellnessViewModel = viewModel()
) {
  Column(
    modifier = modifier.fillMaxSize()
  ) {
    BackHandler {
      closeCodelab3()
    }
    StatefulWaterCounter()

    WellnessTasksList(
      list = wellnessViewModel.tasks,
      onCloseTask = { item ->
        wellnessViewModel.remove(item)
      },
      onCheckedChange = { item, newValue ->
        wellnessViewModel.onCheckChange(item, newValue)
      }
    )
  }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
  DesignSystemTheme {
    Codelab3Feature()
  }
}
