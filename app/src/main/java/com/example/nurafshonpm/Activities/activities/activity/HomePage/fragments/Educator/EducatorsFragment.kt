package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments.Educator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments.Educator.Models.EducatorResponse
import com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments.Educator.Models.EducatorResponseGet
import com.example.nurafshonpm.Activities.activities.adapters.ExtraLessonsAdapter
import com.example.nurafshonpm.Activities.activities.modul.ExtraLessons
import com.example.nurafshonpm.Activities.activities.networks.RetrofitHTTP
import com.example.nurafshonpm.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EducatorsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_educators, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.EducatorsFragment)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        getList(view)
    }

    private fun getList(view: View) {
        val list = ArrayList<EducatorResponse>()
        val progress = view.findViewById<ProgressBar>(R.id.progressed_educator)
        progress.visibility = View.VISIBLE
        RetrofitHTTP.retrofitService().getEducatorAnnouncement().enqueue(object: Callback<EducatorResponseGet>{
            override fun onResponse( call: Call<EducatorResponseGet>, response: Response<EducatorResponseGet>) {
                progress.visibility = View.GONE
                if(response.isSuccessful){
                    val data = response.body()
                    for(index in data!!.reversed()){
                        list.add(index)
                    }
                    refreshData(list)

                    Log.d("s", response.body().toString())
                }
            }

            override fun onFailure(call: Call<EducatorResponseGet>, t: Throwable) {
               progress.visibility = View.GONE
                Log.d("f", t.message.toString())
            }

        })
    }


    private fun refreshData(data: ArrayList<EducatorResponse>) {
        val adapter = ExtraLessonsAdapter(data)
        recyclerView.adapter = adapter
    }
}