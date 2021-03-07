package com.rishabh.countrylistapplication.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* To change the status bar text color */
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }
        setContentView(getLayout())
        initResource()

    }

    abstract fun getLayout(): Int
    abstract fun initResource()
}