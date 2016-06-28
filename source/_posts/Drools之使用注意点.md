title: Drools之使用注意点
date: 2016-04-28 07:49:23
categories: [后端]
tags: [Java, Drools]
---

1.DRL中不要使用单引号，对于字符串一定使用双引号.

2.如果集成了Spring，一定不能调用kieSession.dispose();

3.stateful和stateless区别