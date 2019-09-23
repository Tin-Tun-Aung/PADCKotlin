package com.padc.padckotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.padckotlin.R
import com.padc.padckotlin.data.vos.EventVO
import com.padc.padckotlin.delegates.EventItemDelegate
import com.padc.padckotlin.viewholders.EventItemViewHolder

class EventListAdapter(private val delegate: EventItemDelegate) :
    BaseAdapter<EventItemViewHolder, EventVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_event, parent, false)
        return EventItemViewHolder(view, delegate)
    }



}