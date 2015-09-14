title: 深入浅出Node.js - 前后端共用模块(2.7)
date: 2015-08-04 05:14:25
categories:
tags: [Node.js, 深入浅出Node.js]
---

1.AMD规范：`define(id?, dependencies?, factory);`

```javascript
define(['dep1', 'dep2'], function(dep1, dep2){
    return function(){};
});

```

2.CMD规范：`define(factory)`
```javascript
define(function(require, exports, module){
    //模块代码
});

```
<!--more-->

3.AMD与CMD区别
- AMD需要在声明模块时指定所有的依赖，通过形参传递依赖到模块内，而CMD支持动态引入，即CMD 推崇依赖就近，AMD 推崇依赖前置（AMD 也支持 CMD 的写法）
```javascript
// CMD
define(function(require, exports, module) {
    var a = require('./a')
    a.doSomething()
    // 此处略去 100 行
    var b = require('./b') // 依赖可以就近书写
    b.doSomething()
    // ...
})

// AMD 默认推荐的是
define(['./a', './b'], function(a, b) { // 依赖必须一开始就写好
    a.doSomething()
    // 此处略去 100 行
    b.doSomething()
    // ...
})
```
- AMD 是 RequireJS 在推广过程中对模块定义的规范化产出。CMD 是 SeaJS 在推广过程中对模块定义的规范化产出。
更详尽可以查看[AMD规范与CMD规范介绍](http://blog.chinaunix.net/uid-26672038-id-4112229.html)

3.兼容多种模块规范（Node、AMD、CMD、常见浏览器）
```javascript
;(function(name, definition){
    //检查上下文环境是否为AMD或CMD
    var hasDefine = typeof define === 'function';
    //检查上下文环境是否是node
    var hasExports = typeof module !== 'undefined' && module.exports;
    
    if (hasDefine) {
        //AMD、CMD
        define(definition);
    } else if (hasExports) {
        //Node
        module.exports = definition();
    } else {
        //将模块的执行结果挂在window变量中，在浏览器中this指向window对象
        this[name] = definition();
    }
})('hello', function(){
    var hello = function(){
        console.log('hello world');
    };
    return hello;
});
```