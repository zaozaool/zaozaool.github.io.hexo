title: Maven多模块中关于final static常量的一个坑
date: 2016-07-07 20:05:37
categories: [后端]
tags: [Maven, Java]
---



#【背景】
多个独立的web项目合并到同一个Maven多模块项目中，目的是抽取公共模块，减少维护成本。
各个web项目的客户编码有不同的前缀，所以中各个web项目中都定义了一个常量，但是各个站点的值是不同的，中合并到一个Maven多模块项目后，抽取公共部分时由于中公共部分代码中需要用到这个常量，所以就随便将其中一个项目的该常量拿到了公共模块中，而各个站点的该常量保留，可是项目真正启动后，当使用该常量时发现其值一直是公共模块定义的，导致各个站点的客户编码使用了同样的前缀，从而出现了问题。

#【结论】
如果公共模块中一个常量是各个站点都需要使用的，但是中各个单点的值又不一致，那么千万不要将该常量定义成final的。

#【解决方法】
* 去除final定义即可
* 将该常量定义到各个项目的配置文件中

#【举例】
<!-- more -->

```java
//公共模块的常量类
pacakge test.constants;

public class Constants {

    //这里定义成final的就会有问题
    public static final String PR = "TEST";

}

//公共模块的工具类
pacakge test.utils;

public class TestUtil {
    
    public static String getAccountNo(){
        return Constants.PR + 1111;
    }
}



//站点A的常量类
pacakge test.constants;

public class Constants {

    //如果这里定义成final的
    public static final String PR = "A";

}

//站点A生成客户号
pacakge test.utils;

public class Account {
    public static void main(String[] args) {
        System.out.println(TestUtil.getAccountNo());
        //得到的是TEST1111，而不是A1111
    }
}



//站点B的常量类
pacakge test.constants;

public class Constants {

    //如果这里定义成final的
    public static final String PR = "B";

}

//站点B生成客户号
pacakge test.utils;

public class Account {
    public static void main(String[] args) {
        System.out.println(TestUtil.getAccountNo());
        //得到的是TEST1111，而不是B1111
        //如果将公共模块和站点A、B的PR常量的final去掉，那么就是没有问题的
        //这种各个站点不一致的常量应该定义中配置文件中， 由于我这里是将已经存在各个站点合并，才会出现这样的问题
    }
}

```