package com.brookmanholmes.scaffold.presentation.base

/**
 * Created by brookman on 9/16/17.
 */
interface LoadDataView {
    fun showLoading()
    fun hideLoading()
    fun showRetry()
    fun hideRetry()
    fun showError(message: String)
}