package com.khun.sportnewsandinformation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.khun.sportnewsandinformation.data.models.User
import com.khun.sportnewsandinformation.data.users
import com.khun.sportnewsandinformation.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val userName = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            val confirmPassword = binding.edtConfirmedPassword.text.toString()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alert")

            if (userName.isNullOrBlank() || password.isNullOrBlank() || confirmPassword.isNullOrBlank()){
                builder.setMessage("All fields are required to fill.")
                builder.setPositiveButton("OK"){ dialog, which ->
                    dialog.dismiss()
                }
            } else if(password != confirmPassword){
                builder.setMessage("Passwords doesn't match.")
                builder.setPositiveButton("OK"){ dialog, which ->
                    dialog.dismiss()
                }
            }else{
                users.add(User(userName, password))
                builder.setMessage("New user created succeffully. Please login again.")
                builder.setPositiveButton("OK"){ dialog, which ->
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
            builder.create().show()
        }
    }
}