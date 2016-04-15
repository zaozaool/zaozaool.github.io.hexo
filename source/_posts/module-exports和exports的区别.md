title: module.exports和exports的区别
date: 2015-07-31 05:39:40
categories: [后端]
tags: [Node.js]
---

这是别人解释的[module.exports和exports的区别](http://zihua.li/2012/03/use-module-exports-or-exports-in-node)

我的理解比较简单，2点：
1.`exports`是对`module.exports`的引用
2.而`require`引入的是`module.exports`
<!--more-->

所以如果只是这样写肯定是有问题的,这样改变了exports的引用地址
```javascript
    exports = something...
```
最保险的写法是
```javascript
exports = module.exports = something...
```

加属性或方法
```javascript
    exports.attr = something...
    exports.method = something...
```
或
```javascript
    module.exports.attr = something...
    module.exports.method = something...
```

轻拍...