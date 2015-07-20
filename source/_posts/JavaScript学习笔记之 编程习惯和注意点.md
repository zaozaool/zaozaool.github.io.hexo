title: 'JavaScript学习笔记之 编程习惯和注意点'
date: 2015-07-20 05:03:26
categories: 
tags: javascript
---

1.我们将 `<script>` 元素放在 HTML 文件底部的原因是，浏览器解析 HTML 似乎按照代码出现的顺序来的。如果 JavaScript被首先读取，它也应该影响下面的 HTML，但有时会出现问题，因为 JavaScript 会在 HTML 之前被加载，如果 JavaScript 代码出现问题则 HTML 不会被加载。所以将 JavaScript 代码放在底部是最好的选择。

2.JS中的每一行都应该以一个分号结尾，以表明这一行的结束。如果你不这样做，可能会遇到意想不到的结果。