title: Solr获取document的score及组合排序
date: 2016-11-07 05:46:21
categories: [后端]
tags: [Solr]
---
#获取每个document的score
查询是时需要将score作为返回字段
```
fl=*,score
```

#先根据具体字段再根据score排序
Solr默认是按照score排序的，如果有下面需求，需要先按照某个字段排序（如类型），再按照score排序则需要传值
```
sort=字段名 ASC,score DESC 
```