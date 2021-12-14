package com.lee989898.mysolelife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee989898.mysolelife.R

class BoardInsirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_insird)

        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val time = intent.getStringExtra("time")

    }
}