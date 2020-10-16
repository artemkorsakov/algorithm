#!/bin/bash
set -e
echo "Publishing snapshot..."
sbt +publishSigned
echo "Publishing snapshot success..."