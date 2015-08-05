title: 深入浅出Node.js - 模块加载(2.2)
date: 2015-07-30 04:33:30
categories:
tags: [Node.js, 深入浅出Node.js]
---

1.加载模块的3个步骤
- 路径分析
- 文件定位
- 编译执行

2.加载顺序
- 优先从缓存加载（无论是核心模块还是文件模块，都优先从缓存加载）
- 核心模块的缓存检查先于文件模块的缓存检查
- 缓存中没有的再通过路径分析、文件定位、编译执行加载

3.路径分析、文件定位、模块编译
- 模块标识符分析
    - 核心模块，如`http`、`fs`、`path`等
    - 以.或..开始的相对路径文件模块
    - 以/开始的绝对路径文件模块
        - 以.或..或/开始的标识符，`require`方法会将路径转化为真实路径，并以真实路径为索引，将编译结果存放当缓存中，使二次加载更快
    - 非路径开始的文件模块，一般为第三方包，即自定义模块，自定义模块路径的生成规则为：
        - 当前文件目录下的`node_modules`目录
        - 父目录下的`node_modules`
        - 沿路径向上逐级递归，直到根目录下的`node_modules`

- 文件定位
    - Node按照`.js、.json、.node`的次序补足扩展名（**如果是`.node`和`.json`的文件在`require`时带上扩展名**）
    - 如果`require`的是一个目录，则Node会当做包（自定义模块）来处理，
        - 解析`package.json`，找到main属性指定的文件进行定位，如无扩展名则进入扩展名分析的步骤
        - 如main属性指定的文件名错误或没有`package.json`，则默认将index当做默认文件名，依次查找`index.js、index.json、index.node`
        - 如以上2步定位失败，则进入下一个模块路径进行查找，如遍历完毕依然没有定位成功，则抛出查找失败异常

- 模块编译
    - Node中，每个文件模块都是一个对象
    - 不同的扩展名载入方法
        - `.js`通过`fs`模块同步读取编译
        - `.node`是C\C++编写的扩展文件，通过`process.dlopen()`加载最后编译生成的文件，所以`.node`模块文件不需要编译，只有加载和执行。实际上在Windows下是`.dll`文件，在*nix下是`.so`文件
        - `.json`通过`fs`模块同步读取，用`JSON.parse()`解析返回
        - 其他扩展名都被当做`.js`文件载入
    - 编译成功的文件模块会将文件路径作为索引缓存在`Modele._cache`对象上（核心模块缓存到`NatvieModule._cache`对象上）
    - 模块的`exports`、`require`、`module`、`__filename`、`__dirname`在哪儿定义的？Node在编译模块时进行头尾包装，如：
```javascript
(function(exports, require, module, __filename, __dirname){
    var math = require('math');
    exports.area = function(radius) {
        return Math.PI * radius * radius;
    }
});
```
      达到模块间作用域隔离，包装后通过VM原生模块的`runInThisContext()`执行（类似`eval`，只有明确上下文，不污染全局）返回一个具体的function，最后将当前模块对象的`exports`、`require()`、`module`(模块对象本身)以及文件路径、文件目录作为参数传递给这个function执行

