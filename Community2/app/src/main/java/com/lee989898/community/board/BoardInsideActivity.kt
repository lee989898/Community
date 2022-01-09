package com.lee989898.community.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee989898.community.R
import com.lee989898.community.databinding.ActivityBoardInsideBinding

class BoardInsideActivity : AppCompatActivity() {

    lateinit var binding: ActivityBoardInsideBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityBoardInsideBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")
        val time = intent.getStringExtra("time")

        binding.titleArea.text = title
        binding.textArea.text = content
        binding.timeArea.text = time

    }
}