package io.github.alemazzo.architect.cli.commands.installers.context

import io.github.alemazzo.architect.cli.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class InstallersContextFactory : AbstractContextFactory<InstallersContextHolder>() {
	@Singleton
	override fun create(): InstallersContextHolder = getContext()
}