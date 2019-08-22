package com.example.retrofitcoroutinesgsonfetchapidata.Data.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcoroutinesgsonfetchapidata.R


class ResponseAdapter : RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder>() {

    private var dataList = ArrayList<Data>()
    // fun set list
    fun setList(list: ArrayList<Data>){
        dataList = list
    }

    class ResponseViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val displayNameT: TextView = view.findViewById(R.id.displayName)
        val listNameT: TextView = view.findViewById(R.id.listName)
        val oldDateT: TextView = view.findViewById(R.id.oldDate)
        val newDateT: TextView = view.findViewById(R.id.newDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item_response, parent, false)
        return ResponseViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        val name = dataList[position].displayName
        val listName = dataList[position].listName
        val oldDate = dataList[position].oldestPublishedDate
        val newDate = dataList[position].newestPublishedDate
        holder.displayNameT.text = "Name:   $name"
        holder.listNameT.text = "List Name: $listName"
        holder.oldDateT.text = "Old Date:   $oldDate"
        holder.newDateT.text = "New Date:   $newDate"
    }
}