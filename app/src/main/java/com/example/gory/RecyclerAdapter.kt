package com.example.gory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Galeria", "Mapa", "Zdobyte szczyty", "Pogoda", "Kalendarz", "Co to KGP?", "Funkcja 7", "Funkcja 8")
    private var subtitles = arrayOf("Zobacz zdjęcia i \nnajważniejsze szczegóły \nwszystkich szczytów", "Sprawdź okolicę i \nszczegóły dojazdu"
        , "Nie pozwól sobie zapomnieć \nco już za Tobą, zapisz to!", "Sprawdź czy warto \nwziąć pelerynę", "Sprawdź kiedy masz \nczas zdobyć je wszystkie!", "Geneza Korony Gór Polski", "Opis", "Opis")

    private var urls = arrayOf("https://image.freepik.com/free-vector/polaroid-camera-pictures_23-2148076974.jpg",
        "https://image.freepik.com/free-vector/wanderlust-explore-landscape_24908-55342.jpg",
        "https://image.freepik.com/free-vector/wanderlust-explore-landscape_24908-55338.jpg",
        "https://image.freepik.com/free-vector/weather-concept-illustration_114360-1189.jpg",

        "https://image.freepik.com/free-vector/wanderlust-explore-landscape_24908-55342.jpg",
        "https://image.freepik.com/free-vector/wanderlust-explore-landscape_24908-55342.jpg",
        "https://image.freepik.com/free-vector/wanderlust-explore-landscape_24908-55342.jpg",
        "https://image.freepik.com/free-vector/wanderlust-explore-landscape_24908-55342.jpg",
        "https://image.freepik.com/free-vector/wanderlust-explore-landscape_24908-55342.jpg",);

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemSubtitle.text = subtitles[position]

        Glide.with(holder.itemView)
            .load(urls[position])
            .centerCrop()
            .placeholder(R.drawable.image1)
            .into(holder.itemImage)

        if(position == 1 || position == 0 || position == 2 || position == 3){
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