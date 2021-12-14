package com.lee989898.mysolelife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee989898.mysolelife.R
import com.lee989898.mysolelife.databinding.ActivityBoardInsirdBinding

class BoardInsirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityBoardInsirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardInsirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val time = intent.getStringExtra("time")

        binding.titleArea.text = title
        binding.textArea.text = content
        binding.timeArea.text = time

    }
}