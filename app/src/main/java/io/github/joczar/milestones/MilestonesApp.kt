package io.github.joczar.milestones

import android.app.Application
import androidx.room.Room
import io.github.joczar.milestones.data.dao.AppDatabase

class MilestonesApp : Application() {
    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "milestones-db"
        )
            .fallbackToDestructiveMigration(true) // TODO: remove in production
            .build()
    }

}