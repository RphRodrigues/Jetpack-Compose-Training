package br.com.rstudio.codelab.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import br.com.rstudio.codelab5.feature.Codelab5Feature
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class Codelab5Activity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DesignSystemTheme {
        Codelab5Feature()
      }
    }
  }
}

@PreviewLightDark()
@Composable
fun GreetingPreview() {
  DesignSystemTheme {
    Codelab5Feature()
  }
}