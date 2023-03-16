package com.muhamapps.moviecatalogueapp3.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.data.source.CatalogueRepository
import com.muhamapps.moviecatalogueapp3.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailCatalogueViewModelTest {
    private lateinit var viewModel: DetailCatalogueViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailCatalogueViewModel(catalogueRepository)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovieCatalogue(movieId)
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(catalogueRepository.getMovies(movieId)).thenReturn(movie)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedMovieCatalogue(tvShowId)
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getTvShows(tvShowId)).thenReturn(tvShow)
        viewModel.getTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
//        val tvShowEntity = viewModel.getTvShow().value as TvShowEntity
//        Mockito.verify(catalogueRepository).getTvShows(tvShowId)
//        assertNotNull(tvShow)
//        assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
//        assertEquals(dummyTvShow.title, tvShowEntity.title)
//        assertEquals(dummyTvShow.total_season, tvShowEntity.total_season)
//        assertEquals(dummyTvShow.year, tvShowEntity.year)
//        assertEquals(dummyTvShow.rate, tvShowEntity.rate)
//        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
//        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
//        assertEquals(dummyTvShow.description, tvShowEntity.description)
//        assertEquals(dummyTvShow.poster, tvShowEntity.poster)
//
//        viewModel.getTvShow().observeForever(tvShowObserver)
//        Mockito.verify(tvShowObserver).onChanged(dummyTvShow)
    }

//    fun getCourseWithModule() {
//        val dummyCourseWithModule = Resource.success(DataDummy.generateDummyCourseWithModules(dummyCourse, true))
//        val course = MutableLiveData<Resource<CourseWithModule>>()
//        course.value = dummyCourseWithModule
//        `when`(academyRepository.getCourseWithModules(courseId)).thenReturn(course)
//        viewModel.courseModule.observeForever(observer)
//        verify(observer).onChanged(dummyCourseWithModule)
//    }
}