package com.brookmanholmes.scaffold.domain.exeception

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Created by brookman on 9/16/17.
 */
class DefaultErrorBundleTest {
    private lateinit var defaultErrorBundle: DefaultErrorBundle
    private lateinit var mockException: Exception

    @Before
    fun setup() {
        mockException = mock()
        defaultErrorBundle = DefaultErrorBundle(mockException)
    }

    @Test
    fun getErrorMessage() {
        defaultErrorBundle.getErrorMessage()

        verify(mockException).message
    }

}