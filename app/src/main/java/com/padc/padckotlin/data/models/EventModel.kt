package com.padc.padckotlin.data.models

import com.padc.padckotlin.data.vos.EventVO

interface EventModel {

    fun getEvents(
        onSuccess: (List<EventVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getEventById(eventId: Int): EventVO

}