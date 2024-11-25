package io.github.alemazzo.architect.cli.configuration

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("architect")
data class ConfigurationConfiguration(
	val locations: List<String> = emptyList(),
)