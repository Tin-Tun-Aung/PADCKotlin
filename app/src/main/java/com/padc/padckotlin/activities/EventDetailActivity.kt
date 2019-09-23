package com.padc.padckotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.padc.padckotlin.R
import com.padc.padckotlin.adapters.EventDetailImageAdapter
import com.padc.padckotlin.data.vos.EventVO
import kotlinx.android.synthetic.main.activity_event_details.*

class EventDetailActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)
        setSupportActionBar(toolbar)

        vpEventDetailImages.adapter = EventDetailImageAdapter()

        val eventId = intent.getIntExtra(EXTRA_EVENT_ID, 0)
        if (eventId != 0){
            val eventVO = model.getEventById(eventId)
            bindData(eventVO)
        }

    }

    private fun bindData(eventVO: EventVO) {
        tvEventTitle.text = eventVO.eventName
        collapsingToolbar.title = eventVO.eventName

        Glide.with(ivTagImage)
            .load(eventVO.eventOrganizerVO.organizerPhotoUrl)
            .into(ivTagImage)

        tvDate.text = eventVO.eventStartTime
        tvCategory.text = eventVO.eventType.toString()
    }


    companion object {

        const val EXTRA_EVENT_ID = "eventIdExtra"

        fun newIntent(context: Context, eventId: Int): Intent {
            return Intent(context, EventDetailActivity::class.java).apply {
                putExtra(EXTRA_EVENT_ID, eventId)
            }

        }
    }
}