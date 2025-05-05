package io.github.alemazzo.architect.cli.commands.pipelines.context

data class PipelineContext(
	val name: String = "pipeline",
	val type: String = "github/classic-java-17",
)

data class PipelinesContextHolder(
	val pipeline: PipelineContext = PipelineContext()
)