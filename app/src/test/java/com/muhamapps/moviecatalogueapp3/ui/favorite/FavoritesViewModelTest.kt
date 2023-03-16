package com.muhamapps.moviecatalogueapp3.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoritesViewModelTest {

    private lateinit var viewModel: FavoritesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observerMovie: Observer<List<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<List<TvShowEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListTvShow: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoritesViewModel(catalogueRepository)
    }

    @Test
    fun getMovieFavorite() {
        val dummyMovies = pagedListMovie
        `when`(dummyMovies.size).thenReturn(10)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovies

        `when`(catalogueRepository.getMoviesFavorite()).thenReturn(movies)
        val movieEntities = viewModel.getMovieFavorite().value
        Mockito.verify(catalogueRepository).getMoviesFavorite()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovieFavorite().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovies)
    }

    @Test
    fun getTvShowFavorite() {
        val dummyTvShows = pagedListTvShow
        `when`(dummyTvShows.size).thenReturn(10)
        val tvShows = MutableLiveData<PagedList<TvShowEntity>>()
        tvShows.value = dummyTvShows

        `when`(catalogueRepository.getTvShowsFavorite()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getFavoriteTvShows().value
        Mockito.verify(catalogueRepository).getTvShowsFavorite()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getFavoriteTvShows().observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(dummyTvShows)
    }
}