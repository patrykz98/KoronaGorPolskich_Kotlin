package com.example.gory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gory.R
import androidx.recyclerview.widget.RecyclerView
import com.example.gory.api.WheaterJson
import com.example.gory.data.WheaterItem
import kotlinx.android.synthetic.main.weather_item.view.*

class WheatherItemAdapter :
    RecyclerView.Adapter<WheatherItemAdapter.ViewHolder>() {

    private var list = emptyList<WheaterJson>()

    private var l = ArrayList<WheaterJson>()

    private val latValues = arrayListOf("49.65597974904006","49.17977")
    private val lonValues = arrayListOf("20.276747739454148","20.08803")
    private val placesMountain = arrayListOf("Mogielica","Rysy")
    private val regionMountain = arrayListOf("Beskid Sądecki","Najwyższy szczyt tatr")

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WheatherItemAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false))
    }

    override fun onBindViewHolder(holder: WheatherItemAdapter.ViewHolder, position: Int) {
//        holder.itemView.textViewLocation.text = data[position].name
//        holder.itemView.textViewLocation2.text = data[position].subname
        holder.itemView.textViewTemperature.text = l[position].main.temp.toString()
        holder.itemView.textViewLocation.text = placesMountain[position]
        holder.itemView.textViewLocation2.text = regionMountain[position]
    }

    override fun getItemCount(): Int {
        return l.size
    }

    fun setData(newList: WheaterJson){
        list = listOf(newList)
        l.add(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

    }


}