title: tomcat启动不报错但是服务也没有启动成功
date: 2016-07-13 08:51:26
categories: [后端]
tags: [Java, Tomcat]
---

之前遇到了一次tomcat启动时没有报任何错误，但是服务也没有启动成功，访问不了，后来同事帮忙在网上找到这样一篇文章，这里记录下
[DEBUGGING THE DREADED “SEVERE: ERROR LISTENERSTART” AND “SEVERE: ERROR FILTERSTART” TOMCAT ERROR MESSAGES](http://blog.trifork.com/2011/03/18/debugging-the-dreaded-severe-error-listenerstart-and-severe-error-filterstart-tomcat-error-messages/)

具体操作：
1.  中web application下的WEB-INF/classes路径中创建logging.properties文件，其内容为：
```properties
org.apache.catalina.core.ContainerBase.[Catalina].level = INFO //INFO级别可以更改
org.apache.catalina.core.ContainerBase.[Catalina].handlers = java.util.logging.ConsoleHandler
```
2.  启动服务，这个时候错误就会打印到控制台（catalina.out）

