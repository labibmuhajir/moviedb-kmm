package com.github.labibmuhajir.moviedb.service.model

import com.github.labibmuhajir.moviedb.service.model.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieSearchResponse(
    val page: Int?,
    val results: List<Movie>?,
    @SerialName("total_pages")
    val totalPages: Int?,
    @SerialName("total_results")
    val totalResults: Int?
)