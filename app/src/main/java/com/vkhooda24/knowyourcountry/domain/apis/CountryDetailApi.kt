package com.vkhooda24.knowyourcountry.domain.apis

import com.vkhooda24.knowyourcountry.domain.model.CountryDetail
import io.reactivex.Observable

/**
 * Created by Vikram Hooda on 12/22/18.
 */
interface CountryDetailApi {

    fun getCountryDetail(countryName: String): Observable<List<CountryDetail>>
}
