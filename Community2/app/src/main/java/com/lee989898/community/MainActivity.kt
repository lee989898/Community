package com.lee989898.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lee989898.community.auth.IntroActivity
import com.lee989898.community.setting.SettingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.settingBtn).setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

//        findViewById<Button>(R.id.logoutBtn).setOnClickListener {
//
//            auth.signOut()
//
//            val intent = Intent(this, IntroActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            startActivity(intent)
//
//        }



    }
}