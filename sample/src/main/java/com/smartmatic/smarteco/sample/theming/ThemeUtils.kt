package com.smartmatic.smarteco.sample.theming

import android.R

import android.app.Activity

import android.content.Intent


object ThemeUtils {
    private var cTheme = 0
    const val PURPLE = 0
    const val TEAL = 1
    const val GREEN = 2

    fun changeToTheme(activity: Activity, theme: Int) {
        cTheme = theme
        activity.finish()
        activity.startActivity(Intent(activity, activity.javaClass))
    }

    fun onActivityCreateSetTheme(activity: Activity) {
        when (cTheme) {
            PURPLE -> activity.setTheme(com.smartmatic.smarteco.R.style.Theme_Smartmatic_SmartEco)
            TEAL -> activity.setTheme(com.smartmatic.smarteco.R.style.Theme_Smartmatic_SmartEco_Teal)
            GREEN -> activity.setTheme(com.smartmatic.smarteco.R.style.Theme_Smartmatic_SmartEco_Green)
            else -> activity.setTheme(com.smartmatic.smarteco.R.style.Theme_Smartmatic_SmartEco)
        }
    }

    fun getTheme(): Int
    {
        return cTheme

    }
}

