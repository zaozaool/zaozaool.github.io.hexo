title: ABAP基础之选择屏幕
date: 2015-09-11 03:12:50
categories:
tags: [SAP, ABAP]
---

#PARAMETERS
```ABAP
语法：
PARAMETERS {para[(len)]}|{para [LENGTH len]}
    [type_options]
    [screen_options]
    [value_options].
```
<!--more-->

其他参数：
```ABAP
1. ... TYPE type [DECIMALS dec]
    Example:PARAMETERS p_t1 type p decimals 2.
    TYPE可用类型：c, d, i, n, p, string, t, and x
    f无法使用,要定义小数位用p类型+ DECIMALS定义。
2. ... LIKE dobj | LIKE (name)
    Example:DATA comp TYPE c LENGTH 60.
    PARAMETERS p_carrid LIKE spfli-carrid.
    PARAMETERS p_dyn1 LIKE comp.
    PARAMETERS p_dyn2 LIKE (comp).
    INITIALIZATION.
    comp = 'SPFLI-CARRID'.
3. ... OBLIGATORY 必输
4. ... NO-DISPLAY 隐藏
5. ... VISIBLE LENGTH vlen 可见长度
6. ... AS CHECKBOX [USER-COMMAND fcode] 复选框
    Example： PARAMETERS: TAX AS CHECKBOX DEFAULT 'X',
    NTD AS CHECKBOX.
7. ... RADIOBUTTON GROUP group [USER-COMMAND fcode] 单选按钮组
    Example： PARAMETERS: BOY RADIOBUTTON GROUP SEX DEFAULT 'X',
    GIRL RADIOBUTTON GROUP SEX.
8. ... AS LISTBOX VISIBLE LENGTH vlen [USER-COMMAND fcode] 列表框
    Example：PARAMETERS p_carrid TYPE spfli-carrid
    AS LISTBOX VISIBLE LENGTH 20
    DEFAULT 'LH'.
9. ... DEFAULT val 设置默认值
    Example:PARAMETERS: COMPANY(20) DEFAULT 'FIT',
    BIRTH TYPE D DEFAULT '20110201'.
10. ... LOWER CASE 将输入值转成小写
11. ... MATCHCODE OBJECT search_help 加搜索帮助
    Example： PARAMETERS p_carrid TYPE s_carr_id
    MATCHCODE OBJECT demo_f4_de.
12. ... MEMORY ID pid 从SAP内存中读取值，DEFAULT优先于MEMORY ID
    Example:PARAMETERS p_prog TYPE sy-repid MEMORY ID rid.
13. ... VALUE CHECK 从数据字典中检查输入值
    Example:PARAMETERS p_carrid TYPE spfli-carrid VALUE CHECK
```

#SELECTION-OPTIONS（多项选择）
```ABAP
语法：SELECT-OPTIONS [selection name] FOR [field name] [DEFAULT [value] [TO [value]]]
```
[selection_tab]内表的四个字段：
```ABAP
1. SIGN:
    I: 表筛选条件符合的资料
    E: 表筛选条件不符合的资料
2. OPTION: 比较的条件符号
    EQ(等于),NE(不等于),GT(大于),LE(小于),CP(包含),NP(不包含)
3. LOW: 最小值
4. HIGH: 最大值
```

其他参数：
```ABAP
1. ... OBLIGATORY 必输
    Example:SELECT-OPTIONS s_carrid FOR spfli-carrid OBLIGATORY.
2. ... NO-DISPLAY 隐藏
3. ... NO-EXTENSION 没有范围选择按钮
    Example:SELECT-OPTIONS s_carrid FOR spfli-carrid NO-EXTENSION.
4. ... NO INTERVALS 没有间隔选择
    Example:SELECT-OPTIONS s_carrid FOR spfli-carrid NO INTERVALS.
5. ... DEFAULT val1 [TO val2] [OPTION opt] [SIGN sgn] 设置默认值
    Example： SELECT-OPTIONS s_carrid FOR spfli-carrid DEFAULT 'AC' to 'AF'.
```

#SELECTION-SCREEN
同一列中输入数个数据项
```ABAP
语法:
SELECTION-SCREEN BEGIN OF LINE.
......
SELECTION-SCREEN END OF LINE.
Example:
    SELECTION-SCREEN BEGIN OF LINE.
        SELECTION-SCREEN POSITION 20.
            PARAMETERS NAME(10).
        SELECTION-SCREEN POSITION 40.
        PARAMETERS BIRTH TYPE D.
    SELECTION-SCREEN END OF LINE.//在20格输入NAME内容, 40格输入 BIRTH的内容
```

绘出BLOCK PANEL

```ABAP
语法:
SELECTION-SCREEN BEGIN OF BLOCK <block> [WITH FRAME [TITLE <title>].
......
SELECTION-SCREEN END OF BLOCK <block>.
Example:
    SELECTION-SCREEN BEGIN OF BLOCK RADIO WITH FRAME TITLE title.
        PARAMETER R1 RADIOBUTTON GROUP GR1.
        PARAMETER R2 RADIOBUTTON GROUP GR1.
        PARAMETER R3 RADIOBUTTON GROUP GR1.
    SELECTION-SCREEN END OF BLOCK RADIO.
    INITIALIZATION.
    TITLE = 'Selection'.

1. 产生空白列
    语法: SELECTION-SCREEN SKIP [<n>]
    Example: 
        SELECTION-SCREEN SKIP 2.//产生两列空白列
2. 画底线
    语法: SELECTION-SCREEN ULINE / <pos>(length)
    Example: 
        SELECTION-SCREEN ULINE /10(30).//自第10格开始产生长度30的底线
3. 印出备注说明
    语法: SELECTION-SCREEN COMMENT / <pos>(length) <name>
    Example: 
        SELECTION-SCREEN COMMENT /10(30) REMARK.
        INITIALIZATION.
        REMARK = 'Pls enter your name'.
```

#初始化选择屏幕
```ABAP
INITIALIZATION.
......
```

#输入检查
```ABAP
AT SELECTION-SCREEN.
......
```