package com.lee989898.mysolelife.fragments

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
import com.lee989898.mysolelife.R
import com.lee989898.mysolelife.board.BoardInsirdActivity
import com.lee989898.mysolelife.board.BoardListRVAdapter
import com.lee989898.mysolelife.board.BoardModel
import com.lee989898.mysolelife.board.BoardWriteActivity
import com.lee989898.mysolelife.contentsList.ContentModel
import com.lee989898.mysolelife.databinding.FragmentTalkBinding
import com.lee989898.mysolelife.utils.FBRef


class TalkFragment : Fragment() {

    lateinit var binding: FragmentTalkBinding

    private val boardDataList = mutableListOf<BoardModel>()
    private val boardKeyList = mutableListOf<String>()

    private lateinit var boardRVAdapter: BoardListRVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalkBinding.inflate(layoutInflater)

        boardRVAdapter = BoardListRVAdapter(boardDataList)
        binding.boardListView.adapter = boardRVAdapter

        binding.boardListView.setOnItemClickListener{
            parent, view, positon,id ->

//            intent.putExtra("title", boardDataList[positon].title)
//            intent.putExtra("content", boardDataList[positon].content)
//            intent.putExtra("time", boardDataList[positon].time)


            val intent = Intent(context, BoardInsirdActivity::class.java)
            intent.putExtra("key", boardKeyList[positon])
            startActivity(intent)

        }

        binding.writeBtn.setOnClickListener {
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }

        getFBBoardDate()

        return binding.root
    }

    private fun getFBBoardDate(){

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

            }
        }
        FBRef.boardRef.addValueEventListener(postListener)

    }


}