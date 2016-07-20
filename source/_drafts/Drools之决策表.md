title: Drools之决策表
date: 2016-07-18 10:22:52
categories: [后端]
tags: [Java, Drools]
---

Drools Decision Table主要分成2块，Rule Set和Rule Table。Rule Set主要是导入类、table名称等公共部分的处理。而Rule Table则是具体的condition和action操作了。

#Rule Set可用属性
|  Keyword      | Value                 | Usage           |
| :------------ |:--------------------- | ---------------:|
| RuleSet       |                       |                 |
| Sequential    |                       |                 |
| Import        |                       |                 |
| Variables     |                       |                 |
| Functions     |                       |                 |
| Queries       |                       |                 |

|  Keyword         | Initial | Usage                         |
| :--------------- |:------- | -----------------------------:|
| PRIORITY         |         |                               |
| DURATION         |         |                               |
| NO-LOOP          |         |                               |
| LOCK-ON-ACTIVE   |         |                               |
| AUTO-FOCUS       |         |                               |
| ACTIVATION-GROUP |         |                               |
| AGENDA-GROUP     |         |                               |
| RULEFLOW-GROUP   |         |                               |

#Rule Table