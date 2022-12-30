package com.neillbarrett.debitsandcredits

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.database.UsersTable
import com.neillbarrett.debitsandcredits.databinding.ActivityManageUsersBinding

val inAdapter: String = "In UserListAdapter "

class UserListAdapter(private val userSelect: (UsersTable?) -> Unit) :
    ListAdapter<UsersTable, UserListAdapter.UserViewHolder>(UsersComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.UserViewHolder {

        Log.w(inAdapter,"OnCreateViewHolder started")

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_manage_users, parent, false)
        return UserViewHolder.create(parent)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(usersTable: UsersTable?, userSelect: (UsersTable?) -> Unit) {

            Log.w(inAdapter,"UserViewHolder started")

            itemView.setOnClickListener { View.OnClickListener {
/*                if (View.) { }*/

                val nameSelected = userSelect(usersTable)
                //userSelect(usersTable)
                //need to assign the result of the clicklistener to the editText
                //binding.etEditName.setText(R.layout.activity_list_of_users.toString())
            }}
        }

        companion object {
            fun create(parent: ViewGroup) : UserViewHolder {

                Log.w(inAdapter,"Companion object 'Create' function started")

                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_manage_users, parent, false)
                return UserViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Log.w(inAdapter,"OnBindViewHolder started")

        val current = getItem(position)
        holder.bind(current, userSelect)
    }

    class UsersComparator : DiffUtil.ItemCallback<UsersTable>() {
        override fun areItemsTheSame(oldItem: UsersTable, newItem: UsersTable): Boolean {
            Log.w(inAdapter,"areItemsTheSame function started")
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UsersTable, newItem: UsersTable): Boolean {
            Log.w(inAdapter,"areContentsTheSame function started")
            return oldItem.userName == newItem.userName
        }
    }
}