package com.udacity.shoestore.presentation.shoe_listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.domain.model.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoes: LiveData<MutableList<Shoe>> = _shoes

    fun addShoe(item: Shoe?) {
        item?.let {
            _shoes.value?.add(it)
        }
    }
}