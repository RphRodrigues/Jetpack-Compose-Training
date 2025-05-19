package br.com.rstudio.codelab3.app.ui.watercounter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rstudio.codelab3.app.ui.theme.ComposeTrainingTheme

@Composable
fun StatefulWaterCounter(modifier: Modifier = Modifier) {
  Column {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessWaterCounter(count, { count++ }, modifier)
  }
}

@Composable
fun StatelessWaterCounter(
  value: Int,
  onValueChange: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier.padding(16.dp)) {
    if (value > 0) {
      Text("You've had $value glasses.")
    }
    Button(
      onClick = { onValueChange.invoke() },
      modifier = modifier.padding(top = 8.dp),
      enabled = value < 10
    ) {
      Text("Add one")
    }
  }
}


@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
  ComposeTrainingTheme {
    StatefulWaterCounter()
  }
}