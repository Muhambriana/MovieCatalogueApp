package com.muhamapps.moviecatalogueapp3.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.muhamapps.moviecatalogueapp3.data.source.remote.response.MovieResponse
import com.muhamapps.moviecatalogueapp3.data.source.remote.response.TvShowResponse
import com.muhamapps.moviecatalogueapp3.utils.EspressoIdlingResource
import com.muhamapps.moviecatalogueapp3.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies() : LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
        EspressoIdlingResource.decrement()
        return resultMovie
    }

    fun getAllTvShows() : LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShows())
        EspressoIdlingResource.decrement()
        return resultTvShow
    }

}