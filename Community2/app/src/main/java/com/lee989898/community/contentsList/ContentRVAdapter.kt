package com.lee989898.community.contentsList

import android.content.Context
import android.content.Intent
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lee989898.community.R
import com.lee989898.community.utils.FBAuth
import com.lee989898.community.utils.FBRef

class ContentRVAdapter(val context: Context, val items: ArrayList<ContentModel>, val keyList: ArrayList<String>)
    : RecyclerView.Adapter<ContentRVAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ContentRVAdapter.ViewHolder, position: Int) {

        holder.bindItems(items[position], keyList[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindItems(item: ContentModel, key: String){

            itemView.setOnClickListener{

                Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ContentShowActivity::class.java)
                intent.putExtra("url", item.webUrl)
                itemView.context.startActivity(intent)
            }

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

            bookmarkArea.setOnClickListener {
                Log.d("ContentRVAdapter", FBAuth.getUid())
                Toast.makeText(context, key,Toast.LENGTH_SHORT).show()

                FBRef.bookmarkRef.child(FBAuth.getUid()).child(key).setValue("Good")

            }

            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)



        }

    }


}