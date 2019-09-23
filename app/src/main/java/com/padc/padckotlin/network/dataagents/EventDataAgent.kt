package com.padc.padckotlin.network.dataagents

import com.padc.padckotlin.data.vos.EventVO

interface EventDataAgent {

    fun getEvents(
        accessToken: String,
        onSuccess: (List<EventVO>) -> Unit,
        onFailure: (String) -> Unit
    )

}