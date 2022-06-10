package com.smartmatic.smarteco.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.AutoCompleteTextView
import com.smartmatic.smarteco.R

class Spinner : androidx.appcompat.widget.AppCompatAutoCompleteTextView {

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        androidx.appcompat.R.style.Base_Widget_AppCompat_Spinner_Underlined
    ) {
        init(attrs, androidx.appcompat.R.style.Base_Widget_AppCompat_Spinner_Underlined)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        androidx.appcompat.R.style.Base_Widget_AppCompat_Spinner_Underlined
    ) {
        init(attrs, androidx.appcompat.R.style.Base_Widget_AppCompat_Spinner_Underlined)
    }

    constructor(context: Context, attrs: AttributeSet) : super(
        context,
        attrs,
        androidx.appcompat.R.style.Base_Widget_AppCompat_Spinner_Underlined
    ) {
        init(attrs, androidx.appcompat.R.style.Base_Widget_AppCompat_Spinner_Underlined)
    }

    constructor(context: Context) : super(context) {
        init(null!!, androidx.appcompat.R.style.Base_Widget_AppCompat_Spinner_Underlined)
    }

    private fun init(attrs: AttributeSet, defStyle: Int) {

        if (attrs != null) {
            val a = getContext().obtainStyledAttributes(attrs, R.styleable.Spinner, defStyle, 0)
            val fontName = a.getString(R.styleable.Spinner_spinner_font_type)
            try {
                if (fontName != null) {
                    val myTypeface =
                        Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName)
                    setTypeface(myTypeface)
                }

                isFocusable = false
                isFocusableInTouchMode = false
                inputType = 0

                this.setOnClickListener {

                    this.showDropDown()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            a.recycle()
        }

    }
}