package com.vkhooda24.knowyourcountry.dagger

import com.vkhooda24.knowyourcountry.ui.activities.CountriesListActivity
import com.vkhooda24.knowyourcountry.ui.activities.CountryDetailActivity
import com.vkhooda24.knowyourcountry.ui.activities.WelcomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Vikram Hooda on 12/22/18.
 */
@Module(includes = [ViewModelModule::class])
abstract class UiModule {

    @ContributesAndroidInjector
    internal abstract fun provideWelcomeActivity(): WelcomeActivity

    @ContributesAndroidInjector
    internal abstract fun provideCountriesListActivity(): CountriesListActivity

    @ContributesAndroidInjector
    internal abstract fun provideCountryDetailActivity(): CountryDetailActivity
}
