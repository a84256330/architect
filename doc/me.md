# me

## 基础

**java进程不见了，怎么定位？** 

#### **①、Java应用程序的问题：发生OOM导致进程Crash**

最常见的是发生堆内存异常“java.lang.OutOfMemoryError: Java heap space”，排查步骤如下：

- Step1: 查看JVM参数 -XX:+HeapDumpOnOutOfMemoryError 和 -XX:HeapDumpPath=*/java.hprof；
- Step2: 根据HeapDumpPath指定的路径查看是否产生dump文件；
- Step3: 若存在dump文件，使用Jhat、VisualVM等工具分析即可；

#### **②、JVM出错：JVM或JDK自身的Bug导致进程Crash**

当JVM出现致命错误时，会生成一个错误文件 hs_err_pid.log，其中包括了导致jvm crash的重要信息，可以通过分析该文件定位到导致crash的根源，从而改善以保证系统稳定。当出现crash时，该文件默认会生成到工作目录下，然而可以通过jvm参数-XX:ErrorFile指定生成路径。

#### **③被操作系统OOM-Killer**

- Step1: 查看操作系统日志：sudo grep –color “java” /var/log/messages，确定Java进程是否被操作系统Kill；
- Step2: 若被操作系统Kill，执行dmesg命令查看系统各进程资源占用情况，明确Java占用内存是否合理，以及是否有其它进程不合理的占用了大量内存空间；

**String  str=new String (“a”+”b“)会创建几个对象？字符串常量池在Jvm哪个位置** 

4个，1.8之前在永久代，1.8在堆

**hashMap的了解**

## 操作系统

**select poll  epoll的区别？epoll的数据结构** 

https://zhuanlan.zhihu.com/p/272891398

红黑树以及就绪链表

redis 用epoll

**进程间的通信方式？有哪些信号通信是不可靠的？为什么是不可靠的？**

**僵尸进程怎么解决？协程有了解过嘛** 

## 网络

 **TCP三次连接，这个listen backLog有什么作用** 

https://www.jianshu.com/p/71aba04df492

创建TCP服务的四个基本步骤：

1. socket – 创建socket套接字。
2. bind – 绑定要监听的IP地址。
3. listen – 开始监听客户端连接请求。
4. accept – 获取TCP握手成功的连接。

 **TCP四次挥手，Time WAIT发生在哪方？两个超时重传时间的作用？大量 timeout怎么处理**？ 

主动关闭连接的一方，调用close()；协议层发送FIN包

被动关闭的一方收到FIN包后，回复ACK，进入CLOSE_WAIT状态，主动关闭的一方等待对方关闭，进入FIN_WAIT_2状态，此时，主动关闭的一方会等待被动关闭一方的应用程序调用close操作

被动关闭的一方在完成所有数据发送后，调用close()操作；此时，协议层会发送FIN包给主动关闭的一方，然后等待对方的ACK，进入LAST_ACK状态；

主动关闭的一方收到FIN包，回复ACK，进入TIME_WAIT状态；被动关闭的一方收到ACK后，进入CLOSED状态

等待2MSL时间，主动关闭的一方，结束TIME_WAIT，进入CLOSED状态
https://blog.csdn.net/fanren224/article/details/89849276



**https的加密过程？证书认证的过程**

**请求出现超时，但应用查不到这个请求日志，怎么排查** 

## 算法

**线程交叉打印 12A34B56C，多种实现方式（一个打印数字，一个打印字母）** 

**一个字符串，一个子字符串，判断子字符串在字符串中出现的次数，不要求连续，但有先后顺序  s=rabbbit  t=rabbit，出现的次数为3** 

**一个字符串，一个子字符串，判断子字符串在字符串中出现的次数，不要求连续，但有先后顺序  s=rabbbit  t=rabbit，出现的次数为3** 

**对于一个字符串，计算其中[最长回文子串]()的长度** 

 **[算法]()1：给定一个长度为N的整形数组arr，其中有N个互不相等的自然数1-N，请实现arr的[排序]()，但是不要把下标0∼N−1位置上的数通过直接赋值的方式替换成1∼N** 

 **[算法]()2：判断一个树是否是[平衡二叉树]()** 

## 多线程

**Synchronized和lock的区别**

**线程池[项目]()中怎么使用，遇到过什么问题** 

**synchronized的锁优化是怎么样的** 

**threadLocal[项目]()中怎么使用** 

**线程安全的类有哪些，平时有使用么，用来解决什么问题** 

**锁升级过程，轻量锁可以变成偏向锁么，偏向锁可以变成无锁么，自旋锁，对象头结构，锁状态变化过程** 

## Spring

**Spring的设计模式？工厂模式是怎么实现的**

**Spring事务**  

## redis

**哨兵模式是为了解决什么？整个流程大概是怎样的** 

**本地缓存和[redis]()缓存的区别** 

**[redis]()的数据更新策略之类**

**[redis]()的部署方式，集群部署的丢失数据，主备切换过程** 

[redis]()集群，为什么是16384，哨兵模式，选举过程，会有脑裂问题么，raft[算法]()，优缺点 

## zookeeper

zoo[keep]()er的基本原理，数据模型，znode类型，应用场景有哪些 

## Mysql

**Mysql的事务特性？原子性是怎么实现的(通过undo  log日志实现）** 

 **Mysql的默认隔离级别？什么是不可重复读** 

**select语句的执行过程** 

**乐观锁和悲观锁的区别，[项目]()中的使用** 

**mysql日志文件有哪些，分别介绍下作用**

## JVM

**内存溢出，内存泄漏遇到过么，什么场景产生的，怎么解决的** 

## 设计

一个热榜功能怎么设计，怎么设计缓存，如何保证缓存和数据库的一致性 

