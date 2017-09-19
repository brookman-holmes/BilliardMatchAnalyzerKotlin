package com.brookmanholmes.bma.data.entity

import java.util.*

/**
 * Created by brookman on 9/17/17.
 */
inline fun <reified T : Enum<T>> encodeEnumSet(set: Collection<T>): Int {
    var value = 0

    for (enum in set) {
        value = value or (1 shl enum.ordinal)
    }

    return value
}

inline fun <reified T : Enum<T>> decodeEnumSet(code: Int, clazz: Class<T>): EnumSet<T> {
    val result = EnumSet.noneOf(clazz)
    val values: Array<T>? = clazz.getMethod("values").invoke(null) as? Array<T>
    var value = code
    while (value != 0) {
        val ordinal = Integer.numberOfTrailingZeros(value)
        value = value xor Integer.lowestOneBit(value)
        result.add(values?.get(ordinal))
    }

    return result
}