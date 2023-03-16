package com.muhamapps.moviecatalogueapp3.ui.movies

import androidx.lifecycle.*
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository
import com.muhamapps.moviecatalogueapp3.vo.Resource

class MoviesViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<List<MovieEntity>>> = catalogueRepository.getAllMovies()

}