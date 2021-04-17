package com.github.labibmuhajir.moviedb.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.labibmuhajir.moviedb.domain.MovieUseCase
import com.github.labibmuhajir.moviedb.service.model.Movie
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class MainViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    private val _segmentedLiveData = MutableLiveData<List<Pair<String, List<Movie>>>>()
    val segmentedLiveData: LiveData<List<Pair<String, List<Movie>>>> get() = _segmentedLiveData
    private val _bannerLiveData = MutableLiveData<List<Movie>>()
    val bannerLiveData: LiveData<List<Movie>> get() = _bannerLiveData

    init {
        viewModelScope.launch {
            async { getBanner() }
            async { getSegmented() }
        }
    }

    fun getBanner() {
        viewModelScope.launch {
            try {
                val result = movieUseCase.discoverMovie()
                _bannerLiveData.postValue(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getSegmented() {
        viewModelScope.launch {
            try {
                supervisorScope {
                    val result = mutableListOf<Pair<String, List<Movie>>>()
                    val popular = async { movieUseCase.getPopularMovie() }
                    val upcoming = async { movieUseCase.getUpcomingMovie() }

                    popular.await().let {
                        result.add("Popular Movies" to it)
                    }
                    upcoming.await().let {
                        result.add("Upcoming Movies" to it)
                    }

                    _segmentedLiveData.postValue(result)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}