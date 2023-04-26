package com.devjj.platform.nurbanhoney.extension

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class DateTime constructor(date: String) {
	private val dateTime : LocalDateTime

	init {
		dateTime = parse(date)
	}

	override fun toString() = dateTime.format(displayPattern).toString()

	private val parsingPattern =
		DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.000'Z'")

	private fun parse(date: String?): LocalDateTime =
		LocalDateTime.parse(date, parsingPattern)

	private val displayPattern: DateTimeFormatter =
		DateTimeFormatter.ofPattern("MM월 dd일 HH:mm:ss")

	companion object{
		val now : DateTime = DateTime("2000-01-01T00:00:00.000Z")
	}
}
