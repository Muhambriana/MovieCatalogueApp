package com.muhamapps.moviecatalogueapp3.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository

class FavoritesViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovieFavorite(): LiveData<PagedList<MovieEntity>> = catalogueRepository.getMoviesFavorite()

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = catalogueRepository.getTvShowsFavorite()

}