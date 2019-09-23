package com.padc.padckotlin.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padc.padckotlin.data.vos.EventVO
import com.padc.padckotlin.delegates.EventItemDelegate
import com.padc.padckotlin.utils.loadUrl
import kotlinx.android.synthetic.main.view_item_event.view.*


class EventItemViewHolder(itemView: View, private val delegate: EventItemDelegate) :
    BaseViewHolder<EventVO>(itemView) {


    init {
        // (View) -> Unit

        itemView.setOnClickListener {
            data?.id?.let { id ->
                delegate.onTapEventItem(id)
            }
        }
    }


    override fun bindData(data: EventVO) {
        itemView.tvEventName.text = data.eventName
        itemView.tvTime.text = data.eventStartTime
        itemView.tvEventAgeRange.text = data.eventRequirementsVO.ageRange
        itemView.tvLocationName.text = data.eventLocationName
        itemView.tvLocationFullAddress.text = data.eventLocationFullAddress
        itemView.tvOrganizerName.text = data.eventOrganizerVO.organizerName
        itemView.tvEventOwnerRole.text = data.eventOrganizerVO.organizerRole

        itemView.ivOrganizer.loadUrl(data.eventOrganizerVO.organizerPhotoUrl)
    }
}