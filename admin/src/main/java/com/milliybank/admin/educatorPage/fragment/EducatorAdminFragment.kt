package com.milliybank.admin.educatorPage.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.admin.R
import com.milliybank.admin.educatorPage.ModelEducator.Model.EducatorRequest
import com.milliybank.admin.educatorPage.ModelEducator.Model.EducatorResponse
import com.milliybank.admin.educatorPage.adapter.HobbyAdapter
import com.milliybank.admin.educatorPage.models.EducatorsResponseGet
import com.milliybank.admin.educatorPage.models.EducatorsResponseGetItem
import com.milliybank.admin.educatorPage.modul.HobbyData
import com.milliybank.admin.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EducatorAdminFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_educator_admin, container, false)
        initViews(view)
        return view

    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycleHobbies_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        onClicked(view)
        getList(view)
    }
    private fun onClicked(view: View){
        val postData = view.findViewById<AppCompatButton>(R.id.hobbiesButtonSubmit_id)
        postData.setOnClickListener {
            apiEducator(view)
        }
    }

    private fun apiEducator(view: View){
        val lessonName = view.findViewById<EditText>(R.id.extraLessonName_id)
        val date = view.findViewById<EditText>(R.id.extraLessonsDate)
        val teacherName = view.findViewById<EditText>(R.id.extraLessonTeacher_id)
        val startTime = view.findViewById<EditText>(R.id.extraLessonStartTime_id)
        val endTime = view.findViewById<EditText>(R.id.extraLessonEndTime_id)
        val groupName = view.findViewById<EditText>(R.id.extraLessonGroupName_id)

        val getLessonName = lessonName.text.toString().trim()
        val getDate = date.text.toString().trim()
        val getTeacher = teacherName.text.toString().trim()
        val getStart = startTime.text.toString().trim()
        val getEnd = endTime.text.toString().trim()
        val getGroup = groupName.text.toString().trim()

        val educatorRequest = EducatorRequest(getDate, getLessonName, getTeacher, getStart, getEnd, getGroup)
        RetrofitHttp.retrofitService().postEducatorAnnouncement(educatorRequest).enqueue(object: Callback<EducatorResponse>{
            override fun onResponse(call: Call<EducatorResponse>, response: Response<EducatorResponse>) {
                Log.d("suc", response.body().toString())
            }

            override fun onFailure(call: Call<EducatorResponse>, t: Throwable) {
                Log.d("##",t.message.toString())
            }

        })
    }

    private fun getList(view: View){
        val list = ArrayList<EducatorsResponseGetItem>()
        val progress = view.findViewById<ProgressBar>(R.id.progress_educator)
        progress.visibility = View.VISIBLE
        RetrofitHttp.retrofitService().getEducatorAnnouncement().enqueue(object :Callback<EducatorsResponseGet>{
            override fun onResponse(call: Call<EducatorsResponseGet>, response: Response<EducatorsResponseGet>) {
                progress.visibility = View.GONE
                if (response.isSuccessful){
                    val data = response.body()
                    for (index in data!!.reversed()){
                        list.add(index)
                    }
                    refreshData(list)

                    Log.d("@sss", response.body().toString())
                }

            }

            override fun onFailure(call: Call<EducatorsResponseGet>, t: Throwable) {
                progress.visibility = View.GONE
                Log.d("@eee",t.message.toString())

            }

        })
    }



    private fun refreshData(data: ArrayList<EducatorsResponseGetItem>) {
        val adapter = HobbyAdapter(data)
        recyclerView.adapter = adapter
    }


}