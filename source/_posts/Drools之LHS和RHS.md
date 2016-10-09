title: Drools之LHS和RHS
date: 2016-04-25 07:51:42
categories: [后端]
tags: [Java, Drools]
---
#LHS
##约束连接
对于对象内部的多个约束的连接，可以采用“&&”（and）、“||”(or)和“,”(and)来实现，表面上看“,”与“&&”具有相同的含义，但是有一点需要注意，“，”与“&&”和“||” 不能混合使用
##比较操作符
操作符包括：>、>=、<、<=、= =、!=、contains、not contains、memberof、not memberof、matches、not matches
<!--more-->
contains、not contains、memberof、not memberof都是用来判断Fact对象的某个字段与集合（Collection/Array）的关系，区别在于contains和not contains中集合类型的数据作为比较项，而memberOf和not memberOf中集合类型的数据作为被比较项
```java
#contains
rule "rule1"
    when    
        $order:Order(items contains "手机");
    then      
        System.out.println($order.getName());  
end

#memberOf
rule "rule1"    
    when   
        $order:Order("手机" memberOf items);  
    then      
        System.out.println($order.getName()); 
end 
```
matches和not matches是用来对某个Fact的字段与标准的Java正则表达式进行相似匹配，被比较的字符串可以是一个标准的Java正则表达式，但有一点需要注意，那就是正则表达式字符串当中不用考虑“\”的转义问题

#RHS
不建议在RHS代码当中有条件判断，如果需要条件判断，那么请重新考虑将其放在LHS当中，否则就违背了使用规则的初衷。


更多RHS的相关知识请参考一下几篇文章：
[Drools宏对象的常用方法](https://zaozaool.github.io/2016/04/25/Drools宏对象的常用方法/)

#Drools文件中的package和Java文件中package的区别
规则文件当中的package和Java语言当中的package有相似之处，也有不同之处。在Java 当中package的作用是用来对功能相似或相关的文件放在同一个package下进行管理，这种package管理既有物理上Java文件位置的管理也有逻辑上的文件位置的管理，在Java当中这种通过package管理文件要求在文件位置在逻辑上与物理上要保持一致；在Drools的规则文件当中package对于规则文件中规则的管理只限于逻辑上的管理，而不管其在物理上的位置如何，这点是规则与Java文件的package的区别。
