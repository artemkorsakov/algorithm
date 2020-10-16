#!/bin/bash
set -e

echo "Publishing release..."
git status
sbt 'release with-defaults'
echo "Publishing release success..."
