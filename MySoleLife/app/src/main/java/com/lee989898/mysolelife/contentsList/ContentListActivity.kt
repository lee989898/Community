package com.lee989898.mysolelife.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lee989898.mysolelife.R

class ContentListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        val rv : RecyclerView = findViewById(R.id.rv)

        val items = ArrayList<ContentModel>()

        items.add(ContentModel("https://img4.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202105/22/onehomelife/20210522141402431wgbo.png", "title1"))
        items.add(ContentModel("https://img2.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202112/09/onehomelife/20211209012114500yscx.png", "title2"))
        items.add(ContentModel("https://img3.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202112/08/onehomelife/202112080134100198voo.png", "title3"))


        val rvAdapter = ContentRVAdapter(baseContext, items)
        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(this,2)

    }
}