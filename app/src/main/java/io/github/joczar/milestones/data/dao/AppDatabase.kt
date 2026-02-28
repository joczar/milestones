package io.github.joczar.milestones.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.joczar.milestones.data.model.Step
import io.github.joczar.milestones.data.model.Goal

@Database(
    entities = [Goal::class, Step::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun goalDao(): GoalDao
    abstract fun stepDao(): StepDao
}