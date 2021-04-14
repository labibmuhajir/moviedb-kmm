package com.github.labibmuhajir.moviedb.domain

import com.github.labibmuhajir.moviedb.data.MovieDataSource
import com.github.labibmuhajir.moviedb.service.model.Movie
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface MovieUseCase {
    suspend fun getPopularMovie(page: Int = 1): List<Movie>
    suspend fun getUpcomingMovie(page: Int = 1): List<Movie>
    suspend fun discoverMovie(page: Int = 1): List<Movie>
    fun flowPopularMovie(page: Int, either: Either<List<Movie>>)
    fun flowUpcomingMovie(page: Int, either: Either<List<Movie>>)
    fun flowDiscoverMovie(page: Int, either: Either<List<Movie>>)
}

typealias Either<T> = (T?, Throwable?) -> Unit

class MovieUseCaseImpl : MovieUseCase, KoinComponent {
    private val movieDataSource: MovieDataSource by inject()

    private val coroutineScope = MainScope()

    private var popularMovieJob: Job? = null
    private var upcomingMovieJob: Job? = null
    private var discoverMovieJob: Job? = null

    override suspend fun getPopularMovie(page: Int): List<Movie> {
        val total = 10
        return movieDataSource.getPopularMovie(page).results?.take(total) ?: listOf()
    }

    override suspend fun getUpcomingMovie(page: Int): List<Movie> {
        val total = 10
        return movieDataSource.getUpcomingMovie(page).results?.take(total) ?: listOf()
    }

    override suspend fun discoverMovie(page: Int): List<Movie> {
        val total = 3
        return movieDataSource.discoverMovie(page).results?.take(total) ?: listOf()
    }

    override fun flowPopularMovie(page: Int, either: Either<List<Movie>>) {
        popularMovieJob = coroutineScope.launch {
            flow { emit(getPopularMovie(page)) }.catch {
                either(null, it)
            }.collect{
                either(it, null)
            }
        }
    }

    override fun flowUpcomingMovie(page: Int, either: Either<List<Movie>>) {
        upcomingMovieJob = coroutineScope.launch {
            flow { emit(getUpcomingMovie(page)) }.catch {
                either(null, it)
            }.collect{
                either(it, null)
            }
        }
    }

    override fun flowDiscoverMovie(page: Int, either: Either<List<Movie>>) {
        discoverMovieJob = coroutineScope.launch {
            flow { emit(discoverMovie(page)) }.catch {
                either(null, it)
            }.collect { either(it, null) }
        }
    }
}