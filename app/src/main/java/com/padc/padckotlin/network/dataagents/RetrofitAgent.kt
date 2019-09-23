package com.padc.padckotlin.network.dataagents

import com.padc.padckotlin.data.vos.EventVO
import com.padc.padckotlin.network.EventsApi
import com.padc.padckotlin.network.resposes.GetEventsResponse
import com.padc.padckotlin.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitAgent : EventDataAgent {

    private val eventApi: EventsApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        eventApi = retrofit.create(EventsApi::class.java)
    }


    override fun getEvents(
        accessToken: String,
        onSuccess: (List<EventVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = eventApi.getAllEvents(accessToken)

        call.enqueue(object : Callback<GetEventsResponse> {

            override fun onFailure(call: Call<GetEventsResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetEventsResponse>,
                response: Response<GetEventsResponse>
            ) {
                val eventsResponse = response.body()

                if (eventsResponse != null) {
                    if (eventsResponse.data != null) {
                        onSuccess(eventsResponse.data)
                    } else {
                        onFailure(eventsResponse.message)
                    }
                } else {
                    onFailure("${response.code()} ${response.message()}")
                }

            }
        })
    }
}