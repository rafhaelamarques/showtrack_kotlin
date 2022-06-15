package com.cotemig.showtrack.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String?,
    @SerializedName("rating") @Expose val rating: Rating?,
    @SerializedName("webChannel") @Expose val webChannel: WebChannel?,
    @SerializedName("image") @Expose val image: Image?,
    @SerializedName("summary") @Expose val summary: String?,
    @SerializedName("_embedded") @Expose val embedded: Embedded?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readParcelable(Rating::class.java.classLoader),
        parcel.readParcelable(WebChannel::class.java.classLoader),
        parcel.readParcelable(Image::class.java.classLoader),
        parcel.readString(),
        parcel.readParcelable(Embedded::class.java.classLoader),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeParcelable(rating, flags)
        parcel.writeParcelable(webChannel, flags)
        parcel.writeParcelable(image, flags)
        parcel.writeString(summary)
        parcel.writeParcelable(embedded, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Episode> {
        override fun createFromParcel(parcel: Parcel): Episode {
            return Episode(parcel)
        }

        override fun newArray(size: Int): Array<Episode?> {
            return arrayOfNulls(size)
        }
    }
}

data class Embedded(@SerializedName("nextepisode") @Expose val nextepisode: NextEpisode?) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readParcelable(NextEpisode::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(nextepisode, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Embedded> {
        override fun createFromParcel(parcel: Parcel): Embedded {
            return Embedded(parcel)
        }

        override fun newArray(size: Int): Array<Embedded?> {
            return arrayOfNulls(size)
        }
    }
}

data class NextEpisode(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("url") @Expose val url: String?,
    @SerializedName("name") @Expose val name: String?,
    @SerializedName("season") @Expose val season: String?,
    @SerializedName("number") @Expose val number: String?,
    @SerializedName("airdate") @Expose val airdate: String?,
    @SerializedName("airtime") @Expose val airtime: String?,
    @SerializedName("runtime") @Expose val runtime: String?,
    @SerializedName("image") @Expose val image: String?,
    @SerializedName("summary") @Expose val summary: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(url)
        parcel.writeString(name)
        parcel.writeString(season)
        parcel.writeString(number)
        parcel.writeString(airdate)
        parcel.writeString(airtime)
        parcel.writeString(runtime)
        parcel.writeString(image)
        parcel.writeString(summary)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NextEpisode> {
        override fun createFromParcel(parcel: Parcel): NextEpisode {
            return NextEpisode(parcel)
        }

        override fun newArray(size: Int): Array<NextEpisode?> {
            return arrayOfNulls(size)
        }
    }
}

