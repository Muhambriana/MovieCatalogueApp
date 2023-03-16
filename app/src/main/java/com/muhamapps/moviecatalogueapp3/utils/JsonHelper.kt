package com.muhamapps.moviecatalogueapp3.utils

import android.content.Context
import com.muhamapps.moviecatalogueapp3.data.source.remote.response.MovieResponse
import com.muhamapps.moviecatalogueapp3.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("CatalogueResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val year = movie.getString("year")
                val rate = movie.getString("rate")
                val genre = movie.getString("genre")
                val duration = movie.getString("duration")
                val description = movie.getString("description")
                val poster = movie.getString("poster")

                val movieResponse = MovieResponse(id, title, year, rate, genre, duration, description, poster)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShows(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("CatalogueResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvShows")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getString("id")
                val title = tvShow.getString("title")
                val totalSeason = tvShow.getString("total_seasons")
                val year = tvShow.getString("year")
                val rate = tvShow.getString("rate")
                val genre = tvShow.getString("genre")
                val duration = tvShow.getString("duration")
                val description = tvShow.getString("description")
                val poster = tvShow.getString("poster")

                val tvShowResponse = TvShowResponse(id, title, totalSeason, year, rate, genre, duration, description, poster)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}