title: Drools中常用但易混淆的概念
date: 2016-06-12 07:00:11
categories: [后端]
tags: [Java, Drools]
---

##KIE/Drools/jBPM

[官方的一句话](http://docs.jboss.org/drools/release/6.4.0.Final/drools-docs/html/ch04.html#KIEAnatomySection)解释了比较到位：
The process of researching an integration knowledge solution for Drools and jBPM has simply used the "droolsjbpm" group name. This name permeates GitHub accounts and Maven POMs. As scopes broadened and new projects were spun KIE, an acronym for Knowledge Is Everything, was chosen as the new group name. The KIE name is also used for the shared aspects of the system; such as the unified build, deploy and utilization.
![kie](http://docs.jboss.org/drools/release/6.4.0.Final/drools-docs/html/images/kie/Overview/kie.png)

##KieServices/KieRepository/KieProject/KieContainer/KieModule/KieBase/KieSession区别,部分转自[Drools入门系列（六）——KIE之基础API详解](http://www.tuicool.com/articles/jeIVjiy)
<!--more-->
###KieServices
通过KieServices对象得到一个KieContainer，然后KieContainer根据session name来新建一个KieSession，最后通过KieSession来运行规则。通过KieServices访问KIE关于构建和运行的相关对象，比如说可以获取KieContainer，利用KieContainer来访问KBase和KSession等信息；可以获取KieRepository对象，利用KieRepository来管理KieModule等
###KieRepository
KieRepository是一个单例对象，它是一个存放KieModule的仓库，KieModule由kmodule.xml文件定义（当然不仅仅只是用它来定义）。
###KieContainer
KieContainer是一个KieBase的容器
###KieProject：
KieContainer通过KieProject来初始化、构造KieModule，并将KieModule存放到KieRepository中，然后KieContainer可以通过KieProject来查找KieModule定义的信息，并根据这些信息构造KieBase和KieSession。
###KieBase
KieBase就是一个知识仓库，包含了若干的规则、流程、方法等，在Drools中主要就是规则和方法，KieBase本身并不包含运行时的数据之类的，如果需要执行规则KieBase中的规则的话，就需要根据KieBase创建KieSession。
###KieSession:
KieSession就是一个跟Drools引擎打交道的会话，其基于KieBase创建，它会包含运行时数据，包含“事实 Fact”，并对运行时数据事实进行规则运算。我们通过KieContainer创建KieSession是一种较为方便的做法，其实他本质上是从KieBase中创建出来的。
KieSession就是应用程序跟规则引擎进行交互的会话通道。
创建KieBase是一个成本非常高的事情，KieBase会建立知识（规则、流程）仓库，而创建KieSession则是一个成本非常低的事情，所以KieBase会建立缓存，而KieSession则不必。