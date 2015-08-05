title: 我的vagrant相关命令
date: 2015-07-17 06:53:09
tags: 备忘
---
#vagrant启动/停止
vagrant up
vagrant halt

#启动cloud 9
sudo node /home/vagrant/cloud9/c9sdk/server.js -p 8181 -l 0.0.0.0 -a : -w /home/vagrant/cloud9/test-express/

#启动/停止mongodb
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

#vagrant 映射配置
```
#apache tomcat
config.vm.network "forwarded_port", guest: 8081, host: 80

#remote java application
config.vm.network "forwarded_port", guest: 8787, host: 8787

#cloud 9 IDE
config.vm.network "forwarded_port", guest: 8181, host: 8181

#mongodb
config.vm.network "forwarded_port", guest: 27017, host: 27117
config.vm.network "forwarded_port", guest: 28017, host: 28117

#node.js app
config.vm.network "forwarded_port", guest: 3000, host: 3100

#hexo
config.vm.network "forwarded_port", guest: 4000, host: 4000
```