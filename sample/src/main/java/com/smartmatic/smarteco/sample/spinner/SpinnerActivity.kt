package com.smartmatic.smarteco.sample.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smartmatic.smarteco.sample.R
import com.smartmatic.smarteco.widget.spinner.SpinnerAdapter

class SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        var array = arrayOf("India", "USA", "China", "Japan", "Other")

        val adapter = SpinnerAdapter(this, array)


        val  smartecoSpinner1 = findViewById<com.smartmatic.smarteco.widget.Spinner>(R.id.smartecoSpinner1)
        smartecoSpinner1.setAdapter(adapter)

        val  smartecoSpinner2 = findViewById<com.smartmatic.smarteco.widget.Spinner>(R.id.smartecoSpinner2)
        smartecoSpinner2.setAdapter(adapter)

        val  smartecoSpinner3 = findViewById<com.smartmatic.smarteco.widget.Spinner>(R.id.smartecoSpinner3)
        smartecoSpinner3.setAdapter(adapter)

        val  smartecoSpinner4 = findViewById<com.smartmatic.smarteco.widget.Spinner>(R.id.smartecoSpinner4)
        smartecoSpinner4.setAdapter(adapter)

    }
}