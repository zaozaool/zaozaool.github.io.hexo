title: jQuery源码分析笔记
date: 2016-08-25 05:35:39
categories: [前端]
tags: [jQuery]
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

[源码分析博客](http://www.cnblogs.com/nuysoft/archive/2011/11/14/2248023.html)