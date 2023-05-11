package com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "plan_of_student")
class PlanData
    (
    @ColumnInfo(name = "plan_title_of_student") var title: String?,
    @ColumnInfo(name = "plan_description") var description: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

}