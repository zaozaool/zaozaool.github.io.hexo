title: ABAP基础之PERFORM子程序
date: 2015-09-16 08:28:40
categories:
tags: [SAP, ABAP]
---

#INCLUDE子程序
```ABAP
语法：
INCLUDE <程序名>.
```

#PERFORM子程序
```ABAP
语法：
PERFORM <程序名> [USING <传入参数名>] [CHANGING <传出参数名>] [TABLES <内表名>].
```
<!--more-->

例如：
```ABAP
REPORT ZTEST08.

INCLUDE ZTEST08_I1.

PERFORM ZTEST08_P1 USING Z_NUM Z_NAME CHANGING Z_RESULT.


FORM ZTEST08_P1  USING    P_Z_NUM
                          P_Z_NAME
                 CHANGING P_Z_RESULT.
    ...do something
ENDFORM.


//ZTEST08_I1
DATA:Z_NUM TYPE I.
DATA:Z_NAME(10) TYPE C.
DATA:Z_RESULT(10) TYPE C.
```