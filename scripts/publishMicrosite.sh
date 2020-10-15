set -e

git config --global user.email artemkorsakov@mail.ru
git config --global user.name artemkorsakov
git config --global push.default simple

sbt publishMicrosite