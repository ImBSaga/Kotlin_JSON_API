package com.uda_kotlin.task4.network

import com.uda_kotlin.task4.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("v2/everything?q=apple&from=2021-02-23&to=2021-02-23&sortBy=popularity&apiKey=fe01716aa8384919986cf2e7379cf045")
    fun getDataArticle(): Call<ResponseServer>

    @GET("v2/everything?q=apple&from=2021-02-23&to=2021-02-23&sortBy=popularity&sources=engadget&apiKey=fe01716aa8384919986cf2e7379cf045")
    fun getEngadgetArticle(): Call<ResponseServer>

    @GET("v2/everything?q=apple&from=2021-02-23&to=2021-02-23&sortBy=popularity&sources=reuters&apiKey=fe01716aa8384919986cf2e7379cf045")
    fun getReutersArticle(): Call<ResponseServer>

    @GET("v2/everything?q=apple&from=2021-02-23&to=2021-02-23&sortBy=popularity&sources=ars-technica&apiKey=fe01716aa8384919986cf2e7379cf045")
    fun getArsTechniciaArticle(): Call<ResponseServer>

    @GET("v2/everything?q=apple&from=2021-02-23&to=2021-02-23&sortBy=popularity&sources=mashable&apiKey=fe01716aa8384919986cf2e7379cf045")
    fun getMashableArticle(): Call<ResponseServer>

}