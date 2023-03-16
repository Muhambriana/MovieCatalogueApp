package com.muhamapps.moviecatalogueapp3.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository
import com.muhamapps.moviecatalogueapp3.vo.Resource

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getTvShows(): LiveData<Resource<List<TvShowEntity>>> = catalogueRepository.getAllTvShows()
}