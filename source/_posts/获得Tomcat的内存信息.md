title: 获得Tomcat的内存信息
date: 2016-09-12 02:58:19
categories: [后端]
tags: [Java, Tomcat]
---

```java
/**
 * 获得Tomcat的内存信息
 * @return
 */
private Map<String, Object> getMemoryInfo() {
    Map<String, Object> memDataMap = new HashMap<String, Object>();

    double MB = 1024.0 * 1024.0;

    //当前JVM的最大可用内存
    double maxMemory = (Runtime.getRuntime().maxMemory()) / MB;

    //当前JVM占用的内存总数
    double totalMemory = (Runtime.getRuntime().totalMemory()) / MB;

    //因为JVM只有在需要内存时才占用物理内存使用，所以freeMemory()的值一般情况下都很小
    double freeMemory = (Runtime.getRuntime().freeMemory()) / MB;

    //JVM实际可用内存
    double totalUsableMemory = maxMemory - totalMemory + freeMemory;

    memDataMap.put("totalUsableMemory", totalUsableMemory);
    memDataMap.put("totalMemory", totalMemory);
    memDataMap.put("maxMemory", maxMemory);

    NumberFormat nt = NumberFormat.getPercentInstance();
    nt.setMinimumFractionDigits(2);
    memDataMap.put("memUsage", nt.format(totalMemory / maxMemory));

    return memDataMap;
}
```