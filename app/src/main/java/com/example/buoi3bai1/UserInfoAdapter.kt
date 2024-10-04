package com.example.buoi3bai1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class UserInfo(val fullName: String, val email: String, val phone: String, val gender: String)

class UserInfoAdapter(private val userList: List<UserInfo>) :
    RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder>() {

    class UserInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullNameTextView: TextView = itemView.findViewById(R.id.fullNameTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)
        val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_info_item, parent, false)
        return UserInfoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        val userInfo = userList[position]
        holder.fullNameTextView.text = userInfo.fullName
        holder.emailTextView.text = userInfo.email
        holder.phoneTextView.text = userInfo.phone
        holder.genderTextView.text = userInfo.gender
    }

    override fun getItemCount(): Int = userList.size
}
