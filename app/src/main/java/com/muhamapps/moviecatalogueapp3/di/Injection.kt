package com.muhamapps.moviecatalogueapp3.di

import android.content.Context
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository
import com.muhamapps.moviecatalogueapp3.data.source.local.LocalDataSource
import com.muhamapps.moviecatalogueapp3.data.source.local.room.MovieCatalogueDatabase
import com.muhamapps.moviecatalogueapp3.data.source.remote.RemoteDataSource
import com.muhamapps.moviecatalogueapp3.utils.AppExecutors
import com.muhamapps.moviecatalogueapp3.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val database = MovieCatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}