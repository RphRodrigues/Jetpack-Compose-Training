package br.com.rstudio.codelab2.app

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class Codelab2Activity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DesignSystemTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }

  override fun onResume() {
    super.onResume()
    val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val memoryInfo = ActivityManager.MemoryInfo()
    activityManager.getMemoryInfo(memoryInfo)

    Log.d("MemoryInfo", "Available Memory: ${memoryInfo.availMem / (1024 * 1024)} MB")
    Log.d("MemoryInfo", "Total Memory: ${memoryInfo.totalMem / (1024 * 1024)} MB")
    Log.d("MemoryInfo", "Low Memory: ${memoryInfo.lowMemory}")
    Log.d("MemoryInfo", "Threshold: ${memoryInfo.threshold / (1024 * 1024)} MB")
    Log.d("MemoryInfo", "isLowRamDevice: ${activityManager.isLowRamDevice}")
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  DesignSystemTheme {
    Greeting("Android")
  }
}