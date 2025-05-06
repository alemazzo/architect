package io.github.alemazzo.architect.core.installers.context

data class InstallerContext(
	val owner: String,
	val name: String,
	val appPath: String,
	val assetType: String = "jar",
	val path: String = ".installers",
)