package com.muhamapps.moviecatalogueapp3

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import com.muhamapps.moviecatalogueapp3.ui.home.HomeActivity
import com.muhamapps.moviecatalogueapp3.utils.DataDummy
import com.muhamapps.moviecatalogueapp3.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    //Catalogue Item Movie Test
    @Test
    fun catalogueTest1() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    //Detail Movie Test
    @Test
    fun catalogueTest2() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.year)).check(matches(isDisplayed()))
        onView(withId(R.id.year)).check(matches(withText(dummyMovie[0].year)))
        onView(withId(R.id.rate)).check(matches(isDisplayed()))
        onView(withId(R.id.rate)).check(matches(withText(dummyMovie[0].rate)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.duration)).check(matches(isDisplayed()))
        onView(withId(R.id.duration)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_favorite_item)).perform(click())

        pressBack()
    }

    //Catalogue Item Tv Show Test
    @Test
    fun catalogueTest3() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    //Detail Tv Show Test
    @Test
    fun catalogueTest4() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.total_season)).check(matches(isDisplayed()))
        onView(withId(R.id.total_season)).check(matches(withText(dummyTvShow[0].total_season)))
        onView(withId(R.id.year)).check(matches(isDisplayed()))
        onView(withId(R.id.year)).check(matches(withText(dummyTvShow[0].year)))
        onView(withId(R.id.rate)).check(matches(isDisplayed()))
        onView(withId(R.id.rate)).check(matches(withText(dummyTvShow[0].rate)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.duration)).check(matches(isDisplayed()))
        onView(withId(R.id.duration)).check(matches(withText(dummyTvShow[0].duration)))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(withText(dummyTvShow[0].description)))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_favorite_item)).perform(click())

        pressBack()
    }

    //Catalogue Item Favorite Movie Test
    @Test
    fun catalogueTest5() {
        onView(withText(R.string.movies_favorite)).perform(click())
        onView(withId(R.id.rv_favorite_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    //Catalogue Item Favorite TvShow Test
    @Test
    fun catalogueTest6() {
        onView(withText(R.string.tv_show_favorite)).perform(click())
        onView(withId(R.id.rv_favorite_tvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }





}