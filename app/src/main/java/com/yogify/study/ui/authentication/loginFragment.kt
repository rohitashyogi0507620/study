package com.yogify.study.ui.authentication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.yogify.study.MainActivity
import com.yogify.study.R
import com.yogify.study.databinding.FragmentLoginBinding


class loginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    val loginViewModel by lazy { ViewModelProvider(this).get(LoginViewModel::class.java) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.signUpText.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signup)
        }

        binding.loginButton.setOnClickListener {
               startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}