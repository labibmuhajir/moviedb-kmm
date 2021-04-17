package com.github.labibmuhajir.moviedb.service

import com.github.labibmuhajir.moviedb.service.model.MovieListResponse
import com.github.labibmuhajir.moviedb.service.model.MovieSearchResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HttpService : Service, KoinComponent {
    private val client: HttpClient by inject()
    companion object {
        val baseUrl = "api.themoviedb.org"
        val apiKey = "b26733daf3a5f7fd722800d1110e79b8"
        val imageUrl = "https://image.tmdb.org/t/p"
    }

    override suspend fun getDiscoverMovie(page: Int): MovieSearchResponse {
        val endpoint = "/3/discover/movie"

        val response = client.get<MovieSearchResponse>(buildRequest(endpoint) {
            parametersOf("page", "$page")
        })

        client.close()

        return response
    }

    override suspend fun getPopularMovie(page: Int): MovieListResponse {
        val endpoint = "/3/movie/popular"

        val response = client.get<MovieListResponse>(buildRequest(endpoint) {
            parametersOf("page", "$page")
        })

        client.close()

        return response
    }

    override suspend fun getUpcomingMovie(page: Int): MovieListResponse {
        val endpoint = "/3/movie/upcoming"

        val response = client.get<MovieListResponse>(buildRequest(endpoint) {
            parametersOf("page", "$page")
        })

        client.close()

        return response
    }

    private fun buildRequest(endpoint: String, block: URLBuilder.() -> Unit = {}): HttpRequestBuilder {
        return HttpRequestBuilder(scheme = URLProtocol.HTTPS.name, path = endpoint, block = block)
    }
}