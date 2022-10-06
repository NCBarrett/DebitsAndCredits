package com.neillbarrett.debitsandcredits

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.database.UsersTable
import java.sql.RowId

class UserListAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<UsersTable>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.userName

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_list_of_users, parent, false) as TextView
        return TextItemViewHolder(view)
    }

}

class UserListListener(val clickListener: (pkUserId: Long) -> Unit) {
    fun onClick(user: UsersTable) = clickListener(user.pkUserId)
}