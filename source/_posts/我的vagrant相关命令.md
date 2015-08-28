title: 我的vagrant相关命令
date: 2015-07-17 06:53:09
tags: 备忘
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

#hexo
config.vm.network "forwarded_port", guest: 4000, host: 4000
```

#apt-get安装与卸载
```shell
sudo apt-get install xxxx

sudo apt-get remove xxxx
sudo apt-get autoremove
```