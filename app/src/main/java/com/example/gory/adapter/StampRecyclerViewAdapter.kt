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
    private val imageUrlStamp = arrayListOf<String>("https://www.podrozujznami.pl/wp-content/uploads/2021/10/Lysica_18.jpg",
    "https://wypadwswiat.pl/wp-content/uploads/2019/06/IMG_0982-1024x683.jpg",
    "https://www.z4polski.stron.net.pl/wp-content/uploads/2018/10/Skrzynka-na-Skopcu.jpg",
    "https://www.places2visit.pl/wp-content/uploads/2020/04/klodzkagora11-1024x683.jpg"
    ,"https://hasajacezajace.com/wp-content/uploads/2020/11/IMG_20200815_174918.jpg",
    "https://podroznikidwa.pl/wp-content/uploads/2021/08/e54f55aa-994f-403e-a4d1-d92260ac7d76.jpg",
    "https://4.bp.blogspot.com/-X8b9X2VgliY/WlDX_y9oB-I/AAAAAAAAFNo/ZqeIby0cba0C1P5lbZohXUCH0F1BK6mpgCLcBGAs/s1600/IMG_20171231_142054.jpg",
    "https://3.bp.blogspot.com/-EzIH6f5M63w/W14uC7P4tqI/AAAAAAAABtU/bvbrqA72e_EEy-S-enN2Tq5Fxf3JhlS5QCLcBGAs/s1600/2018-07-29%2B11.09.28%2B1.jpg",
    "https://4.bp.blogspot.com/-_P5YnB4CtlQ/WlDPpyYs96I/AAAAAAAAFLE/fEbvi8UUzeQWcsqxVkmps00_5W3E3f1BQCLcBGAs/s1600/DSC_8916.JPG",
    "https://podroznikidwa.pl/wp-content/uploads/2021/04/2-scaled-e1618737505897.jpg",
    "https://nadszczytami.pl/wp-content/uploads/2019/05/Skalnik_00045.jpg",
    "https://www.na-szlaku.net.pl/images/pieczatki.sudety/pttk.jagodna.jpg",
    "https://korona-gor-polski.pl/wp-content/gallery/szczyty-gory-zlote/pieczatka-na-kowadle-1.jpg",
    "https://hasajacezajace.com/wp-content/uploads/2019/03/Lackowa-14-1024x575.jpg",
    "https://www.lkedzierski.com/photos/2016/06/kgp-wielka-sowa-12.jpg",
    "https://1.bp.blogspot.com/-7ZY8cNow9E0/XycUPosjySI/AAAAAAAAEVg/0Ax-7tXRew4fSwjRg-QWGswhAMiFrZt6wCLcBGAsYHQ/s1600/2020-08-02%2B08.21.47%2B1.jpg",
    "https://www.na-szlaku.net.pl/images/pieczatki.sudety/pttk.orlica.jpg",
    "https://1.bp.blogspot.com/-VOpdhgMEySU/XVk1IQxRaWI/AAAAAAAADJk/BuyWsVM6f6kxtlZFls0eopM0uHsMVZTLACLcBGAs/s1600/2019-08-13%2B11.45.08%2B1.jpg",
    "https://blog.dariusz-kwiatkowski.eu/wp-content/uploads/2019/08/12_chatka_gorzystow_pieczatka.jpg",
    "https://1.bp.blogspot.com/-lZnbupGbwOA/XyfxMys0YAI/AAAAAAAAEYA/9MA_dnsXgNAZYMv9nLxj7FF3eOAytNBBwCLcBGAsYHQ/s1600/2020-08-02%2B10.17.44%2B1.jpg",
    "https://www.na-szlaku.net.pl/images/pieczatki.beskidy/pttk.skrzyczne.2.jpg",
    "https://3.bp.blogspot.com/-HGc0Bd_dtis/WpwqXlYPrBI/AAAAAAAAF1M/J2B4P2nPgm0IR5AaiK9RF9rPEoSXCzB4gCLcBGAs/s640/IMG_20180304_180433.jpg",
    "https://podroznikidwa.pl/wp-content/uploads/2021/09/img_0029-1.jpg",
        "https://odkrywczym-szlakiem.pl/wp-content/uploads/2021/04/Punkt-informacyjno-kasowy-Carynska-pieczatka.jpg",
    "https://www.na-szlaku.net.pl/images/pieczatki.sudety/snieznik.jpg",
    "https://polska-org.pl/foto/6297/Schronisko_Dom_Slaski_Karpacz_6297646.jpg",
    "https://klossowicz.mormol.pl/wp-content/uploads/2020/05/Piecz%C4%85tka-w-ksi%C4%85%C5%BCeczce-Zdobywcy-Korony-G%C3%B3r-Polski.jpg",
    "https://www.na-szlaku.net.pl/images/pieczatki.tatry/chata.pod.rysami.jpg")


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
            .load(url)
            .centerInside()
            .placeholder(R.drawable.image1)
            .into(view.findViewById<ImageView>(R.id.imageViewAlertDialog))

        alertDialogBuilder.show()
    }

    override fun getItemCount(): Int {
        return placesMountain.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}