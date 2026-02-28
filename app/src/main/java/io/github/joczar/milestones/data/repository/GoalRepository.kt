package io.github.joczar.milestones.data.repository

import io.github.joczar.milestones.data.dao.GoalDao
import io.github.joczar.milestones.data.dao.StepDao

class GoalRepository(
    private val goalDao: GoalDao,
    private val stepDao: StepDao
)