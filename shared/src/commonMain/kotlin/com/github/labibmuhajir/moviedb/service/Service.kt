package com.github.labibmuhajir.moviedb.service

import com.github.labibmuhajir.moviedb.service.model.MovieListResponse
import com.github.labibmuhajir.moviedb.service.model.MovieSearchResponse

interface Service {
    suspend fun getDiscoverMovie(page: Int): MovieSearchResponse

    suspend fun getPopularMovie(page: Int): MovieListResponse

    suspend fun getUpcomingMovie(page: Int): MovieListResponse
}