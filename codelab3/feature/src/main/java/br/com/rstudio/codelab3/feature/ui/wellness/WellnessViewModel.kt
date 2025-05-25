package br.com.rstudio.codelab3.feature.ui.wellness

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import br.com.rstudio.codelab3.feature.data.WellnessTask

fun getWellnessTasksList(): List<WellnessTask> {
  return List(30) { i -> WellnessTask(id = i, label = "Task #$i") }
}

class WellnessViewModel : ViewModel() {

  private var _tasks = getWellnessTasksList().toMutableStateList()
  val tasks: List<WellnessTask>
    get() = _tasks

  fun remove(item: WellnessTask) {
    _tasks.remove(item)
  }

  fun onCheckChange(item: WellnessTask, newValue: Boolean) {
    _tasks.find { it.id == item.id }?.checked = newValue
  }
}
