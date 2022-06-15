package com.cotemig.showtrack.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Show(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String?,
    @SerializedName("rating") @Expose val rating: Rating?,
    @SerializedName("webChannel") @Expose val webChannel: WebChannel?,
    @SerializedName("image") @Expose val image: Image?,
    @SerializedName("summary") @Expose val summary: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readParcelable(Rating::class.java.classLoader),
        parcel.readParcelable(WebChannel::class.java.classLoader),
        parcel.readParcelable(Image::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeParcelable(rating, flags)
        parcel.writeParcelable(webChannel, flags)
        parcel.writeParcelable(image, flags)
        parcel.writeString(summary)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Show> {
        override fun createFromParcel(parcel: Parcel): Show {
            return Show(parcel)
        }

        override fun newArray(size: Int): Array<Show?> {
            return arrayOfNulls(size)
        }
    }
}

data class Rating(@SerializedName("average") @Expose val average: String? = "N/A") : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(average)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rating> {
        override fun createFromParcel(parcel: Parcel): Rating {
            return Rating(parcel)
        }

        override fun newArray(size: Int): Array<Rating?> {
            return arrayOfNulls(size)
        }
    }
}

data class WebChannel(
    @SerializedName("name") @Expose val name: String? = "N/A",
    @SerializedName("officialSite") @Expose val officialSite: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(officialSite)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WebChannel> {
        override fun createFromParcel(parcel: Parcel): WebChannel {
            return WebChannel(parcel)
        }

        override fun newArray(size: Int): Array<WebChannel?> {
            return arrayOfNulls(size)
        }
    }
}

data class Image(
    @SerializedName("medium") @Expose val medium: String?,
    @SerializedName("original") @Expose val original: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(medium)
        parcel.writeString(original)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: Parcel): Image {
            return Image(parcel)
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }
}