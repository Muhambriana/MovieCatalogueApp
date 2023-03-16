package com.muhamapps.moviecatalogueapp3.ui.tvshow

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.muhamapps.moviecatalogueapp3.databinding.FragmentTvShowBinding
import com.muhamapps.moviecatalogueapp3.viewmodel.ViewModelFactory
import com.muhamapps.moviecatalogueapp3.vo.Status

class TvShowFragment : Fragment() {
    private var fragmentTvShowBinding: FragmentTvShowBinding? = null
    private val binding get() = fragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShows().observe(this, { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            tvShows.data?.let { tvShowAdapter.setTvShow(it) }
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(binding?.rvTvShow) {
                this?.layoutManager =
                    if (activity!!.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                        GridLayoutManager(context,2)
                    } else {
                        GridLayoutManager(context,4)
                    }
                this?.setHasFixedSize(true)
                this?.adapter = tvShowAdapter
            }
        }
    }
}