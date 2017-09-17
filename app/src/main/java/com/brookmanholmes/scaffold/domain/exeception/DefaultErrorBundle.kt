package com.brookmanholmes.scaffold.domain.exeception

/**
 *  Wrapper around Exceptions used to manage default errors.
 */
class DefaultErrorBundle(private val exception: Exception): ErrorBundle {

    override fun getException(): java.lang.Exception {
        return exception
    }

    override fun getErrorMessage(): String {
        return exception.message?: "Unknown Error"
    }


}