package com.muhamapps.moviecatalogueapp3.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.muhamapps.moviecatalogueapp3.R
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.MovieEntity
import com.muhamapps.moviecatalogueapp3.data.source.local.entity.TvShowEntity
import com.muhamapps.moviecatalogueapp3.databinding.ActivityDetailCatalogueBinding
import com.muhamapps.moviecatalogueapp3.viewmodel.ViewModelFactory


class DetailCatalogueActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailCatalogueBinding: ActivityDetailCatalogueBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailCatalogueBinding = ActivityDetailCatalogueBinding.inflate(layoutInflater)
        detailCatalogueBinding = activityDetailCatalogueBinding

        setContentView(detailCatalogueBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Information Detail"

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailCatalogueViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieCatalogueId = extras.getString(EXTRA_MOVIE)
            if (movieCatalogueId != null) {

                detailCatalogueBinding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedMovieCatalogue(movieCatalogueId)
                if (movieCatalogueId.take(2) == "mv"){
                    activityDetailCatalogueBinding.progressBar.visibility = View.INVISIBLE
                    viewModel.getMovie().observe(this, { movie -> populateMovie(movie) } )
                }
                else if (movieCatalogueId.take(2) == "ts"){
                    detailCatalogueBinding.apply {
                        progressBar.visibility = View.GONE
                        textSeason.text = "Season"
                    }
                    viewModel.getTvShow().observe(this, { tvShow -> populateTvShow(tvShow) })
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun populateMovie(movieEntity: MovieEntity?) {
        val statusFavorite = movieEntity?.isFavorite
        detailCatalogueBinding.apply {
            textTitle.text = movieEntity?.title
            year.text = movieEntity?.year
            rate.text = movieEntity?.rate
            genre.text = movieEntity?.genre
            duration.text = movieEntity?.duration
            description.text = movieEntity?.description
            Glide.with(this@DetailCatalogueActivity)
                .load(movieEntity?.poster)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster)
        }

        statusFavorite?.let { status ->
            setStatusFavorite(status)
        }

        detailCatalogueBinding.fabFavoriteItem.setOnClickListener {
            setMovieFavorite(movieEntity)
        }
    }

    private fun populateTvShow(tvShowEntity: TvShowEntity?) {
        val statusFavorite = tvShowEntity?.isFavorite
        detailCatalogueBinding.apply {
            textTitle.text = tvShowEntity?.title
            year.text = tvShowEntity?.year
            rate.text = tvShowEntity?.rate
            genre.text = tvShowEntity?.genre
            totalSeason.text = tvShowEntity?.total_season
            duration.text = tvShowEntity?.duration
            description.text = tvShowEntity?.description
            Glide.with(this@DetailCatalogueActivity)
                .load(tvShowEntity?.poster)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(imagePoster)
        }

        statusFavorite?.let { status ->
            setStatusFavorite(status)
        }

        detailCatalogueBinding.fabFavoriteItem.setOnClickListener {
            setTvShowFavorite(tvShowEntity)
        }
    }

    private fun setMovieFavorite(movie: MovieEntity?) {
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailCatalogueViewModel::class.java]
        if (movie != null) {
            if (movie.isFavorite){
                Toast.makeText(this, "${movie.title} Removed From Favorite Movie", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "${movie.title} Added To Favorite Movie", Toast.LENGTH_SHORT).show()
            }
            viewModel.setMovieFavorite(movie)
        }
    }

    private fun setTvShowFavorite(tvShow: TvShowEntity?) {
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailCatalogueViewModel::class.java]
        if (tvShow != null) {
            if (tvShow.isFavorite){
                Toast.makeText(this, "${tvShow.title} Removed From Favorite Tv Show", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "${tvShow.title} Added To Favorite Tv Show", Toast.LENGTH_SHORT).show()
            }
            viewModel.setTvShowFavorite(tvShow)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if(statusFavorite){
            detailCatalogueBinding.fabFavoriteItem.setImageDrawable(getDrawable(R.drawable.ic_favorite))
        }
        else{
            detailCatalogueBinding.fabFavoriteItem.setImageDrawable(getDrawable(R.drawable.ic_favorite_border))
        }
    }

}