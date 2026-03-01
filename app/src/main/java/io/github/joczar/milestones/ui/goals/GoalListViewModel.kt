package io.github.joczar.milestones.ui.goals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.joczar.milestones.data.model.Goal
import io.github.joczar.milestones.data.repository.GoalRepository
import kotlinx.coroutines.launch

class GoalListViewModel(private val goalRepository: GoalRepository) : ViewModel() {

    val goals = goalRepository.getAllGoals()

    fun addGoal(title: String, description: String) {
        viewModelScope.launch {
            goalRepository.insertGoal(Goal(title = title, description = description))
        }
    }
}