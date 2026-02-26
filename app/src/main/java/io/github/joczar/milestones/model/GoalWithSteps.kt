package io.github.joczar.milestones.model

import androidx.room.Embedded
import androidx.room.Relation

data class GoalWithSteps(
    @Embedded val goal: Goal,
    @Relation(
        parentColumn = "id",
        entityColumn = "goalId"
    )
    val steps: List<Step>
)