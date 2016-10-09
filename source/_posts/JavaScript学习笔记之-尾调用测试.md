title: JavaScript学习笔记之 斐波那契数列尾调用测试
date: 2015-10-01 07:45:51
categories: [后端]
tags: [JavaScript, 算法]
---

为了验证JavaScript中尾调用的优点，所以做了计算斐波那契数列的尾调用写法和非尾调用写法的性能对比，结果是惊人的，真是不试不知道，一试吓一跳。

这里我都是循环计算斐波那契数列第1-40位的数值，下面是各个环境的验证结果：
**Firefox: 普通写法:1000-1300 ms，尾调用写法:0-2 ms**
**Chrome: 普通写法:1550-1700 ms，尾调用写法:0-2 ms**
**IE9: 普通写法:46000+ ms，尾调用写法:0-2 ms**

以上只是在我自己电脑上的3种浏览器测试的结果，但是可以看出其巨大的差异，所以多函数嵌套调用以及递归时，尽可能的使用尾调用。[测试地址](https://zaozaool.github.io/test-fibonacci.html)
<!--more-->

普通写法（非尾调用）：
```javascript
function fibonacci(n) {
    if (n <= 2) {
        return 1;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```

尾调用写法：
```javascript
function fibonacci(n) {
    n = n || 1; //undefined、null、false、0、NaN、””（空字符串）
    n = isNaN(n) ? 1 : n; //非数值类型
    n = n < 0 ? 1 : n; //负数
    //n = parseInt(n); //取整
    n = ~~n; //使用否运算取整
    var a = 1;
    var b = 1;
    if (arguments.length == 3) {
        a = arguments[1];
        b = arguments[2];
    }
    if (n <= 2) {
        return b;
    } else {
        return fibonacci(n - 1, b, a + b);
    }
}
```


有关尾调用的介绍，请参看下面这篇文章：
阮一峰 [尾调用优化](http://www.ruanyifeng.com/blog/2015/04/tail-call.html)