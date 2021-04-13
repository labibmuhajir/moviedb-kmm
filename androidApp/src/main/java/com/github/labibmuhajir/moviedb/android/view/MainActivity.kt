package com.github.labibmuhajir.moviedb.android.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.labibmuhajir.moviedb.android.databinding.ActivityMainBinding
import com.github.labibmuhajir.moviedb.android.extension.viewBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.java.KoinJavaComponent.inject


class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainViewModel>()
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val a  by inject<String>()

    private val bannerAdapter by lazy { PosterAdapter() }
    private val segmentedAdapter by lazy { SegmentedAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.vpBanner.adapter = bannerAdapter
        binding.rvMovie.adapter = segmentedAdapter
        viewModel.bannerLiveData.observe(this) { bannerAdapter.movies = it }
        viewModel.segmentedLiveData.observe(this) { segmentedAdapter.data = it }
        viewModel.initData()
    }
}
