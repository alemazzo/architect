package io.github.alemazzo.architect.cli.plugins.conventional.commits.context

import io.github.alemazzo.architect.cli.api.annotation.Architect
import io.github.alemazzo.architect.cli.api.context.Context
import io.github.alemazzo.architect.cli.plugins.conventional.commits.ConventionalCommits
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class ConventionalCommitsContextFactory : Architect {
	@Singleton
	fun getConventionalCommits(context: Context): ConventionalCommitsContext {
		logger.info("Loading context of type ${ConventionalCommits::class.simpleName}")
		return context.of<ConventionalCommits>()?.context ?: ConventionalCommitsContext()
	}
}