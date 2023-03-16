package com.muhamapps.moviecatalogueapp3.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse (
    var tvShowId: String,
    var title: String,
    var total_season: String,
    var year: String,
    var rate: String,
    var genre: String,
    var duration: String,
    var description: String,
    var poster: String
): Parcelable
