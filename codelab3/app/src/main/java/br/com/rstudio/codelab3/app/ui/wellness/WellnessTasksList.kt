package br.com.rstudio.codelab3.app.ui.wellness

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rstudio.codelab3.app.data.WellnessTask
import br.com.rstudio.codelab3.app.ui.theme.ComposeTrainingTheme

@Composable
fun WellnessTasksList(
  list: List<WellnessTask>,
  onCloseTask: (WellnessTask) -> Unit,
  onCheckedChange: (WellnessTask, Boolean) -> Unit,
  modifier: Modifier = Modifier
) {
  LazyColumn(
//    state = rememberLazyListState(),
    modifier = modifier
  ) {
    items(items = list, key = { task -> task.id }) { task ->
      StatelessWellnessTaskItem(
        taskName = task.label,
        onCloseTask = { onCloseTask.invoke(task) },
        isCheckboxEnabled = task.checked,
        onCheckedChange = { newValue ->
          onCheckedChange(task, newValue)
        },
        modifier = modifier
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview() {
  ComposeTrainingTheme {
    WellnessTasksList(
      list = getWellnessTasksList(),
      onCloseTask = {},
      onCheckedChange = { _, _ -> }
    )
  }
}
