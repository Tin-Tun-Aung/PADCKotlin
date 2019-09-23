package com.padc.padckotlin.network.resposes

import com.google.gson.annotations.SerializedName
import com.padc.padckotlin.data.vos.EventVO
import com.padc.padckotlin.utils.CODE_RESPONSE_OK

data class GetEventsResponse(
    @SerializedName("code")
    val code: Int = 0,

    @SerializedName("message")
    val message: String = "",

    @SerializedName("data")
    val data: List<EventVO>? = null
) {

    fun isResponseOk(): Boolean {
        return code == CODE_RESPONSE_OK && data != null
    }
}