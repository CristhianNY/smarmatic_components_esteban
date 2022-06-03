package com.smartmatic.smarteco.sample.feedback

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.smartmatic.smarteco.sample.R
import com.smartmatic.smarteco.widget.MessageRibbon

class FeedbackActivity : AppCompatActivity() {
    private lateinit var buttonFeedback: Button
    private lateinit var alertFeedback: MessageRibbon
    private lateinit var successFeedback: MessageRibbon
    private lateinit var warningFeedback: MessageRibbon
    private lateinit var infoFeedback: MessageRibbon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        getViews()
        setListeners()
    }

    private fun setListeners() {
        buttonFeedback.setOnClickListener {
            alertFeedback.visibility = View.VISIBLE
            successFeedback.visibility = View.VISIBLE
            warningFeedback.visibility = View.VISIBLE
            infoFeedback.visibility = View.VISIBLE
        }
    }

    private fun getViews() {
        alertFeedback = findViewById(R.id.messageRibbonAlert)
        successFeedback = findViewById(R.id.messageRibbonSuccess)
        warningFeedback = findViewById(R.id.messageRibbonWarning)
        infoFeedback = findViewById(R.id.messageRibbonInfo)

        buttonFeedback = findViewById(R.id.feedbackButton)
    }
}