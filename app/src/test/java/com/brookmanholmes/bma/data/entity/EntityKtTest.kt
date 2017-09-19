package com.brookmanholmes.bma.data.entity

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.*

/**
 * Created by brookman on 9/17/17.
 */
class EntityKtTest {
    private enum class Directions {
        NORTH, SOUTH, EAST, WEST
    }

    @Test
    fun testEncodingEnumSet() {
        var expected = 0
        expected = expected or (1 shl Directions.EAST.ordinal)
        expected = expected or (1 shl Directions.WEST.ordinal)

        val actual = encodeEnumSet(EnumSet.of(Directions.EAST, Directions.WEST))

        assertThat(expected, `is`(actual))
    }

    @Test
    fun testDecodingEnumSet() {
        var expected = EnumSet.of(Directions.EAST, Directions.WEST)

        val actual = decodeEnumSet(encodeEnumSet(expected), Directions::class.java)

        assertThat(expected, `is`(actual))
    }
}