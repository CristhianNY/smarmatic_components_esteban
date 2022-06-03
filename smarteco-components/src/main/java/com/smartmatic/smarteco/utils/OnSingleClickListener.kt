package com.smartmatic.smarteco.utils

import android.os.SystemClock
import android.view.View

private const val MIN_CLICK_INTERVAL = 800

class OnSingleClickListener(
    private val onSingleClick: (View) -> Unit
) : View.OnClickListener {
    private var mLastClickTime: Long = 0L
    override fun onClick(v: View) {
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        if (elapsedTime <= MIN_CLICK_INTERVAL) return
        mLastClickTime = currentClickTime
        onSingleClick(v)
    }
}
