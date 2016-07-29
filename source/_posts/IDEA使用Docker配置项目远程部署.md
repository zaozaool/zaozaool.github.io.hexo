title: IDEA使用Docker配置项目远程部署
date: 2016-07-29 01:41:46
categories: [其他]
tags: [Docker, Java]
---

1. 服务器安装Docker，添加配置并重启
```shell
vim /etc/default/docker 

DOCKER_OPTS="-H unix:///var/run/docker.sock -H tcp://0.0.0.0:2375"
```

2. 添加Tomcat
```shell
docker run tomcat
```
<!-- more -->
3. IDEA安装Docker插件，需重启后生效

4. 在项目目录下创建docker-dir目录，并创建Dockerfile文件，其内容为：
```shell
#build

FROM tomcat

#Drools规则引擎使用，跟该主题无关
RUN mkdir /root/.m2
WORKDIR /root/.m2
RUN wget http://10.168.2.64/scripts/settings.xml

#Debug端口映射
ENV CATALINA_OPTS  "-agentlib:jdwp=transport=dt_socket,address=0.0.0.0:18787,suspend=n,server=y"
EXPOSE 18787

#部署war
ADD SCM-usorder.war /usr/local/tomcat/webapps/
```

5. Settings > Build,Execution,Deployment > Clouds下增加docker，如图：
![配置](http://zaozaool.github.io/pic/docker-2.209.png)

6. Edit Configuration > New Docker Deployment
![配置](http://zaozaool.github.io/pic/docker-usorder-2.209.png)
![配置](http://zaozaool.github.io/pic/docker-usorder-2.209_2.png)

7. 修改war的输出目录[ctrl+shift+alt+S]
![配置](http://zaozaool.github.io/pic/SCM-usorder.war.png)

8. 官方教程
[官方教程](https://www.jetbrains.com/help/idea/2016.2/docker.html)
