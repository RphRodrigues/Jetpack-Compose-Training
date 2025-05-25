package br.com.rstudio.codelab3.feature.ui.wellness

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
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
  WellnessScreen(
    closeCodelab3 = closeCodelab3,
    modifier = modifier
  )
}

@Composable
private fun WellnessScreen(
  modifier: Modifier = Modifier,
  closeCodelab3: () -> Unit,
  wellnessViewModel: WellnessViewModel = viewModel()
) {
  Column(modifier = modifier) {
    BackHandler {
      closeCodelab3()
    }
    StatefulWaterCounter(modifier)

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
