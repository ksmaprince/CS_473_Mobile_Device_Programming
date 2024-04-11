package com.khun.sportnewsandinformation.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.khun.sportnewsandinformation.MainActivity
import com.khun.sportnewsandinformation.data.models.User
import com.khun.sportnewsandinformation.data.users
import com.khun.sportnewsandinformation.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Use: Username: admin Password: 123 to test or register new account.", Toast.LENGTH_LONG).show()

        binding.contentLogin.btnLogin.setOnClickListener {
            val username = binding.contentLogin.edtUsername.text.toString()
            val password = binding.contentLogin.edtPassword.text.toString()
            if (users.contains(User(username, password))){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Alert")
                builder.setMessage("Invalid Username and Password")
                builder.setPositiveButton("OK"){ dialog, which ->
                    dialog.dismiss()
                }
                builder.create().show()
            }
        }

        binding.contentLogin.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.contentLogin.ivFacebook.setOnClickListener {
            Toast.makeText(this, "Integrate Facebook login in the future.", Toast.LENGTH_LONG).show()
        }

        binding.contentLogin.ivGoogle.setOnClickListener {
            Toast.makeText(this, "Integrate Google login in the future.", Toast.LENGTH_LONG).show()
        }

        binding.contentLogin.ivTwitter.setOnClickListener {
            Toast.makeText(this, "Integrate Twitter login in the future.", Toast.LENGTH_LONG).show()
        }
    }
}