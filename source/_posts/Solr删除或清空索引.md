title: Solr删除或清空索引
date: 2016-12-06 05:49:26
categories: [后端]
tags: [Solr]
---
#删除索引
```
<delete><id>1</id></delete>
<commit/>
```
或
```
<delete><query>id:1</query></delete>
<commit/>
```

#清空索引
```
<delete><query>*:*</query></delete>
<commit/>
```