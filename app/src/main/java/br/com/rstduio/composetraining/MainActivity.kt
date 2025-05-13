package br.com.rstduio.composetraining

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rstduio.composetraining.ui.theme.ComposeTrainingTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    enableEdgeToEdge()

    setContent {
      ComposeTrainingTheme {
        MyApp(Modifier.fillMaxSize())
      }
    }
  }
}

@Composable
fun MyApp(modifier: Modifier) {
  var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

  Surface(modifier) {
    if (shouldShowOnboarding) {
      OnboardingScreen(
        onContinueClick = { shouldShowOnboarding = false }
      )
    } else {
      Greetings()
    }
  }
}

@Composable
private fun Greetings(
  modifier: Modifier = Modifier,
  names: List<String> = List(1000) { "$it" }
) {
  LazyColumn(
    modifier = modifier
      .padding(vertical = 4.dp)
  ) {
    items(items = names) { name ->
      Greeting(name = name, modifier = modifier)
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  var isExpanded by rememberSaveable { mutableStateOf(false) }
  var paddingExpanded = if (!isExpanded) 0.dp else 48.dp

  Surface(
    color = MaterialTheme.colorScheme.primary,
    modifier = modifier
      .padding(horizontal = 8.dp, vertical = 4.dp)
  ) {
    Row(
      modifier = Modifier.padding(24.dp)
    ) {
      Column(
        modifier = Modifier
          .weight(1f)
          .padding(bottom = paddingExpanded)
      ) {
        Text(text = "Hello ")
        Text(text = name)
      }
      ElevatedButton(
        onClick = {
          isExpanded = !isExpanded
          Log.d("rtudio", "onClick ${isExpanded}")
        }
      ) {
        Text(
          text = if (!isExpanded) "Show more" else "Show less"
        )
      }
    }
  }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingsPreview() {
  ComposeTrainingTheme {
    Greetings()
  }
}

@Preview(showBackground = true, heightDp = 320, widthDp = 320)
@Composable
fun MyAppPreview() {
  ComposeTrainingTheme {
    MyApp(Modifier.fillMaxSize())
  }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier) {
//  Surface(
//    color = MaterialTheme.colorScheme.primary,
//    modifier = modifier
//      .padding(horizontal = 8.dp, vertical = 4.dp)
//  ) {
//    Box(
//      contentAlignment = Alignment.CenterEnd
//    ) {
//      Column(
//        modifier = modifier
//          .fillMaxWidth()
//          .padding(24.dp)
//      ) {
//        Text(text = "Hello")
//        Text(text = name)
//      }
//      ElevatedButton(
//        onClick = { },
//        colors = ButtonDefaults.buttonColors(
//          containerColor = MaterialTheme.colorScheme.inversePrimary
//        ),
//        modifier = modifier
//          .padding(end = 24.dp)
//      ) {
//        Text(
//          text = "Show more",
//          color = MaterialTheme.colorScheme.primary
//        )
//      }
//    }
//  }
//}

/*
* MutableState
* mutableStateOf
* remember - guarantees that compose will remembered the value when composable recomposes
* rememberSaveable - to remember changes across the configuration changes, use it with by keyword
*
* */

//@Composable
//fun AddText(text: String, modifier: Modifier) {
//  Text(
//    text = text,
//    color = Color.Black,
//    fontSize = 20.sp,
//    fontWeight = FontWeight.Bold,
//    modifier = modifier
//      .background(color = Color.Yellow)
//  )
//}
