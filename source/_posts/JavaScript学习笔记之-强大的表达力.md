title: JavaScript学习笔记之 强大的表达力
date: 2015-09-24 09:02:35
categories: [后端]
tags: [JavaScript]
---

#自定义方法
```javascript
Number.prototype.add = function(x) {
    return this + x;
};
console.log(8['add'](2));//10
console.log((8).add(2));//10
//第一个点解释为小数点，第二个点解释为点运算符。
console.log(8..add(2));//10
//报错，因为数值后面的点，会被解释为小数点，而不是点运算符。
console.log(8.add(2));//SyntaxError: Unexpected token ILLEGAL
```
<!--more-->
#链式运算
```javascript
Number.prototype.subtract = function(x) {
    return this - x;
};
console.log((8).add(2).subtract(4));//6
console.log(8["add"](2)["subtract"](4));//6
```

#去掉圆括号
将(8).double().square()-->(8).double.suqare
ES5规定，每个对象的属性都有一个取值方法get，用来自定义该属性的读取操作。
```javascript
Number.prototype = Object.defineProperty(
    Number.prototype, "double", {
        get: function() {
            return (this + this)
        }
    }
);
Number.prototype = Object.defineProperty(
    Number.prototype, "square", {
        get: function() {
            return (this * this)
        }
    }
);
console.log((8).double); //16
console.log((8).double.square); //256
console.log(8["double"]["square"]); //256
```


此文章原文来自：
阮一峰 [JavaScript 有多灵活](http://www.ruanyifeng.com/blog/2015/02/flexible-javascript.html)