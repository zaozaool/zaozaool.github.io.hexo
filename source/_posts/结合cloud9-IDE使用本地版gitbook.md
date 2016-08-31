title: 结合cloud9 IDE使用本地版gitbook
date: 2016-08-31 01:24:28
categories: [其他]
tags: [Git]
---

1.  安装node(建议使用nvm安装，方便版本管理和切换)

2.  安装[Cloud9 IDE](https://github.com/c9/core)
```shell
#第一次安装
git clone git://github.com/c9/core.git c9sdk
cd c9sdk
scripts/install-sdk.sh

#更新
git pull origin master
scripts/install-sdk.sh
```

3.  安装gitbook
```shell
npm install -g gitbook-cli
```
<!-- more -->
4.  创建文档主目录并运行
```shell
mkdir doc
cd doc
gitbook init
nohup node ~/c9sdk/server.js -p 8182 -l 0.0.0.0 -a : -w ~/doc > doc.out 2>&1 &
```

5.  查看或build doc
```shell
gitbook serve
gitbook build
```

![效果](http://zaozaool.github.io/pic/gitbook-clound.jpg)

[gitbook setup](https://github.com/GitbookIO/gitbook/blob/master/docs/setup.md)