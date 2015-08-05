title: JavaScript学习笔记之 全局对象[方法属性]
date: 2015-07-21 01:41:20
categories:
tags: JavaScript
---

1.[eval(string, [object])](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/eval)的第一个参数是个字符串。如果字符串表示了一个表达式，eval()会对表达式求值。如果参数表示了一个或多个JavaScript声明， 那么eval()会执行声明。不要调用eval()来为算数表达式求值； JavaScript 会自动为算数表达式求值。解析JSON。
###避免在不必要的情况下使用eval

2.[isFinite(testValue)](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/isFinite) 是全局的方法，不与任何对象有关系。isFinite 方法检测它参数的数值。如果参数是 NaN，正无穷大或者负无穷大，会返回false，其他返回 true。

3.[parseFloat(string)](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/parseFloat)
如果参数字符串的第一个字符不能被解析成为数字,则parseFloat返回NaN.
parseFloat 也可转换和返回Infinity值. 可以使用isFinite 函数来判断结果是否是一个优先的数值 (非Infinity, -Infinity, 或 NaN).

4.[parseInt(string, radix)](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/parseInt)在没有指定基数，或者基数为 0 的情况下，JavaScript 作如下处理：
- 如果字符串 string 以"0x"或者"0X"开头, 则基数是16 (16进制).
- 如果字符串 string 以"0"开头, 基数是8（八进制）或者10（十进制），那么具体是哪个基数由实现环境决定。ECMAScript 5 规定使用10，但是并不是所有的浏览器都遵循这个规定。因此，**永远都要明确给出radix参数的值**。
- 如果字符串 string 以其它任何值开头，则基数是10 (十进制)。
- 如果第一个字符不能被转换成数字，parseInt返回NaN。

将整型数值以特定基数转换成它的字符串值可以使用 **intValue.toString(radix)**.

5.[escape()、unescape()、encodeURI()、encodeURIComponent()、decodeURI()、decodeURIComponent()比较](http://www.cnblogs.com/jhxk/articles/1634359.html)
- 传递参数时需要使用encodeURIComponent，这样组合的url才不会被#等特殊字符截断。 
- 进行url跳转时可以整体使用encodeURI
- 尽量避免使用escape()和unescape()方法