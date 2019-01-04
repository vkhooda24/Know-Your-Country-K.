package com.vkhooda24.knowyourcountry.dagger

import com.vkhooda24.knowyourcountry.domain.retrofit.RetrofitBuilder
import com.vkhooda24.knowyourcountry.domain.services.CountriesListService
import com.vkhooda24.knowyourcountry.domain.services.CountryDetailService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

import javax.inject.Singleton

/**
 * Created by Vikram Hooda on 12/22/18.
 */
@Module
class ServicesModule {

    internal val retrofit: Retrofit
        @Singleton
        @Provides
        get() = RetrofitBuilder.build()

    @Singleton
    @Provides
    internal fun provideCountriesListService(retrofit: Retrofit) = retrofit.create(CountriesListService::class.java)

    @Singleton
    @Provides
    internal fun provideCountryDetailService(retrofit: Retrofit) = retrofit.create(CountryDetailService::class.java)
}
