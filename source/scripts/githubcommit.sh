#!/bin/sh

hexo_root=/home/vagrant/repo/zaozaool.github.io.hexo

cd $hexo_root

#提交源码
git add *
git commit -am "commit"
git push -u origin master

#生成静态html
hexo clean
hexo generate

#统计并生成图形报表
cd $hexo_root/source/scripts/
bash statistic.sh

#发布
hexo deploy
