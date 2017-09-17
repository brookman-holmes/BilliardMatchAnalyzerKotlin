package com.brookmanholmes.bma.presentation.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.brookmanholmes.bma.R
import com.brookmanholmes.bma.presentation.exception.ErrorMessageFactory
import com.brookmanholmes.bma.presentation.main.MainActivity
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

class SignInActivity : AppCompatActivity(), OnSuccessListener<AuthResult>, OnFailureListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnSuccessListener(this)
                .addOnFailureListener(this)
    }


    protected fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(result: AuthResult?) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onFailure(exception: Exception) {
        showToastMessage(exception.localizedMessage)
        Log.i(this.javaClass.name, exception.localizedMessage)
    }
}
