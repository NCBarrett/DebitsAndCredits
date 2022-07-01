package com.neillbarrett.debitsandcredits.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.neillbarrett.debitsandcredits.Transactions
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [Transactions::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class TransactionsDB : RoomDatabase() {

    abstract fun Dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: TransactionsDB? = null

        fun getDatabase(context: Context): TransactionsDB {
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

        private fun buildDatabase(context: Context): TransactionsDB {
            return Room.databaseBuilder(
                context.applicationContext,
                TransactionsDB::class.java,
                "transaction_database"
            ).build()
        }
    }
}