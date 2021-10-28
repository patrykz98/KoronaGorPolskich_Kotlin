package com.example.gory

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.widget.Toast

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("Galeria", "Mapa", "Zdobyte szczyty", "Pogoda", "Kalendarz", "Co to KGP?", "Funkcja 7", "Funkcja 8")
    private var subtitles = arrayOf("Zobacz zdjęcia i \nnajważniejsze szczegóły \nwszystkich szczytów", "Sprawdź okolicę i \nszczegóły dojazdu"
        , "Nie pozwól sobie zapomnieć \nco już za Tobą, zapisz to!", "Sprawdź czy warto \nwziąć pelerynę", "Sprawdź kiedy masz \nczas zdobyć je wszystkie!", "Geneza Korony Gór Polski", "Opis", "Opis")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemSubtitle.text = subtitles[position]

        if(position == 1 || position == 0){
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

        init {
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemSubtitle = itemView.findViewById(R.id.itemSubtitle)

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