package com.example.gory.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.gory.R
import kotlinx.android.synthetic.main.stamp_item.view.*

class StampRecyclerViewAdapter: RecyclerView.Adapter<StampRecyclerViewAdapter.ViewHolder>() {

    private val placesMountain = arrayListOf("Łysica",
        "Ślęża",
        "Skopiec",
        "Kłodzka Góra",
        "Chełmiec",
        "Biskupia Kopia",
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
    private val imageUrlStamp = arrayListOf<String>("https://www.podrozujznami.pl/wp-content/uploads/2021/10/Lysica_18.jpg",
    "https://lh3.googleusercontent.com/proxy/aWib1tkiwBx29SRPnHtjllM1TlgWmF3_xnUCorSwI1gcC1_GNbXvLN_UplkQX_TGhTta7p3mJ8nlEOZr_d7mzh9B7M75f-6-LqC0kbwR_9jN-sXtyI8dbmFwbSQABNFVHu4D3ihJEnDExbyk1aTGWPq_MTcdYBjVGxF4bgWf0_TfAq8",
    "https://i2.wp.com/www.chorobanizinna.pl/wp-content/uploads/2017/11/Skopiec-e1511734662198.jpg",
    "https://www.places2visit.pl/wp-content/uploads/2020/04/klodzkagora11-1024x683.jpg")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.stamp_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.textViewMountainName.text = placesMountain[position]

        holder.itemView.setOnClickListener(object: View.OnClickListener{

            override fun onClick(v: View) {
                showAlertDialogWithGlideImage(v,imageUrlStamp[position])
            }
        })
    }

    fun showAlertDialogWithGlideImage(v: View, url: String){
        val alertDialogBuilder = AlertDialog.Builder(v!!.context)
        val factory = LayoutInflater.from(v!!.context)
        val view: View = factory.inflate(R.layout.alert_dialog_image, null)
        alertDialogBuilder.setView(view)

        Glide.with(v!!.context)
            .load(url
            )
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.image1)
            .into(view.findViewById<ImageView>(R.id.imageViewAlertDialog))

        alertDialogBuilder.show()
    }

    override fun getItemCount(): Int {
        return placesMountain.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}