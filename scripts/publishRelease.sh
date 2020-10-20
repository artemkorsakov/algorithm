#!/bin/bash
set -e

echo "Publishing release..."
git checkout master
sbt 'release release-version 0.1.0 next-version 0.1.1-SNAPSHOT'
echo "Publishing release success..."
