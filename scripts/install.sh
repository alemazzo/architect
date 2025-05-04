#!/usr/bin/env bash
set -e

NAME="architect"
ASSET_NAME="architect.jar"
INSTALL_DIR="$HOME/.architect"
BIN_PATH="/usr/local/bin/$NAME"

FINAL_ASSET="$INSTALL_DIR/$ASSET_NAME"
FINAL_EXECUTABLE="$INSTALL_DIR/$NAME"

echo "📦 Installing Architect CLI..."
mkdir -p "$INSTALL_DIR"

cat <<EOF > "$FINAL_EXECUTABLE"
#!/bin/bash
exec java -jar "$FINAL_ASSET" "\$@"
EOF

chmod +x "$FINAL_EXECUTABLE"

GITHUB_REPO="alemazzo/architect" # Replace with the GitHub repository (e.g., "alemazzo/architect")

# Fetch the latest release metadata
LATEST_RELEASE_URL="https://api.github.com/repos/$GITHUB_REPO/releases/latest"
ASSET_URL=$(curl -s "$LATEST_RELEASE_URL" | jq -r ".assets[] | select(.name == \"$ASSET_NAME\") | .browser_download_url")

# Check if the asset URL was found
if [[ -z "$ASSET_URL" || "$ASSET_URL" == "null" ]]; then
    echo "Error: Asset '$ASSET_NAME' not found in the latest release of '$GITHUB_REPO'."
    exit 1
fi

# Download the asset
echo "Downloading $ASSET_NAME from $ASSET_URL..."
curl -s -L "$ASSET_URL" --output "$FINAL_ASSET"

if [[ $? -eq 0 ]]; then
    echo "Download complete: $ASSET_NAME"
else
    echo "Error: Failed to download $ASSET_NAME."
    exit 1
fi

echo "✅ Architect installed at $INSTALL_DIR"

if [ -w /usr/local/bin ]; then
  ln -sf "$FINAL_EXECUTABLE" "$BIN_PATH"
  echo "🚀 Run with: architect"
else
  echo "⚠️ You don't have permission to write to /usr/local/bin."
  echo "Please add $INSTALL_DIR to your PATH or link manually."
fi
