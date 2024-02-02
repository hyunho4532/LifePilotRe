package com.hyun.lifepilotre.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hyun.lifepilotre.dao.UserDao
import com.hyun.lifepilotre.data.model.User

@Database(entities = [User::class], version = 1)
abstract class LifePilotDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: LifePilotDatabase? = null

        fun getInstance(context: Context): LifePilotDatabase {
            if (instance == null) {
                synchronized(LifePilotDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LifePilotDatabase::class.java,
                        "lifepilot_database"
                    ).build()
                }
            }

            return instance!!
        }
    }
}