package com.github.labibmuhajir.moviedb.manager

expect class NetworkChecker {
    fun isNetworkAvailable(): Boolean
}