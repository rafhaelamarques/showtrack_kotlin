package com.cotemig.showtrack.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Show(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("rating") @Expose val rating: Rating?,
    @SerializedName("webChannel") @Expose val webChannel: WebChannel?,
    @SerializedName("image") @Expose val image: Image?,
    @SerializedName("summary") @Expose val summary: String?,
)

@Serializable
data class Rating(@SerializedName("average") @Expose val average: String? = "N/A")

@Serializable
data class WebChannel(
    @SerializedName("name") @Expose val name: String? = "N/A",
    @SerializedName("officialSite") @Expose val officialSite: String?
)

@Serializable
data class Image(
    @SerializedName("medium") @Expose val medium: String?,
    @SerializedName("original") @Expose val original: String?
)