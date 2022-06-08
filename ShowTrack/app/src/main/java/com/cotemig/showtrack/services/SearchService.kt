package com.cotemig.showtrack.services

import com.cotemig.showtrack.models.MazeApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("search/shows")
    fun searchSerie(@Query("q") q: String?): Call<List<MazeApi>>
}