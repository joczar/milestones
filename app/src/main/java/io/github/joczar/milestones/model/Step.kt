package io.github.joczar.milestones.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Goal::class,
            parentColumns = ["id"],
            childColumns = ["goalId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Step(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val goalId: Long,
    val title: String,
    val isCompleted: Boolean = false
)