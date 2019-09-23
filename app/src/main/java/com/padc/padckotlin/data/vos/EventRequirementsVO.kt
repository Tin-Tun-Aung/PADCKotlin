package com.padc.padckotlin.data.vos

import com.google.gson.annotations.SerializedName

data class EventRequirementsVO (
    @SerializedName("gender")
    val gender: Int,

    @SerializedName("age_range")
    val ageRange: String,

    @SerializedName("privacy")
    val privacy: String,

    @SerializedName("max_people_available")
    val maxPeopleAvailable: Int
)