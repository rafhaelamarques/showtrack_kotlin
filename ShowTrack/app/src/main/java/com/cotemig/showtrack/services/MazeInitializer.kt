package com.cotemig.showtrack.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MazeInitializer {

    private val url = "https://api.tvmaze.com/";

    private val retrofit =
        Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()

    fun getSearchService() : SearchService{
        return retrofit.create(SearchService::class.java)
    }

    fun getEpisodeService() : EpisodeService{
        return retrofit.create(EpisodeService::class.java)
    }
}