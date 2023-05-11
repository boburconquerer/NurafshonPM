package com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PlanData::class], version = 1)
abstract class PlanDatabase : RoomDatabase(){

    abstract fun planDao(): PlanDao
    companion object{
        private var INSTANCE: PlanDatabase? = null
        fun getInstance(context: Context): PlanDatabase?{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PlanDatabase::class.java,
                    "Daily plans"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }

    }
}