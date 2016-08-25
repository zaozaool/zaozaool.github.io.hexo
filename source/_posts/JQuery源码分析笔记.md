title: jQuery源码分析笔记
date: 2016-08-25 05:35:39
categories: [前端]
tags: [JavaScript, jQuery]
---

- js自调用匿名函数的两种写法：
```javascript
(function(window, undefined){
    // code
})(window);

(function(window, undefined){
    // code
}(window));
```
	
- undefined能够被重写，赋予新的值。
```javascript
undefined = "now it's defined";
alert( undefined );
```
<!-- more -->
| 浏览器   | 测试结果            | 结论          |
| :------- |:------------------- | -------------:|
| ie       | now it's defined    | 可以改变      |
| ff       | undefined           | 不能改变      |
| chrome   | now it's defined    | 可以改变      |
| opera    | now it's defined    | 可以改变      |


- jQuery.fn.init.prototype = jQuery.fn = jQuery.prototype
jQuery.fn.init的功能是对传进来的selector参数进行分析，进行各种不同的处理，然后生成jQuery对象。

| 类型（selector）   | 处理方式                           |
| :-------------     |:---------------------------------- |
| DOM元素            | 包装成jQuery对象，直接返回         |
| body（优化）       | 从document.body读取                |
| 单独的HTML标签     | document.createElement             |
| HTML字符串         | document.createDocumentFragment    |
| HTML字符串         | document.createDocumentFragment    |
| #id                | document.getElementById            |
| 选择器表达式       | $(…).find                          |
| 函数               | 注册到dom ready的回调函数          |
		
				
- jQuery.extend = jQuery.fn.extend 
合并两个或更多对象的属性到第一个对象中。
```javascript
jQuery.extend([deep], target, object1, [objectN])
```

- jQuery中的循环技巧
    - 简单的for-in（事件）
```javascript
for ( type in events ) {}
```

    - 缓存length属性，避免每次都去查找length属性，稍微提升遍历速度。
    但是如果遍历HTMLCollection时，性能提升非常明显，因为每次访问HTMLCollection的属性，HTMLCollection都会内部匹配一次所有的节点  
```javascript
for ( var j = 0, l = handlers.length; j < l; j++ ) {}
```

    - 不比较下标，直接判断元素是否为true（强制类型转换）
```javascript
var elem;
for ( var i = 0; elems[i]; i++ ) {
	elem = elems[i];
	// ...
}
```

    - 遍历动态数组（事件），不能缓存length属性，j++之前先执行j--，保证不会因为数组下标的错误导致某些数组元素遍历不到
```javascript
for ( j = 0; j < eventType.length; j++ ) {
	eventType.splice( j--, 1 );
}
for ( var i = 1; i < results.length; i++ ) {
	if ( results[i] === results[ i - 1 ] ) {
		results.splice( i--, 1 );
	}
}
```

    - 迭代过程中尽可能减少遍历次数（事件），如果你能知道从哪里开始遍历的话，这里是pos
```javascript
for ( j = pos || 0; j < eventType.length; j++ ) {}
```

    - 倒序遍历（事件），减少了几个字符：循环条件判断，合并i自减和i取值，倒序遍历会有浏览器优化，稍微提升遍历速度
```javascript
for ( var i = this.props.length, prop; i; ) {
	prop = this.props[ --i ];
	event[ prop ] = originalEvent[ prop ];
}
```

[源码分析博客](http://www.cnblogs.com/nuysoft/archive/2011/11/14/2248023.html)