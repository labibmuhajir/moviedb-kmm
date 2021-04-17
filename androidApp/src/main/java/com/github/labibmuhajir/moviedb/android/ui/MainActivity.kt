package com.github.labibmuhajir.moviedb.android.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.labibmuhajir.moviedb.android.view.Banner
import com.github.labibmuhajir.moviedb.android.view.SegmentedMovie
import com.github.labibmuhajir.moviedb.service.model.Movie
import com.google.accompanist.pager.ExperimentalPagerApi
import org.koin.androidx.compose.getViewModel


class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(content = {
            MaterialTheme { MainView() }
        })
    }
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun MainView() {
    val viewModel = getViewModel<MainViewModel>()
    val banner: List<Movie> by viewModel.bannerLiveData.observeAsState(listOf())
    val segmented: List<Pair<String, List<Movie>>> by viewModel.segmentedLiveData.observeAsState(
        listOf()
    )

    Scaffold {
        LazyColumn {
            item {
                Banner(banner)
                Spacer(modifier = Modifier.size(12.dp))
                SegmentedMovie(segmented)
            }
        }
    }
}