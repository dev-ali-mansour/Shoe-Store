package com.udacity.shoestore.presentation.login

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().title = getString(R.string.title)
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.apply {
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            btnLogin.setOnClickListener {
                NavHostFragment.findNavController(this@LoginFragment).navigate(action)
            }
            btnRegister.setOnClickListener {
                NavHostFragment.findNavController(this@LoginFragment).navigate(action)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}