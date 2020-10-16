#!/bin/bash

echo "Set environments..."
export SONATYPE_USER=$SONATYPE_USER
export SONATYPE_PASSWORD=$SONATYPE_PASSWORD
export GITHUB_TOKEN=$GITHUB_TOKEN

echo "Set git variables..."
git config --global user.email "artemkorsakov@mail.ru"
git config --global user.name "artemkorsakov"
git config --global push.default simple

echo "gpg version..."
gpg --version
openssl aes-256-cbc -K $encrypted_404964577bd1_key -iv $encrypted_404964577bd1_iv -in all.gpg.enc -out all.gpg -d
gpg --import all.gpg
gpg --list-secret-keys

echo "gpg.conf..."
file=~/.gnupg/gpg.conf
echo "use-agent" >$file
# echo "pinentry-mode loopback" >>$file
echo "default-key $GPG_DEFAULT_KEY" >>$file
echo "passphrase $GPG_PASSPHRASE" >>$file
cat $file

echo "gpg-agent.conf..."
echo "allow-loopback-pinentry" >~/.gnupg/gpg-agent.conf
cat ~/.gnupg/gpg-agent.conf
echo RELOADAGENT | gpg-connect-agent

echo "Set environments success..."
