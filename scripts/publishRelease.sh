#!/bin/bash
set -e

echo "Publishing release..."
git checkout master
git tag
git tag -a v0.0.15 -m 'release 0.0.15'
git push origin v0.0.15
sbt 'release with-defaults'
echo "Publishing release success..."
