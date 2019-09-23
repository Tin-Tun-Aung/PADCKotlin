package com.padc.padckotlin.network

import com.padc.padckotlin.network.resposes.GetEventsResponse
import com.padc.padckotlin.utils.GET_EVENTS
import com.padc.padckotlin.utils.PARAM_ACCESS_TOKEN
import retrofit2.Call
import retrofit2.http.*

interface EventsApi {

    @POST(GET_EVENTS)
    @FormUrlEncoded
    fun getAllEvents(@Field(PARAM_ACCESS_TOKEN) accessToken: String): Call<GetEventsResponse>
}