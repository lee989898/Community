package com.lee989898.mysolelife.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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

        return view!!

    }
}