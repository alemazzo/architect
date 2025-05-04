package io.github.alemazzo.architect.cli.engine.applications.components

import picocli.CommandLine

object GroupedCommandsRenderer : CommandLine.IHelpSectionRenderer {
    override fun render(help: CommandLine.Help): String {
        val phases = listOf("init", "build", "verify", "test", "run", "release")

        val commands = help.subcommands().entries

        val phasesBuilder = StringBuilder("Phases:\n")
        val pluginsBuilder = StringBuilder("Plugins:\n")

        val phasesCommands = commands.filter { it.key in phases }
        val pluginsCommands = commands.filter { it.key !in phases }.sortedBy { it.key }

        phasesCommands.forEach { (name, command) ->
            phasesBuilder.append("  $name - ${command.commandSpec().usageMessage().description().joinToString()}\n")
        }

        pluginsCommands.forEach { (name, command) ->
            pluginsBuilder.append("  $name - ${command.commandSpec().usageMessage().description().joinToString()}\n")
        }

        return StringBuilder("\n").append(phasesBuilder).append("\n").append(pluginsBuilder).toString()

    }
}
