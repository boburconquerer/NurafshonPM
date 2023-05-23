package com.example.nurafshonpm.Activities.activities.fragments.postModel

 class RatingRequest{
     val createdAt: String?=null
     var description: String?=null
     var id: Int?=null
     var teacher: String?=null
     var rating: String?=null
     val updatedAt: String?=null

     constructor(id: Int?) {
         this.id = id
     }

     constructor(description: String?, teacher: String?, rating: String?) {
         this.description = description
         this.teacher = teacher
         this.rating = rating
     }
 }
