package com.vkhooda24.knowyourcountry.domain.model

/**
 * Created by Vikram Hooda on 12/27/18.
 */
open class Country(
    var name: String? = null,

    var nativeName: String? = null,

    var cioc: String? = null,

    var region: String? = null,

    var numericCode: String? = null,

    var callingCodes: Array<String>? = null,

    var alpha3Code: String? = null,

    var topLevelDomain: Array<String>? = null,

    var alpha2Code: String? = null,

    var capital: String? = null,

    var altSpellings: Array<String>? = null,

    var subregion: String? = null,

    var timezones: Array<String>? = null,

    var flag: String? = null,

    var area: String? = null,

    var latlng: Array<String>? = null,

    var demonym: String? = null,

    var gini: String? = null,

    var borders: Array<String>? = null,

    var population: String? = null
)
