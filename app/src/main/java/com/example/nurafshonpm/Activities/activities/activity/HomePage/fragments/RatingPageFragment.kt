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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rating, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewRating)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        refreshData(data())

    }

    private fun data(): ArrayList<ModelRating> {
        val list = ArrayList<ModelRating>()
        for (i in 1..20){
            list.add(ModelRating("Alisher Daminov","5","good teacher, instructs students to junior stage in app development.good teacher, instructs students to junior stage in app development.good teacher, instructs students to junior stage in app development.good teacher, instructs students to junior stage in app development.good teacher, instructs students to junior stage in app development."))
        }
        return list
    }

    private fun refreshData(data: ArrayList<RatingDataItem>) {
        val adapter = RatingAdapter(data)
        recyclerView.adapter = adapter

    }
    private fun apiList(){
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar_id)
        progressBar.visibility = View.VISIBLE


        RetrofitHTTP.retrofitService().ratingList().enqueue(object:Callback<RatingData>{

            override fun onResponse(call: Call<RatingData>, response: Response<RatingData>) {
                progressBar.visibility = View.GONE
                Log.d("Hello" , response.body().toString())
                if(response.isSuccessful){
                    refreshData(response.body()!!)

                }
            }

            override fun onFailure(call: Call<RatingData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }
    }
//Hello
}