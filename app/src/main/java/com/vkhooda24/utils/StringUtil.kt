package com.vkhooda24.utils

/**
 * Created by Vikram Hooda on 12/25/18.
 */
object StringUtil {

    fun formatNumberWithCommas(number: String): String {
        try {
            //            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            //            return numberFormat.format(number);
            return String.format("%,d", Integer.valueOf(number))
        } catch (e: Exception) {
            return number
        }

    }
}
