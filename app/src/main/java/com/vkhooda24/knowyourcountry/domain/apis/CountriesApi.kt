package com.vkhooda24.knowyourcountry.domain.apis

import com.vkhooda24.knowyourcountry.domain.model.Countries
import io.reactivex.Observable

/**
 * Created by Vikram Hooda on 12/22/18.
 */
interface CountriesApi {

    fun getCountriesList(regionName: String): Observable<List<Countries>>
}
