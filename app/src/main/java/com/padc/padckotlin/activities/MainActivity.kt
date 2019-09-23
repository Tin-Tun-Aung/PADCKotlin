package com.padc.padckotlin.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padc.padckotlin.R
import com.padc.padckotlin.adapters.EventListAdapter
import com.padc.padckotlin.delegates.EventItemDelegate
import kotlinx.android.synthetic.main.activity_adapter_based_view.*

class MainActivity : BaseActivity(), EventItemDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter_based_view)
        setSupportActionBar(toolbar)

        val eventListAdapter = EventListAdapter(this)

        with(rvEvents) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = eventListAdapter
        }

        model.getEvents(
            { events ->
                eventListAdapter.setNewData(events.toMutableList())
            }, {
                Snackbar.make(rootView, it, Snackbar.LENGTH_LONG).show()
            }
        )
    }

    override fun onTapEventItem(eventId: Int) {
        startActivity(EventDetailActivity.newIntent(applicationContext, eventId))
    }
}
