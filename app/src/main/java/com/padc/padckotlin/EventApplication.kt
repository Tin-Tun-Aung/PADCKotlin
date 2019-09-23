package com.padc.padckotlin

import android.app.Application
import com.padc.padckotlin.data.models.EventModelImpl

class EventApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        EventModelImpl.initDatabase(applicationContext)
    }

}