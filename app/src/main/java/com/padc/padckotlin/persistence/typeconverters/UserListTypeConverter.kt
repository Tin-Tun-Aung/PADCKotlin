package com.padc.padckotlin.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.padckotlin.data.vos.UserVO

class UserListTypeConverter {

    @TypeConverter
    fun toString(list: List<UserVO>): String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json: String): List<UserVO> {
        val typeToken = object : TypeToken<List<UserVO>>(){

        }.type
        return Gson().fromJson(json, typeToken)
    }
}