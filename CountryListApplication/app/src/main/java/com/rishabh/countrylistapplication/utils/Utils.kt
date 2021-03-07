package com.rishabh.countrylistapplication.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

object Utils {

    fun isConnectedToNetwork(context: Context?): Boolean {
        //return true
        try {
            hideKeyboard((context as Activity?)!!)
        } catch (e: Exception) {
        }
        val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true

    }

    fun hideKeyboard(activity: Activity?) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (null != activity?.getCurrentFocus())
            imm.hideSoftInputFromWindow(activity.currentFocus?.applicationWindowToken, 0)
    }

    /* Hide keyboard on outside touch */
    @SuppressLint("ClickableViewAccessibility")
    fun hideKeyboardOnOutsideTouch(view: View, activity: Activity) {
        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener { view, motionEvent ->
                hideKeyboard(activity)
                false
            }
        }
    }

    fun showToast(context: Context?, msg: String) {
        try {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
        }
    }
}

