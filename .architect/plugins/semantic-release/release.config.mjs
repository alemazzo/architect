import config from 'semantic-release-preconfigured-conventional-commits' with { type: "json" };
config.plugins.push(

    "@semantic-release/github",
    "@semantic-release/git",
)
export default config;
