package com.cotemig.showtrack.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MazeResult(
    @SerializedName("score") @Expose val score: Double,
    @SerializedName("show") @Expose val show: Show,
)