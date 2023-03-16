package com.muhamapps.moviecatalogueapp3.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.LocalDataSource
import com.muhamapps.moviecatalogueapp3.data.source.remote.RemoteDataSource
import com.muhamapps.moviecatalogueapp3.utils.AppExecutors
import com.muhamapps.moviecatalogueapp3.utils.DataDummy
import com.muhamapps.moviecatalogueapp3.utils.LiveDataTestUtils
import com.muhamapps.moviecatalogueapp3.utils.PagedListUtil
import com.muhamapps.moviecatalogueapp3.vo.Resource
import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movie = DataDummy.generateDummyMovies()[0]
    private val movieId = movieResponses[0].movieId
    private val tvShowResponses = DataDummy.generateRemoteDummyTvShows()
    private val tvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = tvShowResponses[0].tvShowId


    @Test
    fun getAllMovies() {
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtils.getValue(catalogueRepository.getAllMovies())
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dummyTvShows = MutableLiveData<List<TvShowEntity>>()
        dummyTvShows.value = DataDummy.generateDummyTvShows()
        `when`(local.getAllTvShows()).thenReturn(dummyTvShows)

        val tvShowEntities = LiveDataTestUtils.getValue(catalogueRepository.getAllTvShows())
        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMovies() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = movie
        `when`(local.getMovies(movieId)).thenReturn(dummyMovie)

        val movieEntities = LiveDataTestUtils.getValue(catalogueRepository.getMovies(movieId))
        verify(local).getMovies(movieId)
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.title)
        assertEquals(movieResponses[0].title, movieEntities.title)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = tvShow
        `when`(local.getTvShows(tvShowId)).thenReturn(dummyTvShow)

        val tvShowEntities = LiveDataTestUtils.getValue(catalogueRepository.getTvShows(tvShowId))
        verify(local).getTvShows(tvShowId)
        assertNotNull(tvShowEntities)
        assertNotNull(tvShowEntities.title)
        assertEquals(tvShowResponses[0].title, tvShowEntities.title)
    }

    @Test
    fun getMoviesFavorite(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovieFavorites()).thenReturn(dataSourceFactory)
        catalogueRepository.getMoviesFavorite()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovieFavorites()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())

    }

    @Test
    fun getTvShowsFavorite(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShowFavorites()).thenReturn(dataSourceFactory)
        catalogueRepository.getTvShowsFavorite()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getTvShowFavorites()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}