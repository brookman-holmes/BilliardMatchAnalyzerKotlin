package com.brookmanholmes.scaffold.presentation.base

import android.support.v4.app.Fragment
import android.widget.Toast
import com.brookmanholmes.scaffold.presentation.exception.ErrorMessageFactory

/**
 * Created by brookman on 9/16/17.
 */
abstract class BaseFragment<T: Presenter>: Fragment() {
    protected lateinit var presenter: T

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroy()
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}