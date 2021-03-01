package com.uda_kotlin.task4

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.cardview.widget.CardView
import com.uda_kotlin.task4.adapter.NewsAdapter
import com.uda_kotlin.task4.model.Article
import com.uda_kotlin.task4.model.ResponseServer
import com.uda_kotlin.task4.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvCat1 = cv_cat_1
        val cvCat2 = cv_cat_2
        val cvCat3 = cv_cat_3
        val cvCat4 = cv_cat_4
        val cvCat5 = cv_cat_5





        if (isConnect() == true) {

            sv_news.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    val adpFilter = (rv_news_list.adapter as NewsAdapter).filter
                    adpFilter.filter(newText.toString())
                    Log.d("dap","$adpFilter")
                    return false
                }

            })

            operateCategorySelection(1)

            cvCat1.setOnClickListener { operateCategorySelection(1) }
            cvCat2.setOnClickListener { operateCategorySelection(2) }
            cvCat3.setOnClickListener { operateCategorySelection(3) }
            cvCat4.setOnClickListener { operateCategorySelection(4) }
            cvCat5.setOnClickListener { operateCategorySelection(5) }

            configNetworkAll()

        } else {
            pb_news_home.visibility = View.GONE
            Toast.makeText(this, "Device tidak Connect dengan Internet", Toast.LENGTH_SHORT).show()
        }


    }


    private fun showData(data: ArrayList<Article>?) {
        rv_news_list.adapter = NewsAdapter(data)
    }

    fun configNetworkAll() {

        ConfigNetwork.getRetrofit().getDataArticle().enqueue(object : Callback<ResponseServer> {
            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

                pb_news_home.visibility = View.GONE
                Log.d("error server", t.message!!)

            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                Log.d("response server", response.message())
                if (response.isSuccessful) {

                    pb_news_home.visibility = View.GONE
                    val status = response.body()?.status

                    if (status == "ok") {
                        val data = response.body()?.articles

                        showData(data)

                    } else {
                        Log.d("No response", response.message())
                    }
                }
            }
        })
    }

    fun configNetworkEngadget() {

        ConfigNetwork.getRetrofit().getEngadgetArticle().enqueue(object : Callback<ResponseServer> {
            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

                pb_news_home.visibility = View.GONE
                Log.d("error server", t.message!!)

            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                Log.d("response server", response.message())
                if (response.isSuccessful) {

                    pb_news_home.visibility = View.GONE
                    val status = response.body()?.status

                    if (status == "ok") {
                        val data = response.body()?.articles

                        showData(data)

                    } else {
                        Log.d("No response", response.message())
                    }
                }
            }
        })
    }

    fun configNetworkReuters() {

        ConfigNetwork.getRetrofit().getReutersArticle().enqueue(object : Callback<ResponseServer> {
            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

                pb_news_home.visibility = View.GONE
                Log.d("error server", t.message!!)

            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                Log.d("response server", response.message())
                if (response.isSuccessful) {

                    pb_news_home.visibility = View.GONE
                    val status = response.body()?.status

                    if (status == "ok") {
                        val data = response.body()?.articles

                        showData(data)

                    } else {
                        Log.d("No response", response.message())
                    }
                }
            }
        })
    }

    fun configNetworkArsTechnicia() {

        ConfigNetwork.getRetrofit().getArsTechniciaArticle().enqueue(object : Callback<ResponseServer> {
            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

                pb_news_home.visibility = View.GONE
                Log.d("error server", t.message!!)

            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                Log.d("response server", response.message())
                if (response.isSuccessful) {

                    pb_news_home.visibility = View.GONE
                    val status = response.body()?.status

                    if (status == "ok") {
                        val data = response.body()?.articles

                        showData(data)

                    } else {
                        Log.d("No response", response.message())
                    }
                }
            }
        })
    }

    fun configNetworkAllMashable() {

        ConfigNetwork.getRetrofit().getMashableArticle().enqueue(object : Callback<ResponseServer> {
            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

                pb_news_home.visibility = View.GONE
                Log.d("error server", t.message!!)

            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                Log.d("response server", response.message())
                if (response.isSuccessful) {

                    pb_news_home.visibility = View.GONE
                    val status = response.body()?.status

                    if (status == "ok") {
                        val data = response.body()?.articles

                        showData(data)

                    } else {
                        Log.d("No response", response.message())
                    }
                }
            }
        })
    }


    fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }

    private fun operateCategorySelection(position: Int) {
        val cvCat1 = cv_cat_1
        val cvCat2 = cv_cat_2
        val cvCat3 = cv_cat_3
        val cvCat4 = cv_cat_4
        val cvCat5 = cv_cat_5

        val tvCat1 = tv_cat_1
        val tvCat2 = tv_cat_2
        val tvCat3 = tv_cat_3
        val tvCat4 = tv_cat_4
        val tvCat5 = tv_cat_5

        tvCat1?.setTextColor(Color.BLACK)
        tvCat2?.setTextColor(Color.BLACK)
        tvCat3?.setTextColor(Color.BLACK)
        tvCat4?.setTextColor(Color.BLACK)
        tvCat5?.setTextColor(Color.BLACK)
        cvCat1?.setCardBackgroundColor(Color.WHITE)
        cvCat2?.setCardBackgroundColor(Color.WHITE)
        cvCat3?.setCardBackgroundColor(Color.WHITE)
        cvCat4?.setCardBackgroundColor(Color.WHITE)
        cvCat5?.setCardBackgroundColor(Color.WHITE)

        when (position) {
            1 -> {
                Log.d("Working", "1")
                cvCat1?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat1?.setTextColor(Color.WHITE)
                configNetworkAll()
            }
            2 -> {
                Log.d("Working", "2")
                cvCat2?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat2?.setTextColor(Color.WHITE)
                configNetworkEngadget()
            }
            3 -> {
                Log.d("Working", "3")
                cvCat3?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat3?.setTextColor(Color.WHITE)
                configNetworkReuters()
            }
            4 -> {
                Log.d("Working", "4")
                cvCat4?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat4?.setTextColor(Color.WHITE)
                configNetworkArsTechnicia()
            }
            5 -> {
                Log.d("Working", "5")
                cvCat5?.setCardBackgroundColor(Color.parseColor("#00BCD4"))
                tvCat5?.setTextColor(Color.WHITE)
                configNetworkAllMashable()
            }
        }
    }
}