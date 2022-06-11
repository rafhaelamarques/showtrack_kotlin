package com.cotemig.showtrack.services

import com.cotemig.showtrack.models.Episode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeService {

    @GET("shows/{id}?embed=nextepisode")
    fun episodeSchedule(@Path("id") id: Int?): Call<List<Episode>>
}