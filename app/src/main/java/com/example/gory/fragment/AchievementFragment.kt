package com.example.gory.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.gory.R
import com.example.gory.adapter.AchievementAdapter
import com.example.gory.data.AchievementDatabase
import com.example.gory.databinding.FragmentAchievementBinding
import kotlinx.coroutines.launch

class AchievementFragment : BaseFragment() {

    private var _binding: FragmentAchievementBinding? = null
    private val binding get () = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAchievementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.achievementRecyclerView.setHasFixedSize(true)
        binding.achievementRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                var achievements = AchievementDatabase.getDatabse(it).achievementDao().getAllAchievement()
                binding.achievementRecyclerView.adapter = AchievementAdapter(achievements)
            }
        }

        binding.arrowBack.setOnClickListener{
            val fragment = MenuFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.addToBackStack(fragment.javaClass.simpleName)
                ?.commit()
        }

        binding.buttonAddNewAchievement.setOnClickListener{
            val fragment = CreateAchievementFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.addToBackStack(fragment.javaClass.simpleName)
                ?.commit()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}