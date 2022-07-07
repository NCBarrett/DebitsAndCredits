package com.neillbarrett.debitsandcredits.database

import androidx.room.*
import java.sql.Date

@Entity (tableName = "t_Transactions")
data class Transactions (
    @PrimaryKey (autoGenerate = true) val transId: Int,
    @ColumnInfo (name = "fkUserId") val fkUserId: Int,
    @ColumnInfo (name = "Date") val Date: Date,
    @ColumnInfo (name = "fkPaymentTypeId") val fkPaymentTypeId: Long,
    @ColumnInfo (name = "Debit") val Debit: Long?,
    @ColumnInfo (name = "Credit") val Credit: Long?,
    @ColumnInfo (name = "Balance") val Balance: Long,
    @ColumnInfo (name = "Comments") val Comments: String
)

/* MAPPING USERS LOOKUP TABLE TO TRANSACTIONS TABLE */
@Entity (tableName = "Users")
data class Users (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "pkUserId") val pkUserId: Int,
    @ColumnInfo (name = "UserName") val userName: String
        )

data class UserAndTransaction (
    @Embedded val trans: Transactions,
    @Relation(
        parentColumn = "fkUserId",
        entityColumn = "pkUserId"
    )
    val users: List<Users>
    )
/* MAPPING USERS LOOKUP TABLE TO TRANSACTIONS TABLE */

/*
@Entity
    (foreignKeys = [ForeignKey(entity = Transactions::class,
    parentColumns = arrayOf("fkPaymentType"),
    childColumns = arrayOf("typeId"),
    onDelete = ForeignKey.CASCADE)]
)
data class Types(
    @PrimaryKey @ColumnInfo (name = "typeId", index = true) val typeId: Int,
    @ColumnInfo (name = "pymtType") val pymtType: String
)*/
