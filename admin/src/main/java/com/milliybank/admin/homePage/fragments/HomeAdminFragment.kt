package com.milliybank.admin.homePage.fragments

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
import com.milliybank.admin.homePage.adapter.PostAdapter
import com.milliybank.admin.homePage.modul.AdminHome
import com.milliybank.admin.homePage.modul.AdminHomeItem
import com.milliybank.admin.homePage.modul.PostData
import com.milliybank.admin.network.RetrofitHttp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeAdminFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_admin, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclePost_id)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        dataOfPost(view)
        getDataOfList(view)
    }
    private fun dataOfPost(view: View){
        val postAnnounceButton = view.findViewById<AppCompatButton>(R.id.postAnnounceButton_id)
        postAnnounceButton.setOnClickListener {
            postDataOfList(view)
        }

    }

    private fun postDataOfList(view:View){
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar_id)
        progressBar.visibility = View.VISIBLE

        val newTitle = view.findViewById<EditText>(R.id.newTitle_id)
        val newTitleDesc = view.findViewById<EditText>(R.id.newTitleDesc_id)

        val title = newTitle.text.toString().trim()
        val description = newTitleDesc.text.toString().trim()

        val data = PostData(title,description)

        RetrofitHttp.retrofitService().postAnnouncement(data).enqueue(object :Callback<AdminHomeItem>{
            override fun onResponse(call: Call<AdminHomeItem>, response: Response<AdminHomeItem>) {
                progressBar.visibility = View.GONE
                Log.d("@@@s", response.body().toString())
            }

            override fun onFailure(call: Call<AdminHomeItem>, t: Throwable) {
                progressBar.visibility = View.GONE
                Log.d("@@@e",t.message.toString())
            }

        })
    }
    private fun getDataOfList(view: View){
        val list = ArrayList<AdminHomeItem>()
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar_id)
        progressBar.visibility = View.VISIBLE
        RetrofitHttp.retrofitService().getAnnouncement().enqueue(object :Callback<AdminHome>{
            override fun onResponse(call: Call<AdminHome>, response: Response<AdminHome>) {
                progressBar.visibility = View.GONE

                if (response.isSuccessful){
                    val data = response.body()
                    for (index in data!!.reversed()){
                        list.add(index)
                    }
                    //refreshData(response.body()!!)
                    refreshData(list)
                }
                Log.d("@@@s", response.body().toString())
            }

            override fun onFailure(call: Call<AdminHome>, t: Throwable) {
                progressBar.visibility = View.GONE
                Log.d("@@@e", t.message.toString())
            }
        })
    }


    private fun refreshData(data: ArrayList<AdminHomeItem>) {
        val adapter = PostAdapter(data)
        recyclerView.adapter = adapter
    }
}