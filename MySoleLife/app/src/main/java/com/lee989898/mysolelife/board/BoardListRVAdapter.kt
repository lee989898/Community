package com.lee989898.mysolelife.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.lee989898.mysolelife.R

class BoardListRVAdapter(val boardList: MutableList<BoardModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return boardList.size

    }

    override fun getItem(p0: Int): Any {
        return boardList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
        if(view == null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent, false)
        }

        val title = view?.findViewById<TextView>(R.id.titleArea)
        title!!.text = boardList[position].title

        val content = view?.findViewById<TextView>(R.id.contentArea)
        content!!.text = boardList[position].content

        val time = view?.findViewById<TextView>(R.id.timeArea)
        time!!.text = boardList[position].time

        return view!!

    }
}