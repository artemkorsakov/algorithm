#!/bin/bash
set -e

echo "Publishing release..."
git checkout master
sbt 'release release-version 0.0.15 next-version 0.0.16-SNAPSHOT'
echo "Publishing release success..."
