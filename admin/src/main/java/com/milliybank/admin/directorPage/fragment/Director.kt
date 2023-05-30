package com.milliybank.admin.directorPage.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milliybank.admin.R
import com.milliybank.admin.directorPage.adapter.ComplaintAdapter
import com.milliybank.admin.directorPage.models.DirectorResponse
import com.milliybank.admin.directorPage.models.DirectorResponseItem
import com.milliybank.admin.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Director : Fragment() {


    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_director, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.directorView_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getList(view)

    }

    private fun getList(view: View) {
        val list = ArrayList<DirectorResponseItem>()
        val progressBar = view.findViewById<ProgressBar>(R.id.progress_director)
        progressBar.visibility = View.VISIBLE
        RetrofitHttp.retrofitService().getComplaint().enqueue(object: Callback<DirectorResponse>{
            override fun onResponse(
                call: Call<DirectorResponse>,
                response: Response<DirectorResponse>
            ) {
                progressBar.visibility = View.GONE
                if (response.isSuccessful){
                    val data = response.body()
                    for (index in data!!.reversed()){
                        list.add(index)
                    }
                    refreshData(list)

                    Log.d("@Message", response.body().toString())
                }

            }

            override fun onFailure(call: Call<DirectorResponse>, t: Throwable) {
               progressBar.visibility = View.GONE
                Log.d("@errorGiven",t.message.toString())
            }

        })
    }

    private fun refreshData(data:ArrayList<DirectorResponseItem>){
        val adapter = ComplaintAdapter(data)
        recyclerView.adapter = adapter
    }
    //Hello//Hello//Hello//Hello//Hello//Hello//Hello//Hello//Hello//Hello//Hello

}