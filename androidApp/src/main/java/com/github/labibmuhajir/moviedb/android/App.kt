package com.github.labibmuhajir.moviedb.android

import android.app.Application
import com.github.labibmuhajir.moviedb.android.di.androidModule
import com.github.labibmuhajir.moviedb.di.initKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin { modules(androidModule) }
    }
}