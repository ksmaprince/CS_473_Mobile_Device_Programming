package com.khun.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.khun.ecommerceapp.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            val name = binding.edtName.text.toString()
            val mobileEmail = binding.edtMobileEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val rePassword = binding.edtRePassword.text.toString()
            if (name.isEmpty() || mobileEmail.isEmpty() || password.isEmpty() || rePassword.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            } else if (password != rePassword){
                Toast.makeText(this, "Password doesn't match", Toast.LENGTH_LONG).show()
            } else if (isUserAlreadyExist(mobileEmail)){
                Toast.makeText(this, "User already exist", Toast.LENGTH_LONG).show()
            }else{
                users.add(User(name, mobileEmail, password))
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }
        }
    }

    private fun isUserAlreadyExist(emailPhone: String): Boolean{
        users.forEach {
            if (it.emailPhone == emailPhone) return true
        }
        return false
    }
}