title: Drools中常用但易混淆的概念
date: 2016-06-12 07:00:11
categories: [后端]
tags: [Java, Drools]
---

##KIE/Drools/jBPM

[官方的一句话](http://docs.jboss.org/drools/release/6.4.0.Final/drools-docs/html/ch04.html#KIEAnatomySection)解释了比较到位：
The process of researching an integration knowledge solution for Drools and jBPM has simply used the "droolsjbpm" group name. This name permeates GitHub accounts and Maven POMs. As scopes broadened and new projects were spun KIE, an acronym for Knowledge Is Everything, was chosen as the new group name. The KIE name is also used for the shared aspects of the system; such as the unified build, deploy and utilization.

##KieContainer/KieModule/KieBase/KieSession
是包含的关系：KieModule>KieBase>KieSession
而KieModule/KieBase/KieSession均是由KieContainer创建的
其中KieModule和KieBase只会创建一次，而KieSession则有可能创建多次
