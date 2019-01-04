package com.vkhooda24.knowyourcountry.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vkhooda24.knowyourcountry.R
import com.vkhooda24.knowyourcountry.domain.model.Countries
import com.vkhooda24.knowyourcountry.ui.activities.CountriesListActivity

/**
 * Created by Vikram Hooda on 12/23/18.
 */
class CountriesRecyclerAdapter(
    private val countriesListActivity: CountriesListActivity,
    private val countriesList: List<Countries>
) : RecyclerView.Adapter<CountriesRecyclerAdapter.RecyclerViewHolder>() {
    private var onItemClickListener: OnClickCountryName? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(countriesListActivity)
            .inflate(R.layout.adapter_countries_recycler_view, viewGroup, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(recyclerViewHolder: RecyclerViewHolder, position: Int) {

        val countryName = countriesList[position].name
        recyclerViewHolder.countryNameTextView.text = countryName

        //choice to use not-null assertion operator(!!) to throw exception if null OR
        //use safe call operator(?.) for no action if null value
        recyclerViewHolder.itemView.setOnClickListener { v -> onItemClickListener?.onClickItem(countryName) }
    }

    override fun getItemCount() = countriesList.size

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryNameTextView: TextView = itemView.findViewById(R.id.countryNameTextView)
    }

    fun setOnItemClickListener(onItemClickListener: OnClickCountryName) {
        this.onItemClickListener = onItemClickListener
    }

    interface OnClickCountryName {
        fun onClickItem(countryName: String?)
    }
}