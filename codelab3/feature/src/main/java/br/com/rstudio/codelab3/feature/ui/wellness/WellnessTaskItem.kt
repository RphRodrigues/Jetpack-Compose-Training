package br.com.rstudio.codelab3.feature.ui.wellness

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rstudio.codelab3.feature.R
import br.com.rstudio.designsystem.ui.theme.DesignSystemTheme

@Composable
fun StatefulWellnessTaskItem(
  taskName: String,
  onCloseTask: () -> Unit,
  modifier: Modifier = Modifier
) {
  var checkboxState by rememberSaveable { mutableStateOf(false) }

  StatelessWellnessTaskItem(
    taskName = taskName,
    onCloseTask = onCloseTask,
    isCheckboxEnabled = checkboxState,
    onCheckedChange = { newValue -> checkboxState = newValue },
    modifier = modifier
  )
}

@Composable
fun StatelessWellnessTaskItem(
  taskName: String,
  onCloseTask: () -> Unit,
  isCheckboxEnabled: Boolean,
  onCheckedChange: (Boolean) -> Unit,
  modifier: Modifier = Modifier
) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text = taskName,
      modifier = modifier
        .weight(1f)
        .padding(start = 10.dp)
    )
    Checkbox(
      checked = isCheckboxEnabled,
      onCheckedChange = onCheckedChange
    )
    IconButton(
      onClick = onCloseTask,
    ) {
      Icon(
        imageVector = Icons.Filled.Close,
        contentDescription = stringResource(R.string.wellness_task_close_button)
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskPreview() {
  DesignSystemTheme {
    StatelessWellnessTaskItem(
      taskName = "This is a task",
      onCloseTask = {},
      isCheckboxEnabled = true,
      onCheckedChange = {}
    )
  }
}
