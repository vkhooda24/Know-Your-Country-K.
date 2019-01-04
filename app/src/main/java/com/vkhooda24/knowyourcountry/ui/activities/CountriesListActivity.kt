package com.vkhooda24.knowyourcountry.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.vkhooda24.knowyourcountry.R
import com.vkhooda24.knowyourcountry.app.AppConstants
import com.vkhooda24.knowyourcountry.constants.IntentKeys
import com.vkhooda24.knowyourcountry.domain.model.Countries
import com.vkhooda24.knowyourcountry.ui.adapter.CountriesRecyclerAdapter
import com.vkhooda24.knowyourcountry.viewmodel.CountriesViewModel
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_countries_list.*
import javax.inject.Inject

/**
 * Created by Vikram Hooda on 12/22/18.
 */
class CountriesListActivity : Activity() {

    private lateinit var countriesRecyclerAdapter: CountriesRecyclerAdapter
//    private var countriesRecyclerAdapter: CountriesRecyclerAdapter? = null


    internal var countriesViewModel: CountriesViewModel? = null
        @Inject set

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    //Nullable string i.e can assign null to this property
    private var regionName: String? = AppConstants.REGION_ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries_list)

        //chain returns null if any of the properties in it is null
        //safe call operator ?.
        regionName = intent?.extras?.getString(IntentKeys.REGION_NAME) ?: AppConstants.REGION_ALL

        compositeDisposable.add(
            countriesViewModel!!.getCountriesList(regionName!!) // Elvis operator ?:
                .subscribe(
                    { countries -> bindViewsData(countries) },
                    { throwable -> throwable.printStackTrace() }
                )
        )
    }

    private fun bindViewsData(countries: List<Countries>) {

        //Initialize views
        //Create recycler adapter
        countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        countriesRecyclerAdapter = CountriesRecyclerAdapter(this, countries)
        countriesRecyclerView.adapter = countriesRecyclerAdapter

        countriesCountTextView.text = getString(R.string.countries_list_heading, regionName, countries.size)

        countriesRecyclerAdapter.setOnItemClickListener(object : CountriesRecyclerAdapter.OnClickCountryName {
            override fun onClickItem(countryName: String?) {
                val intent = Intent(this@CountriesListActivity, CountryDetailActivity::class.java)
                intent.putExtra(IntentKeys.COUNTRY_NAME, countryName)
                startActivity(intent)
            }

        })
    }
}