package io.github.alemazzo.architect.cli.configuration

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import java.io.File

@Factory
class ArchitectConfigurationFactory(val parser: ArchitectConfigurationParser) {
	
	@Bean
	fun getArchitectConfiguration(): ArchitectConfiguration {
		val file = File("architect.yml")
		if (!file.exists()) return ArchitectConfiguration()
		return parser.parse(file.readText())
	}

}