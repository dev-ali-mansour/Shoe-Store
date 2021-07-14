package com.udacity.shoestore.domain.model

import android.os.Parcelable
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import kotlinx.parcelize.Parcelize


@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable

@BindingAdapter("android:text")
fun setText(view: TextView, value: Double) {
    var setValue = view.text.isEmpty()
    try {
        if (!setValue) {
            setValue = view.text.toString().toDouble() != value
        }
    } catch (e: NumberFormatException) {
    }
    if (setValue) {
        view.text = value.toString()
    }
}

@InverseBindingAdapter(attribute = "android:text")
fun getText(view: TextView): Double {
    return try {
        view.text.toString().toDouble()
    } catch (e: NumberFormatException) {
        0.0
    }
}
