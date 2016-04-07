#!/bin/sh

hexo_root=/home/vagrant/repo/zaozaool.github.io.hexo

cd $hexo_root
git add *
git commit -am "commit"
git push -u origin master

hexo clean
hexo generate
hexo deploy
