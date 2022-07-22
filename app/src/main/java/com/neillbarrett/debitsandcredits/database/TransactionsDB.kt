package com.neillbarrett.debitsandcredits.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [DebitsAndCreditsDB::class, Users::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class DebitsAndCreditDB : RoomDatabase() {

    abstract fun Dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: DebitsAndCreditDB? = null

        fun getDatabase(context: Context): DebitsAndCreditsDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                kotlin.synchronized(this){
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            //Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): DebitsAndCreditsDB {
            return Room.databaseBuilder(
                context.applicationContext,
                DebitsAndCreditsDB::class.java,
                "transaction_database"
            ).build()
        }
    }
}