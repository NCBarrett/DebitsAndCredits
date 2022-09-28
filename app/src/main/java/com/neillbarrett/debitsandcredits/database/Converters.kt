package com.neillbarrett.debitsandcredits.database

import androidx.room.TypeConverter
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.sql.Date

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

}/*    @TypeConverter
    fun fromStringToJSON(stringList: ClothingList): String {
        return Gson().toJson(stringList)
    }
    @TypeConverter
    fun fromJSONToString(json: String): ClothingList {
        return Gson().fromJson(json,ClothingList::class.java)*/