package br.com.rstduio.composetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import br.com.rstudio.codelab1.feature.Codelab1Feature
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class MainActivity : ComponentActivity() {

  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DesignSystemTheme {
        val uiState by viewModel.uiState.collectAsState()

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          ComposeTraining(
            uiState = uiState,
            navigateTo= {
              viewModel.navigateTo(it)
            },
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}

@Composable
fun ComposeTraining(
  uiState: MainState,
  modifier: Modifier = Modifier,
  navigateTo: (MainState) -> Unit = {}
) {
  when (uiState) {
    MainState.Codelab1 -> Codelab1Feature(
      closeCodelab1 = {
        navigateTo(MainState.Home)
      },
      modifier = modifier.fillMaxSize()
    )
    else -> {
      Column(
        modifier = modifier
          .fillMaxSize()
          .padding(16.dp)
      ) {
        ListItem("Codelab 1", { navigateTo(MainState.Codelab1) })
        ListItem("Codelab 2", { navigateTo(MainState.Home) })
        ListItem("Codelab 3", { navigateTo(MainState.Home) })
        ListItem("Codelab 4", { navigateTo(MainState.Home) })
      }
    }
  }
}

@Composable
fun ListItem(
  title: String,
  navigateToCodelab1: () -> Unit,
  modifier: Modifier = Modifier
) {
  Card(
    onClick = navigateToCodelab1,
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
    ComposeTraining(MainState.Codelab1)
  }
}