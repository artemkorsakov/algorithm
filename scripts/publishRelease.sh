#!/bin/bash
set -e

echo "Publishing release..."
git status
git checkout master
sbt 'release with-defaults'
echo "Publishing release success..."
