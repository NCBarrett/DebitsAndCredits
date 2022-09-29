package com.neillbarrett.debitsandcredits

import com.neillbarrett.debitsandcredits.database.UsersTable
import java.sql.RowId

class UserListAdapter() {

}

class UserListListener(val clickListener: (pkUserId: Long) -> Unit) {
    fun onClick(user: UsersTable) = clickListener(user.pkUserId)
}