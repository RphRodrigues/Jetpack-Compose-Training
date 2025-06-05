/*
 * Copyright 2020 The Android Open Source Project
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

package br.com.rstudio.codelab6.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rstudio.codelab6.feature.data.DestinationsRepository
import br.com.rstudio.codelab6.feature.data.ExploreModel
import br.com.rstudio.codelab6.feature.di.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

const val MAX_PEOPLE = 4

@HiltViewModel
class MainViewModel @Inject constructor(
  private val destinationsRepository: DestinationsRepository,
  @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

  private val _suggestedDestinations = MutableStateFlow<List<ExploreModel>>(emptyList())
  val suggestedDestinations: StateFlow<List<ExploreModel>> = _suggestedDestinations.asStateFlow()

  val hotels: List<ExploreModel> = destinationsRepository.hotels
  val restaurants: List<ExploreModel> = destinationsRepository.restaurants

  init {
    _suggestedDestinations.value = destinationsRepository.destinations
  }

  fun updatePeople(people: Int) {
    viewModelScope.launch {
      if (people > MAX_PEOPLE) {
        _suggestedDestinations.value = emptyList()
      } else {
        val newDestinations = withContext(defaultDispatcher) {
          destinationsRepository.destinations
            .shuffled(Random(people * (1..100).shuffled().first()))
        }
        _suggestedDestinations.value = newDestinations
      }
    }
  }

  fun toDestinationChanged(newDestination: String) {
    viewModelScope.launch {
      val newDestinations = withContext(defaultDispatcher) {
        destinationsRepository.destinations
          .filter { it.city.nameToDisplay.contains(newDestination) }
      }
      _suggestedDestinations.value = newDestinations
    }
  }
}
