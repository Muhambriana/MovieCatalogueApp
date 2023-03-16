package com.muhamapps.moviecatalogueapp3.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.muhamapps.moviecatalogueapp3.R
import com.muhamapps.moviecatalogueapp3.ui.favorite.movie.FavoriteMoviesFragment
import com.muhamapps.moviecatalogueapp3.ui.favorite.tvshow.FavoriteTvShowFragment
import com.muhamapps.moviecatalogueapp3.ui.movies.MoviesFragment
import com.muhamapps.moviecatalogueapp3.ui.tvshow.TvShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_show, R.string.movies_favorite, R.string.tv_show_favorite)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MoviesFragment()
            1 -> TvShowFragment()
            2 -> FavoriteMoviesFragment()
            3 -> FavoriteTvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 4

}