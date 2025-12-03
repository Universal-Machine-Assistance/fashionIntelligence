#!/bin/bash
set -e

# Install Java if not present (for shadow-cljs)
if ! command -v java &> /dev/null; then
  echo "Java not found, attempting to install..."
  if command -v apt-get &> /dev/null; then
    # Try with sudo first, then without (in case we're already root)
    (apt-get update && apt-get install -y default-jdk) || \
    (sudo apt-get update && sudo apt-get install -y default-jdk) || \
    (echo "Java installation failed" && exit 1)
  elif command -v apk &> /dev/null; then
    (apk add --no-cache openjdk17-jre) || \
    (sudo apk add --no-cache openjdk17-jre) || \
    (echo "Java installation failed" && exit 1)
  else
    echo "No package manager found, Java must be pre-installed"
    exit 1
  fi
fi

# Verify Java is available
java -version || (echo "Java is not available" && exit 1)

# Run shadow-cljs build
shadow-cljs release app

