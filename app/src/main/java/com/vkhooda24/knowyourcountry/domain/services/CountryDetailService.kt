package com.vkhooda24.knowyourcountry.domain.services

import com.vkhooda24.knowyourcountry.domain.model.CountryDetail
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Vikram Hooda on 12/22/18.
 */
interface CountryDetailService {

    @GET("name/{countryName}?fullText=true")
    fun getCountryDetail(@Path("countryName") countryName: String): Observable<List<CountryDetail>>
}