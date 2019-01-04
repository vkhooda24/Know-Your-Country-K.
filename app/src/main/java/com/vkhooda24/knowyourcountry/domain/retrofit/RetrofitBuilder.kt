package com.vkhooda24.knowyourcountry.domain.retrofit

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Vikram Hooda on 12/22/18.
 */
object RetrofitBuilder {

    val BASE_URL: String = "https://restcountries.eu/rest/v2/"

    fun build(): Retrofit = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }.build()
}