#!/bin/sh

openssl aes-256-cbc -K $encrypted_404964577bd1_key -iv $encrypted_404964577bd1_iv -in all.gpg.enc -out all.gpg -d
gpg --import all.gpg
