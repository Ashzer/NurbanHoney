package com.devjj.platform.nurbanhoney.extension

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class LocalDateTimeUtils {
    companion object {
        private val parsingPattern =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.000'Z'")
        fun parse(date: String?): LocalDateTime =
            LocalDateTime.parse(date, parsingPattern)
        private val displayPattern: DateTimeFormatter =
            DateTimeFormatter.ofPattern("MM월 dd일 HH:mm:ss")
        fun LocalDateTime.toString(date: LocalDateTime?) = this.format(
            displayPattern
        ).toString()

        fun LocalDateTime.toFormattedString() =this.format(
            LocalDateTimeUtils.displayPattern
        ).toString()
    }
}

