package com.github.labibmuhajir.moviedb.android.extension

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import coil.load
import com.github.labibmuhajir.moviedb.service.HttpService

enum class ImageSize(val size: String) {
    w500("w500"),
    w200("w200")
}

fun ImageView.loadUrl(url: String, size: ImageSize = ImageSize.w200) {
    val imageUrl = "${HttpService.imageUrl}/${size.size}/$url"
    load(imageUrl)
}

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }