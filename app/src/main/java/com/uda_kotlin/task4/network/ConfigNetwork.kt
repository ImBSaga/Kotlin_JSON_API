package com.uda_kotlin.task4.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getRetrofit() : NewsService{

            val retrofit = Retrofit.Builder()
                .baseUrl("http://newsapi.org/")
                //add Converter sesuai contoh Gson
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(NewsService::class.java)

            return service
        }
    }

}