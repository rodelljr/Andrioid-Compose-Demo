package com.roger.composedemo.helper

import java.math.RoundingMode
import java.text.DecimalFormat

fun convertValue(standard: Boolean, value: Double, unit: Double): String {
    var total = 0.0
    return if(standard) {
        total = (value / unit)
        refineConvert(total)
    } else {
        total =(value * unit)
        refineConvert(total)
    }
}

fun convertTemp(standard: Boolean, value: Double): String {
    var total = 0.0
    return if(standard) {
        total = ((value - 32) * 5 / 9)
        refineTemp(total)
    } else {
        total = ((value * 9 / 5) + 32)
        refineTemp(total)
    }
}

fun refineTemp(value: Double): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(value)
}

fun refineConvert(value: Double): String {
    val df = DecimalFormat("#.#####")
    df.roundingMode = RoundingMode.CEILING
    return df.format(value)
}
