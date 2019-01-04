package com.vkhooda24.knowyourcountry.viewmodel.viewmodelImpl

import com.vkhooda24.knowyourcountry.domain.apis.CountryDetailApi
import com.vkhooda24.knowyourcountry.domain.model.CountryDetail
import com.vkhooda24.knowyourcountry.viewmodel.CountryDetailViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.observable.ObservableFromIterable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vikram Hooda on 12/22/18.
 */
class CountryDetailViewModelImpl(private val countryDetailApi: CountryDetailApi) : CountryDetailViewModel {

    override fun getCountryDetail(countryName: String): Observable<CountryDetail> {
        return countryDetailApi.getCountryDetail(countryName)
            .flatMap { countryDetails -> ObservableFromIterable.fromIterable(countryDetails) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
