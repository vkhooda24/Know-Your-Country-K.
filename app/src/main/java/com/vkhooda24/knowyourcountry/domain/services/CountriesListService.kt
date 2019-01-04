package com.vkhooda24.knowyourcountry.domain.services

import com.vkhooda24.knowyourcountry.domain.model.Countries
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Vikram Hooda on 12/22/18.
 */
interface CountriesListService {

//    @GET("region/{regionName}")
//    abstract fun getRegionCountries(@Path("regionName") regionName: String): Observable<List<Countries>>
//
//    @GET("all")
//    abstract fun getAllCountries(): Observable<List<Countries>>
//

//    @GET("all")
//    fun getAllCountries(): Observable<List<Countries>>

    //OR
    @get:GET("all")
    val allCountries: Observable<List<Countries>>

    @GET("region/{regionName}")
    fun getRegionCountries(@Path("regionName") regionName: String): Observable<List<Countries>>
}
