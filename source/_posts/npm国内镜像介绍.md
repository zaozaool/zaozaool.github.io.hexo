title: npm国内镜像介绍
date: 2016-04-19 04:18:52
categories: [后端]
tags: [Node.js, npm]
---
镜像使用方法（三种办法任意一种都能解决问题，建议使用第三种，将配置写死，下次用的时候配置还在）:

#淘宝镜像
1.通过config命令
```shell
npm config set registry https://registry.npm.taobao.org 
npm info underscore （如果上面配置正确这个命令会有字符串response）
```

2.命令行指定
```shell
npm --registry https://registry.npm.taobao.org info underscore 
```

3.编辑 ~/.npmrc 加入下面内容
```shell
registry = https://registry.npm.taobao.org
```
<!--more-->
registry.npm.taobao.org 是从 registry.npmjs.org 进行全量同步的
搜索镜像: https://npm.taobao.org

#cnpm镜像
1.通过config命令
```shell
npm config set registry http://registry.cnpmjs.org npm info underscore （如果上面配置正确这个命令会有字符串response）
```

2.命令行指定
```shell
npm --registry http://registry.cnpmjs.org info underscore
```

3.编辑 ~/.npmrc 加入下面内容
```shell
registry = http://registry.cnpmjs.org
```

搜索镜像: http://cnpmjs.org

文章转载并汇总自：
[使用npm安装一些包失败了的看过来（npm国内镜像介绍）](https://cnodejs.org/topic/4f9904f9407edba21468f31e)
[nodejs npm国内镜像](http://my.oschina.net/gongbaodd/blog/302957)
