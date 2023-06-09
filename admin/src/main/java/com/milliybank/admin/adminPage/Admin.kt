package com.milliybank.admin.adminPage

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
import com.milliybank.admin.homePage.adapter.messageAdapter.MessageAdapter
import com.milliybank.admin.homePage.modulMessage.MessageResponse
import com.milliybank.admin.homePage.modulMessage.MessageResponseItem
import com.milliybank.admin.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Admin : Fragment() {

    private lateinit var recyclerView:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_admin, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.adminView_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getList(view)
    }

    private fun getList(view: View) {
        val list  = ArrayList<MessageResponseItem>()
        val progressBar = view.findViewById<ProgressBar>(R.id.progress_admin)
        progressBar.visibility = View.VISIBLE

        RetrofitHttp.retrofitService().getMessage().enqueue(object : Callback<MessageResponse>{
            override fun onResponse(
                call: Call<MessageResponse>,
                response: Response<MessageResponse>
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

            override fun onFailure(call: Call<MessageResponse>, t: Throwable) {
                progressBar.visibility = View.GONE
                Log.d("@Error",t.message.toString())
            }

        })
    }
    private fun refreshData(data2:ArrayList<MessageResponseItem>){
        val adapter = MessageAdapter(data2)
        recyclerView.adapter = adapter
    }
}