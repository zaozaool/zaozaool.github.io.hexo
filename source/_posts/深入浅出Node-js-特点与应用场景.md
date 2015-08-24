title: 深入浅出Node.js - 特点与应用场景(1.4、1.5)
date: 2015-07-30 04:26:17
categories: 
tags: [Node.js, 深入浅出Node.js]
---

1.Node的特点
- 异步I/O
- 基于事件和回调函数
- 单线程与子进程```child_process```
    - 这里的单线程仅仅只是`javascript`执行在单线程中而已，内部I/O另有线程池
- 跨平台
    - Node基于`libuv`实现跨平台 

2.Node的应用场景
- I/O密集型
- CPU密集型 可以通过编写C/C++扩展及子进程的方式实现
- 分布式