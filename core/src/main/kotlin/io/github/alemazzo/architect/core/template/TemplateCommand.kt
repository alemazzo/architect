package io.github.alemazzo.architect.core.template

import io.github.alemazzo.architect.engine.plugins.api.PluginCommand
import io.github.alemazzo.architect.core.template.application.TemplateInitTask
import io.github.alemazzo.architect.core.template.application.TemplateVerifyTask
import io.github.alemazzo.architect.core.template.context.TemplateContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = TemplateCommand.NAME,
	description = ["Run the template command"],
	subcommands = [
		TemplateInitTask::class,
		TemplateVerifyTask::class,
	]
)
class TemplateCommand : PluginCommand<TemplateContext>(NAME) {
	companion object {
		const val NAME = "template"
	}
}