package com.milliybank.admin.homePage.modul

class PostData {
    var title: String? = null
    var description: String? = null
    var id: Int? = null
    val createdAt: String? = null
    val updatedAt: String? = null


    constructor(title: String?, description: String?) {
        this.title = title
        this.description = description

    }

    constructor(id: Int?) {
        this.id = id
    }
}
