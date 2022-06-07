package com.smartmatic.smarteco.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.smartmatic.smarteco.R
import com.smartmatic.smarteco.databinding.SubHeaderViewBinding

private const val DEFAULT_ATTR = 0
private const val STRING_EMPTY = ""

class SubHeader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = DEFAULT_ATTR
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding =
        SubHeaderViewBinding.inflate(LayoutInflater.from(context), this, true)

    private var subHeaderTitle: String = STRING_EMPTY
    private var subHeaderBackText: String = STRING_EMPTY
    private var subHeaderPollingPlace: String = STRING_EMPTY
    private var subHeaderPollingPlaceTitle: String = STRING_EMPTY
    private var subHeaderBackgroundColor: Int = 0

    init {
        initialize(attrs)
    }

    private fun initialize(attrs: AttributeSet?) {
        loadAttrs(attrs)
        binding.ctSubHeader.setBackgroundColor(subHeaderBackgroundColor)
    }

    private fun loadAttrs(attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.SubHeader,
            0, 0
        ).apply {

            subHeaderTitle = getString(R.styleable.SubHeader_subheader_title) ?: STRING_EMPTY
            subHeaderBackText =
                getString(R.styleable.SubHeader_subheader_back_text) ?: STRING_EMPTY
            subHeaderPollingPlace =
                getString(R.styleable.SubHeader_subheader_polling_place) ?: STRING_EMPTY
            subHeaderPollingPlaceTitle =
                getString(R.styleable.SubHeader_subheader_polling_title) ?: STRING_EMPTY
            subHeaderBackgroundColor = getColor(
                R.styleable.SubHeader_subheader_background_color,
                ContextCompat.getColor(context, R.color.gray_10)
            )
            recycle()
        }
    }

    fun setSUHeaderTitle(title: String) {
        binding.tvTitle.text = title
    }

    fun setSubHeaderBackText(text: String) {
        binding.tvGoBack.text = text
    }

    fun setPollingPlaceText(text: String) {
        binding.tvPollingLocation.text = subHeaderPollingPlaceTitle.plus(text)
    }

    fun setSubHeaderColor(color: Int) {
        binding.ctSubHeader.setBackgroundColor(ContextCompat.getColor(context, color))
    }

    fun backAction(action: () -> Unit): SubHeader {
        binding.tvGoBack.setOnClickListener {
            action()
        }
        return this
    }

    fun backVisibility(isVisible: Boolean) {
        binding.tvGoBack.visibility = if (isVisible) View.VISIBLE else View.GONE
        binding.separator.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    companion object {
        @BindingAdapter("sub_header_title")
        @JvmStatic
        fun setTitle(view: SubHeader, title: String?) {
            title?.let { view.setSUHeaderTitle(it) }
        }

        @BindingAdapter("sub_header_back_text")
        @JvmStatic
        fun setBackText(view: SubHeader, back: String?) {
            back?.let { view.setSubHeaderBackText(it) }
        }

        @BindingAdapter("set_sub_header_polling_place")
        @JvmStatic
        fun setPollingPlace(view: SubHeader, pollingPlace: String?) {
            pollingPlace?.let { view.setPollingPlaceText(it) }
        }

        @BindingAdapter("sub_header_back_click")
        @JvmStatic
        fun onSearchClick(view: SubHeader, onClickLink: () -> Unit) {
            view.backAction(onClickLink)
        }

        @BindingAdapter("sub_header_back_visibility")
        @JvmStatic
        fun setViewVisibility(view: SubHeader, isVisible: Boolean?) = view.run {
            isVisible?.let { view.backVisibility(it) }
        }
    }
}