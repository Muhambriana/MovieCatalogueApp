package com.muhamapps.moviecatalogueapp3.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.NetworkBoundResource
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueDataSource
import com.muhamapps.moviecatalogueapp3.data.source.local.LocalDataSource
import com.muhamapps.moviecatalogueapp3.data.source.remote.ApiResponse
import com.muhamapps.moviecatalogueapp3.data.source.remote.RemoteDataSource
import com.muhamapps.moviecatalogueapp3.data.source.remote.response.MovieResponse
import com.muhamapps.moviecatalogueapp3.data.source.remote.response.TvShowResponse
import com.muhamapps.moviecatalogueapp3.utils.AppExecutors
import com.muhamapps.moviecatalogueapp3.vo.Resource

class FakeCatalogueRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : CatalogueDataSource {

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getAllMovies()
            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()
            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()
            public override fun saveCallResult(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val movie = MovieEntity(response.movieId,
                        response.title,
                        response.year,
                        response.rate,
                        response.genre,
                        response.duration,
                        response.description,
                        response.poster)
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                localDataSource.getAllTvShows()
            override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()
            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()
            public override fun saveCallResult(tvShowResponses: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponses) {
                    val tvShow = TvShowEntity(response.tvShowId,
                        response.title,
                        response.total_season,
                        response.year,
                        response.rate,
                        response.genre,
                        response.duration,
                        response.description,
                        response.poster)
                    tvShowList.add(tvShow)
                }

                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getMovies(id: String): LiveData<MovieEntity> = localDataSource.getMovies(id)

    override fun getTvShows(id: String): LiveData<TvShowEntity> = localDataSource.getTvShows(id)

    override fun getMoviesFavorite(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getMovieFavorites(), config).build()
    }

    override fun getTvShowsFavorite(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getTvShowFavorites(), config).build()
    }

    override fun setMoviesFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorites(movie, state) }

    override fun setTvShowsFavorite(tvShow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorites(tvShow, state) }

}