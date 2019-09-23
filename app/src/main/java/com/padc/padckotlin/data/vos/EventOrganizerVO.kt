package com.padc.padckotlin.data.vos

import com.google.gson.annotations.SerializedName

data class EventOrganizerVO(
    @SerializedName("organizer_name")
    val organizerName: String,

    @SerializedName("organizer_photo_url")
    val organizerPhotoUrl: String,

    @SerializedName("organizer_role")
    val organizerRole: String
)