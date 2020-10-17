#!/usr/bin/env bash

echo "Installing and configuration gpg..."
echo "Go to dist folder"
mkdir dist
cd dist

echo "Install Pinentry"
sudo apt-get install pinentry-curses
echo 'pinentry-program /usr/bin/pinentry-curses' | tee -a ~/.gnupg/gpg-agent.conf
gpg-connect-agent reloadagent /bye

echo "Go to parent folder"
cd ..

echo "gpg version"
gpg --version

echo "Import gpg keys"
gpg --batch --import all.gpg

echo "List gpg keys"
gpg --list-keys

echo "List secret gpg keys"
gpg --list-secret-keys

echo "gpg.conf"
file=~/.gnupg/gpg.conf
echo "use-agent" >$file
echo "pinentry-mode loopback" >>$file
echo "default-key $GPG_DEFAULT_KEY" >>$file
echo "passphrase $GPG_PASSPHRASE" >>$file
cat $file

echo "gpg-agent.conf"
echo "allow-loopback-pinentry" >~/.gnupg/gpg-agent.conf
cat ~/.gnupg/gpg-agent.conf
echo RELOADAGENT | gpg-connect-agent

echo "Installing and configuration gpg success..."

echo "Installing Ruby environment..."
rvm use 2.6.5 --install --fuzzy
gem update --system

echo "Installing Jekyll..."
gem install jekyll -v 4

echo "Installing Ruby and Jekyll success..."