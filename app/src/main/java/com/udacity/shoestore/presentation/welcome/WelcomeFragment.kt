package com.udacity.shoestore.presentation.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.presentation.login.LoginFragmentDirections

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().title=getString(R.string.welcome)
        val binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }
}