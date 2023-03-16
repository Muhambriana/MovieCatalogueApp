package com.muhamapps.moviecatalogueapp3.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository
import com.muhamapps.moviecatalogueapp3.utils.DataDummy
import com.muhamapps.moviecatalogueapp3.vo.Resource


import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<TvShowEntity>>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = Resource.success(DataDummy.generateDummyTvShows())
        val tvShows = MutableLiveData<Resource<List<TvShowEntity>>>()
        tvShows.value = dummyTvShows

        Mockito.`when`(catalogueRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShows().value?.data
        Mockito.verify(catalogueRepository).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }
}
