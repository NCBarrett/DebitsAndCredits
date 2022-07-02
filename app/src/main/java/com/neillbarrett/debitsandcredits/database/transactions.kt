package com.neillbarrett.debitsandcredits

import androidx.room.*
import java.sql.Date

@Entity (tableName = "t_Transactions")
data class Transactions (
    @PrimaryKey val id: Int,
    @ColumnInfo (name = "fkUser") val userId: Int,
    @ColumnInfo (name = "Date") val Date: Date,
    @ColumnInfo (name = "fkPaymentType") val PymtType: Long,
    @ColumnInfo (name = "Debit") val Debit: Long?,
    @ColumnInfo (name = "Credit") val Credit: Long?,
    @ColumnInfo (name = "Balance") val Balance: Long,
    @ColumnInfo (name = "Comments") val Comments: String
)

@Entity
    (foreignKeys = [ForeignKey(entity = Transactions::class,
    parentColumns = arrayOf("fkUser"),
    childColumns = arrayOf("userId"),
    onDelete = ForeignKey.CASCADE)]
)
data class Users (
    @PrimaryKey val userId: Int,
    @ColumnInfo (name = "UserName") val userName: String
        )

@Entity
    (foreignKeys = [ForeignKey(entity = Transactions::class,
    parentColumns = arrayOf("fkPaymentType"),
    childColumns = arrayOf("typeId"),
    onDelete = ForeignKey.CASCADE)]
)
data class Types(
    @PrimaryKey val typeId: Int,
    @ColumnInfo (name = "pymtType") val pymtType: String
)