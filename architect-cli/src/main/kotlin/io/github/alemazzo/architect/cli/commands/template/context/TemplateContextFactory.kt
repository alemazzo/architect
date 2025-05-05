package io.github.alemazzo.architect.cli.commands.template.context

import io.github.alemazzo.architect.cli.engine.context.api.AbstractContextFactory
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Singleton
@Factory
class TemplateContextFactory : AbstractContextFactory<TemplateContext>() {
	@Singleton
	override fun create(): TemplateContext = getContext()
}