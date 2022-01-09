package com.lee989898.community.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee989898.community.R
import com.lee989898.community.contentsList.BookmarkModel
import com.lee989898.community.databinding.ActivityBoardWriteBinding
import com.lee989898.community.utils.FBAuth
import com.lee989898.community.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {

    lateinit var binding: ActivityBoardWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityBoardWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.writeBtn.setOnClickListener {

            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()


            FBRef.boardRef
                .push()
                .setValue(BoardModel(title, content, uid, time))

            finish()

        }


    }
}