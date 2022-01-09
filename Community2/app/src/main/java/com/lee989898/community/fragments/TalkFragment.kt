package com.lee989898.community.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.lee989898.community.R
import com.lee989898.community.board.BoardInsideActivity
import com.lee989898.community.board.BoardListLVAdapter
import com.lee989898.community.board.BoardModel
import com.lee989898.community.board.BoardWriteActivity
import com.lee989898.community.contentsList.ContentModel
import com.lee989898.community.databinding.FragmentTalkBinding
import com.lee989898.community.utils.FBRef


class TalkFragment : Fragment() {

    lateinit var binding: FragmentTalkBinding

    lateinit var boardRVAdapter : BoardListLVAdapter

    private val boardDataList = mutableListOf<BoardModel>()

    private val boardKeyList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalkBinding.inflate(layoutInflater)




        boardRVAdapter = BoardListLVAdapter(boardDataList)
        binding.boardListView.adapter = boardRVAdapter

        binding.boardListView.setOnItemClickListener{
            parent,view,position,id ->

//            intent.putExtra("title", boardDataList[positoion].title)
//            intent.putExtra("content", boardDataList[positoion].content)
//            intent.putExtra("time", boardDataList[positoion].time)

            val intent = Intent(context, BoardInsideActivity::class.java)
            intent.putExtra("key", boardKeyList[position])
            startActivity(intent)
        }


        binding.writeBtn.setOnClickListener {
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)

        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)

        }

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }


        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)

        }

        getFBBoardData()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun getFBBoardData(){
        val postListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {

            boardDataList.clear()

            for (dataModel in dataSnapshot.children) {


                val item = dataModel.getValue(BoardModel::class.java)
                boardDataList.add(item!!)
                boardKeyList.add(dataModel.key.toString())
            }

            boardKeyList.reverse()
            boardDataList.reverse()
            boardRVAdapter.notifyDataSetChanged()


        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
            Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
        }
    }
        FBRef.boardRef.addValueEventListener(postListener)

    }

}