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
import com.example.nurafshonpm.Activities.activities.adapters.RatingAdapter
import com.example.nurafshonpm.Activities.activities.fragments.model.RatingData
import com.example.nurafshonpm.Activities.activities.fragments.model.RatingDataItem
import com.example.nurafshonpm.Activities.activities.modul.ModelRating
import com.example.nurafshonpm.Activities.activities.networks.RetrofitHTTP
import com.example.nurafshonpm.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RatingPageFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rating, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewRating)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        apiList(view)

    }



    private fun refreshData(data: ArrayList<RatingDataItem>) {
        val adapter = RatingAdapter(data)
        recyclerView.adapter = adapter

    }
    private fun apiList(view: View){
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar_id)
        progressBar.visibility = View.VISIBLE

        val list = ArrayList<RatingDataItem>()
        RetrofitHTTP.retrofitService().ratingList().enqueue(object:Callback<RatingData> {

            override fun onResponse(call: Call<RatingData>, response: Response<RatingData>) {
                progressBar.visibility = View.GONE
                Log.d("Succes!", response.body().toString())
                if (response.isSuccessful) {
                    val data = response.body()
                    for (index in data!!.reversed()){
                        list.add(index)
                    }
                  //  refreshData(response.body()!!)
                    refreshData(list)

                }
            }

            override fun onFailure(call: Call<RatingData>, t: Throwable) {
                Log.d("Error", t.message.toString())
                progressBar.visibility = View.GONE

            }
        })
    }
//Hello
}