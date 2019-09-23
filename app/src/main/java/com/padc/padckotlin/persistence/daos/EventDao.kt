package com.padc.padckotlin.persistence.daos

import androidx.room.*
import com.padc.padckotlin.data.vos.EventVO

@Dao
abstract class EventDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    abstract fun insertEvents(events: List<EventVO>): LongArray

    @Query("SELECT * FROM events")
    abstract fun getAllEvents(): List<EventVO>

    @Query("SELECT * FROM events WHERE id = :id")
    abstract fun getEventById(id: Int): EventVO

    fun areEventsExistInDB(): Boolean {
        return getAllEvents().isNotEmpty()
    }
}