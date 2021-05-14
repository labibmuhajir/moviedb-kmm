package com.github.labibmuhajir.moviedb.manager

import platform.SystemConfiguration.SCNetworkReachabilityCreateWithAddress


actual class NetworkChecker {
    actual fun isNetworkAvailable(): Boolean {
        //todo


        return true
    }
}