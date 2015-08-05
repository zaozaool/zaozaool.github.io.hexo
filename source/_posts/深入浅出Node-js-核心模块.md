title: 深入浅出Node.js - 核心模块(2.3)
date: 2015-07-30 09:17:10
categories:
tags: [Node.js, 深入浅出Node.js]
---

1.核心模块分为C/C++编写的和JavaScript编写的两部分，C/C++文件存放在src目录下，js文件存放在lib目录下，C\C++编写的部分称为内建模块，JavaScript编写的称为核心模块

2.核心模块的编译过程
- 编译C\C++前，编译程序需要将所有的JavaScript模块文件编译为C/C++代码
    - 转存为C/C++代码:先采用V8附带的`js2c.py`工具编译js模块文件为C/C++代码，并以字符串的形式存储到node命名空间，不可直接执行
    - 编译JavaScript核心模块到缓存
- 编译译C\C++

3.核心模块的引入流程，已os模块为例：
`require('os')-->NativeModule.require("os")-->process.binding("os")-->get_builtin_module("node_os")-->NODE_MODULE(node_os, reg_gunc)`
