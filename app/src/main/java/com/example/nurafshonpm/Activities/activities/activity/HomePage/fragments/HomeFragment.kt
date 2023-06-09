package com.example.nurafshonpm.Activities.activities.activity.HomePage.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nurafshonpm.Activities.activities.adapters.AdapterHomePage
import com.example.nurafshonpm.Activities.activities.fragments.model.HomeAnnounce
import com.example.nurafshonpm.Activities.activities.fragments.model.HomeAnnounceItem
import com.example.nurafshonpm.Activities.activities.networks.RetrofitHTTP
import com.example.nurafshonpm.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewHomePage)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        apiList(view)
    }

    private fun refreshData(data: ArrayList<HomeAnnounceItem>) {
        val adapter = AdapterHomePage(data)
        recyclerView.adapter = adapter
    }

    private fun apiList(view: View){
        val progressBar:ProgressBar = view.findViewById(R.id.homeProgressBar_id)
        progressBar.visibility = View.VISIBLE
        val list = ArrayList<HomeAnnounceItem>()
        RetrofitHTTP.retrofitService().announcementList().enqueue(object : Callback<HomeAnnounce> {
            override fun onResponse(call: Call<HomeAnnounce>, response: Response<HomeAnnounce>) {
                progressBar.visibility = View.GONE
                Log.d("Announce" , response.body().toString())
                if(response.isSuccessful){
                    val data = response.body()
                    for (index in data!!.reversed()){
                        list.add(index)
                    }
                    refreshData(list)

                }
            }

            override fun onFailure(call: Call<HomeAnnounce>, t: Throwable) {
                Log.d("Error" , t.message.toString())
            }

        })
    }
}