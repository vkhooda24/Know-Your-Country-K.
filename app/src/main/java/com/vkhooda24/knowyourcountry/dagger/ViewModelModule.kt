package com.vkhooda24.knowyourcountry.dagger

import com.vkhooda24.knowyourcountry.domain.apis.CountriesApi
import com.vkhooda24.knowyourcountry.domain.apis.CountryDetailApi
import com.vkhooda24.knowyourcountry.viewmodel.CountriesViewModel
import com.vkhooda24.knowyourcountry.viewmodel.CountryDetailViewModel
import com.vkhooda24.knowyourcountry.viewmodel.viewmodelImpl.CountriesViewModelImpl
import com.vkhooda24.knowyourcountry.viewmodel.viewmodelImpl.CountryDetailViewModelImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vikram Hooda on 12/22/18.
 */
@Module(includes = [ApiModule::class])
class ViewModelModule {

    @Singleton
    @Provides
    internal fun provideCountriesViewModel(countriesApi: CountriesApi): CountriesViewModel =
        CountriesViewModelImpl(countriesApi)

    @Singleton
    @Provides
    internal fun provideCountryDetailViewModel(countryDetailApi: CountryDetailApi): CountryDetailViewModel =
        CountryDetailViewModelImpl(countryDetailApi)
}
