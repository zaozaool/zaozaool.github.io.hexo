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

#统计图形报表使用的数据
bash $hexo_root/source/scripts/statistic.sh

#发布
hexo deploy
