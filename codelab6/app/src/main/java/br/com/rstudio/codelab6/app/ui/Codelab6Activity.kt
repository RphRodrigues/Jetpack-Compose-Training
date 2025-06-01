package br.com.rstudio.codelab6.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import br.com.rstudio.codelab6.feature.Codelab6Feature
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class Codelab6Activity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DesignSystemTheme {
        Codelab6Feature()
      }
    }
  }
}

@PreviewLightDark()
@Composable
fun GreetingPreview() {
  DesignSystemTheme {
    Codelab6Feature()
  }
}
