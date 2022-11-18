package com.neillbarrett.debitsandcredits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.database.UsersTable
import com.neillbarrett.debitsandcredits.databinding.ActivityManageUsersBinding

class UserListAdapter(private val userSelect: (UsersTable?) -> Unit) :
    ListAdapter<UsersTable, UserListAdapter.UserViewHolder>(UsersComparator()) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, userSelect)
    }

    class UserViewHolder(private val binding: ActivityManageUsersBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(usersTable: UsersTable?, userSelect: (UsersTable?) -> Unit) {

            binding.root.setOnClickListener( View.OnClickListener {
                //val nameSelected = userSelect(usersTable)
                userSelect(usersTable)
                //need to assign the result of the clicklistener to the editText
                binding.etEditName.setText(R.layout.activity_list_of_users.toString())
            })
        }

        companion object {
            fun create(parent: ViewGroup) : UserViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_manage_users, parent, false)
                return UserViewHolder(ActivityManageUsersBinding.bind(view))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_manage_users, parent, false)
        return UserViewHolder.create(parent)
    }

    class UsersComparator : DiffUtil.ItemCallback<UsersTable>() {
        override fun areItemsTheSame(oldItem: UsersTable, newItem: UsersTable): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UsersTable, newItem: UsersTable): Boolean {
            return oldItem.userName == newItem.userName
        }
    }
}