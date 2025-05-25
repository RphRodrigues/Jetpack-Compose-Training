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

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Codelab4Feature(
  modifier: Modifier = Modifier,
  closeCodelab4: () -> Unit = {}
) {
  BackHandler {
    closeCodelab4()
  }
  Surface(tonalElevation = 5.dp) {
    ReplyAppContent(modifier)
  }
}

@Composable
fun ReplyAppContent(
  modifier: Modifier,
  viewModel: ReplyHomeViewModel = viewModel()
) {

  val selectedDestination = remember { mutableStateOf(ReplyRoute.INBOX) }
  val uiState by viewModel.uiState.collectAsState()

  Column(modifier) {
    if (selectedDestination.value == ReplyRoute.INBOX) {
      ReplyInboxScreen(
        replyHomeUIState = uiState,
        closeDetailScreen = {
          viewModel.closeDetailScreen()
        },
        navigateToDetail = { emailId ->
          viewModel.setSelectedEmail(emailId)
        },
        modifier = Modifier.weight(1f)
      )
    } else {
      EmptyComingSoon(modifier = Modifier.weight(1f))
    }

    NavigationBar {
      TOP_LEVEL_DESTINATIONS.forEach { replyDestination ->
        NavigationBarItem(
          selected = selectedDestination.value == replyDestination.route,
          onClick = { selectedDestination.value = replyDestination.route },
          icon = {
            Icon(
              imageVector = replyDestination.selectedIcon,
              contentDescription = stringResource(id = replyDestination.iconTextId)
            )
          }
        )
      }
    }
  }
}


object ReplyRoute {
  const val INBOX = "Inbox"
  const val ARTICLES = "Articles"
  const val DM = "DirectMessages"
  const val GROUPS = "Groups"
}

data class ReplyTopLevelDestination(
  val route: String,
  val selectedIcon: ImageVector,
  val unselectedIcon: ImageVector,
  val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
  ReplyTopLevelDestination(
    route = ReplyRoute.INBOX,
    selectedIcon = Icons.Default.Inbox,
    unselectedIcon = Icons.Default.Inbox,
    iconTextId = R.string.tab_inbox
  ),
  ReplyTopLevelDestination(
    route = ReplyRoute.ARTICLES,
    selectedIcon = Icons.Default.Article,
    unselectedIcon = Icons.Default.Article,
    iconTextId = R.string.tab_article
  ),
  ReplyTopLevelDestination(
    route = ReplyRoute.DM,
    selectedIcon = Icons.Outlined.ChatBubbleOutline,
    unselectedIcon = Icons.Outlined.ChatBubbleOutline,
    iconTextId = R.string.tab_dm
  ),
  ReplyTopLevelDestination(
    route = ReplyRoute.GROUPS,
    selectedIcon = Icons.Default.People,
    unselectedIcon = Icons.Default.People,
    iconTextId = R.string.tab_groups
  )
)
