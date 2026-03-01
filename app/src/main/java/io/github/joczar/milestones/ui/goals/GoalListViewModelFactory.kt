package io.github.joczar.milestones.ui.goals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.joczar.milestones.data.repository.GoalRepository
import kotlin.jvm.java

class GoalListViewModelFactory (
        private val repository: GoalRepository
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GoalListViewModel::class.java)) {
                return GoalListViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }