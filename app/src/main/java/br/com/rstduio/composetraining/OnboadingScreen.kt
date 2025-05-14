package br.com.rstduio.composetraining

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rstduio.composetraining.ui.theme.ComposeTrainingTheme

@Composable
fun OnboardingScreen(
  modifier: Modifier = Modifier,
  onContinueClick: () -> Unit
) {

  Column(
    modifier = modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "Welcome to the basics codelab!")
    ElevatedButton(
      onClick = onContinueClick,
      modifier = modifier.padding(vertical = 24.dp)
    ) {
      Text(text = "Continue")
    }
  }
}

@Preview(showBackground = true, heightDp = 320, widthDp = 320)
@Composable
fun OnboardingScreenPreview() {
  ComposeTrainingTheme {
    OnboardingScreen(onContinueClick = { })
  }
}
