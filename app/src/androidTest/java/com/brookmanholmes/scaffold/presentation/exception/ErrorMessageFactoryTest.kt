package com.brookmanholmes.scaffold.presentation.exception

import android.support.test.InstrumentationRegistry
import com.brookmanholmes.scaffold.R
import com.brookmanholmes.scaffold.data.exception.NetworkConnectionException

import org.junit.Test
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

/**
 * Created by brookman on 9/16/17.
 */
class ErrorMessageFactoryTest {
    private var context = InstrumentationRegistry.getTargetContext()


    @Test
    fun testNetworkConnectionErrorMessage() {
        var expectedMessage = context.getString(R.string.exception_message_no_connection)
        var actualMessage = ErrorMessageFactory.create(context, NetworkConnectionException())

        assertThat(actualMessage, `is`(equalTo(expectedMessage)))
    }
}