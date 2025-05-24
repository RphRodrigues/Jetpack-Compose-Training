package br.com.rstudio.codelab1.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import br.com.rstudio.codelab1.feature.Codelab1Feature
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class Codelab1Activity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DesignSystemTheme {
        Codelab1Feature(Modifier.fillMaxSize())
      }
    }
  }
}
