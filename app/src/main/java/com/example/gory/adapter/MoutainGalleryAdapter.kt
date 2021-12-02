package com.example.gory.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gory.data.Moutains
import com.example.gory.R
import com.example.gory.data.WheaterItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.galerry_card_item.view.*

class MoutainGalleryAdapter(val context: Context?, private val mountains: ArrayList<Moutains>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.galerry_card_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        Picasso.get().load(mountains[position].url).into(holder.itemView.moutainImage)

        holder.itemView.moutainName.text = mountains[position].name
        holder.itemView.moutainHeight.text = mountains[position].height
        holder.itemView.moutainTime.text = mountains[position].time
        holder.itemView.moutainDescription.text = mountains[position].description

    }

    override fun getItemCount(): Int {
        return mountains.size
    }

    class ViewHolder(v: View?):RecyclerView.ViewHolder(v!!), View.OnClickListener{

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }


    }

}