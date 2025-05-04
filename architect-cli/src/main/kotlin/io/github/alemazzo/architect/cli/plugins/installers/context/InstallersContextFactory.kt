package io.github.alemazzo.architect.cli.plugins.installers.context

import io.github.alemazzo.architect.cli.engine.api.context.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class InstallersContextFactory : AbstractContextFactory<InstallersContextHolder>() {
	@Singleton
	override fun create(): InstallersContextHolder = getContext()
}