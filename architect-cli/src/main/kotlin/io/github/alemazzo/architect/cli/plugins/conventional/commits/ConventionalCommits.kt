package io.github.alemazzo.architect.cli.plugins.conventional.commits

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.alemazzo.architect.cli.api.command.plugin.Plugin
import io.github.alemazzo.architect.cli.context.Context
import io.github.alemazzo.architect.cli.plugins.conventional.commits.configuration.ConventionalCommitsContext
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton

class ConventionalCommits : Plugin<ConventionalCommitsContext>() {

	companion object {
		const val name = "conventional-commits"
	}

	@JsonProperty(name)
	override var context: ConventionalCommitsContext? = null

}

@Singleton
@Factory
class ConventionalCommitsFactory {
	@Singleton
	fun getConventionalCommits(context: Context): ConventionalCommitsContext {
		println("Loading configuration of type ${ConventionalCommits::class.simpleName}")
		return context.of<ConventionalCommits>()?.context ?: ConventionalCommitsContext()
	}
}

@Requires(bean = ConventionalCommitsContext::class)
annotation class ConventionalCommitsPlugin