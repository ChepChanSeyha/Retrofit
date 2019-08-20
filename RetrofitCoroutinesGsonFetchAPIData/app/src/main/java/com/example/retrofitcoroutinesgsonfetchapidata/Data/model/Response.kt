package com.example.retrofitcoroutinesgsonfetchapidata.Data.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("num_results")
	val numResults: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)