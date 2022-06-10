package com.smartmatic.smarteco.sample.theming

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButtonToggleGroup
import com.smartmatic.smarteco.sample.R
import com.smartmatic.smarteco.widget.spinner.SpinnerAdapter


class ThemingActivity : AppCompatActivity() {

    var themeID = com.smartmatic.smarteco.R.style.Theme_Smartmatic_SmartEco;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(themeID);
        ThemeUtils.onActivityCreateSetTheme(this);

        setContentView(R.layout.activity_theming)

        val materialBTG = findViewById<MaterialButtonToggleGroup>(R.id.toggleGroupHorizontal)

        var array = arrayOf("India", "USA", "China", "Japan", "Other")
        val adapter = SpinnerAdapter(this, array)
        val  smartecoSpinner2 = findViewById<com.smartmatic.smarteco.widget.Spinner>(R.id.smartecoSpinner2)
        smartecoSpinner2?.setAdapter(adapter)

        when (ThemeUtils.getTheme()) {
            ThemeUtils.PURPLE -> materialBTG.check(R.id.PurpleThemeButton)
            ThemeUtils.TEAL -> materialBTG.check(R.id.TealThemeButton)
            ThemeUtils.GREEN -> materialBTG.check(R.id.GreenThemeButton)
            else -> materialBTG.check(R.id.PurpleThemeButton)
        }

        val btnPupleTheme = findViewById<Button>(R.id.PurpleThemeButton)

        btnPupleTheme.setOnClickListener {
            //themeID = com.smartmatic.smarteco.R.style.Theme_Smartmatic_SmartEco
            //changeTheme(themeID)
            ThemeUtils.changeToTheme(this, ThemeUtils.PURPLE)
        }

        val btnTealTheme = findViewById<Button>(R.id.TealThemeButton)
        btnTealTheme.setOnClickListener {
            //themeID = com.smartmatic.smarteco.R.style.Theme_Smartmatic_SmartEco_Teal
            //changeTheme(themeID)
            ThemeUtils.changeToTheme(this, ThemeUtils.TEAL)
        }

        val btnGreenTheme = findViewById<Button>(R.id.GreenThemeButton)
        btnGreenTheme.setOnClickListener {
            //themeID = com.smartmatic.smarteco.R.style.Theme_Smartmatic_SmartEco_Green
            ThemeUtils.changeToTheme(this, ThemeUtils.GREEN)
            //changeTheme(themeID)
        }

    }

}
