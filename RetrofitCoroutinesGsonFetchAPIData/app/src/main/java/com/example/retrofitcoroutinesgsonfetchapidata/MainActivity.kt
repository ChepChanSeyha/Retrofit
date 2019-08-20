package com.example.retrofitcoroutinesgsonfetchapidata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitcoroutinesgsonfetchapidata.Data.RetrofitClient
import com.example.retrofitcoroutinesgsonfetchapidata.Data.model.ResponseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var adapter: ResponseAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        setupResponseList()
    }

    private fun setupResponseList() {
        rvData.layoutManager = LinearLayoutManager(this)
        adapter = ResponseAdapter()
        rvData.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        loadResponse()
    }

    private fun loadResponse() {
        val client = RetrofitClient()
        val call = client.getService().reposStatus()
        call.enqueue(object : Callback<com.example.retrofitcoroutinesgsonfetchapidata.Data.model.Response> {
            override fun onFailure(
                call: Call<com.example.retrofitcoroutinesgsonfetchapidata.Data.model.Response>,
                t: Throwable
            ) {
                Toast.makeText(this@MainActivity, "Get Status error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<com.example.retrofitcoroutinesgsonfetchapidata.Data.model.Response>,
                response: Response<com.example.retrofitcoroutinesgsonfetchapidata.Data.model.Response>
            ) {
                response.body()?.let {
                    Toast.makeText(this@MainActivity, "Get Status Success", Toast.LENGTH_LONG).show()
                }
            }

        })
    }

}
