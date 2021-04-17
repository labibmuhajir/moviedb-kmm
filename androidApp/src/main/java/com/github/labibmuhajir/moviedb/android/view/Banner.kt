package com.github.labibmuhajir.moviedb.android.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.labibmuhajir.moviedb.android.extension.ImageSize
import com.github.labibmuhajir.moviedb.android.extension.fixUrl
import com.github.labibmuhajir.moviedb.service.model.Movie
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun Banner(data: List<Movie>) {
    HorizontalPager(
        state = PagerState(pageCount = data.size),
        modifier = Modifier
            .fillMaxWidth()
            .height(232.dp),
    ) { page ->
        if (data.isNotEmpty()) {
            CoilImage(
                data = data[page].backdropPath?.fixUrl(ImageSize.w500) ?: "",
                contentDescription = "Backdrop movie",
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                },
            )
        }
    }
}