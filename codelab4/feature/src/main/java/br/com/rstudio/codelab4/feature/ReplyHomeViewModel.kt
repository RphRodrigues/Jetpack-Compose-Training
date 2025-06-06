/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.rstudio.codelab4.feature

import androidx.lifecycle.ViewModel
import br.com.rstudio.codelab4.feature.data.Email
import br.com.rstudio.codelab4.feature.data.LocalEmailsDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReplyHomeViewModel : ViewModel() {

  // UI state exposed to the UI
  private val _uiState = MutableStateFlow(ReplyHomeUIState(loading = true))
  val uiState: StateFlow<ReplyHomeUIState> = _uiState

  init {
    initEmailList()
  }

  private fun initEmailList() {
    val emails = LocalEmailsDataProvider.allEmails
    _uiState.value = ReplyHomeUIState(
      emails = emails,
      selectedEmail = emails.first()
    )
  }

  fun setSelectedEmail(emailId: Long) {
    /**
     * We only set isDetailOnlyOpen to true when it's only single pane layout
     */
    val email = uiState.value.emails.find { it.id == emailId }
    _uiState.value = _uiState.value.copy(
      selectedEmail = email,
      isDetailOnlyOpen = true
    )
  }

  fun closeDetailScreen() {
    _uiState.value = _uiState
      .value.copy(
        isDetailOnlyOpen = false,
        selectedEmail = _uiState.value.emails.first()
      )
  }
}

data class ReplyHomeUIState(
  val emails: List<Email> = emptyList(),
  val selectedEmail: Email? = null,
  val isDetailOnlyOpen: Boolean = false,
  val loading: Boolean = false,
  val error: String? = null
)
