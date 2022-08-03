package com.neillbarrett.debitsandcredits.database

import androidx.room.TypeConverter
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
import java.sql.Date
import java.util.*
import kotlin.collections.ArrayList

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun listFromString(value: String?): List<String> {
        val listType = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun stringFromList(list: List<String?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}

/*    @TypeConverter
    fun stringToListServer(data: String?): List<ServerEntity?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<ServerEntity?>?>() {}.type
        return gson.fromJson<List<ServerEntity?>>(data, listType)
    }

    @TypeConverter
    fun listServerToString(someObjects: List<ServerEntity?>?): String? {
        return gson.toJson(someObjects)
    }
    On the other hand to convert the String lists, it would simply be done as follows */