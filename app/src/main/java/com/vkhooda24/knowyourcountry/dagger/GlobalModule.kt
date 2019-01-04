package com.vkhooda24.knowyourcountry.dagger

import com.vkhooda24.knowyourcountry.app.KnowYourCountryApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vikram Hooda on 12/25/18.
 */
@Module
class GlobalModule {

    @Provides
    @Singleton
    internal fun provideAppContext() = KnowYourCountryApplication.application


    // RAW kotlin code when use IDE tool to convert Java to Kotlin

//    @Provides
//    @Singleton
//    internal fun provideAppContext(): Context {
//        return KnowYourCountryApplication.application
//    }

}
