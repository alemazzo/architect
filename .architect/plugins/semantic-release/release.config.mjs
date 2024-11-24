import config from 'semantic-release-preconfigured-conventional-commits' with { type: "json" };
config.plugins.push(
    "@semantic-release/git",
    [
        "@semantic-release/github",  {
        "assets": [
            {
                "path": "../../../architect-cli/build/libs/architect-cli-0.1-all.jar",
                "name": "architect-cli.jar",
                "label": "Architect CLI"
            }
        ],
    }],
)
export default config;
