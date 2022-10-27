package com.neillbarrett.debitsandcredits.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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

        fun getDatabase(context: Context, scope: CoroutineScope): DebitsAndCreditsDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DebitsAndCreditsDB::class.java,
                    "DebitsAndCredits"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

/*    // As a test example
    private class UsersListCallback (private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var userDao = database.Dao()

                    userDao.deleteUsers()

                    var user = UsersTable(0, "KnightMare")
                    userDao.insertUser()
                }

            }
        }
    }*/
}