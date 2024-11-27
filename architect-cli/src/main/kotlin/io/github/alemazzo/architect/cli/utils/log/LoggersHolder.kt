package io.github.alemazzo.architect.cli.utils.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory


object LoggersHolder {
	private val loggerMap: MutableMap<String, Logger> = mutableMapOf()

	@Synchronized
	fun loggerOf(clazz: Class<*>) =
		loggerMap.getOrPut(clazz.name) { LoggerFactory.getLogger(clazz) }
}