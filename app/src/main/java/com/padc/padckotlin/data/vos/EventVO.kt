package com.padc.padckotlin.data.vos

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "events")
data class EventVO (
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id: Int,

    @SerializedName("event_name")
    @ColumnInfo(name = "event_name")
    val eventName: String,

    @SerializedName("event_start_time")
    @ColumnInfo(name = "event_start_time")
    val eventStartTime: String,

    @SerializedName("event_location_name")
    @ColumnInfo(name = "event_location_name")
    val eventLocationName: String,

    @SerializedName("event_location_full_address")
    @ColumnInfo(name = "event_location_full_address")
    val eventLocationFullAddress: String,

    @SerializedName("event_organizer")
    @Embedded(prefix = "event_organizer_")
    val eventOrganizerVO: EventOrganizerVO,

    @SerializedName("schedule_status")
    @ColumnInfo(name = "schedule_status")
    val scheduleStatus: Int,

    @SerializedName("event_type")
    @ColumnInfo(name = "event_type")
    val eventType: Int,

    @SerializedName("event_requirements")
    @Embedded(prefix = "event_requirements_")
    val eventRequirementsVO: EventRequirementsVO,

    @SerializedName("interested_user")
    val interestedUsers: List<UserVO>,

    @SerializedName("going_user")
    val goingUsers: List<UserVO>
)