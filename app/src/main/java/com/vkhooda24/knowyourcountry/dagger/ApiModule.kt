package com.vkhooda24.knowyourcountry.dagger

import com.vkhooda24.knowyourcountry.domain.apis.CountriesApi
import com.vkhooda24.knowyourcountry.domain.apis.CountryDetailApi
import com.vkhooda24.knowyourcountry.domain.apis.apisimpl.CountriesApiImpl
import com.vkhooda24.knowyourcountry.domain.apis.apisimpl.CountryDetailImpl
import com.vkhooda24.knowyourcountry.domain.services.CountriesListService
import com.vkhooda24.knowyourcountry.domain.services.CountryDetailService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vikram Hooda on 12/22/18.
 */
@Module(includes = [ServicesModule::class])
class ApiModule {

    @Singleton
    @Provides
    internal fun provideCountriesApi(countriesListService: CountriesListService): CountriesApi =
        CountriesApiImpl(countriesListService)

    @Singleton
    @Provides
    internal fun provideCountryDetailApi(countryDetailService: CountryDetailService): CountryDetailApi =
        CountryDetailImpl(countryDetailService)
}
