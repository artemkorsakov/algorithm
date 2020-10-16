#!/bin/bash
set -e

echo "Publishing documentation..."
sbt publishMicrosite
echo "Publishing documentation success..."
