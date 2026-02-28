package io.github.joczar.milestones.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.github.joczar.milestones.data.model.Step
import kotlinx.coroutines.flow.Flow

@Dao
interface StepDao {
    
    @Insert
    suspend fun insert(step: Step)
    
    @Update
    suspend fun update(step: Step)
    
    @Delete
    suspend fun delete(step: Step)
    
    @Query("""
        SELECT * FROM Step WHERE goalId = :goalId
    """)
    fun findByGoalId(goalId: Long): Flow<List<Step>>
}