package com.neillbarrett.debitsandcredits.database

import androidx.room.*
import java.sql.Date

@Entity (tableName = "DebitsAndCreditsTable")
data class DebitsAndCreditsTable (
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
@Entity (tableName = "UsersTable")
data class UsersTable (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "pkUserId") val pkUserId: Int,
    @ColumnInfo (name = "UserName") val userName: String
        )

data class UserAndTrans (
    @Embedded val user: UsersTable,
    @Relation(
        parentColumn = "pkUserId",
        entityColumn = "fkUserId"
    )
    val trans: List<DebitsAndCreditsDB>
)
/* MAPPING USERS LOOKUP TABLE TO TRANSACTIONS TABLE */

/* MAPPING PAYMENT TYPE LOOKUP TABLE TO TRANSACTIONS TABLE */
/*
@Entity
    (foreignKeys = [ForeignKey(entity = DebitsAndCreditsDB::class,
    parentColumns = arrayOf("fkPaymentType"),
    childColumns = arrayOf("typeId"),
    onDelete = ForeignKey.CASCADE)]
)
data class Type(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "typeId") val typeId: Int,
    @ColumnInfo (name = "pymtType") val pymtType: String
) */

/* MAPPING PAYMENT TYPE LOOKUP TABLE TO TRANSACTIONS TABLE */
