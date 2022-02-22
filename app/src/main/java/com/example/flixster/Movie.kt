package com.example.flixster

import org.json.JSONArray

// Movie class represents a movie object to be displayed in the UI
data class Movie (
    val movieID: Int,
    val posterPath: String,
    val title: String,
    val overview: String,
){
    companion object{
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie>{
            val movies = mutableListOf<Movie>()
            for(i in 0 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}