package com.smartmatic.smarteco.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.smartmatic.smarteco.R
import com.smartmatic.smarteco.databinding.MessageRibbonViewBinding


private const val ERROR_TYPE = 0
private const val SUCCESS_TYPE = 1
private const val WARNING_TYPE = 2
private const val INFO_TYPE = 3
private const val STRING_EMPTY = ""
private const val DEFAULT_ATTR = 0

class MessageRibbon @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = DEFAULT_ATTR
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var smErrorTitle: String = STRING_EMPTY

    private var typeMessage: Int = 0

    private val binding =
        MessageRibbonViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        initialize(attrs)
    }

    private fun initialize(attrs: AttributeSet?) {
        loadAttrs(attrs)
        initView()
    }

    private fun initView() {
        binding.tvMessage.text = smErrorTitle
        binding.ivClose.setOnClickListener { this.visibility = View.INVISIBLE }
    }

    fun fadeIn() {
        this.visibility = View.VISIBLE
    }

    private fun loadAttrs(attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MessageRibbon,
            0, 0
        ).apply {
            smErrorTitle =
                getString(R.styleable.MessageRibbon_error_title) ?: STRING_EMPTY

            typeMessage = getInt(R.styleable.MessageRibbon_message_type, 0)
            getTheViewBackground(typeMessage)
            recycle()
        }
    }

    private fun getTheViewBackground(type: Int) {
        when (type) {
            ERROR_TYPE -> setUpErrorView()
            SUCCESS_TYPE -> setUpSuccessView()
            WARNING_TYPE -> setUpWarningView()
            INFO_TYPE -> setUpInfoView()
        }
    }

    fun setMessageText(message: String) {
        binding.tvMessage.text = message
    }

    private fun setUpErrorView() {
        binding.container.background = ContextCompat.getDrawable(context, R.drawable.error_shape)
        binding.tvMessage.setTextColor(ContextCompat.getColor(context, R.color.red_90))
    }

    private fun setUpSuccessView() {
        binding.container.background = ContextCompat.getDrawable(context, R.drawable.success_shape)
        binding.tvMessage.setTextColor(ContextCompat.getColor(context, R.color.submitted_color))
        binding.ivLeft.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.ic_alert_check_circle
            )
        )
        binding.ivClose.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.color_green_green_70
            )
        )
    }

    private fun setUpWarningView() {
        binding.container.background = ContextCompat.getDrawable(context, R.drawable.warning_shape)
        binding.tvMessage.setTextColor(ContextCompat.getColor(context, R.color.gold_90))
        binding.ivLeft.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.ic_alert_exclamation_triangle
            )
        )
        binding.ivClose.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.gold_70
            )
        )
    }

    private fun setUpInfoView() {
        binding.container.background = ContextCompat.getDrawable(context, R.drawable.info_shape)
        binding.tvMessage.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.feedback_info_text_color
            )
        )
        binding.ivLeft.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.feedback_info_text_color
            )
        )
        binding.ivClose.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.feedback_info_text_color
            )
        )
    }
}
