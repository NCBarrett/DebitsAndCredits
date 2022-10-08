package com.neillbarrett.debitsandcredits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.database.UsersTable
import org.w3c.dom.Text
import java.sql.RowId

class UserListAdapter: ListAdapter<UsersTable, UserListAdapter.ViewHolder>(UserListDiffCallBack()) {

    class UserListDiffCallBack : DiffUtil.ItemCallback<UsersTable>(){
        override fun areItemsTheSame(oldItem: UsersTable, newItem: UsersTable): Boolean {
            return oldItem.pkUserId == newItem.pkUserId
        }

        override fun areContentsTheSame(oldItem: UsersTable, newItem: UsersTable): Boolean {
            return oldItem == newItem
        }
    }

    /*var data = listOf<UsersTable>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_list_of_users, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        //holder.textView.text = item.userName
        val res = holder.itemView.context.resources
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val userName: TextView = itemView.findViewById(R.id.tv_UserName)
    }
}

class UserListListener(val clickListener: (pkUserId: Long) -> Unit) {
    fun onClick(user: UsersTable) = clickListener(user.pkUserId)
}