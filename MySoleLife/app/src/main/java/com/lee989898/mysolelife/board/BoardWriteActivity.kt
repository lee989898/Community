package com.lee989898.mysolelife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lee989898.mysolelife.R
import com.lee989898.mysolelife.contentsList.BookmarkModel
import com.lee989898.mysolelife.databinding.ActivityBoardWriteBinding
import com.lee989898.mysolelife.utils.FBAuth
import com.lee989898.mysolelife.utils.FBRef
import java.text.SimpleDateFormat
import java.util.*

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
                .setValue(BoardModel(title,content,uid,time))

            Toast.makeText(this, "게시글 입력 완료", Toast.LENGTH_SHORT).show()

            finish()





        }


    }
}