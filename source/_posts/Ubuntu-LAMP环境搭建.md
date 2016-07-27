title: Ubuntu LAMP环境搭建
date: 2016-07-22 21:31:28
categories: [其他]
tags: [备忘, Linux]
---

1.  更新源
```shell
sudo apt-get update
```
2.  安装Apache2
```shell
sudo apt-get install apache2
```
3.  安装PHP
```shell
sudo apt-get install php5 -y
```
4.  安装mysql
```shell
sudo apt-get install mysql-server
sudo apt-get install mysql-client
```
5.  访问http://ip:80，修改权限/var/www                          
```shell
sudo chmod 777 /var/www
```
