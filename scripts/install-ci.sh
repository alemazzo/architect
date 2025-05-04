ARCHITECT_BIN_DIR="$HOME/.local/bin"
mkdir -p "$ARCHITECT_BIN_DIR"

GITHUB_REPO="alemazzo/architect"
ASSET_NAME="architect.jar"
JAR_PATH="$ARCHITECT_BIN_DIR/architect.jar"

ASSET_URL=$(curl -s "https://api.github.com/repos/$GITHUB_REPO/releases/latest" | jq -r ".assets[] | select(.name == \"$ASSET_NAME\") | .browser_download_url")
curl -s -L "$ASSET_URL" --output "$JAR_PATH"

alias architect="java -jar $JAR_PATH"