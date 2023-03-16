package com.muhamapps.moviecatalogueapp3.ui.favorite.movie

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.muhamapps.moviecatalogueapp3.databinding.FragmentFavoriteMoviesBinding
import com.muhamapps.moviecatalogueapp3.ui.favorite.FavoritesViewModel
import com.muhamapps.moviecatalogueapp3.viewmodel.ViewModelFactory


class FavoriteMoviesFragment : Fragment() {

    private var fragmentMoviesBinding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = fragmentMoviesBinding
    private lateinit var viewModel: FavoritesViewModel
    private lateinit var moviesAdapter: FavoriteMoviesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMoviesBinding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

        moviesViewModel()

        moviesAdapter = FavoriteMoviesAdapter()

        with(binding?.rvFavoriteMovies) {
            this?.layoutManager =
                if (activity!!.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    GridLayoutManager(context,2)
                } else {
                    GridLayoutManager(context,4)
                }
            this?.setHasFixedSize(true)
            this?.adapter = moviesAdapter
        }



        }
//        itemTouchHelper.attachToRecyclerView(binding?.rvMovies)
    }

    override fun onStart() {
        moviesViewModel()
        super.onStart()
    }

    override fun onResume() {
        moviesViewModel()
        super.onResume()
    }

    private fun moviesViewModel() {
        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[FavoritesViewModel::class.java]
        viewModel.getMovieFavorite().observe(this, { moviesFavorite ->
            fragmentMoviesBinding?.progressBar?.visibility = View.GONE
            moviesAdapter.submitList(moviesFavorite)
            moviesAdapter.notifyDataSetChanged()
            if(moviesFavorite.isEmpty()){
                view?.let { Snackbar.make(it, "No Favorite Movie For Now", Snackbar.LENGTH_SHORT).show() }
            }
        })
    }

}