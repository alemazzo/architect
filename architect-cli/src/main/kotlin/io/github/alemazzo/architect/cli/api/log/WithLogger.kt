package io.github.alemazzo.architect.cli.api.log

import org.slf4j.Logger


interface WithLogger {

	val logger: Logger
		get() = LoggersHolder.loggerOf(this.javaClass)
}