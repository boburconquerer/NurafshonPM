package com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GoalDao {
    @Query("SELECT * FROM Goals_of_Student")
    fun getAll():GoalData

    @Insert
    fun insert(goalData: GoalData)

    @Delete
    fun delete(goalData: GoalData)

    @Query("DELETE FROM Goals_of_Student")
    fun deleteAll()
}