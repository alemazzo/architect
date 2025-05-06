package io.github.alemazzo.architect.core.pipelines.context

data class PipelineContext(
	val name: String = "pipeline",
	val type: String = "pipelines/github/classic-java-17",
)

data class PipelinesContextHolder(
	val pipeline: PipelineContext = PipelineContext()
)