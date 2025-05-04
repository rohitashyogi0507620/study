package com.yogify.study.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.yogify.study.databinding.FragmentHomeBinding
import com.yogify.study.ui.home.adapter.BannerSliderAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    //Done on Github
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        viewModel.bannerHomeScreen.observe(viewLifecycleOwner) {
            val adapter = BannerSliderAdapter(requireContext(), it)
            binding.sliderBanner.setSliderAdapter(adapter)
            binding.sliderBanner.setIndicatorAnimation(IndicatorAnimationType.WORM)
            adapter.setOnItemClickListener { response ->
            }

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}