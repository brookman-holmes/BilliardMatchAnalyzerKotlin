package com.brookmanholmes.bma.data.exception

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

import org.junit.Before

/**
 * Created by brookman on 9/16/17.
 */
class RepositoryErrorBundleTest {
    private lateinit var repositoryErrorBundle: RepositoryErrorBundle

    private lateinit var mockException: Exception


    @Before
    fun setup() {
        mockException = mock()
        repositoryErrorBundle = RepositoryErrorBundle(mockException)

    }

    @Test
    fun getErrorMessage() {
        repositoryErrorBundle.getErrorMessage()

        verify(mockException).message
    }

}