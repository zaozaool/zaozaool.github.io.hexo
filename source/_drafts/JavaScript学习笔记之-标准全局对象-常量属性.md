title: JavaScript学习笔记之 全局对象[常量属性]
date: 2015-07-21 01:41:20
categories:
tags: JavaScript
---

1.[判断一个值是否是NaN](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/NaN)
等号运算符（== 和 ===） 不能被用来判断一个值是否是 NaN。必须使用 Number.isNaN() 或 [isNaN()](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/isNaN) 函数。

2.[Infinity](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Infinity)、[Number.NEGATIVE_INFINITY](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Number/NEGATIVE_INFINITY)、[Number.POSITIVE_INFINITY](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Number/POSITIVE_INFINITY)

3.[undifined](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/undefined):必须使用严格相等运算符===,而不能使用普通的相等运算符==,因为x == undefined成立还可能是因为x为null,在JavaScript中null== undefined是返回true的.
<!--more-->
```javascript
var x;
if (x === undefined) {
   // 执行到这里
} else {
   // 不会执行到这里
}
```
如果一个变量根本没有被声明,只有使用typeof判断才不会报错,用相等运算符判断会抛出异常
```javascript
// x没有被声明过
if (typeof x === 'undefined') { // 不会报错
   // these statements execute
}
if(x === undefined){ // 抛出ReferenceError异常
}
```
不过如果要检测的变量是个全局变量,可以不使用typeof.可以通过检测全局对象的同名属性来代替
```javascript
// x可能没有被声明过,但如果已经声明了的话,x是个全局变量
if (window.x === undefined) { // 即使window.x不存在,也不会报错
   // 可能会执行到这里
}
if(x === undefined){ // 如果window.x不存在,则会抛出ReferenceError异常
}
```

4.[null 是一个字面量（而不是全局对象的一个属性，undefined 是）](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/null)
null 与 undefined 的不同点：
```javascript
typeof null        // object (bug in ECMAScript, should be null)
typeof undefined   // undefined
null === undefined // false
null  == undefined // true
```
