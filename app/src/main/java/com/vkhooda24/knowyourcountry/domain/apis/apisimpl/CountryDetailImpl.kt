package com.vkhooda24.knowyourcountry.domain.apis.apisimpl

import com.vkhooda24.knowyourcountry.domain.apis.CountryDetailApi
import com.vkhooda24.knowyourcountry.domain.model.CountryDetail
import com.vkhooda24.knowyourcountry.domain.services.CountryDetailService
import io.reactivex.Observable

/**
 * Created by Vikram Hooda on 12/22/18.
 */
class CountryDetailImpl(private val countryDetailService: CountryDetailService) : CountryDetailApi {

    override fun getCountryDetail(countryName: String): Observable<List<CountryDetail>> {
        return countryDetailService.getCountryDetail(countryName)
    }
}
