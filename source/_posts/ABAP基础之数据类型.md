title: ABAP基础之数据类型
date: 2015-09-16 09:01:22
categories:
tags: [SAP, ABAP]
---
#变量定义
```ABAP
DATA <f> [<length>] <type> [<value>] [<decimals>]
<f>: 变量名称, 最长30个字符, 不可含有 + . , : ( ) 等字符
<length><type>: 数据型态及长度, 如 LINE(20) TYPE C. MYNAME LIKE SY-UNAME.
<value>: 初值
<decimals>: 小数位数
```
<!--more-->

#数据类型
<table><tbody><tr><td>数据类型</td><td>描述</td><td>初始值</td><td>标准长度</td><td>允许长度</td></tr><tr><td>I</td><td>Integer</td><td>0</td><td>4</td><td>4</td></tr><tr><td>P</td><td>Packed number</td><td>0</td><td>8</td><td>1-16</td></tr><tr><td>F</td><td>Floating Point#</td><td>0.000…</td><td>8</td><td>8</td></tr><tr><td>N</td><td>Numeric Text</td><td>0…0</td><td>1</td><td>1-max.</td></tr><tr><td>C</td><td>Character Text</td><td>(blank)</td><td>1</td><td>1-max.</td></tr><tr><td>D</td><td>Date</td><td>20110706</td><td>8</td><td>8</td></tr><tr><td>T</td><td>Time</td><td>000000</td><td>6</td><td>6</td></tr><tr><td>X</td><td>Hexadecimal #</td><td>00</td><td>1</td><td>1-max.</td></tr></tbody></table>