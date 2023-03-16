package com.muhamapps.moviecatalogueapp3.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.muhamapps.moviecatalogueapp3.databinding.FragmentFavoriteTvShowBinding
import com.muhamapps.moviecatalogueapp3.ui.favorite.FavoritesViewModel
import com.muhamapps.moviecatalogueapp3.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {
    private var fragmentTvShowBinding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = fragmentTvShowBinding
    private lateinit var viewModel: FavoritesViewModel
    private lateinit var tvShowAdapter: FavoriteTvShowAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTvShowBinding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            tvShowAdapter = FavoriteTvShowAdapter()

            tvShowsViewModel()

            with(binding?.rvFavoriteTvShow) {
                this?.layoutManager =
                    if (activity!!.resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
                        GridLayoutManager(context,2)
                    } else {
                        GridLayoutManager(context,4)
                    }
                this?.setHasFixedSize(true)
                this?.adapter = tvShowAdapter
            }
        }
    }

    override fun onResume() {
        tvShowsViewModel()
        super.onResume()
    }

    private fun tvShowsViewModel() {
        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[FavoritesViewModel::class.java]
        viewModel.getFavoriteTvShows().observe(this, { tvShowFavorite ->
            fragmentTvShowBinding?.progressBar?.visibility = View.GONE
            tvShowAdapter.submitList(tvShowFavorite)
            tvShowAdapter.notifyDataSetChanged()
            if(tvShowFavorite.isEmpty()){
                view?.let { Snackbar.make(it, "No Favorite Tv Show For Now", Snackbar.LENGTH_SHORT).show() }
            }
        })
    }
}