package com.github.labibmuhajir.moviedb.service

import com.github.labibmuhajir.moviedb.service.model.MovieListResponse
import com.github.labibmuhajir.moviedb.service.model.MovieSearchResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HttpService : Service, KoinComponent {
    private val client: HttpClient by inject()
    companion object {
        val baseUrl = "https://api.themoviedb.org"
        val apiKey = "b26733daf3a5f7fd722800d1110e79b8"
        val imageUrl = "https://image.tmdb.org/t/p"
    }

    override suspend fun getDiscoverMovie(page: Int): MovieSearchResponse {
        val endpoint = "/3/discover/movie"
        val url = baseUrl + endpoint

        val response = client.get<MovieSearchResponse>(url) {
            parameter("page", page)
        }

        client.close()

        return response
    }

    override suspend fun getPopularMovie(page: Int): MovieListResponse {
        val endpoint = "/3/movie/popular"
        val url = baseUrl + endpoint

        val response = client.get<MovieListResponse>(url) {
            parameter("page", page)
        }

        client.close()

        return response
    }

    override suspend fun getUpcomingMovie(page: Int): MovieListResponse {
        val endpoint = "/3/movie/upcoming"
        val url = baseUrl + endpoint

        val response = client.get<MovieListResponse>(url) {
            parameter("page", page)
        }

        client.close()

        return response
    }
}