#!/bin/bash
set -e

echo "Publishing release..."
sbt release with-defaults
echo "Publishing release success..."
