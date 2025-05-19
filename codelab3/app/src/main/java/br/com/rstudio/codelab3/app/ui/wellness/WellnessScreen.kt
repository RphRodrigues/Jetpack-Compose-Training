package br.com.rstudio.codelab3.app.ui.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.rstudio.codelab3.app.ui.watercounter.StatefulWaterCounter
import br.com.rstudio.codelab3.app.ui.theme.ComposeTrainingTheme

@Composable
fun WellnessScreen(
  modifier: Modifier = Modifier,
  wellnessViewModel: WellnessViewModel = viewModel()
) {
  Column(modifier = modifier) {
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
  ComposeTrainingTheme {
    WellnessScreen()
  }
}
