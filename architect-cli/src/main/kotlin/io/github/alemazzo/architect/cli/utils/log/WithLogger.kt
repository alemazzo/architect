package io.github.alemazzo.architect.cli.utils.log

import org.slf4j.Logger


interface WithLogger {

	val logger: Logger
		get() = LoggersHolder.loggerOf(this.javaClass)
}