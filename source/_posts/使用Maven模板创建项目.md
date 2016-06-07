title: 使用Maven模板创建项目
date: 2016-06-06 07:51:11
categories: [后端]
tags: [Maven, Java]
---

##列出Maven模板列表（1000+），并选择模板创建项目
mvn archetype:generate

##导出Maven模板列表到txt
mvn archetype:generate > templates.txt


##导入Eclipse
mvn eclipse:eclipse

##根据常用模板创建项目

###maven-archetype-quickstart (Java Project)
```shell
$ mvn archetype:generate -DgroupId=com.yiibai.core -DartifactId=ProjectName -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

###maven-archetype-webapp (Java Web Project)
```shell
$ mvn archetype:generate -DgroupId=com.yiibai.web -DartifactId=ProjectName -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```