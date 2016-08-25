title: jQuery中的循环技巧
date: 2016-08-25 06:03:26
categories: [前端]
tags: [JavaScript, jQuery]
---


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
<!-- more -->
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