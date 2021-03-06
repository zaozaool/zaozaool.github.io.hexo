title: 深入浅出Node.js - 异步I/O(3.2-3.4)
date: 2015-08-11 13:21:28
categories: [后端]
tags:  [Node.js, 深入浅出Node.js]
---

1.异步I/O与非阻塞I/O
- 异步与非阻塞都能达到并行I/O的目的
- 从计算机内核I/O而言，异步/同步于阻塞/非阻塞不是一码事
- 系统内核I/O只有两种方式：阻塞于非阻塞（阻塞I/O造成CPU等待浪费，非阻塞I/O让CPU处理状态判断，所以是对CPU的浪费）
    - 在调用阻塞I/O时，应用程序需要等待I/O完成才返回结果，造成CPU等待I/O，不能充分利用CPU，所有内核提供非阻塞I/O
    - 在调用非阻塞I/O时会立即返回，CPU的时间片可以用来处理其他事务，但是由于返回的不是业务层期望的数据，而只是当前调用的状态，那么应用程序需要通过`轮询`获取数据<!--more-->

2.轮询的技术演进
- `read`：最原始、性能最低的一种，通过重复调用来检查I/O的状态来完成数据的读取，在最终得到数据前，CPU一直好用在等待上
- `select`：在`read`基础上改进，通过对文件描述符上的事件状态来进行判断，最多同时检查1024个文件描述符
- `poll`：该方案将`select`中的1024长度的数组换成了链表的方式，避免数组长度的限制。其次避免了不必要的检查
- `epoll`：Linux下效率最高的I/O事件通知机制，在进入轮询时如果没有检查到I/O事件，将会进行休眠，直到事件发生将他唤醒
- `kqueue`：实现方式和`epoll`类型，不过仅在`FreeBSD`系统下存在

3.Node的异步I/O
- 事件循环：进程启动时，Node创建一个类型与`while(true)`的循环，每执行一次循环体的过程称为`Tick`，每个`Tick`的过程就是查看是否有事件待处理，如有则取出事件及其相关回调函数并执行。然后执行下个循环，如不再有事件处理则退出进程。在Windows下该循环基于IOCP创建，二在*nix下则基于多线程创建
- 观察者：每个`Tick`的过程中，有一个或者多个观察者，并通过向他们询问来判断是否有事件需要处理
- 请求对象：是异步I/O的中间产物，所有的状态都保存在这个对象中，包括送入线程池等待执行以及I/O操作完毕后的回调函数，其是异步I/O的第一部分
- 执行回调：其是第二部分
- 流程图：

4.非I/O的异步API
- `setTimeout()`
- `setInterval()`
- `setImmediate()`
- `process.nextTick()`


