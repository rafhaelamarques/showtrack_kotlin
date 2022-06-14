package com.cotemig.showtrack.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MazeResult(
    @SerializedName("score") @Expose val score: Double,
    @SerializedName("show") @Expose val show: Show?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readParcelable(Show::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(score)
        parcel.writeParcelable(show, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MazeResult> {
        override fun createFromParcel(parcel: Parcel): MazeResult {
            return MazeResult(parcel)
        }

        override fun newArray(size: Int): Array<MazeResult?> {
            return arrayOfNulls(size)
        }
    }
}