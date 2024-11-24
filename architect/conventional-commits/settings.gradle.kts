rootProject.name = "conventional-commits"

plugins {
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.15"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

gitHooks {
    commitMsg { conventionalCommits() }
    createHooks()
}