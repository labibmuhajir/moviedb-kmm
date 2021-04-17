package com.github.labibmuhajir.moviedb.android.extension

import com.github.labibmuhajir.moviedb.service.HttpService

enum class ImageSize(val size: String) {
    w500("w500"),
    w200("w200")
}

fun String.fixUrl(size: ImageSize = ImageSize.w200): String {
    return "${HttpService.imageUrl}/${size.size}/$this"
}