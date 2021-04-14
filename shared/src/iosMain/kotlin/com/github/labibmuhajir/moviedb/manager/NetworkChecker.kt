package com.github.labibmuhajir.moviedb.manager

import cocoapods.AFNetworking.*

actual class NetworkChecker {
    actual fun isNetworkAvailable(): Boolean {
        return  AFNetworkReachabilityManager().isReachable()
    }
}