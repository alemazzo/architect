#!/usr/bin/env bash
set -e

NAME="architect"
ASSET_NAME="architect.jar"
INSTALL_DIR="$HOME/.architect"
BIN_PATH="$INSTALL_DIR/$NAME"

FINAL_ASSET="$INSTALL_DIR/$ASSET_NAME"

echo "📦 Installing Architect CLI..."
mkdir -p "$INSTALL_DIR"

cat <<'EOF' > "$BIN_PATH"
#!/bin/bash
DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
exec java -jar "$DIR/architect.jar" "$@"
EOF

chmod +x "$BIN_PATH"

if [ "$1" == "local" ]; then
  # Install with gradle assemble in architect-cli and moving the jar
  echo "Building Architect CLI"
  cd architect-cli || exit
  ./gradlew assemble
  cp build/libs/architect-cli-0.1-all.jar "$FINAL_ASSET"
  cd .. || exit
  exit 0
else
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
fi

echo "✅ Architect installed at $INSTALL_DIR"

# Detect shell profile
SHELL_NAME=$(basename "$SHELL")
PROFILE=""

if [ "$SHELL_NAME" = "bash" ]; then
    PROFILE="$HOME/.bashrc"
elif [ "$SHELL_NAME" = "zsh" ]; then
    PROFILE="$HOME/.zshrc"
else
    PROFILE="$HOME/.profile"
fi

# Add to PATH if not already present
if ! grep -qs "export PATH=\"$HOME/.architect:\$PATH\"" "$PROFILE"; then
    echo "export PATH=\"$HOME/.architect:\$PATH\"" >> "$PROFILE"
    echo "✅ Added $INSTALL_DIR to your PATH in $PROFILE"
    echo "🔄 Please run: source $PROFILE or restart your terminal"
else
    echo "ℹ️ $INSTALL_DIR is already in your PATH"
fi

echo "🚀 Run with: architect"
