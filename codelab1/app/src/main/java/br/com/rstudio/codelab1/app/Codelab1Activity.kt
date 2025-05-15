package br.com.rstudio.codelab1.app

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class Codelab1Activity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent { }
  }
}

@Composable
fun Codelab1App(modifier: Modifier) {
  var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

  Surface(modifier) {
    if (shouldShowOnboarding) {
      OnboardingScreen(
        onContinueClick = { shouldShowOnboarding = false })
    } else {
      Greetings()
    }
  }
}

@Composable
private fun Greetings(
  modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }
) {
  LazyColumn(
    modifier = modifier.padding(vertical = 4.dp)
  ) {
    items(items = names) { name ->
      Greeting(name = name, modifier = modifier)
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Card(
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.secondary
    ), modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
  ) {
    CardContent(name)
  }
}

@Composable
fun CardContent(name: String) {
  var isExpanded by rememberSaveable { mutableStateOf(false) }

  Row(
    modifier = Modifier
      .padding(12.dp)
      .animateContentSize(
        animationSpec = spring(
          dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
      )
  ) {
    Column(
      modifier = Modifier
        .weight(1f)
        .padding(12.dp)
    ) {
      Text(text = "Hello")
      Text(
        text = name, style = MaterialTheme.typography.headlineMedium.copy(
          fontWeight = FontWeight.ExtraBold
        )
      )
      if (isExpanded) {
        Text(
          text = ("Composem ipsum color sit lazy, " + "padding theme elit, sed do bouncy. ").repeat(4)
        )
      }
    }
    IconButton(
      modifier = Modifier.padding(10.dp), onClick = {
        isExpanded = !isExpanded
        Log.d("rtudio", "onClick $isExpanded")
      }) {
      Icon(
        imageVector = if (!isExpanded) Icons.Filled.ExpandMore else Icons.Filled.ExpandLess,
        contentDescription = if (!isExpanded) {
          stringResource(R.string.show_less)
        } else {
          stringResource(R.string.show_more)
        }
      )
    }
  }
}

@Preview(
  showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES, name = "GreetingPreviewDark"
)
@Composable
fun GreetingsPreview() {
  DesignSystemTheme {
    Greetings()
  }
}

/*
* MutableState
* mutableStateOf
* remember - guarantees that compose will remembered the value when composable recomposes
* rememberSaveable - to remember changes across the configuration changes, use it with by keyword
* */
