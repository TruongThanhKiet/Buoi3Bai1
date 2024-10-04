package com.example.buoi3bai1

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var userInfoAdapter: UserInfoAdapter
    private val userList = mutableListOf<UserInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fullNameEditText: EditText = findViewById(R.id.fullNameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val genderRadioGroup: RadioGroup = findViewById(R.id.genderRadioGroup)
        val termsCheckBox: CheckBox = findViewById(R.id.termsCheckBox)
        val saveButton: Button = findViewById(R.id.saveButton)
        val userInfoRecyclerView: RecyclerView = findViewById(R.id.userInfoRecyclerView)

        userInfoAdapter = UserInfoAdapter(userList)
        userInfoRecyclerView.adapter = userInfoAdapter
        userInfoRecyclerView.layoutManager = LinearLayoutManager(this)

        saveButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()

            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.maleRadioButton -> "Nam"
                R.id.femaleRadioButton -> "Nữ"
                else -> "Khác"
            }

            if (termsCheckBox.isChecked) {
                val userInfo = UserInfo(fullName, email, phone, gender)
                userList.add(userInfo)
                userInfoAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Bạn phải đồng ý với điều khoản sử dụng", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
