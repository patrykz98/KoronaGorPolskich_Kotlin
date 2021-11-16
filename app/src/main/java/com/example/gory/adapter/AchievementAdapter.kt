package com.example.gory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gory.R
import com.example.gory.data.Achievement
import kotlinx.android.synthetic.main.achievement_rv_item.view.*

class AchievementAdapter(val arrList: List<Achievement>) :
    RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        return AchievementViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.achievement_rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {

        holder.itemView.textViewPlace.text = arrList[position].place
        holder.itemView.textViewTime.text = arrList[position].time
        holder.itemView.textViewDate.text = arrList[position].date
    }

    override fun getItemCount(): Int {
        return arrList.size
    }


    class AchievementViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }
}