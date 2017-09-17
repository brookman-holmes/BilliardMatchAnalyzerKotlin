package com.brookmanholmes.bma.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.brookmanholmes.bma.R
import com.brookmanholmes.bma.presentation.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
