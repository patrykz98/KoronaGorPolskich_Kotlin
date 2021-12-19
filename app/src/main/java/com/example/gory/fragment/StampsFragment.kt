package com.example.gory.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.gory.R
import com.example.gory.adapter.StampRecyclerViewAdapter
import com.example.gory.databinding.FragmentStampsBinding

class StampsFragment : Fragment() {

    private var _binding: FragmentStampsBinding? = null
    private val binding get () = _binding!!

    private val rvAdapter by lazy {
       StampRecyclerViewAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setupRecyclerview() {
        binding.stampRecyclerView.adapter = rvAdapter
        binding.stampRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStampsBinding.inflate(inflater, container, false)

        setupRecyclerview()

        binding.frameLayoutStampBook.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val alertDialogBuilder = AlertDialog.Builder(v!!.context)
                val factory = LayoutInflater.from(v!!.context)
                val view: View = factory.inflate(R.layout.alert_dialog_image, null)
                alertDialogBuilder.setView(view)

                Glide.with(v!!.context)
                    .load("https://3.bp.blogspot.com/-v3TUogh_pqc/WvCDGdHPYoI/AAAAAAAABLM/9TlcoB7iHFccbCArYh7zfyUgOPcrBesxQCEwYBhgL/s1600/2018-05-07%2B06.36.45%2B1.jpg")
                    .centerInside()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.image1)
                    .into(view.findViewById<ImageView>(R.id.imageViewAlertDialog))

                alertDialogBuilder.show()
            }

        })

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

}