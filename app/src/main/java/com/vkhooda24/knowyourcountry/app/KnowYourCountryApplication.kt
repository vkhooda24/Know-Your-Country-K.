package com.vkhooda24.knowyourcountry.app

import android.app.Activity
import android.app.Application
import com.vkhooda24.knowyourcountry.dagger.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Vikram Hooda on 12/22/18.
 */
class KnowYourCountryApplication : Application(), HasActivityInjector {

    internal var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>? = null
        @Inject set

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create().inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? = dispatchingActivityInjector

    companion object {
        var application = KnowYourCountryApplication()
    }
}
