package com.milliybank.admin.directorPage.models

data class DirectorResponseItem(
    val complaint_description: String,
    val complaint_title: String,
    val createdAt: String,
    val id: Int,
    val updatedAt: String
)