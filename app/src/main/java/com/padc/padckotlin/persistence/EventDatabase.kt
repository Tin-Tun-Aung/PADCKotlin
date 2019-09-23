package com.padc.padckotlin.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padc.padckotlin.data.vos.EventVO
import com.padc.padckotlin.persistence.daos.EventDao
import com.padc.padckotlin.persistence.typeconverters.UserListTypeConverter
import com.padc.padckotlin.utils.EVENT_DB

@Database(entities = [EventVO::class], version = 1, exportSchema = false)
@TypeConverters(UserListTypeConverter::class)
abstract class EventDatabase: RoomDatabase() {

    abstract fun eventDao() : EventDao

    companion object {
        private var instance: EventDatabase? = null

        fun getInstance(context: Context): EventDatabase {
            if (instance == null) {
                    instance = Room.databaseBuilder(context, EventDatabase::class.java, EVENT_DB)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }


            val db = instance!!
            return db
        }
    }


}