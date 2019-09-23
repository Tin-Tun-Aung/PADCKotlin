package com.padc.padckotlin.data.vos

import com.google.gson.annotations.SerializedName

data class UserVO(
    @SerializedName("user_name")
    val userName: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("phone_number")
    val phoneNumber: String,

    @SerializedName("photo_url")
    val photoUrl: String,

    @SerializedName("cover_url")
    val coverUrl: String,

    @SerializedName("address")
    val address: String
)