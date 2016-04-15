title: 我的vagrant相关命令
date: 2015-07-17 06:53:09
categories: [其他]
tags: [备忘]
---

#vagrant启动/停止
```shell
vagrant init  # 初始化
vagrant up  # 启动虚拟机
vagrant halt  # 关闭虚拟机
vagrant reload  # 重启虚拟机
vagrant ssh  # SSH 至虚拟机
vagrant status  # 查看虚拟机运行状态
vagrant destroy  # 销毁当前虚拟机
```
<!--more-->

#启动cloud 9
```shell
sudo node /home/vagrant/cloud9/c9sdk/server.js -p 8181 -l 0.0.0.0 -a : -w /home/vagrant/cloud9/test-express/
```

#启动/停止mongodb
```shell
sudo mongod --journal --fork --dbpath /home/vagrant/mongodb-linux-i686-3.0.4/data/ --logpath /home/vagrant/mongodb-linux-i686-3.0.4/logs
kill -2 PID
```

#启动/停止redis
```shell
sudo /usr/bin/redis-server /etc/redis/redis.conf
redis-cli shutdown
kill -9 PID
```
#启动/停止postgresql
```shell
sudo /usr/lib/postgresql/9.1/bin/postgres -D /var/lib/postgresql/9.1/main -c config_file=/etc/postgresql/9.1/main/postgresql.conf
kill -2 PID

sudo su - postgres
psql
\q: 退出psql
\password dbuser
\h：查看SQL命令的解释，比如\h select。
\?：查看psql命令列表。
\l：列出所有数据库。
\c [database_name]：连接其他数据库。
\d：列出当前数据库的所有表格。
\d [table_name]：列出某一张表格的结构。
\du：列出所有用户。
\e：打开文本编辑器。
\conninfo：列出当前数据库和连接的信息。
```

#git
```shell
git init
git add */filename
git commit -m "message"
git push -u origin master 
git pull origin master
git --help
```

#hexo
```shell
hexo new [post|page|draft] "name"
hexo server
hexo clean
hexo generate
hexo deploy
hexo --help
```

#vagrant 映射配置
```shell
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
config.vm.network "forwarded_port", guest: 3001, host: 3101

#hexo
config.vm.network "forwarded_port", guest: 4000, host: 4000

#redis
config.vm.network "forwarded_port", guest: 6379, host: 6379

#ftp
config.vm.network "forwarded_port", guest: 21, host: 21

#postgresql
config.vm.network "forwarded_port", guest: 5432, host: 5432

#edp
config.vm.network "forwarded_port", guest: 8008, host: 8008
```

#apt-get安装与卸载
```shell
sudo apt-get install xxxx

sudo apt-get remove xxxx
sudo apt-get autoremove
```