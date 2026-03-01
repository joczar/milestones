package io.github.joczar.milestones.data.repository

import io.github.joczar.milestones.data.dao.GoalDao
import io.github.joczar.milestones.data.dao.StepDao
import io.github.joczar.milestones.data.model.Goal
import io.github.joczar.milestones.data.model.Step
import kotlinx.coroutines.flow.Flow

class GoalRepository(
    private val goalDao: GoalDao,
    private val stepDao: StepDao
) {
    fun getAllGoals(): Flow<List<Goal>> = goalDao.fetchAll()

    suspend fun insertGoal(goal: Goal) = goalDao.insert(goal)

    fun getStepsForGoal(goalId: Long): Flow<List<Step>> = stepDao.findByGoalId(goalId)
}