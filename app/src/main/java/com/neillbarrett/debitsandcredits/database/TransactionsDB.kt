package com.neillbarrett.debitsandcredits.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [UsersTable::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class DebitsAndCreditsDB : RoomDatabase() {

    /**
     * Connects the database to the DAO.
     */
    abstract val dao: Dao

    companion object {
        @Volatile
        private var INSTANCE: DebitsAndCreditsDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): DebitsAndCreditsDB {
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