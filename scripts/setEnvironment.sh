#!/bin/bash

echo "Set environments..."
export SONATYPE_USER=$SONATYPE_USER
export SONATYPE_PASSWORD=$SONATYPE_PASSWORD
export GITHUB_TOKEN=$GITHUB_TOKEN

echo "Set git variables..."
git config --global user.email "artemkorsakov@mail.ru"
git config --global user.name "artemkorsakov"
git config --global push.default simple

echo "Set environments success..."