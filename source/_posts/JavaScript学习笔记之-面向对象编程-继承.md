title: JavaScript学习笔记之 面向对象编程-继承
date: 2015-09-21 09:02:06
categories: [后端]
tags: [JavaScript]
---

#I、构造函数的继承
动物与猫的继承如何实现呢？
```javascript
function Animal() {
    this.species = "动物";
}
Animal.prototype.eat = function() {
    alert("Eat anything.");
};
function Cat(name, color) {
    this.name = name;
    this.color = color;
}
```
<!--more-->
##1.1、构造函数继承
使用call或apply方法，将父对象的构造函数绑定在子对象上，即在子对象构造函数中加一行：
```javascript
function Cat(name, color) {
    Animal.apply(this, arguments);
    this.name = name;
    this.color = color;
}
var cat1 = new Cat("大毛", "黄色");
alert(cat1.species); // 动物
cat1.eat();//cat1.eat is not a function
```
缺点: 只能继承父类的实例属性，因而找不到eat方法

##1.2、prototype继承（即原型链继承）
```javascript
// 将Cat的prototype对象指向一个Animal的实例，相当于完全删除了prototype 对象原先的值，然后赋予一个新值
Cat.prototype = new Animal(); 
alert(Cat.prototype.constructor == Animal); //true
Cat.prototype.constructor = Cat; // 编程时务必要遵守
alert(Cat.prototype.constructor == Cat); //true
var cat1 = new Cat("大毛", "黄色");
alert(cat1.species); // 动物

// 实例也有一个constructor属性，默认调用prototype对象的constructor属性
alert(cat1.constructor == Cat.prototype.constructor); // true

```

##1.3、直接继承prototype（***慎用***）
该方法为prototype继承的改进，与其相比，
优点：效率比较高（不用执行和建立Animal的实例了），比较省内存。
缺点：Cat.prototype和Animal.prototype指向了同一个对象，任何对Cat.prototype的修改，都会反映到Animal.prototype。
```javascript
Cat.prototype = Animal.prototype;
Cat.prototype.constructor = Cat; // 编程时务必要遵守
var cat1 = new Cat("大毛", "黄色");
alert(cat1.species); // 动物
```


#II、非构造函数的继承
如何实现医生继承自中国呢？
```javascript
var Chinese = {
    nation: '中国'
};
var Doctor = {
    career: '医生'
}
```

##2.1、object()方法
json格式的发明人Douglas Crockford，提出了一个object()函数，可以做到这一点。
```javascript
function object(o) {
    function F() {}
    F.prototype = o;
    return new F();
}
```
这个object()函数，其实只做一件事，就是把子对象的prototype属性，指向父对象，从而使得子对象与父对象连在一起。
```javascript
//第一步先在父对象的基础上，生成子对象
var Doctor = object(Chinese);
//再加上子对象本身的属性
Doctor.career = '医生';
alert(Doctor.nation); //中国
```

##2.2、浅拷贝
只拷贝基本类型的数据，jQuery的早期实现方式
```javascript
//浅拷贝方法，和Object.create(obj)的实现原理是一样的
function extendCopy(p) {
    var c = {};
    for (var i in p) {
        c[i] = p[i];
    }
    c.uber = p;
    return c;
}
var Doctor = extendCopy(Chinese);
Doctor.career = '医生';
alert(Doctor.nation); // 中国

//浅拷贝的问题：如果父对象的属性等于数组或另一个对象，那么实际上，子对象获得的只是一个内存地址，而不是真正拷贝，因此存在父对象被篡改的可能。
Chinese.birthPlaces = ['北京','上海','香港'];
var Doctor = extendCopy(Chinese);
Doctor.birthPlaces.push('厦门');
alert(Doctor.birthPlaces); //北京, 上海, 香港, 厦门
alert(Chinese.birthPlaces); //北京, 上海, 香港, 厦门
```

##2.3、深拷贝
实现数组和对象的拷贝，递归调用"浅拷贝"即可，jQuery的现行实现方式
```javascript
function deepCopy(p, c) {
    var c = c || {};
    for (var i in p) {
        if (typeof p[i] === 'object') {
            c[i] = (p[i].constructor === Array) ? [] : {};
            deepCopy(p[i], c[i]);
        } else {
            c[i] = p[i];
        }
    }
    return c;
}
Chinese.birthPlaces = ['北京','上海','香港'];
var Doctor = deepCopy(Chinese);
Doctor.birthPlaces.push('厦门');
alert(Doctor.birthPlaces); //北京, 上海, 香港, 厦门
alert(Chinese.birthPlaces); //北京, 上海, 香港
```

#III、寄生组合继承
最流行，最经典的JavaScript继承方式
```javascript
function Cat(name, color) {
    Animal.apply(this, arguments);
    this.name = name;
    this.color = color;
}
Cat.prototype = Object.create(Animal.prototype);//浅拷贝，这里也可以直接换成深拷贝
Cat.prototype.constructor = Cat; // 编程时务必要遵守
```


此文章原文来自：
阮一峰 [Javascript面向对象编程（二）：构造函数的继承](http://www.ruanyifeng.com/blog/2010/05/object-oriented_javascript_inheritance.html)
阮一峰 [Javascript面向对象编程（三）：非构造函数的继承](http://www.ruanyifeng.com/blog/2010/05/object-oriented_javascript_inheritance_continued.html)
[Javascript中的几种继承方式比较](http://blog.csdn.net/kkkkkxiaofei/article/details/46474069)
