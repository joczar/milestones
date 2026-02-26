package io.github.joczar.milestones.repository

import io.github.joczar.milestones.dao.GoalDao
import io.github.joczar.milestones.dao.StepDao

class GoalRepository(
    private val goalDao: GoalDao,
    private val stepDao: StepDao
)