title: Node.js学习笔记(一)
date: 2015-07-17 06:35:12
tags: Node.js
---
1.superagent：客户端请求代理模块，抓取页面用的（lession3）
2.cheerio：Node.js版的JQuery（lession3）
3.eventproxy：可以控制异步并发（lession4）
4.async：可以控制异步并发，并且可以自定义并发数（lession5）
5.should：断言库，用于后端测试，和mocha组合使用（lession6）
6.mocha：测试框架（lession6）
7.istanbul：测试率覆盖工具（lession6）
8.[module.exports和exports的区别](http://zihua.li/2012/03/use-module-exports-or-exports-in-node)
9.chai：断言库，用于前端测试，和mocha组合使用（lession7）
10.phantomjs：一个拥有JavaScript API的无界面WebKit（Chrome、Safari都是有界面的WebKit），mocha-phantomjs
11.supertest：专门用来配合express进行集成测试的，和superagent具有相同的API（lession8）
12.npm i --save 与 npm i --save-dev 的区别，devDependencies与dependencies的区别
13.nodemon：自动检测 node.js 代码的改动，然后自动重启应用，完全用 nodemon 命令代替 node 命令（lession8）
14.bower：解决js的依赖管理
15.supervisor：supervisor自动重启应用，supervisor app

req.query： 处理 get 请求，获取 get 请求参数
req.params： 处理 /:xxx 形式的 get 或 post 请求，获取请求参数
req.body： 处理 post 请求，获取 post 请求体
req.param()： 处理 get 和 post 请求，但查找优先级由高到低为 req.params→req.body→req.query

ejs 的标签系统非常简单，它只有以下三种标签：
<% code %>：JavaScript 代码。
<%= code %>：显示替换过 HTML 特殊字符的内容。
<%- code %>：显示原始 HTML 内容。