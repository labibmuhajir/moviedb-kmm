package com.github.labibmuhajir.moviedb.android.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.labibmuhajir.moviedb.android.extension.ImageSize
import com.github.labibmuhajir.moviedb.android.extension.fixUrl
import com.github.labibmuhajir.moviedb.service.model.Movie
import com.google.accompanist.coil.CoilImage

@ExperimentalFoundationApi
@Composable
fun SegmentedMovie(data: List<Pair<String, List<Movie>>>) {
    data.forEach { segmentedData ->
        Text(
            text = segmentedData.first,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 12.dp)
        )

        RowMovie(segmentedData.second)

        Spacer(modifier = Modifier.size(8.dp))
    }
}

@Composable
fun RowMovie(data: List<Movie>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        item { Spacer(modifier = Modifier.size(8.dp)) }
        items(data) { movie ->
            CoilImage(
                data = movie.posterPath?.fixUrl(ImageSize.w500) ?: "",
                contentDescription = "Movie poster",
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                },
                modifier = Modifier.height(200.dp)
            )
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
    }
}