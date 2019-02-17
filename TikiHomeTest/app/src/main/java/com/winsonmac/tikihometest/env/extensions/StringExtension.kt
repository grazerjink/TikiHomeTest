package com.winsonmac.tikihometest.env.extensions


/* =========================================================================================== */
/*  The extension function of string object                                                    */
/* =========================================================================================== */

/**
 * Check should split to two line
 */
fun String.shouldSplitTwoLine(): String {

    // If keyword still have space, then the string is had two words
    val shouldTwoLine = trimStart().trimEnd().contains(" ")

    if (shouldTwoLine) {

        for (i in 0 until length) {

            if (get(i) == ' ') {
                val preString = substring(0, i)
                val sufString = substring(i + 1, length)

                val isValidSplit = preString.length.div(sufString.length) > 2
                        || sufString.length.div(preString.length) < 2

                if (isValidSplit) {
                    return "$preString\n$sufString"
                }
            }
        }
    }

    return this
}