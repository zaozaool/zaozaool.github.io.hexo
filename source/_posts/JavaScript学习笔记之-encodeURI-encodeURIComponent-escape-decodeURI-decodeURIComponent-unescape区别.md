title: JavaScript学习笔记之 encodeURI、encodeURIComponent、escape、decodeURI、decodeURIComponent、unescape区别
date: 2015-10-01 02:34:35
categories:
tags: JavaScript
---

1.URI方法encodeURI、encodeURIComponent()、decodeURI()、decodeURIComponent()代替了BOM的escape()和unescape()方法。URI方法更可取，因为它们对所有Unicode符号编码,而BOM方法只能对ASCII符号正确编码。尽量避免使用escape()和unescape()方法。
<!--more-->
2.编码
- 传递参数时需要使用encodeURIComponent，这样组合的url才不会被#等特殊字符截断。
- 进行url跳转时可以整体使用encodeURI。
- js使用数据时可以使用escape。
- escape对0-255以外的unicode值进行编码时输出%u****格式，其它情况下escape，encodeURI，encodeURIComponent编码结果相同。
    - escape不编码字符有69个：*，+，-，.，/，@，_，0-9，a-z，A-Z
    - encodeURI不编码字符有82个：!，#，$，&，'，(，)，*，+，,，-，.，/，:，;，=，?，@，_，~，0-9，a-z，A-Z
    - encodeURIComponent不编码字符有71个：!， '，(，)，*，-，.，_，~，0-9，a-z，A-Z

3.解码，分别使用decodeURI/decodeURIComponent/unescape对经过encodeURI/encodeURIComponent/escape编码的字符串进行

4.Base64：JavaScript原生提供两个Base64相关方法。
- btoa()：字符串或二进制值转为Base64编码
- atob()：Base64编码转为原来的编码

```javascript
var string = 'Hello World!';
btoa(string) // "SGVsbG8gV29ybGQh"
atob('SGVsbG8gV29ybGQh') // "Hello World!"

//两个方法不适合非ASCII码的字符
btoa('你好')
// Uncaught DOMException: The string to be encoded contains characters outside of the Latin1 range.

//将非ASCII码字符转为Base64编码，必须中间插入一个转码环节
function b64Encode( str ) {
  return btoa(unescape(encodeURIComponent( str )));
}

function b64Decode( str ) {
  return decodeURIComponent(escape(atob( str )));
}

b64Encode('你好') // "5L2g5aW9"
b64Decode('5L2g5aW9') // "你好"
```

此文章原文来自：
[javascript中escape()、unescape()、encodeURI()、encodeURIComponent()、decodeURI()、decodeURIComponent()比较](http://www.cnblogs.com/jhxk/articles/1634359.html)
阮一峰 [Base64转码](http://javascript.ruanyifeng.com/grammar/string.html#toc5)