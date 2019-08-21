package com.example.retrofitcoroutinesgsonfetchapidata.Data.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcoroutinesgsonfetchapidata.R


class ResponseAdapter(private val myData: List<ResultsItem>) : RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder>()  {

    class ResponseViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val displayNameT: TextView = view.findViewById(R.id.displayName)
        val listNameT: TextView = view.findViewById(R.id.listName)
        val oldDateT: TextView = view.findViewById(R.id.oldDate)
        val newDateT: TextView = view.findViewById(R.id.newDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item_response, parent, false) as TextView
        return ResponseViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        holder.displayNameT.text = myData[position].displayName
        holder.listNameT.text = myData[position].listName
        holder.oldDateT.text = myData[position].oldestPublishedDate
        holder.newDateT.text = myData[position].newestPublishedDate
    }
}