#!/bin/bash

# Check if next release version is passed as a parameter
if [ -z "$1" ]; then
  echo "Error: Next release version is required as a parameter."
  echo "Usage: ./update-version.sh <nextReleaseVersion>"
  exit 1
fi

NEXT_RELEASE_VERSION="$1"

echo "Collecting files to update version..."

# Collect all matching files
FILES=$(find . -type f \( -name '*.gradle' -o -name '*.gradle.kts' -o -name '*.properties' \))

# Check if any files were found
if [ -z "$FILES" ]; then
  echo "No matching files found to update."
  exit 1
fi

# Loop over each file and update the version
echo "Updating version to $NEXT_RELEASE_VERSION in the following files:"
for FILE in $FILES; do
  echo "Updating version in $FILE"

  if [[ "$OSTYPE" == "darwin"* ]]; then
    sed -E -i "" "s/version[[:space:]]*=[[:space:]]*[\"'\\\"]?[^\"'\\\"]+[\"'\\\"]?/version = \"${NEXT_RELEASE_VERSION}\"/g" "$FILE"
  else
    sed -E -i "s/version[[:space:]]*=[[:space:]]*[\"'\\\"]?[^\"'\\\"]+[\"'\\\"]?/version = \"${NEXT_RELEASE_VERSION}\"/g" "$FILE"
  fi
done

echo "Version update complete."
