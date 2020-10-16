#!/bin/bash

echo "Set environments..."
export SONATYPE_USER=$SONATYPE_USER
export SONATYPE_PASSWORD=$SONATYPE_PASSWORD
export GITHUB_TOKEN=$GITHUB_TOKEN

echo "Set git variables..."
git config --global user.email "artemkorsakov@mail.ru"
git config --global user.name "artemkorsakov"
git config --global push.default simple

echo "Set gpg parameters..."
gpg --version

sed -i -e 's/#default-key .*/default-key '$GPG_DEFAULT_KEY' \n passphrase '$GPG_PASSPHRASE'/g' ~/.gnupg/gpg.conf
cat ~/.gnupg/gpg.conf

# sed -i 'allow-loopback-pinentry' ~/.gnupg/gpg-agent.conf

# cat ~/.gnupg/gpg-agent.conf

# echo RELOADAGENT | gpg-connect-agent


