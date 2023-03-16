package com.muhamapps.moviecatalogueapp3.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val mMovieCatalogueDao: MovieCatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = mMovieCatalogueDao.getMovies()

    fun getAllTvShows(): LiveData<List<TvShowEntity>> = mMovieCatalogueDao.getTvShows()

    fun getMovies(movieId: String): LiveData<MovieEntity> = mMovieCatalogueDao.getMovie(movieId)

    fun getTvShows(tvShowId: String): LiveData<TvShowEntity> = mMovieCatalogueDao.getTvShow(tvShowId)

    fun getMovieFavorites(): DataSource.Factory<Int, MovieEntity> = mMovieCatalogueDao.getMovieFavorite()

    fun getTvShowFavorites(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getTvShowFavorite()

    fun setMovieFavorites(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun setTvShowFavorites(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        mMovieCatalogueDao.updateTvShow(tvShow)
    }

    fun insertMovies(movies: List<MovieEntity>) = mMovieCatalogueDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieCatalogueDao.insertTvShow(tvShows)

}