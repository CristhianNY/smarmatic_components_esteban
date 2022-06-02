package com.smartmatic.smarteco.sample.feedback

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.LinearLayoutCompat
import com.smartmatic.smarteco.sample.R

class FeedbackActivity : AppCompatActivity() {
    private lateinit var buttonFeedback: Button
    private lateinit var alertFeedback: LinearLayoutCompat
    private lateinit var successFeedback: LinearLayoutCompat
    private lateinit var warningFeedback: LinearLayoutCompat
    private lateinit var infoFeedback: LinearLayoutCompat
    private lateinit var closeAlertFeedback: AppCompatImageView
    private lateinit var closeSuccessFeedback: AppCompatImageView
    private lateinit var closeWarningFeedback: AppCompatImageView
    private lateinit var closeInfoFeedback: AppCompatImageView

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

        closeAlertFeedback.setOnClickListener {
            alertFeedback.visibility = View.GONE
        }

        closeSuccessFeedback.setOnClickListener {
            successFeedback.visibility = View.GONE
        }

        closeWarningFeedback.setOnClickListener {
            warningFeedback.visibility = View.GONE
        }

        closeInfoFeedback.setOnClickListener {
            infoFeedback.visibility = View.GONE
        }
    }

    private fun getViews() {
        alertFeedback = findViewById(R.id.feedbackAlertContainer)
        successFeedback = findViewById(R.id.feedbackSuccessContainer)
        warningFeedback = findViewById(R.id.feedbackWarningContainer)
        infoFeedback = findViewById(R.id.feedbackInfoContainer)

        closeAlertFeedback = findViewById(R.id.closeAlertFeedback)
        closeSuccessFeedback = findViewById(R.id.closeSuccessFeedback)
        closeWarningFeedback = findViewById(R.id.closeWarningFeedback)
        closeInfoFeedback = findViewById(R.id.closeInfoFeedback)

        buttonFeedback = findViewById(R.id.feedbackButton)
    }
}