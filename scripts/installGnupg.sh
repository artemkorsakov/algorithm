#!/usr/bin/env bash

echo "Installing latest version gpg..."
sudo apt-get install build-essential make zlib1g-dev

echo "Install Libgpg-error"
wget https://www.gnupg.org/ftp/gcrypt/libgpg-error/libgpg-error-1.39.tar.bz2
tar jxf libgpg-error-1.39.tar.bz2
cd libgpg-error-1.39
./configure
make
sudo make install
cd ..

echo "Install Libgcrypt"
wget https://www.gnupg.org/ftp/gcrypt/libgcrypt/libgcrypt-1.8.6.tar.bz2
tar jxf libgcrypt-1.8.6.tar.bz2
cd libgcrypt-1.8.6
./configure
make
sudo make install
cd ..

echo "Install Libksba"
wget https://www.gnupg.org/ftp/gcrypt/libksba/libksba-1.4.0.tar.bz2
tar jxf libksba-1.4.0.tar.bz2
cd libksba-1.4.0
./configure
make
sudo make install
cd ..

echo "Install Libassuan"
wget https://www.gnupg.org/ftp/gcrypt/libassuan/libassuan-2.5.3.tar.bz2
tar jxf libassuan-2.5.3.tar.bz2
cd libassuan-2.5.3
./configure
make
sudo make install
cd ..

echo "Install Ntbtls"
wget https://www.gnupg.org/ftp/gcrypt/ntbtls/ntbtls-0.2.0.tar.bz2
tar jxf ntbtls-0.2.0.tar.bz2
cd ntbtls-0.2.0
./configure
make
sudo make install
cd ..

echo "Install Npth"
wget https://www.gnupg.org/ftp/gcrypt/npth/npth-1.6.tar.bz2
tar jxf npth-1.6.tar.bz2
cd npth-1.6
./configure
make
sudo make install
cd ..

echo "Configure Dynamic Linker"
echo 'include /usr/local/lib/' | sudo tee -a /etc/ld.so.conf
sudo ldconfig -v

echo "Install GnuPG"
wget https://www.gnupg.org/ftp/gcrypt/gnupg/gnupg-2.2.23.tar.bz2
tar jxf gnupg-2.2.23.tar.bz2
cd gnupg-2.2.23/
./configure
make
sudo make install
cd ..

echo "gpg version..."
gpg --version

echo "Install Pinentry"
sudo apt-get install pinentry-curses
echo 'pinentry-program /usr/bin/pinentry-curses' | tee -a ~/.gnupg/gpg-agent.conf
gpg-connect-agent reloadagent /bye

echo "import gpg keys..."
openssl aes-256-cbc -K $encrypted_404964577bd1_key -iv $encrypted_404964577bd1_iv -in all.gpg.enc -out all.gpg -d
gpg --import all.gpg

echo "list gpg keys..."
gpg --list-keys

echo "list secret gpg keys..."
gpg --list-secret-keys

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

echo "Installing and configuration gpg success..."
