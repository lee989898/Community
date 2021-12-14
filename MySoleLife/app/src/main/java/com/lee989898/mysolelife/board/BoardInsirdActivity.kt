package com.lee989898.mysolelife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.lee989898.mysolelife.R
import com.lee989898.mysolelife.databinding.ActivityBoardInsirdBinding
import com.lee989898.mysolelife.utils.FBRef

class BoardInsirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityBoardInsirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardInsirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val title = intent.getStringExtra("title")
//        val content = intent.getStringExtra("content")
//        val time = intent.getStringExtra("time")
//
//        binding.titleArea.text = title
//        binding.textArea.text = content
//        binding.timeArea.text = time

        val key = intent.getStringArrayExtra("key")

        getBoardData(key.toString())

    }

    private fun getBoardData(key : String){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {


               val dataModel = dataSnapshot.getValue(BoardModel::class.java)


                if (dataModel != null) {
                    binding.titleArea.text = dataModel.title
                    binding.textArea.text = dataModel.content
                    binding.timeArea.text = dataModel.time
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.boardRef.child(key).addValueEventListener(postListener)

    }

    }
