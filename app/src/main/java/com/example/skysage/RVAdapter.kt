package com.example.skysage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class RVAdapter(var mContext:Context,var dataList:ArrayList<CityData>):RecyclerView.Adapter<RVAdapter.myCardViewElements>() {
    inner class myCardViewElements(view:View):RecyclerView.ViewHolder(view){

        var cityName:TextView
        var cardView:CardView
        init {
            cityName=view.findViewById(R.id.cityName)
            cardView=view.findViewById(R.id.cardView)
        }

    }

    override fun onBindViewHolder(holder: myCardViewElements, position: Int) {
        var myHolder=dataList[position]
        holder.cityName.text=myHolder.city

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myCardViewElements {
        var design=LayoutInflater.from(mContext).inflate(R.layout.cardview,parent,false)
        return myCardViewElements(design)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}