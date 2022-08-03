package com.neillbarrett.debitsandcredits.database

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.sql.Date

@Entity (tableName = "DebitsAndCreditsTable",
    indices = [Index(value = ["fkUserId", "fkPaymentTypeId"], unique = true),
                Index(value = ["transId"])]
    )
data class DebitsAndCreditsTable (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "transId")
    val transId: Long,
    @ColumnInfo (name = "fkUserId", index = true) val fkUserId: Long,
    @ColumnInfo (name = "Date") val Date: Date,
    @ColumnInfo (name = "fkPaymentTypeId", index = true) val fkPaymentTypeId: Long /* ,
    @ColumnInfo (name = "Debit") val Debit: Long?,
    @ColumnInfo (name = "Credit") val Credit: Long?,
    @ColumnInfo (name = "Balance") val Balance: Long,
    @ColumnInfo (name = "Comments") val Comments: String */
)

/* MAPPING USERS LOOKUP TABLE TO TRANSACTIONS TABLE */
@Entity (tableName = "UsersTable" /*,
    foreignKeys = [ForeignKey(
        entity = DebitsAndCreditsTable::class,
        parentColumns = ["fkUserId"],
        childColumns = ["pkUserId"],
        onDelete = CASCADE)] */)
data class UsersTable (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "pkUserId") val pkUserId: Int,
    @ColumnInfo (name = "UserName") val userName: String
        )

/* data class UserAndTrans (
    @Embedded val user: UsersTable,
    @Relation(
        parentColumn = "pkUserId",
        entityColumn = "fkUserId"
    )
    val trans: List<DebitsAndCreditsDB>
) */
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
