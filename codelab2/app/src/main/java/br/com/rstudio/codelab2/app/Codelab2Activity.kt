package br.com.rstudio.codelab2.app

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import br.com.rstudio.codelab2.feature.Codelab2Feature
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

class Codelab2Activity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      DesignSystemTheme {
        val size: WindowSizeClass = calculateWindowSizeClass(this)
        Codelab2Feature(size.widthSizeClass)
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
