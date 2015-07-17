title: 我的vagrant相关命令
date: 2015-07-17 06:53:09
tags: 备忘
---
vagrant启动/停止
vagrant up
vagrant halt

启动cloud 9
sudo node /home/vagrant/cloud9/c9sdk/server.js -p 8181 -l 0.0.0.0 -a : -w /home/vagrant/cloud9/test-express/

启动/停止mongodb
sudo mongod --journal --fork --dbpath /home/vagrant/mongodb-linux-i686-3.0.4/data/ --logpath /home/vagrant/mongodb-linux-i686-3.0.4/logs
kill -2 PID

#git
git init
git add */filename
git commit -m "message"
git push -u origin master 
git pull origin master
git --help

#hexo
hexo new [post|page|draft] "name"
hexo server
hexo clean
hexo generate
hexo deploy
hexo --help
