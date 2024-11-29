package io.github.alemazzo.architect.cli.plugins.semantic.release.context

data class SemanticReleaseContext(
	val path: String = ".architect/plugins/semantic-release",
	val command: String = "./release",
	val assets: List<Asset> = emptyList(),
) {
	companion object {
		fun fromContext(context: SemanticReleaseContext): SemanticReleaseContext {
			return SemanticReleaseContext(
				path = context.path,
				command = context.command,
				assets = context.assets
			)
		}
	}
}