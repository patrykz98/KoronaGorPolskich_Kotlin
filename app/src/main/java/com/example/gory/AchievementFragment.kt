package com.example.gory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.gory.adapter.AchievementAdapter
import com.example.gory.data.AchievementDatabase
import com.example.gory.databinding.FragmentAchievementBinding
import com.example.gory.databinding.FragmentMapsBinding
import kotlinx.android.synthetic.main.fragment_menu.*
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
//            if (transaction != null) {
//                transaction.setCustomAnimations(android.R.anim.cycle_interpolator,android.R.anim.decelerate_interpolator)
//            }
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