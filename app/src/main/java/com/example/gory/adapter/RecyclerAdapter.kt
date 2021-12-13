package com.example.gory.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.gory.CardViewItemAgent
import com.example.gory.R

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Galeria", "Mapa", "Zdobyte szczyty", "Pogoda", "Kalendarz", "Co to KGP?")
    private var subtitles = arrayOf("Zobacz zdjęcia i \nnajważniejsze szczegóły \nwszystkich szczytów", "Sprawdź okolicę i \nszczegóły dojazdu"
        , "Nie pozwól sobie zapomnieć \nco już za Tobą, zapisz to!", "Sprawdź czy warto \nwziąć pelerynę", "Sprawdź kiedy masz \nczas zdobyć je wszystkie!", "Geneza Korony Gór Polski")

    private var urls = arrayOf("https://image.freepik.com/free-vector/stamp-collecting-concept-illustration_114360-6583.jpg",
        "https://image.freepik.com/free-vector/paper-map-concept-illustration_114360-2203.jpg",
        "https://image.freepik.com/free-vector/checklist-concept-illustration_114360-479.jpg",
        "https://image.freepik.com/free-vector/weather-concept-illustration_114360-1189.jpg",
        "https://image.freepik.com/free-vector/build-your-program-appointment-booking_23-2148552954.jpg",
        "https://image.freepik.com/free-vector/nature-mountain-icons_1284-4518.jpg",
        "https://image.freepik.com/free-vector/wanderlust-explore-landscape_24908-55342.jpg")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemSubtitle.text = subtitles[position]

        Glide.with(holder.itemView)
            .load(urls[position])
            .centerCrop()
            .placeholder(R.drawable.image1)
            .into(holder.itemImage)

        if(position == 1 || position == 0 || position == 2 || position == 3|| position == 4){
            holder.itemView.setOnClickListener{
                val context = holder.itemView.context
                val intent = Intent(context, CardViewItemAgent::class.java)
                intent.putExtra("position", position)
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemTitle: TextView
        var itemSubtitle: TextView
        var itemImage: ImageView

        init {
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemSubtitle = itemView.findViewById(R.id.itemSubtitle)
            itemImage = itemView.findViewById(R.id.itemImage)

            itemView.setOnClickListener{
                val position: Int = adapterPosition
                var title: String = ""
                when (position){
                    0 -> title = "Galeria"
                    1 -> title = "Mapy"
                    2 -> title = "Zdobyte szczyty"
                    3 -> title = "Pogoda"
                    4 -> title = "Kalendarz"
                    5 -> title = "Co to KGP?"
                }

                Toast.makeText(itemView.context, title, Toast.LENGTH_SHORT).show()
            }
        }
    }

}