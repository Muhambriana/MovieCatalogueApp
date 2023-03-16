package com.muhamapps.moviecatalogueapp3.ui.movies

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.muhamapps.moviecatalogueapp3.databinding.FragmentMoviesBinding
import com.muhamapps.moviecatalogueapp3.viewmodel.ViewModelFactory
import com.muhamapps.moviecatalogueapp3.vo.Status


class MoviesFragment : Fragment() {

    private var fragmentMoviesBinding: FragmentMoviesBinding? = null
    private val binding get() = fragmentMoviesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val moviesAdapter = MoviesAdapter()

            viewModel.getMovies().observe(this) { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            movies.data?.let { moviesAdapter.setMovies(it) }
                            moviesAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            with(binding?.rvMovies) {
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
    }


}