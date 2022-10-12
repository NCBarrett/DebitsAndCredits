package com.neillbarrett.debitsandcredits

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UsersTable::class], version = 1, exportSchema = true)
abstract class TransactionsDB : RoomDatabase() {
    abstract val userListDao: DebitsAndCreditsDao

    companion object{
        @Volatile
        private var INSTANCE: TransactionsDB? = null

        fun getInstance(context: Context): TransactionsDB{
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance =
                    Room.databaseBuilder(context.applicationContext, TransactionsDB::class.java, "DebitsAndCredits")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}