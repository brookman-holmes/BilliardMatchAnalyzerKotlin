package com.brookmanholmes.bma.presentation.exception

import android.content.Context
import com.brookmanholmes.bma.R
import com.brookmanholmes.bma.data.exception.NetworkConnectionException

/**
 * Created by brookman on 9/16/17.
 */
class ErrorMessageFactory private constructor() {
    companion object {
        fun create(context: Context, exception: Exception): String {
            var message = context.getString(R.string.exception_message_generic)

            if (exception is NetworkConnectionException)
                message = context.getString(R.string.exception_message_no_connection)

            return message
        }
    }
}