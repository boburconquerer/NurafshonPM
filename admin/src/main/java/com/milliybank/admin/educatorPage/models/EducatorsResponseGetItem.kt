package com.milliybank.admin.educatorPage.models

data class EducatorsResponseGetItem(
    val createdAt: String,
    val end_time: String,
    val group: String,
    val id: Int,
    val name: String,
    val start_date: String,
    val start_time: String,
    val teacher: String,
    val updatedAt: String
)