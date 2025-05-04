ARCHITECT_BIN_DIR="$HOME/.local/bin"
mkdir -p "$ARCHITECT_BIN_DIR"
GITHUB_REPO="alemazzo/architect"
ASSET_NAME="architect.jar"
JAR_PATH="$ARCHITECT_BIN_DIR/architect.jar"
WRAPPER_PATH="$ARCHITECT_BIN_DIR/architect"
ASSET_URL=$(curl -s "https://api.github.com/repos/$GITHUB_REPO/releases/latest" | jq -r ".assets[] | select(.name == \"$ASSET_NAME\") | .browser_download_url")
curl -s -L "$ASSET_URL" --output "$JAR_PATH"
cat <<'EOF' > "$WRAPPER_PATH"
#!/bin/bash
DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
exec java -jar "$DIR/architect.jar" "$@"
EOF
chmod +x "$WRAPPER_PATH"
echo "$ARCHITECT_BIN_DIR" >> $GITHUB_PATH