package com.smartmatic.smarteco.sample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.smartmatic.smarteco.sample.button.ButtonActivity
import com.smartmatic.smarteco.sample.feedback.FeedbackActivity
import com.smartmatic.smarteco.sample.stepper.StepperActivity
import com.smartmatic.smarteco.sample.theming.ThemingActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.themingPlaygroundButton).setOnClickListener {
            startActivity(Intent(this, ThemingActivity::class.java))
        }

        findViewById<Button>(R.id.buttonPlaygroundButton).setOnClickListener {
            startActivity(Intent(this, ButtonActivity::class.java))
        }

        findViewById<Button>(R.id.buttonFeedbackButton).setOnClickListener {
            startActivity(Intent(this, FeedbackActivity::class.java))
        }

        findViewById<Button>(R.id.buttonStepperButton).setOnClickListener {
            startActivity(
                Intent(this, StepperActivity::class.java)
            )
        }

    }
}