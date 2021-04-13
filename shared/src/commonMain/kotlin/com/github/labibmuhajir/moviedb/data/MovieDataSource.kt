package com.github.labibmuhajir.moviedb.data

import com.github.labibmuhajir.moviedb.service.Service
import com.github.labibmuhajir.moviedb.service.model.MovieListResponse
import com.github.labibmuhajir.moviedb.service.model.MovieSearchResponse
import kotlinx.coroutines.MainScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface MovieDataSource {
    suspend fun getPopularMovie(page: Int = 1): MovieListResponse
    suspend fun getUpcomingMovie(page: Int = 1): MovieListResponse
    suspend fun discoverMovie(page: Int = 1): MovieSearchResponse
}

class MovieRepository : MovieDataSource, KoinComponent {
    private val service: Service by inject()

    override suspend fun getPopularMovie(page: Int): MovieListResponse {
        return service.getPopularMovie(page)
    }

    override suspend fun getUpcomingMovie(page: Int): MovieListResponse {
        return service.getUpcomingMovie(page)
    }

    override suspend fun discoverMovie(page: Int): MovieSearchResponse {
        return service.getDiscoverMovie(page)
    }
}