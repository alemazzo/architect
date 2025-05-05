package io.github.alemazzo.architect.cli.commands.installers.context

data class InstallerContext(
	val owner: String,
	val name: String,
	val appPath: String,
	val assetType: String = "jar",
	val path: String = ".installers",
)