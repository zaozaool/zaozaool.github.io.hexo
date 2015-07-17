title: supervisor vs pm2 vs forever
date: 2015-07-17 06:32:40
tags: Node.js
---

使用场合不一样:
supervisor 是开发环境用。
forever 管理多个站点，每个站访问量不大，不需要监控。
pm2 网站访问量比较大，需要完整的监控界面。
[告别node-forever,拥抱PM2](http://www.oschina.net/translate/goodbye-node-forever-hello-pm2?cmp)