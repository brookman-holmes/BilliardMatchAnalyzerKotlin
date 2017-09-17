package com.brookmanholmes.bma.data.exception

import com.brookmanholmes.bma.domain.exeception.ErrorBundle

/**
 * Created by brookman on 9/16/17.
 */
class RepositoryErrorBundle(private val exception: Exception): ErrorBundle {
    override fun getException(): Exception {
        return exception
    }

    override fun getErrorMessage(): String {
        return exception.message?: "Unknown Error"
    }
}