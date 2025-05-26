@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package br.com.rstduio.composetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.rstudio.codelab1.feature.Codelab1Feature
import br.com.rstudio.codelab2.feature.Codelab2Feature
import br.com.rstudio.codelab3.feature.ui.wellness.Codelab3Feature
import br.com.rstudio.codelab4.feature.Codelab4Feature
import br.com.rstudio.codelab5.feature.Codelab5Feature
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class MainActivity : ComponentActivity() {

  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val uiState by viewModel.uiState.collectAsState()
      val size: WindowSizeClass = calculateWindowSizeClass(this)

      DesignSystemTheme {
        ComposeTraining(
          size = size,
          uiState = uiState,
          navigateTo = {
            viewModel.navigateTo(it)
          },
          modifier = Modifier
        )
      }
    }
  }
}

@Composable
fun ComposeTraining(
  size: WindowSizeClass,
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

    MainState.Codelab2 -> Codelab2Feature(
      closeCodelab2 = {
        navigateTo(MainState.Home)
      },
      size = size.widthSizeClass,
      modifier = modifier
    )

    MainState.Codelab3 -> Codelab3Feature(
      closeCodelab3 = {
        navigateTo(MainState.Home)
      }
    )

    MainState.Codelab4 -> Codelab4Feature(
      closeCodelab4 = {
        navigateTo(MainState.Home)
      },
      modifier = modifier.fillMaxSize()
    )

    MainState.Codelab5 -> Codelab5Feature(
      closeCodelab5 = {
        navigateTo(MainState.Home)
      },
      modifier = modifier.fillMaxSize()
    )

    else -> HomeScreen(
      navigateTo = navigateTo,
      modifier = modifier
    )
  }
}

@Composable
fun HomeScreen(
  modifier: Modifier = Modifier,
  navigateTo: (MainState) -> Unit
) {
  Scaffold { innerPadding ->
      Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
          .fillMaxSize()
          .padding(innerPadding)
          .padding(16.dp)
      ) {
        ListItem("Codelab 1", { navigateTo(MainState.Codelab1) })
        ListItem("Codelab 2", { navigateTo(MainState.Codelab2) })
        ListItem("Codelab 3", { navigateTo(MainState.Codelab3) })
        ListItem("Codelab 4", { navigateTo(MainState.Codelab4) })
        ListItem("Codelab 5", { navigateTo(MainState.Codelab5) })
      }
  }
}

@Composable
fun ListItem(
  title: String,
  navigateTo: () -> Unit,
  modifier: Modifier = Modifier
) {
  Card(
    onClick = navigateTo,
    modifier = modifier.fillMaxWidth()
  ) {

    Text(
      text = title,
      modifier = modifier.padding(16.dp)
    )
  }
}

@PreviewLightDark()
@Composable
fun ComposeTrainingPreview() {
  DesignSystemTheme {
    val expandedWindowSize = WindowSizeClass.calculateFromSize(
      size = androidx.compose.ui.unit.DpSize(400.dp, 1280.dp)
    )
    ComposeTraining(size = expandedWindowSize, uiState = MainState.Home)
  }
}