package com.padc.padckotlin.data.models

import android.content.Context
import com.padc.padckotlin.network.dataagents.EventDataAgent
import com.padc.padckotlin.network.dataagents.RetrofitAgent
import com.padc.padckotlin.persistence.EventDatabase

abstract class BaseModel {

    protected val dataAgent: EventDataAgent = RetrofitAgent

    protected lateinit var database: EventDatabase

    fun initDatabase(context: Context){
        database = EventDatabase.getInstance(context)
    }
}