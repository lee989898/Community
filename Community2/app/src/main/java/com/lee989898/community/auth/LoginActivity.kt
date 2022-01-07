package com.lee989898.community.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee989898.community.R
import com.lee989898.community.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val email = binding.emailArea.text.toString()
            val password = binding.passwordArea.text.toString()
        }

    }
}