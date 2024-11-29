package io.github.alemazzo.architect.cli.api.architect.run

import io.github.alemazzo.architect.cli.api.annotation.Architect

interface Runner : Runnable, Architect {
	val name: String
}
