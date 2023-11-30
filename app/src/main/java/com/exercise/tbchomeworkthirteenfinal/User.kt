package com.exercise.tbchomeworkthirteenfinal

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

enum class FieldType {
    @SerializedName("input") INPUT,
    @SerializedName("chooser") CHOOSER
}

data class UserData(
    @SerializedName("field_id") val fieldId: Int,
    @SerializedName("field_type") val fieldType: FieldType,
    val hint: String?,
    val icon: String?,
    @SerializedName("is_active") val isActive: Boolean,
    val keyboard: String? = "",
    val required: Boolean,
    var userInput: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        TODO("fieldType"),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(fieldId)
        parcel.writeString(hint)
        parcel.writeString(icon)
        parcel.writeByte(if (isActive) 1 else 0)
        parcel.writeString(keyboard)
        parcel.writeByte(if (required) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserData> {
        override fun createFromParcel(parcel: Parcel): UserData {
            return UserData(parcel)
        }

        override fun newArray(size: Int): Array<UserData?> {
            return arrayOfNulls(size)
        }
    }
}

