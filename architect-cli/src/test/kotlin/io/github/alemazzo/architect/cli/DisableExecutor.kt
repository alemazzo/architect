package io.github.alemazzo.architect.cli

import io.github.alemazzo.architect.cli.utils.CommandExecutor
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

@MicronautTest
interface DisableExecutor {

	val executor: CommandExecutor

	@BeforeEach
	fun setup() {
		executor.disabled = true
	}

	@AfterEach
	fun tearDown() {
		executor.disabled = false
	}
}