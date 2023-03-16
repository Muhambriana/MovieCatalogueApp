package com.muhamapps.moviecatalogueapp3.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.vo.Resource

interface CatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>

    fun getMovies(id: String): LiveData<MovieEntity>

    fun getTvShows(id: String): LiveData<TvShowEntity>

    fun getMoviesFavorite(): LiveData<PagedList<MovieEntity>>

    fun getTvShowsFavorite(): LiveData<PagedList<TvShowEntity>>

    fun setMoviesFavorite(movieEntity: MovieEntity, state: Boolean)

    fun setTvShowsFavorite(tvShowEntity: TvShowEntity, state: Boolean)

}