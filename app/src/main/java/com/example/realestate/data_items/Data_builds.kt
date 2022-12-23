package com.example.realestate.data_items

import android.os.Parcel
import android.os.Parcelable

data class Data_builds(val image: Int, val name: String, val title: String, val price: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(title)
        parcel.writeString(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data_builds> {
        override fun createFromParcel(parcel: Parcel): Data_builds {
            return Data_builds(parcel)
        }

        override fun newArray(size: Int): Array<Data_builds?> {
            return arrayOfNulls(size)
        }
    }
}

