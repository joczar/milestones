package io.github.joczar.milestones.ui.goals

import androidx.lifecycle.ViewModel
import io.github.joczar.milestones.data.repository.GoalRepository

class GoalDetailsViewModel(private val goalRepository: GoalRepository, private val goalId: Long) : ViewModel() {

    val steps = goalRepository.getStepsForGoal(goalId)
}