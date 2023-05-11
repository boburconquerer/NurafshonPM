package com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlanDao {
    //@Query("SELECT * FROM plan_of_student ORDER BY id DESC")
    @Query("SELECT * FROM plan_of_student")
    fun getAll():List<PlanData>

    @Insert
    fun insert(planData: PlanData)

    @Query("DELETE FROM plan_of_student WHERE id = :id")
    fun delete(id: Int)


}