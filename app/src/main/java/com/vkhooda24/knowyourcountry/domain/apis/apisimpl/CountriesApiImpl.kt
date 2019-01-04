package com.vkhooda24.knowyourcountry.domain.apis.apisimpl

import com.vkhooda24.knowyourcountry.app.AppConstants
import com.vkhooda24.knowyourcountry.domain.apis.CountriesApi
import com.vkhooda24.knowyourcountry.domain.model.Countries
import com.vkhooda24.knowyourcountry.domain.services.CountriesListService
import io.reactivex.Observable

/**
 * Created by Vikram Hooda on 12/22/18.
 */
class CountriesApiImpl(private val countriesListService: CountriesListService) : CountriesApi {

    override fun getCountriesList(regionName: String): Observable<List<Countries>> {
        return if (regionName.equals(AppConstants.REGION_ALL, ignoreCase = true)) {
            countriesListService.allCountries
        } else {
            countriesListService.getRegionCountries(regionName)
        }
    }
}
