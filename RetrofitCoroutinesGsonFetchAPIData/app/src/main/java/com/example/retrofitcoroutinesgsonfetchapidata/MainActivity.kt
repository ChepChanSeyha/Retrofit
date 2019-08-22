package com.example.retrofitcoroutinesgsonfetchapidata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcoroutinesgsonfetchapidata.Data.RetrofitClient
import com.example.retrofitcoroutinesgsonfetchapidata.Data.model.Reqres
import com.example.retrofitcoroutinesgsonfetchapidata.Data.model.ResponseAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapterRes: ResponseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rvData)
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        adapterRes = ResponseAdapter()
        recyclerView.adapter = adapterRes

    }

    override fun onStart() {
        super.onStart()
        val client = RetrofitClient()
        val call = client.getService().reposStatus()
        call.enqueue(object : Callback<Reqres> {
            override fun onFailure(call: Call<Reqres>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Get Status error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Reqres>, myResponse: Response<Reqres>) {
                myResponse.body()?.let {
                    Toast.makeText(this@MainActivity, "Get Status Success", Toast.LENGTH_LONG).show()
                }

                myResponse.isSuccessful
//                Log.d("gg", response.body().toString())

                val gg = myResponse.body()?.results!!
                adapterRes.setList(gg)
                adapterRes.notifyDataSetChanged()
            }

        })
    }

}
