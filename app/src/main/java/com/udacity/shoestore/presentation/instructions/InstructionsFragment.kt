package com.udacity.shoestore.presentation.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().title=getString(R.string.instructions)
        val binding = FragmentInstructionsBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener {
            val action = InstructionsFragmentDirections
                .actionInstructionsFragmentToShoeListingsFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }
}