package com.github.labibmuhajir.moviedb.manager

actual class NetworkChecker {
    actual fun isNetworkAvailable(): Boolean {
        return true
        /***
         * add following dependency on gradle
         * cocoapods {
         *  pod("FXReachability")
         * }
         * then in this actual class use FXReachability.sharedInstance().reachable
         * swift ui preview not working must run on ios or ipados devices
        ***/
    }
}