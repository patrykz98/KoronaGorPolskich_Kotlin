package com.example.gory.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gory.R
import com.example.gory.databinding.MainDashboardBinding

class MainDashboardFragment: Fragment(R.layout.main_dashboard) {
    private var _binding: MainDashboardBinding? = null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainDashboardBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goForwardButton.setOnClickListener{
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