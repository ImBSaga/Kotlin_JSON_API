package com.uda_kotlin.task4.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uda_kotlin.task4.R
import com.uda_kotlin.task4.model.Article
import com.uda_kotlin.task4.ui.NewsDetailActivity
import kotlinx.android.synthetic.main.item_news_list.view.*
import java.util.*
import kotlin.math.log


class NewsAdapter(private var data: ArrayList<Article>?) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>(),
    Filterable {

    var newsFilterList: ArrayList<Article>?

    init {
        newsFilterList = data
    }


    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivNewsImg = itemView.iv_item_news_img
        var tvAuthor = itemView.tv_item_nama_penulis
        var tvSource = itemView.tv_item_source

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_list, parent, false)

        val holder = NewsHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {


        holder.tvAuthor.text = newsFilterList?.get(position)?.author
        holder.tvSource.text = newsFilterList?.get(position)?.source?.name

        Glide.with(holder.itemView.context).load(newsFilterList?.get(position)?.urlToImage)
            .into(holder.ivNewsImg)

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, NewsDetailActivity::class.java)
            intent.putExtra("url", newsFilterList?.get(position)?.url)


            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return newsFilterList?.size ?: 0
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults? {


                val charSearch = constraint.toString()
                Log.d("te", "$charSearch")
                if (charSearch.isEmpty()) {
                    newsFilterList = data
                } else {
                    val resultList = ArrayList<Article>()
                    for (row in data?.indices!!) {
                        if (data?.get(row)?.author?.toLowerCase()
                                ?.contains(charSearch.toLowerCase()) == true
                        ) {
                            val article: Article = data!!.get(row)
                            resultList.add(article)
                            Log.d("da","${data?.get(row)?.author}")
                        }
                    }
                    newsFilterList = resultList
                    Log.d("da","$newsFilterList")
                }
                val filterResults = FilterResults()
                filterResults.values = newsFilterList
                Log.d("da","$filterResults")
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                newsFilterList = results?.values as ArrayList<Article>
                notifyDataSetChanged()
            }

        }
    }

}