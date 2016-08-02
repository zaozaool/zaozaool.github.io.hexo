#!/bin/sh

hexo_root=~/repositories/zaozaool.github.io.hexo

cd $hexo_root

hexo clean

#统计图形报表使用的数据
bash $hexo_root/source/scripts/statistic.sh

#提交源码
git add -A
git commit -am "commit"
git push -u origin master

#生成静态html
hexo generate
#发布
hexo deploy
