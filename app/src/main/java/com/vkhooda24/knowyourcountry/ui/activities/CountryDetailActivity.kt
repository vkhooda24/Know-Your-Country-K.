package com.vkhooda24.knowyourcountry.ui.activities

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.vkhooda24.knowyourcountry.R
import com.vkhooda24.knowyourcountry.app.AppConstants
import com.vkhooda24.knowyourcountry.constants.IntentKeys
import com.vkhooda24.knowyourcountry.viewmodel.CountryDetailViewModel
import com.vkhooda24.utils.StringUtil
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_country_detail.*
import javax.inject.Inject

/**
 * Created by Vikram Hooda on 12/24/18.
 */
class CountryDetailActivity : Activity() {

    internal var countryDetailViewModel: CountryDetailViewModel? = null
        @Inject set

    // can not assign null to this property i.e non nullable property
    private var countryName: String = AppConstants.DEFAULT_COUNTRY_NAME
    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        countryName = intent?.extras?.getString(IntentKeys.COUNTRY_NAME) ?: AppConstants.DEFAULT_COUNTRY_NAME

        countryNameTextView.text = countryName

        compositeDisposable.add(countryDetailViewModel!!.getCountryDetail(countryName).subscribe(
            { countryDetail ->
                val domainName = countryDetail?.topLevelDomain?.get(0) ?: ""
                val timezone = countryDetail?.timezones?.get(0) ?: ""
                countryNameTextView.text = countryDetail.name
                countryCapitalTextView.text = getString(R.string.capital, countryDetail.capital)
                countryNativeNameTextView.text = getString(R.string.native_name, countryDetail.nativeName)
                countryTopLevelDomainTextView.text = getString(R.string.domain_name, domainName)
                countryRegionTextView.text = getString(R.string.region_name, countryDetail.region)
                countrySubRegionTextView.text = getString(R.string.sub_region_name, countryDetail.subregion)
                countryTimeZoneTextView.text = getString(R.string.timezone, timezone)
                countryPopulationTextView.text =
                        getString(
                            R.string.population,
                            StringUtil.formatNumberWithCommas(countryDetail?.population?.get(0).toString())
                        )
                countryAlphaNameTextView.text = getString(R.string.alpha_code_name, countryDetail.alpha3Code)

                Glide.with(this).apply {
                    load(AppConstants.IMAGE_NOT_FOUND_URL).into(countryFlagImageView)
                }
            },
//            { it.printStackTrace() }
            { t: Throwable? -> t?.printStackTrace() }
        ))
    }
}