package com.muhamapps.moviecatalogueapp3.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository
import com.muhamapps.moviecatalogueapp3.di.Injection
import com.muhamapps.moviecatalogueapp3.ui.detail.DetailCatalogueViewModel
import com.muhamapps.moviecatalogueapp3.ui.favorite.FavoritesViewModel
import com.muhamapps.moviecatalogueapp3.ui.movies.MoviesViewModel
import com.muhamapps.moviecatalogueapp3.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mCatalogueRepository: CatalogueRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailCatalogueViewModel::class.java) -> {
                return DetailCatalogueViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavoritesViewModel::class.java) -> {
                return FavoritesViewModel(mCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}