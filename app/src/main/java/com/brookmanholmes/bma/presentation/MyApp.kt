package com.brookmanholmes.bma.presentation

import android.app.Application
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by brookman on 9/16/17.
 */
class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }
}