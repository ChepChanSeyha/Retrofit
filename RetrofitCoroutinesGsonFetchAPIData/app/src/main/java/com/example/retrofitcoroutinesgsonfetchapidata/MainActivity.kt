package com.example.retrofitcoroutinesgsonfetchapidata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcoroutinesgsonfetchapidata.Data.RetrofitClient
import com.example.retrofitcoroutinesgsonfetchapidata.Data.model.MyResponse
import com.example.retrofitcoroutinesgsonfetchapidata.Data.model.ResponseAdapter
import com.example.retrofitcoroutinesgsonfetchapidata.Data.model.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapterRes: ResponseAdapter
    private lateinit var myData: List<ResultsItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.rvData)
        recyclerView.layoutManager = linearLayoutManager
//        adapterRes = ResponseAdapter(myData)
//        recyclerView.adapter = adapterRes
    }

    override fun onStart() {
        super.onStart()
        val client = RetrofitClient()
        val call = client.getService().reposStatus()
        call.enqueue(object : Callback<MyResponse> {
            override fun onFailure(call: Call<com.example.retrofitcoroutinesgsonfetchapidata.Data.model.MyResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Get Status error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<MyResponse>, myResponse: Response<MyResponse>) {
                myResponse.body()?.let {
                    Toast.makeText(this@MainActivity, "Get Status Success", Toast.LENGTH_LONG).show()
                }

                myResponse.isSuccessful
//                Log.d("gg", response.body().toString())

                val resultsItem = myResponse.body()
                myResponse.body()
                val gSon = Gson()
//                try {
//                    val obj = gSon.fromJson(resultsItem, com.example.retrofitcoroutinesgsonfetchapidata.Data.model.MyResponse::class.java)
//                }catch (e: Exception){
//                    e.printStackTrace()
//                }

//                Log.d("gg", obj.toString())

            }

        })
    }

}
