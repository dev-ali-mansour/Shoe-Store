package com.udacity.shoestore.presentation.shoe_listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.domain.model.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val size = MutableLiveData<Double>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoes: LiveData<MutableList<Shoe>> = _shoes

    fun addShoe() {
        _shoes.value?.add(Shoe(name.value!!,size.value!!,company.value!!,description.value!!))
        /*Timber.d(shoe.value?.name)
        shoe.value?.let {
            _shoes.value?.add(it)
            closeState.value = true
        }*/
    }
}