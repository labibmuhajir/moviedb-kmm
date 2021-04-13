package com.github.labibmuhajir.moviedb.android.di

import com.github.labibmuhajir.moviedb.android.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { MainViewModel(get()) }
}