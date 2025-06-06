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

package br.com.rstudio.codelab4.feature.data

import androidx.annotation.DrawableRes

/**
 * A simple data class to represent an Email.
 */
data class Email(
  val id: Long,
  val sender: Account,
  val recipients: List<Account> = emptyList(),
  val subject: String,
  val body: String,
  val attachments: List<EmailAttachment> = emptyList(),
  var isImportant: Boolean = false,
  var isStarred: Boolean = false,
  var mailbox: MailboxType = MailboxType.INBOX,
  val createdAt: String,
  val threads: List<Email> = emptyList()
)

enum class MailboxType {
    INBOX, DRAFTS, SENT, SPAM, TRASH
}

data class EmailAttachment(
    @DrawableRes val resId: Int,
    val contentDesc: String
)