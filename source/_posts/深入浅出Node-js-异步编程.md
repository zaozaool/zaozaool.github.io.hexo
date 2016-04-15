title: 深入浅出Node.js - 异步编程(4.1-)
date: 2015-08-18 14:13:38
categories: [后端]
tags: [Node.js, 深入浅出Node.js]
---

1.函数式编程
- 高阶函数：将函数作为参数或返回值的函数
- 偏函数：参数和变量已经预置的函数的函数，如：

```javascript
var isType = function(type) {
    return function(obj) {
        var toString = Object.prototype.toString;
        return toString.call(obj) == '[object' + type + ']';
    }
}
//创建isString()、isFunction()
var isString = isType('String');
var isFunction = isType('Function');
```
<!--more-->

`Underscore`的`after()`是偏函数的应用：
```javascript
_.after = function(times, func) {
    if (times <= 0) {
        return func();
    }
    return function() {
        if (--times < 1) {
            return func.apply(this.argments);
        };
    };
};
```

