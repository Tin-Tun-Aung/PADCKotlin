package com.padc.padckotlin.data.models

import com.padc.padckotlin.data.vos.EventVO
import com.padc.padckotlin.utils.DUMMY_ACCESS_TOKEN

object EventModelImpl : EventModel, BaseModel() {

    override fun getEvents(onSuccess: (List<EventVO>) -> Unit, onFailure: (String) -> Unit) {
        val eventsFromDB = database.eventDao().getAllEvents()

        if (eventsFromDB.isNotEmpty()) {
            onSuccess(eventsFromDB)
        } else {
            dataAgent.getEvents(
                DUMMY_ACCESS_TOKEN,
                {
                    database.eventDao().insertEvents(it)
                    onSuccess(it)
                },
                onFailure
            )
        }
    }

    override fun getEventById(eventId: Int): EventVO {
        return database.eventDao().getEventById(eventId)
    }
}