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

cat > ~/.gnupg/gpg.conf <<- "EOF"
use-agent
pinentry-mode loopback
default-key $GPG_DEFAULT_KEY
passphrase $GPG_PASSPHRASE
EOF
# sed -i -e 's/#default-key .*/use-agent\npinentry-mode loopback\ndefault-key '$GPG_DEFAULT_KEY'\npassphrase '$GPG_PASSPHRASE'/g' ~/.gnupg/gpg.conf
cat ~/.gnupg/gpg.conf

cat > ~/.gnupg/gpg-agent.conf <<- "EOF"
allow-loopback-pinentry
EOF
echo RELOADAGENT | gpg-connect-agent

