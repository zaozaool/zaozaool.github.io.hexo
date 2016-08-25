title: GenScript SCM解耦及模块化项目
date: 2016-06-15 02:31:02
categories: [后端]
tags: [项目, Maven]
---

#使用技术
Maven多模块

#编译脚本(最关键的一句)
```shell
mvn clean package -P ${env} -pl ${ProjectName} -am;
```