#!/usr/bin/env bash
commit_msg=$(cat "$1")

if ! echo "$commit_msg" | grep -Eq "^(feat|fix|chore|docs|style|refactor|test|perf)(\(.+\))?: .+"; then
  echo "❌ Commit message does not follow conventional commits format."
  echo "Example: feat(core): add validation for empty configs"
  exit 1
fi
