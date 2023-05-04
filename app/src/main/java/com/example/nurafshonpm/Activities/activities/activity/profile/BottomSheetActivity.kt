package com.example.nurafshonpm.Activities.activities.activity.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import com.example.nurafshonpm.R

class BottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_rating)
        initviews()
    }

    private fun initviews() {
       var rating  = findViewById<RatingBar>(R.id.ratingBar)


        rating.stepSize = 5f

        rating.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(this, "Rating: $rating" , Toast.LENGTH_SHORT).show()

        }
    }
}