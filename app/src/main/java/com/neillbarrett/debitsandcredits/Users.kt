package com.neillbarrett.debitsandcredits

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity (tableName = "t_Transactions")
data class Transactions (
    @PrimaryKey val id: Int,
    @ColumnInfo (name = "fkUser") val userId: Int,
    @ColumnInfo (name = "Date") val Date: Long,
    @ColumnInfo (name = "fkPaymentType") val PymtType: Long,
    @ColumnInfo (name = "Debit") val Debit: Long?,
    @ColumnInfo (name = "Credit") val Credit: Long?,
    @ColumnInfo (name = "Balance") val Balance: Long
)

@Entity (tableName = "t_Users")
data class Users (
    @Relation(
        parentColumn = "fkUser",
        entityColumn = "pkId"
    )
    val users: List<Users>

        )