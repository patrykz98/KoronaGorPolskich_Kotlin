package com.example.gory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.gory.databinding.FragmentGalleryBinding
import com.example.gory.databinding.FragmentMenuBinding

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val layoutManager = CardItemZoomAnimation(inflater.context)

        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        binding.galleryItemRecyclerView.layoutManager = layoutManager

        //to auto center views
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.galleryItemRecyclerView)
        binding.galleryItemRecyclerView.isNestedScrollingEnabled = false

        //add items to array
        val mountains = ArrayList<Moutains>()

        mountains.add(
            Moutains(
                "Łysica",
                "614m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Świętokrzyskich",
                "https://bi.im-g.pl/im/9b/3d/17/z24369051IER,Lysica-jednak-jest-wyzsza-niz-przypuszczano.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Ślęża",
                "718m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Masywu Ślęży",
                "https://1.bp.blogspot.com/-uiSp8Wy18uI/XuaZVD6WDLI/AAAAAAAArws/NldNAXI4FbgCiE1SvoK1XZGrPMdLKJSewCK4BGAsYHg/s2400/DSC_6890_edited.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Skopiec",
                "724m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Kaczawskich",
                "https://filiaprimogenita.files.wordpress.com/2019/07/12666361.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Kłodzka Góra",
                "765m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Bardzkich",
                "https://www.ahojprzygodo.com/wp-content/uploads/2020/08/Klodzka-Gora-Wieza-widokowa-korona-gor-polski-Gory-bardzkie-Klodzko-ahoj-przygodo-dolnoslaskie-szczyt-13.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Chełmiec",
                "850m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Wałbrzyskich",
                "https://upload.wikimedia.org/wikipedia/commons/d/d7/Che%C5%82miec_%28szczyt%29-widok.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Biskupia Kopa",
                "889m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Opawskich",
                "https://i.ytimg.com/vi/-iAU1F0w4P0/maxresdefault.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Lubomir",
                "904m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Beskidu Makowskiego",
                "https://www.terazwgorach.pl/wp-content/uploads/2019/09/lubomir-dron2.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Szczeliniec Wielki",
                "919m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Stołowych",
                "https://i1.wp.com/www.naszeszlaki.pl/wp-content/uploads/2021/06/kamienna-malpa-w-szczelincu-wielkim.jpg?fit=900%2C506&ssl=1"
            )
        )

        mountains.add(
            Moutains(
                "Czupel",
                "933m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Beskidu Małego",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/POLAND_BeskidMaly_Czupel_933m.jpg/1200px-POLAND_BeskidMaly_Czupel_933m.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Waligóra",
                "936m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Kamiennych",
                "https://mynaszlaku.pl/wp-content/gallery/waligora-09-04-2019/Sudety04190085-kopia.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Skalnik",
                "945m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Rudaw Janowickich",
                "https://www.ahojprzygodo.com/wp-content/uploads/2020/03/210314151111-ahoj-przygodo-skalnik-szczyt-trasa-dla-dzieci-rudawy-janowickie-wycieczka.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Jagodna",
                "977m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Bystrzyckich",
                "https://hasajacezajace.com/wp-content/uploads/2020/10/DSC05389.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Kowadło",
                "989m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Złotych",
                "https://mynaszlaku.pl/wp-content/gallery/trojak-05-04-2019/Trojak04190034-kopia.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Lackowa",
                "997m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Beskidu Niskiego",
                "https://upload.wikimedia.org/wikipedia/commons/5/5b/Izby%2C_cerkiew_%C5%9Bw._%C5%81ukasza_%28HB4%29.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Wielka Sowa",
                "1015m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Gór Sowich",
                "https://agropajda.pl/wp-content/uploads/2020/06/Wielka_Sowa_1015_m_n_p_m_435013.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Wysoka",
                "1050m. n.p.m.",
                "2h 30m",
                "Najwyższy szczyt Pienin",
                "https://www.globtroter.pl/zdjecia/polska/b232075_polska_pieniny_w_drodze_na_wysoka.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Orlica",
                "1084m n.p.m.",
                "2h 45m",
                "Najwyższy szczyt Gór Orlickich",
                "https://upload.wikimedia.org/wikipedia/commons/0/02/POL_Schronisko_PTTK_Orlica_w_Pieninach_2.JPG"
            )
        )

        mountains.add(
            Moutains(
                "Rudawiec",
                "1106m n.p.m.",
                "2h 45m",
                "Najwyższy szczyt Gór Bialskich",
                "https://upload.wikimedia.org/wikipedia/commons/0/0a/Gory_Bialskie.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Wysoka Kopa",
                "1126m n.p.m.",
                "2h 45m",
                "Najwyższy szczyt Gór Izerskich",
                "https://hasajacezajace.com/wp-content/uploads/2019/10/DSC_1834.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Mogielica",
                "1171m n.p.m.",
                "2h 45m",
                "Najwyższy szczyt beskidu sądeckiego",
                "https://images.unsplash.com/photo-1609676759174-e5bd358627d2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1473&q=80"
            )
        )

        mountains.add(
            Moutains(
                "Skrzyczne",
                "1257m. n.p.m.",
                "4h 45m",
                "Najwyższy szczyt Beskidu Śląskiego",
                "https://slaskie.travel/Media/Default/.MainStorage/Poi/fhv2dfua.v2p/Widok%20Na%20Skrzyczne,%20Sanktuarium1%20fot.%20www.slaskie.travel%20J.Krawczyk.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Radziejowa",
                "1266m. n.p.m.",
                "4h 45m",
                "Najwyższy szczyt Beskidu Sądeckiego",
                "https://u.profitroom.pl/2020-hotelczarnypotok-pl/thumb/0x1000/uploads/IMG_6124.JPG"
            )
        )

        mountains.add(
            Moutains(
                "Turbacz",
                "1310m. n.p.m.",
                "4h 45m",
                "Najwyższy szczyt Gorców",
                "https://1.bp.blogspot.com/-wG10_PVtLp0/XqoOIp9vzJI/AAAAAAAANME/xB1_ZaICbVYtFYVWcgIbiDlhG651MikhQCEwYBhgL/s1600/IMG_2626.JPG"
            )
        )

        mountains.add(
            Moutains(
                "Tarnica",
                "1346m. n.p.m.",
                "4h 45m",
                "Najwyższy szczyt Bieszczad Zachodnich",
                "https://www.worldisbeautiful.eu/up_files/978_11-Tarnica-1346m.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Śnieżnik",
                "1423m. n.p.m.",
                "4h 45m",
                "Najwyższy szczyt Masywu Śnieżnika",
                "https://filiaprimogenita.files.wordpress.com/2019/06/110329241.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Śnieżka",
                "1603m. n.p.m.",
                "4h 45m",
                "Najwyższy szczyt Karkonoszy",
                "https://meteor-turystyka.pl/images/places/0/138.jpg"
            )
        )

        mountains.add(
            Moutains(
                "Babia Góra",
                "1725m. n.p.m.",
                "4h 45m",
                "Najwyższy szczyt Beskidy Żywieckiego",
                "https://www.e-gory.com/46-4.jpg"
            )
        )

        mountains.add(
            Moutains(
            "Rysy",
            "2501m. n.p.m.",
            "4h 45m",
            "Najwyższy szczyt tatr",
            "https://www.zakopane.pl/assets/zakopane25/media/files/60d0a6d1-3c29-4ad5-b131-f8a23191c285/rysy.jpg"
        )
        )


        binding.galleryItemRecyclerView.adapter = MoutainGalleryAdapter(context, mountains)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowBack.setOnClickListener{
            val fragment = MenuFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.commit()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}