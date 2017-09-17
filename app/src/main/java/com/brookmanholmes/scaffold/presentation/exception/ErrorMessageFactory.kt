package com.brookmanholmes.scaffold.presentation.exception

import android.content.Context

/**
 * Created by brookman on 9/16/17.
 */
class ErrorMessageFactory private constructor() {
    companion object {
        fun create(context: Context, exception: Exception): String {
            return exception.localizedMessage
        }
    }
}