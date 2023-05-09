package com.example.nurafshonpm.Activities.activities.localDatabase.localDataGoal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "plan_of_student")
class PlanData {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    @ColumnInfo(name = "plan_title_of_student")
    var title:String? = null
    @ColumnInfo(name = "plan_description")
    var description:String? = null

    constructor()
    constructor(title:String?, description:String?){
        this.description = description
        this.title = title
    }
}