package com.example.retrofitcoroutinesgsonfetchapidata.Data.model

import com.google.gson.annotations.SerializedName

data class Results(

	@field:SerializedName("next_published_date")
	val nextPublishedDate: String? = null,

	@field:SerializedName("bestsellers_date")
	val bestsellersDate: String? = null,

	@field:SerializedName("books")
	val books: List<BooksItem?>? = null,

	@field:SerializedName("corrections")
	val corrections: List<Any?>? = null,

	@field:SerializedName("published_date_description")
	val publishedDateDescription: String? = null,

	@field:SerializedName("normal_list_ends_at")
	val normalListEndsAt: Int? = null,

	@field:SerializedName("list_name")
	val listName: String? = null,

	@field:SerializedName("list_name_encoded")
	val listNameEncoded: String? = null,

	@field:SerializedName("previous_published_date")
	val previousPublishedDate: String? = null,

	@field:SerializedName("display_name")
	val displayName: String? = null,

	@field:SerializedName("published_date")
	val publishedDate: String? = null,

	@field:SerializedName("updated")
	val updated: String? = null
)