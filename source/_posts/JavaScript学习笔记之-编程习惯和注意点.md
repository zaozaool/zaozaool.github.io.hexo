title: 'JavaScript学习笔记之 编程习惯和注意点'
date: 2015-07-20 05:03:26
categories: 
tags: JavaScript
---

1.我们将 `<script>` 元素放在 HTML 文件底部的原因是，浏览器解析 HTML 似乎按照代码出现的顺序来的。如果 JavaScript被首先读取，它也应该影响下面的 HTML，但有时会出现问题，因为 JavaScript 会在 HTML 之前被加载，如果 JavaScript 代码出现问题则 HTML 不会被加载。所以将 JavaScript 代码放在底部是最好的选择。

2.JS中的每一行都应该以一个分号结尾，以表明这一行的结束。如果你不这样做，可能会遇到意想不到的结果。

3.变量提升只对var命令声明的变量有效，如果一个变量不是用var命令声明的，就不会发生变量提升。
<!--more-->
4.标识符的第一个字符为Unicode字母，以及$和_。中文也是合法的标识符。
```javascript
var 临时变量 = 1;// 合法
```

5.对于区块语句，建议始终使用大括号。

6.switch语句后面的表达式与case语句后面的表示式，在比较运行结果时，采用的是严格相等运算符（===），而不是相等运算符（==），这意味着比较时不会发生类型转换。

7.JavaScript的[数据类型](http://javascript.ruanyifeng.com/grammar/basic.html#toc9)，共有六个类别和两个特殊值。
- 原始类型：数值（number）、字符串（string）、布尔值（boolean）
- 合成类型：对象（object）、数组（array）、函数（function）
- 特殊值：null和undefined

8.JavaScript有三种方法，可以确定一个值到底是什么类型：[typeof运算符](http://javascript.ruanyifeng.com/grammar/basic.html#toc11)、instanceof运算符、Object.prototype.toString方法
```javascript
//原始类型
typeof 123 // "number"
typeof "123" // "string"
typeof false // "boolean"
typeof NaN // "number"

//函数
function f(){};
typeof f // "function"

//undefined
typeof undefined // "undefined"
// 错误的写法
if (v){} // ReferenceError: v is not defined
// 正确的写法
if (typeof v === "undefined"){}

//其他
typeof window // "object"
typeof {} // "object"
typeof [] // "object"
typeof null // "object"

//区分数组和对象
var o = {};
var a = [];
o instanceof Array // false
a instanceof Array // true
```

9.[null和undefined](http://javascript.ruanyifeng.com/grammar/basic.html#toc12)
```javascript
//在if语句中，都会被自动转为false，相等运算符甚至直接报告两者相等
if (!undefined) 
    console.log('undefined is false');
// undefined is false
if (!null) 
    console.log('null is false');
// null is false
undefined == null // true
Number(null) // 0
Number(undefined) // NaN
/*
null表示"没有对象"，即该处不应该有值。典型用法是：
- 作为函数的参数，表示该函数的参数不是对象。
- 作为对象原型链的终点。

undefined表示"缺少值"，就是此处应该有一个值，但是还未定义。典型用法是：
- 变量被声明了，但没有赋值时，就等于undefined。
- 调用函数时，应该提供的参数没有提供，该参数等于undefined。
- 对象没有赋值的属性，该属性的值为undefined。
- 函数没有返回值时，默认返回undefined。

JavaScript的标识名区分大小写，undefined和null不同于Undefined和Null，后者只是普通的变量名。
*/
```

10.结果为false的值包括：undefined、null、false、0、[NaN](http://javascript.ruanyifeng.com/grammar/number.html#toc7)、""（空字符串），其他值都视为true。

11.JavaScript内部，所有数字都是以64位浮点数形式储存，整数亦如此，涉及小数的比较和运算要特别小心。
```javascript
1 === 1.0 // true
1 + 1.0 // 2
0.1 + 0.2 === 0.3 // false
0.3 / 0.1 // 2.9999999999999996
(0.3-0.2) === (0.2-0.1) // false
Number.MAX_VALUE // 1.7976931348623157e+308
Number.MIN_VALUE // 5e-324
```
- 能够表示的[数值范围](http://javascript.ruanyifeng.com/grammar/number.html#toc3)为[2<sup>1024</sup>, 2<sup>-1023</sup>)。
- JavaScript对指数部分的两个极端值（11111111111和00000000000）做了定义，11111111111表示NaN和Infinity，00000000000表示0。

12.[NaN是JavaScript之中唯一不等于自身的值](http://javascript.ruanyifeng.com/grammar/number.html#toc7)，且NaN不与任何值相等。
```javascript
NaN === NaN // false
```

13.0除以0得到NaN，其他任意数除以0，得到[Infinity](http://javascript.ruanyifeng.com/grammar/number.html#toc8)，Infinity有正负之分。

14.可以用[parseInt](http://javascript.ruanyifeng.com/grammar/number.html#toc10)方法进行进制的转换。

15.如果长字符串必须分成多行，可以在每一行的尾部使用反斜杠。反斜杠的后面必须是换行符，而不能有其他字符（比如空格），否则会报错。
```javascript
var longString = "Long \
string";
```

16.检查变量是否声明
```javascript
if(a) {} // 报错
if(window.a) {} // 不报错
if(window['a']) {} // 不报错
//后二种写法有漏洞，如果a属性是一个空字符串（或其他对应的布尔值为false的情况），则无法起到检查变量是否声明的作用。正确的写法是使用in运算符。
if('a' in window) {}
```

17.[删除属性](http://javascript.ruanyifeng.com/grammar/object.html#toc6)：一般情况下delete obj.prop都会返回true，即使obj.prop不存在；除非obj.prop定义为不能删除的，此时返回false。delete命令只能删除对象本身的属性，不能删除继承的属性。

18.[javascript中对象是引用传递，而原始类型都是值传递](http://javascript.ruanyifeng.com/grammar/object.html#toc7)。[函数参数传递方式](http://javascript.ruanyifeng.com/grammar/function.html#toc18)是传值传递，但是对于复合类型的变量来说，属性值是传址传递（pass by reference），也就是说，属性值是通过地址读取的。所以在函数体内修改复合类型变量的属性值，会影响到函数外部。

19.[in](http://javascript.ruanyifeng.com/grammar/object.html#toc8)不能识别对象继承的属性，可以使用hasOwnProperty判断。

20.[数组是特殊的对象](http://javascript.ruanyifeng.com/grammar/array.html)，数组成员最多只有4294967295个（232-1）个。[空位](http://javascript.ruanyifeng.com/grammar/array.html#toc3)通过空值生成，还是通过显式设为undefined生成，有一个细微的差别。如果通过空值生成，使用数组的forEach方法、for...in结构、以及Object.keys方法进行遍历，空位都会被跳过。
```javascript
var arr = [1, 2];
arr[10] = 10;
arr //[1,2,10]
arr.length //11

var a = ['a'];
a.length = 3;
a // ["a", undefined × 2]
```

21.Javascript只有两种作用域：一种是全局作用域，变量在整个程序中一直存在；另一种是[函数作用域](http://javascript.ruanyifeng.com/grammar/function.html#toc10)，变量只在函数内部存在。

22.理解闭包：[学习Javascript闭包（Closure）](http://www.ruanyifeng.com/blog/2009/08/learning_javascript_closures.html)和[闭包](http://javascript.ruanyifeng.com/grammar/function.html#toc22)。
```javascript
//代码片段一:
var name = "The Window";
var object = {
    name: "My Object",
    getNameFunc: function() {
        return function() {
            return this.name;
        };
    }
};
alert(object.getNameFunc()());//The Window

//代码片段二:
var name = "The Window";
var object = {
    name: "My Object",
    getNameFunc: function() {
        var that = this;
        return function() {
            return that.name;
        };
    }
};
alert(object.getNameFunc()());//My Object

//代码片段三:
function createIncrementor(start) {
    return function() {
        return start++;
    }
}

var inc = createIncrementor(5);
console.log(inc()); // 5
console.log(inc()); // 6
```

23.[相等运算符](http://javascript.ruanyifeng.com/grammar/operator.html#toc8)的缺点，相等运算符隐藏的类型转换，会带来一些违反直觉的结果。建议只使用严格[相等运算符（===）](http://javascript.ruanyifeng.com/grammar/operator.html#toc7)。
```javascript
'' == '0'; // false
0 == ''; // true
0 == '0'; // true

false == 'false'; // false
false == '0'; // true

false == undefined; // false
false == null; // false
null == undefined; // true

'\t\r\n ' == 0; // true
```

24.使用[否运算](http://javascript.ruanyifeng.com/grammar/operator.html#toc17)取整，是所有取整方法中最快的一种。如：~~2.9 //2

25.[异或运算](http://javascript.ruanyifeng.com/grammar/operator.html#toc18)有一个特殊运用，连续对两个数a和b进行三次异或运算，aˆ=b, bˆ=a, aˆ=b，可以互换它们的值。同时异或运算也可以用来取整。如：12.9^0 // 12

26.使用[左移运算符](http://javascript.ruanyifeng.com/grammar/operator.html#toc19)，将颜色的RGB值转为HEX值。
```javascript
var color = {r: 186, g: 218, b: 85};
var rgb2hex = function(r, g, b) {
    return '#' + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).substr(1);
}
rgb2hex(color.r,color.g,color.b) // "#bada55"
```

27.[右移运算符](http://javascript.ruanyifeng.com/grammar/operator.html#toc20)可以模拟2的整除运算。如：21 >> 3 //2

28.位运算符可以用作设置对象属性的[开关](http://javascript.ruanyifeng.com/grammar/operator.html#toc22)。

29.[Object.keys和Object.getOwnPropertyNames](http://javascript.ruanyifeng.com/stdlib/object.html#toc3)返回对象自身的（不包括继承）所有属性名。区别在于Object.keys只返回可枚举的属性。计算对象属性个数：Object.keys(o).length和Object.getOwnPropertyNames(o).length。

30.[Object.observe](http://javascript.ruanyifeng.com/stdlib/object.html#toc4)方法用于观察对象属性的变化。

31.[给数组按照自定义的逻辑排序](http://javascript.ruanyifeng.com/stdlib/array.html#toc11)。
```javascript
[
  { name: "张三", age: 30 },
  { name: "李四", age: 24 },
  { name: "王五", age: 28 }
].sort(function(o1, o2) {
  return o1.age - o2.age;
});
```
32.[substring、substr、slice的区别](http://javascript.ruanyifeng.com/stdlib/string.html#toc6)：
- substring方法的第一个参数表示子字符串的开始位置，第二个位置表示结束位置。如果出现第一个参数大于第二个参数的情况，substring方法会自动更换两个参数的位置。如果参数为负，对于substring方法，会自动将负数转为0。
- substr方法的第一个参数是子字符串的开始位置，第二个参数是子字符串的长度。对于substr方法，负数出现在第一个参数，表示从尾部开始计算的字符位置；负数出现在第二个参数，将被转为0。
- slice方法的第一个参数是子字符串的开始位置，第二个参数是子字符串的结束位置。如果第一个参数大于第二个参数，slice方法并不会自动调换参数位置，而是返回一个空字符串。如果参数为负，对于slice方法，表示字符位置从尾部开始计算。

