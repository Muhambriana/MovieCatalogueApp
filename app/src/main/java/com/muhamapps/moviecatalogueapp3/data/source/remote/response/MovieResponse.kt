package com.muhamapps.moviecatalogueapp3.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse (
    var movieId: String,
    var title: String,
    var year: String,
    var rate: String,
    var genre: String,
    var duration: String,
    var description: String,
    var poster: String
):Parcelable