package io.github.alemazzo.architect.cli.plugins.template

import io.github.alemazzo.architect.cli.engine.components.plugin.api.PluginCommand
import io.github.alemazzo.architect.cli.plugins.template.application.TemplateInitTaskTask
import io.github.alemazzo.architect.cli.plugins.template.application.TemplateVerifyTasksRunnable
import io.github.alemazzo.architect.cli.plugins.template.context.TemplateContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = TemplateRunnable.NAME,
	description = ["Run the template command"],
	subcommands = [
		TemplateInitTaskTask::class,
		TemplateVerifyTasksRunnable::class,
	]
)
class TemplateRunnable() : PluginCommand<TemplateContext>(NAME) {
	companion object {
		const val NAME = "template"
	}
}