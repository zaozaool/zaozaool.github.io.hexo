#!/bin/sh

cd /home/ubuntu/repositories/zaozaool.github.io.hexo

hexo clean

nohup node /home/ubuntu/cloud9/c9sdk/server.js -p 8181 -l 0.0.0.0 -a : -w /home/ubuntu/repositories/zaozaool.github.io.hexo > hexo.out 2>&1 &
