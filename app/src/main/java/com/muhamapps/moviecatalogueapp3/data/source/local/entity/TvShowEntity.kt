package com.muhamapps.moviecatalogueapp3.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "total_season")
    var total_season: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "rate")
    var rate: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)