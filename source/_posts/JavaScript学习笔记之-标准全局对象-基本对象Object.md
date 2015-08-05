title: 'JavaScript学习笔记之 全局对象[Object]'
date: 2015-07-21 06:56:05
categories:
tags: JavaScript
---

1.使用[Object.create(proto, [ propertiesObject ])](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/create)实现类式继承
`new Constructor()`与`Object.create(Constructor.prototype)`的区别是`new Constructor()`会执行`Constructor`的初始代码，而`Object.create`不会执行