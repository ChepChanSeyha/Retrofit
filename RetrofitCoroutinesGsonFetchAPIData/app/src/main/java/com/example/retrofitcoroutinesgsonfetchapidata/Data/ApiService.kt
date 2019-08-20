package com.example.retrofitcoroutinesgsonfetchapidata.Data

import com.example.retrofitcoroutinesgsonfetchapidata.Data.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("lists/names.json?api-key=uKE04ladNGLmARIGNDbx7boXT7IYqAWL")
    fun reposStatus(): Call<Response>
}