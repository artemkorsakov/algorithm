#!/usr/bin/env bash

echo "Installing Ruby environment..."
rvm use 2.6.5 --install --fuzzy
gem update --system

echo "Installing gpg..."
apt-get install gnupg2

echo "gpg version..."
gpg --version
gpg2 –version

echo "import gpg keys..."
openssl aes-256-cbc -K $encrypted_404964577bd1_key -iv $encrypted_404964577bd1_iv -in all.gpg.enc -out all.gpg -d
gpg2 --import all.gpg

echo "list secret gpg keys..."
gpg2 --list-secret-keys

echo "gpg.conf..."
file=~/.gnupg/gpg.conf
echo "use-agent" >$file
echo "pinentry-mode loopback" >>$file
echo "default-key $GPG_DEFAULT_KEY" >>$file
echo "passphrase $GPG_PASSPHRASE" >>$file
cat $file

echo "gpg-agent.conf..."
echo "allow-loopback-pinentry" >~/.gnupg/gpg-agent.conf
cat ~/.gnupg/gpg-agent.conf
echo RELOADAGENT | gpg-connect-agent

echo "Installing Jekyll..."
gem install jekyll -v 4

echo "Installing success..."