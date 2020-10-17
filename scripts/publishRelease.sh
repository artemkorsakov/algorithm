#!/bin/bash
set -e

echo "Publishing release..."
git checkout master
sbt clearCaches
sbt clean
sbt cleanFiles
sbt cleanIvy
sbt 'release with-defaults'
echo "Publishing release success..."
