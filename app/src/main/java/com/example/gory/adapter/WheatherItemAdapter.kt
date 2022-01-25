package com.example.gory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gory.R
import com.example.gory.api.WheaterJson
import kotlinx.android.synthetic.main.weather_item.view.*
import java.lang.Math.round

class WheatherItemAdapter :
    RecyclerView.Adapter<WheatherItemAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(humidity: Int, wind: Double, sunset: Int, sunrise: Int)
    }

    private var l = ArrayList<WheaterJson>()
    private val placesMountain = arrayListOf("Łysica",
                                            "Ślęża",
                                            "Skopiec",
                                            "Kłodzka Góra",
                                            "Chełmiec",
                                            "Biskupia Kopa",
                                            "Lubomir",
                                            "Szczeliniec Wielki",
                                            "Czupel",
                                            "Waligóra",
                                            "Skalnik",
                                            "Jagodna",
                                            "Kowadło",
                                            "Lackowa",
                                            "Wielka Sowa",
                                            "Wysoka",
                                            "Orlica",
                                            "Rudawiec",
                                            "Wysoka Kopa",
                                            "Mogielica",
                                            "Skrzyczne",
                                            "Radziejowa",
                                            "Turbacz",
                                            "Tarnica",
                                            "Śnieżnik",
                                            "Śnieżka",
                                            "Babia Góra",
                                            "Rysy")
    private val regionMountain = arrayListOf("Najwyższy szczyt Gór Świętokrzyskich",
                                            "Najwyższy szczyt Masywu Ślęży",
                                            "Najwyższy szczyt Gór Kaczawskich",
                                            "Najwyższy szczyt Gór Bardzkich",
                                            "Najwyższy szczyt Gór Wałbrzyskich",
                                            "Najwyższy szczyt Gór Opawskich",
                                            "Najwyższy szczyt Beskidu Makowskiego",
                                            "Najwyższy szczyt Gór Stołowych",
                                            "Najwyższy szczyt Beskidu Małego",
                                            "Najwyższy szczyt Gór Kamiennych",
                                            "Najwyższy szczyt Rudaw Janowickich",
                                            "Najwyższy szczyt Gór Bystrzyckich",
                                            "Najwyższy szczyt Gór Złotych",
                                            "Najwyższy szczyt Beskidu Niskiego",
                                            "Najwyższy szczyt Gór Sowich",
                                            "Najwyższy szczyt Pienin",
                                            "Najwyższy szczyt Gór Orlickich",
                                            "Najwyższy szczyt Gór Bialskich",
                                            "Najwyższy szczyt Gór Izerskich",
                                            "Najwyższy szczyt Beskidu Wyspowego",
                                            "Najwyższy szczyt Beskidu Śląskiego",
                                            "Najwyższy szczyt Beskidu Sądeckiego",
                                            "Najwyższy szczyt Gorców",
                                            "Najwyższy szczyt Bieszczad Zachodnich",
                                            "Najwyższy szczyt Masywu Śnieżnika",
                                            "Najwyższy szczyt Karkonoszy",
                                            "Najwyższy szczyt Beskidy Żywieckiego",
                                            "Najwyższy szczyt Tatr")
    private lateinit var listener: OnItemClickListener
    var humidity: Int = 0
    var wind: Double = 0.0
    var sunrise: Int = 0
    var sunset: Int = 0


    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WheatherItemAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false),
            listener, humidity, wind, sunrise, sunset)
    }

    override fun onBindViewHolder(holder: WheatherItemAdapter.ViewHolder, position: Int) {
        var tempCelsius = (l[position].main.temp-272.15).round(1)

        holder.itemView.textViewTemperature.text = tempCelsius.toString()
        holder.itemView.textViewLocation.text = placesMountain[position]
        holder.itemView.textViewLocation2.text = regionMountain[position]

        System.out.println(l)

        this.humidity = l[position].main.humidity
        this.wind = l[position].wind.speed
        this.sunrise = l[position].sys.sunrise
        this.sunset = l[position].sys.sunset
    }

    override fun getItemCount(): Int {
        return l.size
    }

    fun setData(newList: WheaterJson){
        l.add(newList)
        notifyDataSetChanged()
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }

    class ViewHolder(view: View, listener: OnItemClickListener, humidity: Int, wind: Double, sunrise: Int, sunset: Int) :
        RecyclerView.ViewHolder(view){

        init{
            view.setOnClickListener {
                listener.onItemClick(humidity, wind, sunset, sunrise)
            }
        }

    }
}