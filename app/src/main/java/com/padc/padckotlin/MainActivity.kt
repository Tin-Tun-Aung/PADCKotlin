package com.padc.padckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import kotlinx.android.synthetic.main.activity_adapter_based_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter_based_view)
        setSupportActionBar(toolbar)


    }

}
