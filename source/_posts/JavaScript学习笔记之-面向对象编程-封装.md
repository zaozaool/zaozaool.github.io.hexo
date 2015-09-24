title: JavaScript学习笔记之 面向对象编程-封装
date: 2015-09-21 08:17:49
categories:
tags: JavaScript
---

#一、 原始模式
```javascript
var Cat = {
    name: '',
    color: ''
}
```
<!--more-->
生成实例：
```javascript
var cat1 = {}; // 创建一个空对象
cat1.name = "大毛"; // 按照原型对象的属性赋值
cat1.color = "黄色";
var cat2 = {};
cat2.name = "二毛";
cat2.color = "黑色";
```
缺点：一是如果多生成几个实例，写起来就非常麻烦；二是实例与原型之间，没有任何办法可以看出有什么联系。

原始模式的改进
```javascript
function Cat(name, color) {
    return {
        name: name,
        color: color
    }
}
```
生成实例：
```javascript
var cat1 = Cat("大毛", "黄色");
var cat2 = Cat("二毛", "黑色");
```
缺点：依然是cat1和cat2之间没有内在的联系，不能反映出它们是同一个原型对象的实例。

#二、 构造函数模式
```javascript
function Cat(name, color) {
    this.name = name;
    this.color = color;
}
```
生成实例：
```javascript
var cat1 = Cat("大毛", "黄色");
var cat2 = Cat("二毛", "黑色");
```
这时cat1和cat2会自动含有一个constructor属性，指向它们的构造函数。
Javascript还提供了一个instanceof运算符，验证原型对象与实例对象之间的关系。
```javascript
alert(cat1.constructor == Cat); //true
alert(cat2.constructor == Cat); //true
alert(cat1 instanceof Cat); //true
alert(cat2 instanceof Cat); //true
```
缺点：存在一个浪费内存的问题，比如对于不变的属性和方法，实例后会复制，如：
```javascript
function Cat(name, color) {
    this.name = name;
    this.color = color;
    this.type = "猫科动物";
    this.eat = function() {
        alert("吃老鼠");
    };
}
```
生成实例：
```javascript
var cat1 = new Cat("大毛", "黄色");
var cat2 = new Cat("二毛", "黑色");
alert(cat1.eat == cat2.eat); //false
```

#三、Prototype模式
将不变的属性和方法，直接定义在prototype对象上。
```javascript
function Cat(name, color) {
    this.name = name;
    this.color = color;
}
Cat.prototype.type = "猫科动物";
Cat.prototype.eat = function() {
    alert("吃老鼠");
};
```
生成实例：
```javascript
var cat1 = new Cat("大毛", "黄色");
var cat2 = new Cat("二毛", "黑色");
alert(cat1.eat == cat2.eat); //true
```

Prototype模式的验证方法：
- isPrototypeOf()：用来判断，某个proptotype对象和某个实例之间的关系。
```javascript
alert(Cat.prototype.isPrototypeOf(cat1)); //true
alert(Cat.prototype.isPrototypeOf(cat2)); //true
```
- hasOwnProperty()：用来判断某一个属性到底是本地属性，还是继承自prototype对象的属性。
```javascript
alert(cat1.hasOwnProperty("name")); // true
alert(cat1.hasOwnProperty("type")); // false
```
- in运算符：用来判断，某个实例是否含有某个属性，不管是不是本地属性。还可以用来遍历某个对象的所有属性。
```javascript
alert("name" in cat1); // true
alert("type" in cat1); // true

for (var prop in cat1) {
    alert("cat1[" + prop + "]=" + cat1[prop]);
}
```

此文章原文来自[Javascript 面向对象编程（一）：封装](http://www.ruanyifeng.com/blog/2010/05/object-oriented_javascript_encapsulation.html)