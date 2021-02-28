package com.uda_kotlin.task4.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uda_kotlin.task4.R
import com.uda_kotlin.task4.model.Article
import com.uda_kotlin.task4.ui.NewsDetailActivity
import kotlinx.android.synthetic.main.item_news_list.view.*


class NewsAdapter(var data: ArrayList<Article>?) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivNewsImg = itemView.iv_item_news_img
        val tvPenulis = itemView.tv_item_nama_penulis
        val tvSource = itemView.tv_item_source

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_list, parent, false)

        val holder = NewsHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {

        holder.tvPenulis.text = data?.get(position)?.author
        holder.tvSource.text = data?.get(position)?.source?.name

        Glide.with(holder.itemView.context).load(data?.get(position)?.urlToImage)
            .into(holder.ivNewsImg)

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, NewsDetailActivity::class.java)
            intent.putExtra("url", data?.get(position)?.url)


            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

}