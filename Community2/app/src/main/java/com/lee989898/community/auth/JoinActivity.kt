package com.lee989898.community.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lee989898.community.MainActivity
import com.lee989898.community.R
import com.lee989898.community.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.joinBtn.setOnClickListener {

            var isGoToJoin = true

            val email = binding.emailArea.text.toString()
            val password = binding.passwordArea.text.toString()
            val passwordCheck = binding.passwordCheckArea.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }
            if (passwordCheck.isEmpty()) {
                Toast.makeText(this, "비밀번호확인을 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }


            if (password != passwordCheck) {
                Toast.makeText(this, "비밀번호를 똑같이 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (password.length < 6) {
                Toast.makeText(this, "비밀번호를 6자리 이상 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (isGoToJoin) {

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)

                        } else {
                            Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show()

                        }
                    }
            }


        }


    }
}