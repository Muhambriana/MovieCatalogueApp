package com.muhamapps.moviecatalogueapp3.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository

class DetailCatalogueViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    var movieCatalogueId = String()

    fun setSelectedMovieCatalogue(movieCatalogueId: String) {
        this.movieCatalogueId = movieCatalogueId
    }

    fun setMovieFavorite(movieEntity: MovieEntity) {
        val newState = !movieEntity.isFavorite
        catalogueRepository.setMoviesFavorite(movieEntity, newState)
    }

    fun setTvShowFavorite(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFavorite
        catalogueRepository.setTvShowsFavorite(tvShowEntity, newState)
    }

    fun getMovie(): LiveData<MovieEntity> = catalogueRepository.getMovies(
        this.movieCatalogueId
    )

    fun getTvShow(): LiveData<TvShowEntity> = catalogueRepository.getTvShows(
        this.movieCatalogueId
    )


}