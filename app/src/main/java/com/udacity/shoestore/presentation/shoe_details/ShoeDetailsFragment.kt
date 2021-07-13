package com.udacity.shoestore.presentation.shoe_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.domain.model.Shoe
import com.udacity.shoestore.presentation.shoe_listing.ShoeViewModel
import timber.log.Timber

class ShoeDetailsFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().title = getString(R.string.add_shoe_detail)
        val binding = FragmentShoeDetailsBinding.inflate(
            inflater,
            container,
            false
        )
        binding.apply {
            btnSave.setOnClickListener {
                runCatching {
                    val shoe = Shoe(
                        edtShoeName.text.toString(),
                        edtShoeSize.text.toString().toDouble(),
                        edtCompanyName.text.toString(),
                        edtDescription.text.toString()
                    )
                    viewModel.addShoe(shoe)
                    root.findNavController()
                        .navigate(
                            ShoeDetailsFragmentDirections
                                .actionShoeDetailsToShoeListings()
                        )
                }.onFailure {
                    Snackbar.make(binding.root,"Please enter shoe details correctly",Snackbar.LENGTH_LONG).show()
                    Timber.e("Add Shoe Failure: $it")
                }
            }

            btnCancel.setOnClickListener {
                root.findNavController()
                    .navigate(
                        ShoeDetailsFragmentDirections
                            .actionShoeDetailsToShoeListings()
                    )
            }
        }
        return binding.root
    }
}