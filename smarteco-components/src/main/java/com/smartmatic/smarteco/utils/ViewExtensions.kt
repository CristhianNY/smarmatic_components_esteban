package com.smartmatic.smarteco.utils

import android.view.View

fun View.setOnSingleClickListener(clickListener: View.OnClickListener) {
    setOnClickListener(OnSingleClickListener(clickListener::onClick))
}
