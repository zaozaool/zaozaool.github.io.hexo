title: Linux常用命令
date: 2015-08-07 04:51:44
categories: [其他]
tags: [备忘, Linux]
---

1.`uname -a`,可显示电脑以及操作系统的相关信息。

2.`cat /proc/version`,说明正在运行的内核版本。

3.`cat /etc/issue`, 显示的是发行版本信息

4.`lsb_release -a`, (适用于所有的linux，包括Redhat、SuSE、Debian等发行版，但是在debian下要安装lsb)

5.`uname -r`,输出版本号

6.`ls -l |grep "^-"|wc -l`,统计某文件夹下文件的个数

7.`ls -l |grep "^ｄ"|wc -l`,统计某文件夹下目录的个数

8.`ls -lR|grep "^-"|wc -l`,统计文件夹下文件的个数，包括子文件夹里的

9. `sudo chown -R vagrant:vagrant ~/repO/`,改变拥有者和群组
