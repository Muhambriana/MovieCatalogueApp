package com.muhamapps.moviecatalogueapp3.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): LiveData<List<TvShowEntity>>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovie(movieId: String): LiveData<MovieEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvshowId")
    fun getTvShow(tvshowId: String): LiveData<TvShowEntity>

    @Query("SELECT * FROM movieentities where isFavorite = 1")
    fun getMovieFavorite(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentities where isFavorite = 1")
    fun getTvShowFavorite(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvshow: List<TvShowEntity>)

    @Update
    fun updateTvShow(module: TvShowEntity)

}