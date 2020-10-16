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
sed -i -e "use-agent" \
-e "pinentry-mode loopback" \
-e "s/\(default-key \).*/\1$GPG_DEFAULT_KEY/" \
-e "s/\(passphrase \).*/\1$GPG_PASSPHRASE/" ~/.gnupg/gpg.conf
sed -i 'allow-loopback-pinentry' ~/.gnupg/gpg-agent.conf
echo RELOADAGENT | gpg-connect-agent
cat ~/.gnupg/gpg.conf
cat ~/.gnupg/gpg-agent.conf
