title: 获取当前Java进程的活动线程数
date: 2016-09-12 03:01:59
categories: [后端]
tags: [Java]
---
```java
/**
 * 获取当前Java进程的活动线程数
 * @return
 */
public Map<String, Object> getThreadsTotal() {
    Map<String, Object> threadDataMap = new HashMap<String, Object>();

    Integer currentThreadCount = 0;
    Integer currentThreadsBusy = 0;

    MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
    List<ObjectName> threadPools = new ArrayList<ObjectName>();
    try {
        threadPools.addAll(mbeanServer.queryNames(new ObjectName("*:type=ThreadPool,*"), null));

        for (final ObjectName threadPool : threadPools) {
            //获取所有线程池下的线程总数
            currentThreadCount += (Integer) mbeanServer.getAttribute(threadPool, "currentThreadCount");
            currentThreadsBusy += (Integer) mbeanServer.getAttribute(threadPool, "currentThreadsBusy");

        }
    } catch (MalformedObjectNameException e) {
        logger.error("Get threads information error.", e);
    } catch (ReflectionException e) {
        logger.error("Reflecttion error", e);
    } catch (InstanceNotFoundException e) {
        logger.error("Instance not found error.", e);
    } catch (MBeanException e) {
        logger.error("Mean error", e);
    } catch (AttributeNotFoundException e) {
        logger.error("Could not get attribute", e);
    }

    threadDataMap.put("currentThreadCount", currentThreadCount);
    threadDataMap.put("currentThreadsBusy", currentThreadsBusy);

    return threadDataMap;
}
```
<!-- more -->

```java
/**
 * 获得线程明细列表
 * @return
 */
public List<ThreadInformation> buildThreadInformationsList(boolean isShowDeamon) {
    ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
    List<Thread> threads = new ArrayList<Thread>(stackTraces.keySet());

    //虚拟机是否允许测量所有线程的cup时间
    //isThreadCpuTimeSupported() 方法可用于确定 Java 虚拟机是否支持测量任何线程的 CPU 时间。
    //isCurrentThreadCpuTimeSupported() 方法可用于确定 Java 虚拟机是否支持测量当前线程的 CPU 时间。
    //支持任何线程 CPU 时间测量的 Java 虚拟机实现也支持当前线程的 CPU 时间测量
    boolean cpuTimeEnabled = threadBean.isThreadCpuTimeSupported() && threadBean.isThreadCpuTimeEnabled();

    //获取所有死锁线程的id
    long[] deadlockedThreads = getDeadlockedThreads(threadBean);
    List<ThreadInformation> threadInfosList = new ArrayList<ThreadInformation>(threads.size());

    String hostAddress;
    try {
        hostAddress = InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
        hostAddress = "unknown";
    }

    for (Thread thread : threads) {
        if (isShowDeamon == false && thread.isDaemon()) {
            continue;
        }

        StackTraceElement[] stackTraceElements = stackTraces.get(thread);
        List<StackTraceElement> stackTraceElementList = stackTraceElements == null ? null : new ArrayList<StackTraceElement>(Arrays.asList(stackTraceElements));
        long cpuTimeMillis;//返回指定 ID 的线程的总 CPU 时间（以毫微秒为单位）。
        long userTimeMillis;//返回指定 ID 的线程在用户模式中执行的 CPU 时间（以毫微秒为单位）。
        if (cpuTimeEnabled) {
            cpuTimeMillis = threadBean.getThreadCpuTime(thread.getId()) / 1000000;
            userTimeMillis = threadBean.getThreadUserTime(thread.getId()) / 1000000;
        } else {
            cpuTimeMillis = -1;
            userTimeMillis = -1;
        }
        boolean deadlocked = deadlockedThreads != null && Arrays.binarySearch(deadlockedThreads, thread.getId()) >= 0;

        threadInfosList.add(new ThreadInformation(thread, stackTraceElementList, cpuTimeMillis, userTimeMillis, deadlocked, hostAddress));

    }
    return threadInfosList;
}
```