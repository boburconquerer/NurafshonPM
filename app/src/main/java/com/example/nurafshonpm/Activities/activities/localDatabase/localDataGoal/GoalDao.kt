package com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GoalDao {
    @Query("SELECT * FROM Goals_of_Student  ORDER BY id DESC")
    fun getAll():List<GoalData>

    @Insert
    fun insert(goalData: GoalData)

    @Query("DELETE FROM Goals_of_Student WHERE id = :id")
    fun delete(id: Int)

}