package com.github.labibmuhajir.moviedb.service.model

import com.github.labibmuhajir.moviedb.service.model.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    @SerialName("average_rating")
    val averageRating: Double? = null,
    @SerialName("backdrop_path")
    val backdropPath: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val iso_3166_1: String? = null,
    val iso_639_1: String? = null,
    val name: String? = null,
    val page: Int? = null,
    @SerialName("poster_path")
    val posterPath: String? = null,
    val results: List<Movie>? = null,
    val revenue: Long? = null,
    val runtime: Int? = null,
    @SerialName("sort_by")
    val sortBy: String? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null
)