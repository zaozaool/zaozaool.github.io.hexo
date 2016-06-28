title: Linux whereis/which/locate/find
date: 2016-06-28 06:12:06
categories: [其他]
tags: [备忘, Linux]
---

#which       
which是通过 PATH环境变量 到该路径内查找可执行文件，所以基本的功能是寻找可执行文件
语法：  
```
vagrant@precise32:~$ which 可执行文件名称  
```
<!--more-->

#whereis    
查看文件的位置，和find相比，whereis查找的速度非常快，这是因为linux系统会将系统内的所有文件都记录在一个数据库文件中，当使用whereis和下面即将介绍的locate时，会从数据库中查找数据，而不是像find命令那样，通过遍历硬盘来查找，效率自然会很高。  
语法：  
```
vagrant@precise32:~$ whereis [-bmsu] 文件或者目录名称   
```
参数说 明：  
-b ： 只找二进制文件  
-m ： 只找在说明文件manual路径下的文件  
-s ： 只找source源文件  
-u ： 没有说明文档的文件  


#locate       
配合数据库查看文件位置 
语法：  
```
vagrant@precise32:~$ locate 文件或者目录名称  
```

#find          
实际搜寻硬盘查询文件名称 (find也可以根据文件大小-size 时间-atime 正则表达式-regex)
语法：  
```
vagrant@precise32:~$ find 路径 参数
```
参 数说明：  
时间查找参数：  
-atime n :将n*24小时内存取过的的文件列出来  
-ctime n :将n*24小时内改变、新增的文件或者目录列出来  
-mtime n :将n*24小时内修改过的文件或者目录列出来  
-newer file ：把比file还要新的文件列出来  
名称查找参数：  
-gid n       ：寻找群组ID为n的文件  
-group name  ：寻找群组名称为name的文件  
-uid n       ：寻找拥有者ID为n的文件  
-user name   ：寻找用户者名称为name的文件  
-name file   ：寻找文件名为file的文件（可以使用通配符）  