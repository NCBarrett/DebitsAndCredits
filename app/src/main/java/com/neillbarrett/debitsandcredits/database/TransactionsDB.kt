package com.neillbarrett.debitsandcredits.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [DebitsAndCreditsTable::class, UsersTable::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class DebitsAndCreditsDB : RoomDatabase() {

    abstract fun Dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: DebitsAndCreditsDB ? = null

        fun getDatabase(context: Context): DebitsAndCreditsDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DebitsAndCreditsDB::class.java,
                    "DebitsAndCredits"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}