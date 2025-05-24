package br.com.rstduio.composetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rstudio.codelab1.feature.Codelab1Feature
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DesignSystemTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          ComposeTraining(Modifier.padding(innerPadding))
        }
      }
    }
  }
}

@Composable
fun ComposeTraining(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    ListItem("Codelab 1", { Codelab1Feature(modifier) })
  }
}

@Composable
fun ListItem(
  title: String,
  onItemClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Card(
    onClick = { onItemClick },
    modifier = modifier.fillMaxWidth()
  ) {

    Text(
      text = title,
      modifier = modifier.padding(9.dp)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  DesignSystemTheme {
    ComposeTraining()
  }
}