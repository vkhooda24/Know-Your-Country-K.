package com.vkhooda24.knowyourcountry.viewmodel.viewmodelImpl

import com.vkhooda24.knowyourcountry.domain.apis.CountriesApi
import com.vkhooda24.knowyourcountry.domain.model.Countries
import com.vkhooda24.knowyourcountry.viewmodel.CountriesViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vikram Hooda on 12/22/18.
 */
class CountriesViewModelImpl(private val countriesApi: CountriesApi) : CountriesViewModel {

    override fun getCountriesList(regionName: String): Observable<List<Countries>> {
        return countriesApi.getCountriesList(regionName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
