#!/bin/bash
set -e

echo "Publishing release..."
sbt test
# sbt release release-version 0.0.9 next-version 0.0.10-SNAPSHOT
echo "Publishing release success..."
