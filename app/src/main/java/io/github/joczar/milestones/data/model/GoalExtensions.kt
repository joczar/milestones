package io.github.joczar.milestones.data.model

fun GoalWithSteps.progress() : Float {
    if (steps.isEmpty()) return 0.0f

    val completedSteps = steps.count { step -> step.isCompleted }

    return completedSteps.toFloat() / steps.size
}