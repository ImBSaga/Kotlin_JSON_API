package com.uda_kotlin.task4.ui

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.view.isVisible
import com.uda_kotlin.task4.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)



        if (isConnect() == true) {

            pb_news_detail.visibility = View.GONE

            val url = intent.getStringExtra("url")

            val webView = wv_news_detail

            webView.webViewClient = WebViewClient()
            webView.loadUrl("$url")

        } else {
            pb_news_detail.visibility = View.GONE
            Toast.makeText(this, "Device tidak Connect dengan Internet", Toast.LENGTH_SHORT).show()
        }
    }

    fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }
}