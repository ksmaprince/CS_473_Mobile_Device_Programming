package com.khun.ecommerceapp

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.khun.ecommerceapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            val email = binding.edtEmailPhone.text.toString()
            val password = binding.edtPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all field", Toast.LENGTH_LONG).show()
            } else {
                if (isLoginSuccess(email, password)) {
                    startActivity(Intent(this, ShoppingCategoryActivity::class.java))
                } else {
                    Toast.makeText(this, "Login Fail!!!", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnCreateNewAcc.setOnClickListener {
            startActivity(Intent(this, CreateAccountActivity::class.java))
        }

        binding.chkShowPassword.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) binding.edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            else binding.edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    private fun isLoginSuccess(email: String, password: String): Boolean {
        users.forEach {
            if (it.emailPhone == email && it.password == password) return true
        }
        return false
    }
}