package io.github.alemazzo.architect.cli.plugins.architect.context

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.context.Context
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class ArchitectContextFactory {

	data class Yaml(
		@JsonProperty("architect")
		val context: ArchitectContext?,
	)

	@Singleton
	fun getArchitectContext(context: Context): ArchitectContext =
		context.of<Yaml>()?.context ?: ArchitectContext()
}