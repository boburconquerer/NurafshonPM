package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RatingBar
import androidx.appcompat.widget.AppCompatButton
import com.example.nurafshonpm.Activities.activities.activity.profile.TimeManagementActivity
import com.example.nurafshonpm.Activities.activities.fragments.postModel.RatingRequest
import com.example.nurafshonpm.Activities.activities.fragments.postModel.RatingResponse
import com.example.nurafshonpm.Activities.activities.networks.RetrofitHTTP
import com.example.nurafshonpm.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {

    private lateinit var ratingRequest :RatingRequest
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        initViews(view)
        return view;
    }


    private fun initViews(view: View) {
        openPage(view)

    }

    private fun openPage(view: View) {
        val timeManage = view.findViewById<LinearLayout>(R.id.timeManagement)
        timeManage.setOnClickListener {
            val intent = Intent(requireContext(), TimeManagementActivity::class.java)
            startActivity(intent)
        }
        administration(view)
        director(view)

        teacher(view)


    }

    private fun administration(view: View) {

        val administration = view.findViewById<LinearLayout>(R.id.adminstration)

        administration.setOnClickListener {
            bottomSheetDialog(view)
        }
    }

    private fun director(view: View) {

        val director = view.findViewById<LinearLayout>(R.id.director)

        director.setOnClickListener {
            bottomSheetDialog(view)
        }
    }

    private fun teacher(view: View) {

        var teacher = view.findViewById<LinearLayout>(R.id.teacher)

        teacher.setOnClickListener {
            bottomSheetRating(view)
        }
    }


    private fun bottomSheetDialog(view: View) {
        val bottomSheet = BottomSheetDialog(requireContext())
        bottomSheet.setContentView(R.layout.bottomsheet_fragment)
        bottomSheet.show()


    }


private fun bottomSheetRating(view: View) {
    val bottomSheet = BottomSheetDialog(requireContext())

    bottomSheet.setContentView(R.layout.activity_bottom_sheet_rating)

//    val submit = view.findViewById<AppCompatButton>(R.id.submitRating)
//    submit?.setOnClickListener {
//
//        val employeeName = view.findViewById<EditText>(R.id.employee_name)
//        val description = view.findViewById<EditText>(R.id.description)
//        val rating = view.findViewById<RatingBar>(R.id.ratingBar)
//        val name = employeeName.text.toString().trim()
//        val descript = description.text.toString().trim()
//
//        // ratingRequest o'zgaruvchisining qiymatini yaratish
//        ratingRequest = RatingRequest(name, rating.rating, descript)
//
//        val progressBar = view.findViewById<ProgressBar>(R.id.progressBareee)
//        progressBar.visibility = View.VISIBLE
//
//        RetrofitHTTP.retrofitService().ratingPost(ratingRequest)
//            .enqueue(object : Callback<RatingResponse> {
//                override fun onResponse(
//                    call: Call<RatingResponse>,
//                    response: Response<RatingResponse>
//                ) {
//                    Log.d("Succes" , response.body().toString())
//                    progressBar.visibility = View.GONE
//                }
//
//                override fun onFailure(call: Call<RatingResponse>, t: Throwable) {
//                    progressBar.visibility = View.GONE
//                    Log.d("Failure" , t.message.toString())}
//            })
//    }
    val submit = bottomSheet.findViewById<AppCompatButton>(R.id.submitRating)
    submit?.setOnClickListener {

        val employeeName = bottomSheet.findViewById<EditText>(R.id.employee_name)
        val description = bottomSheet.findViewById<EditText>(R.id.description)
        val rating = bottomSheet.findViewById<RatingBar>(R.id.ratingBar)
        val name = employeeName!!.text.toString().trim()
        val descript = description!!.text.toString().trim()

        // ratingRequest o'zgaruvchisining qiymatini yaratish
        ratingRequest = RatingRequest(name, rating!!.rating, descript)

        val progressBar = bottomSheet.findViewById<ProgressBar>(R.id.progressBareee)
        progressBar!!.visibility = View.VISIBLE

        RetrofitHTTP.retrofitService().ratingPost(ratingRequest)
            .enqueue(object : Callback<RatingResponse> {
                override fun onResponse(
                    call: Call<RatingResponse>,
                    response: Response<RatingResponse>
                ) {
                    progressBar!!.visibility = View.GONE

                    if (response.isSuccessful) {
                        Log.d("Success", response.body().toString())
                        // Muaffaqiyatli natija bo'lsa qilinish kerak bo'lgan ishlarni bajarishingiz mumkin
                    } else {
                        Log.d("Unsuccessful", response.message())
                        // Xatolik bo'lsa uni aniqlash va foydalanuvchiga xabar berish kerak
                    }
                }

                override fun onFailure(call: Call<RatingResponse>, t: Throwable) {
                    progressBar!!.visibility = View.GONE
                    Log.d("Failure" , t.message.toString())
                    // Xatolikni aniqlash va foydalanuvchiga xabar berish kerak
                }
            })
    }
    bottomSheet.show()

}


}