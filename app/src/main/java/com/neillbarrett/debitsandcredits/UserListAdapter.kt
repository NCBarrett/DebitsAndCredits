package com.neillbarrett.debitsandcredits

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neillbarrett.debitsandcredits.database.UsersTable
//import com.neillbarrett.debitsandcredits.generated.callback.OnClickListener
import kotlinx.coroutines.NonDisposableHandle.parent

// class UserListAdapter() : ListAdapter<UsersTable, UserListAdapter.UserViewHolder>(UsersComparator()) {
class UserListAdapter(val userList: Array<String>) :
    ListAdapter<UsersTable, UserListAdapter.UserViewHolder>(UsersComparator()) {

    // IF YOU TOOK OUT "UsersTable" FROM LISTADAPTER, WOULD YOU HAVE THE SAME PROBLEMS?
    // - BETTER YET, USE var onItemClick: ((UsersTable) -> Unit)? = null AS THE TYPE?
    //
    // ADD
    //
    // YOU NEED TO PASS A CONSTRUCTOR FOR THE -CLICKLISTENER-

    //private lateinit var onItemClickListener: OnItemClickListener
    var onItemClick: ((UsersTable) -> Unit)? = null
    var users: List<UsersTable> = emptyList()

/*    val items: MutableList<String> = arrayListOf()*/

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = getItem(position)

        holder.bind(currentUser.userName)

        class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var userView: TextView = itemView.findViewById(R.id.textView)

            init {
                itemView.setOnClickListener {
                    val adapterPos = adapterPosition
                    if (adapterPos != RecyclerView.NO_POSITION) {
                        onItemClick?.invoke(users[adapterPosition])
                    }
                }
            }

            fun bind(text: String?) {
                userView.text = text
            }
        }
/*        return UserViewHolder(holder.itemView).onClick { view, position, type ->
            val item = items.get(position)
        }*/
/*        holder.itemView.setOnClickListener {
            //currentUser?.let { it1 -> onClickListener.onClick(it) }
            //currentUser?.let { it1 -> onClickListener.invoke(it1) }
        }
        holder.itemView.setOnClickListener {View ->
            View.setOnClickListener {  }
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_list_of_users, parent, false)
        //return UserViewHolder.create(parent)

        return UserViewHolder(view)
    }

/*    fun setOnClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }*/

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var userView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            userView.text = text
        }
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

/*fun <T : RecyclerView.ViewHolder> T.onClick(event: (view: View, position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(it, getAdapterPosition(), getItemViewType())
    }
    return this
}*/

/*        companion object {
            fun create(parent: ViewGroup) : UserViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_list_of_users, parent, false)
                return UserViewHolder(view)
            }
        }*/