package com.padc.padckotlin.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padc.padckotlin.data.models.EventModel
import com.padc.padckotlin.data.models.EventModelImpl

abstract class BaseActivity: AppCompatActivity() {

    protected lateinit var model: EventModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = EventModelImpl
    }

}