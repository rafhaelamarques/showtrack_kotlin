package com.cotemig.showtrack.services

import com.cotemig.showtrack.models.Serie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchService {

    @GET("search/shows?q={serie}")
    fun searchSerie(@Path("serie") serie: String?): Call<List<Serie>>
}