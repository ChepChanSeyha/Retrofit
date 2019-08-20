package com.example.retrofitcoroutinesgsonfetchapidata.Data.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcoroutinesgsonfetchapidata.R


class ResponseAdapter: RecyclerView.Adapter<ResponseAdapter.ResponseHolder>() {

    private val response = ArrayList<Response>()

    class ResponseHolder(var textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item_response, parent, false) as TextView
        return ResponseHolder(textView)
    }

    override fun getItemCount(): Int {
        return response.size
    }

    override fun onBindViewHolder(holder: ResponseHolder, position: Int) {
        holder.textView.text = response[position].toString()
    }
}