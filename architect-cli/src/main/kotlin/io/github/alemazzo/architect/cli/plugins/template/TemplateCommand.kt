package io.github.alemazzo.architect.cli.plugins.template

import io.github.alemazzo.architect.cli.engine.components.plugin.api.Plugin
import io.github.alemazzo.architect.cli.plugins.template.application.TemplateInitCommand
import io.github.alemazzo.architect.cli.plugins.template.application.TemplateVerifyCommand
import io.github.alemazzo.architect.cli.plugins.template.context.TemplateContext
import jakarta.inject.Singleton
import picocli.CommandLine

@Singleton
@CommandLine.Command(
	name = TemplateCommand.NAME,
	description = ["Run the template commands"],
	subcommands = [
		TemplateInitCommand::class,
		TemplateVerifyCommand::class,
	]
)
class TemplateCommand() : Plugin<TemplateContext>(NAME) {
	companion object {
		const val NAME = "template"
	}
}