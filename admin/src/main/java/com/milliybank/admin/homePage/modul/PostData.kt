package com.milliybank.admin.homePage.modul

 class PostData{
    val createdAt: String?=null
    var description: String?=null
    var id: Int?=null
    var title: String?=null
    val updatedAt: String?=null


     constructor(description: String?, title: String?) {
         this.description = description
         this.title = title
     }

     constructor(id: Int?) {
         this.id = id
     }
 }
