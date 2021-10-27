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
            "Rysy",
            "2444 m. n.p.m.",
            "4h 45m",
            "Najwyższy szczyt tatr",
            "https://images.unsplash.com/photo-1579037116454-e83d1ceffb72?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1542&q=80"
        )
        )

        mountains.add(
            Moutains(
                "Mogielica",
                "1646 m. n.p.m.",
                "2h 45m",
                "Najwyższy szczyt beskidu sądeckiego",
                "https://images.unsplash.com/photo-1609676759174-e5bd358627d2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1473&q=80"
            )
        )

//        mountains.add(
//            Moutains(
//                "Wysoka",
//                "1546 m. n.p.m.",
//                "2h 30m",
//                "Najwyższy szczyt Pienin",
//                "http://www.kempingowewycieczki.pl/wp-content/uploads/bfi_thumb/Wysokie-Ska%C5%82ki-Pieniny-ma919crromaij1onpya7v4d2g7g2b7oqpy17tlshv4.jpg"
//            )
//        )

        binding.galleryItemRecyclerView.adapter = MoutainGalleryAdapter(context, mountains)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}