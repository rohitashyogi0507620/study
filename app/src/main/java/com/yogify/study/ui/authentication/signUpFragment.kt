package com.yogify.study.ui.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yogify.study.R
import com.yogify.study.databinding.FragmentSignUpBinding


class signUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val signupViewModel = ViewModelProvider(this).get(SignupViewModel::class.java)

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val root: View = binding.root

            binding.loginLink.setOnClickListener {
               // findNavController().navigate(R.id.action_signup_to_login)
                requireActivity().onBackPressed()
            }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}