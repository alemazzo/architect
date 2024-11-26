package io.github.alemazzo.architect.cli.mock

import io.github.alemazzo.architect.cli.configuration.Context
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory

@Factory
class MockedContext {

	@Bean
	fun getContext(): Context {
		return Context("")
	}

}