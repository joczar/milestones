package io.github.joczar.milestones.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import io.github.joczar.milestones.data.model.Goal
import io.github.joczar.milestones.data.model.GoalWithSteps
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {

    @Insert
    suspend fun insert(goal: Goal)

    @Update
    suspend fun update(goal: Goal)

    @Delete
    suspend fun delete(goal: Goal)

    @Query("SELECT * FROM goal")
    fun fetchAll(): Flow<List<Goal>>

    @Query("SELECT * FROM goal WHERE id = :goalId")
    fun findByGoalId(goalId: Long): Flow<Goal>

    @Transaction
    @Query("SELECT * FROM goal")
    fun fetchGoalsWithSteps(): Flow<List<GoalWithSteps>>
}