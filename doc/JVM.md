# JVM

## JVM基础知识

### 什么是JVM

JVM 是一种规范，在用户态虚构出一台计算机，字节码指令（汇编），内存管理（堆，栈，方法区）

JVM之和class有关

JRudy

任何语言-》class-》JVM

JDK 包含 JRE

### 常见JVM

Hotspot,TaobaoVm,azul zing

### 程序，进程，线程，纤程

#### 进程 是系统进行资源分配和调度的基本单位

#### 线程 是[操作系统](https://baike.baidu.com/item/操作系统)能够进行运算[调度](https://baike.baidu.com/item/调度)的最小单位

## ClassFileFormat

### JAVA 代码如何运行

![](http://wechatapppro-1252524126.file.myqcloud.com/image/ueditor/72004200_1578386051.png)

## 类编译-加载-初始化

### 加载过程

1. Loading（加载类信息）

   a.双亲委派，出于安全

   b.LazyLoading (用到再加载，除五种情况)

   ​	–new getstatic putstatic invokestatic指令，访问final变量除	外

   ​	–java.lang.reflect对类进行反射调用时

   ​	–初始化子类的时候，父类首先初始化

   ​	–虚拟机启动时，被执行的主类必须初始化

   ​	–动态语言支持java.lang.invoke.MethodHandle解析的结果	为REF_getstatic REF_putstatic REF_invokestatic的方法句柄	时，该类必须初始化

   c.自定义类加载器，加密，热部署，打破双亲委派（tomcat）

   重写loadClass()

   d.混合执行 编译执行 解释执行

   ​	Java 是混合语言，既能编译又能解释，重复代码改为编译，启动慢

   ​	检测热点代码 -XX:CompileThreshold = 10000

2. Linking

   a.Verification 检测JVM规定的文件

   b.Preparation 静态成员变量赋默认值

   c.Resolution 将类，方法，属性符号引用解析为直接引用，常量池中各种符号引用解析为指针，偏移量

3. Initializing 调用类初始化代码，给静态成员变量赋初始值

   

   总结：load - 默认值 - 初始值

   ​			new - 申请内存 - 默认值 - 初始值

   

​	![](http://wechatapppro-1252524126.file.myqcloud.com/image/ueditor/17363100_1578386062.cn/txdocpic/0/a4c3566192eda95243843644e13dee6d/0)



![](http://wechatapppro-1252524126.file.myqcloud.com/image/ueditor/94094500_1578386070.cn/txdocpic/0/02705de5b5a6d20bf41b2e37e41c2a1d/0)

## JMM

### 硬件层数据一致性

协议很多，intel 用 MESI

https://www.cnblogs.com/z00377750/p/9180644.html

现代CPU的数据一致性实现 = 缓存锁(MESI ...) + 总线锁

读取缓存以cache line为基本单位，目前64bytes

位于同一缓存行的两个不同数据，被两个不同CPU锁定，产生互相影响的伪共享问题

伪共享问题：JUC/c_028_FalseSharing

使用缓存行的对齐能够提高效率

#### 实现MESI协议两套机制

+ flush处理器缓存：强制把写缓存的数据写到高速缓存（或主内存），并让总线给各个CPU发通知，数据变了
+ refresh处理器缓存：如果发现了，一定去高速缓存（或主内存）取新的

### 乱序问题

CPU为了提高指令执行效率，会在一条指令执行过程中（比如去内存读数据（慢100倍）），去同时执行另一条指令，前提是，两条指令没有依赖关系

#### 写合并

https://www.cnblogs.com/liushaodong/p/4777308.html

### 有序性

#### 硬件屏障（x86)lock …



#### 内存屏障

#### JVM级别屏障

+ loadload ：Load1; LoadLoad; Load2
+ storestore ：Store1; StoreStore; Store2
+ loadstore：Load1; LoadStore; Store2
+ storeload：Store1; StoreLoad; Load2

#### volatile 的实现细节

+ 字节码层:ACC_VOLATILE
+ JVM层:StoreStoreBarrier-》 volatile 写操作-》StoreLoadBarrier, LoadLoadBarrier-》volatile读操作-》LoadStoreBarrier
+ OS和硬件层面 ：windows lock前缀的指令实现，执行写操作时，cpu计算完会立刻把值写进主内存，同时因为有mesi协议，其他cpu都会对总线进行嗅探，自己本地缓存中的数据是否被别人修改，发现更改就过期掉，去读取主内存中的新的数据

#### synchronized的实现细节

+ 字节码层:monitorenter monitorexit
+ JVM层:C C++ 调用了操作系统提供的
+ OS和硬件层面 ：x86 lock cmpxchg /xxx

#### hanppens-before原则

#### as if serial

## JVM字节码

### 分类

+ 基于寄存器的指令集
+ 基于栈的指令集（java）

i++

++i 

+ bipush 8 
+ istore_1
+ iload_1
+ iinc 1 by 1
+ return
+ sipush 200
+ new 实例化并且压栈
+ dup 复制 因为实例化会用掉一个，所以先复制一个
+ invokespecial

非静态方法 局部变量表第0位是this，所以能直接调用自己

### **runtime data area 运行时数据区 内存分配**

+ PC计数器 记录程序走到那一步
+ 栈 每个线程独立一个空间，内含栈帧（每个方法一个栈帧）
+ 堆 放对象
+ 方法区 原空间（1.8），永久代1.7
+ 真实栈 运行 c++ c 写的线程
+ Direct Memory



静态变量是长期存在堆内存里

![](http://wechatapppro-1252524126.file.myqcloud.com/image/ueditor/93276900_1578301710.cn/txdocpic/0/0e833f156ae7201a3e89d7afb5cd6447/0)

## 垃圾回收

### 基础知识

#### 什么是垃圾

C语言申请内存：malloc free

C++： new delete

c/C++ 手动回收内存

Java: new ？

自动内存回收，编程上简单，系统不容易出错，手动释放内存，容易出两种类型的问题：



1. 忘记回收
2. 多次回收

没有任何引用指向的一个对象或者多个对象（循环引用）

#### 如何定位垃圾

1. 引用计数（ReferenceCount）

2. 根可达算法(RootSearching)

   方法局部变量和静态变量是gcroot，实例变量不是

#### 常见垃圾回收算法

1. 标记清除(mark sweep) - 位置不连续 产生碎片 效率偏低（两遍扫描）
2. 拷贝算法 (copying) - 没有碎片，浪费空间
3. 标记压缩(mark compact) - 没有碎片，效率偏低（两遍扫描，指针需要调整）

#### 

三色标记，颜色指针 

#### 

### 对象分配

#### 栈上分配

几乎所有的对象实例，都是在堆上分配的，但存在部分例外，栈上分配就是这种除了堆上分配的例外

+ 线程私有小对象
+ 无逃逸
+ 支持标量替换
+ 无需调整

#### 线程本地分配TLAB

+ 占用eden,默认1%

+ 多线程不用竞争eden就可以申请空间，调高效率

+ 小对象

+ 无需调整

![](https://github.com/bjmashibing/JVM/raw/master/%E5%AF%B9%E8%B1%A1%E5%88%86%E9%85%8D%E8%BF%87%E7%A8%8B%E8%AF%A6%E8%A7%A3.png)

### JVM内存分代模型

#### 部分垃圾回收模型

除了Epsilon ZGC Shenandoah之外的GC都使用逻辑分代模型

G1是逻辑分代，物理不分代

除此之外不仅逻辑分，物理也分

#### 新生代 + 老年代 + 永久代（1.7）Perm Generation/ 元数据区(1.8) Metaspace

1. 永久代 元数据 - Class
2. 永久代必须指定大小限制 ，元数据可以设置，也可以不设置，无上限（受限于物理内存）
3. 字符串常量 1.7 - 永久代，1.8 - 堆
4. MethodArea逻辑概念 - 永久代、元数据

#### 新生代 = Eden + 2个suvivor区

1. YGC回收之后，大多数的对象会被回收，活着的进入s0
2. 再次YGC，活着的对象eden + s0 -> s1
3. 再次YGC，eden + s1 -> s0
4. 年龄足够 -> 老年代 （15 CMS 6）
5. s区装不下 -> 老年代

#### 老年代

1. 顽固分子
2. 老年代满了FGC Full GC

#### 触发fgc的几种情况

+ 没有打卡分配担保（1.6之前）
+  没有老年代可用内存<历代年轻代进入老年代平均大小
+ gc 升入 老年代但老年代不足
+ cms 参数到92

#### 动态年龄

#### 分配担保

如果新生代里有大量对象存货下来，确实是自己的S区放不下了，必须转移到老年代去，那么如果老年代也放不开怎么办

只要老年代的连续空间大于新生代对象的总大小或者历次晋升到老年代的对象的平均大小就进行MonitorGC，否则FullGC

## 常见垃圾回收器

1.8默认的垃圾回收：PS + ParallelOld（标记压缩）

### Serial （young）

单线程垃圾回收

### CMS(old)

垃圾回收线程默认为：(cpu+3)/4

+ 初始化标记 ： stw
+ 并发标记
+ 重新标记 : stw
+ 并发清理

#### 缺点

+ 占cpu

+ 浮动垃圾

+  PN + CMS + SerialOld（标记清除）

  放入老年代大小大于可用空间，会发生Concurrent Mode Failure （并发垃圾回收失败），触动Serial Old

## G1

最大的特点，就是把堆内存拆分为多个大小相等的Region,另一个特点是可以设置预期停顿时间



最多2048，一个region 是堆大小除以2048，也可以手动设置，但必须是2的倍数

### 如何进入ygc

新生区region大小占总堆大小60% STW

### 什么时候进入老年代

+ 新生代一直躲过垃圾回收到年龄代
+ 动态年龄规定规则，如果一旦发生ygc，存活对象超过s区的50%
+ 大对象

### 如何控制停顿时间

所以简单来说，G1可以做到让你来设定垃圾回收对系统的影响，他自己通过把内存拆分为大量小Region，以及追踪每个Region中可以回收的对象大小和预估时间，最后在垃圾回收的时候，尽量把垃圾回收对系统造成的影响控制在你指定的时间范围内，同时在有限的时间内尽量回收尽可能多的垃圾对象。

### 大对象

大对象G1有专门的大对象Region

### 打破漏标

+ incremental update-- 增量更新，关注引用的增加，把黑色重新标记为灰色，下次重新扫描属性
+ SATB-关注引用的删除当B->D消失时，要把这个引用推到GC的堆栈，保证D还能被GC扫描到

### 混合回收

老年代占据堆内存45% 触发混合回

### G1垃圾回收过程

+ 初始化标记 stw
+ 并发标记
+ 最终标记 stw
+ 混合回收 stw(时间可控)

### 多久一次gc

-XX:G1MaxNewSizePercent 60%

也会根据-XX:MaxGcPauseMills ，如果他现有垃圾比设置时间小很多，他就不急于gc，继续分配

### 新生代调优

-XX:MaxGcPauseMills 

太小了，频繁gc，太大了会允许分配新对象，积累过多的对象

### mixed Gc 优化

## 常用命令行参数

HotSpot参数分类

> 标准： - 开头，所有的HotSpot都支持
>
> 非标准：-X 开头，特定版本HotSpot支持特定命令
>
> 不稳定：-XX 开头，下个版本可能取消



## 日志

![](https://github.com/bjmashibing/JVM/raw/master/GC%E6%97%A5%E5%BF%97%E8%AF%A6%E8%A7%A3.png)



![](https://github.com/bjmashibing/JVM/raw/master/GCHeapDump.png)

```
eden space 5632K, 94% used [0x00000000ff980000,0x00000000ffeb3e28,0x00000000fff00000)                            后面的内存地址指的是，起始地址，使用空间结束地址，整体空间结束地址


```

total = eden + 1个survivor



## 调优

### 基础概念

1. 吞吐量：用户代码时间 /（用户代码执行时间 + 垃圾回收时间）
2. 响应时间：STW越短，响应时间越好



所谓调优，首先确定，追求啥？吞吐量优先，还是响应时间优先？还是在满足一定的响应时间的情况下，要求达到多大的吞吐量...

问题：

科学计算，吞吐量。数据挖掘，thrput。吞吐量优先的一般：（PS + PO）

响应时间：网站 GUI API （1.8 G1）



### 什么是调优？

1. 根据需求进行JVM规划和预调优
2. 优化运行JVM运行环境（慢，卡顿） cpu 占用高 一般用jstack 看否死锁，或者jstat 看stw
3. 解决JVM运行过程中出现的各种问题(OOM) 内存快照，stack 就看普通log

其实完全不是如此，真正的JVM优化，就是一些内存分配+垃圾回收器的选择（ParNew、CMS、G1）+垃圾回收器的常见参数设置，还有就是一些代码层面的内存泄漏问题，其实搞定这些问题，99%的JVM性能问题你都能搞定了！

### 步骤：

1. 熟悉业务场景（没有最好的垃圾回收器，只有最合适的垃圾回收器）
   1. 响应时间、停顿时间 [CMS G1 ZGC] （需要给用户作响应）
   2. 吞吐量 = 用户时间 /( 用户时间 + GC时间) [PS]
2. 选择回收器组合
3. 计算内存需求（经验值 1.5G 16G）
4. 选定CPU（越高越好）
5. 设定年代大小、升级年龄
6. 设定日志参数
   1. -Xloggc:/opt/xxx/logs/xxx-xxx-gc-%t.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=20M -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCCause
   2. 或者每天产生一个日志文件
7. 观察日志情况

### 调查

1. 一般是运维团队首先受到报警信息
2. top 观察cpu 找到占用率居高不下的
3. top -Hp  4655 观察线程中的进程cpu占比
4. jps 定位 java 进程，jstack 定位 线程 重点关注：WAITING BLOCKED eg. waiting on <0x0000000088ca3310> (a java.lang.Object) 假如有一个进程中100个线程，很多线程都在waiting on  ，一定要找到是哪个线程持有这把锁 怎么找？搜索jstack dump的信息，找 ，看哪个线程持有这把锁RUNNABLE
5. jinfo pid 查看参数
6. jstat -gc pid 500 查看gc
7. jmap -histo 4655|head 20 查找有多少对象

### oom

oom : 产生的位置，方法区，堆内存，栈空间

原空间回收，前提苛刻，必须保证他的类加载器回收，还有他所有对象都回收 产生原因1.动态代理，2.原空间内存过小设置

### 工具使用

#### jstat

jstat -gc pid 1000 10

查看ygc频率，和每次ygc进入老年代内存

新生代对象增长速率，每次ygc,fgc耗时

#### jstack
死锁，Deadlock（重点关注） 
等待资源，Waiting on condition（重点关注） 
•  等待获取监视器，Waiting on monitor entry（重点关注） 
阻塞，Blocked（重点关注） 
可以观察对象增长速率，ygc触发频率，ygc耗时，有多少存活，有多少进入老年代，老年代对象增长速率，FGC频率，FGC耗时

#### jmap

jmap -histo pid 系统运行对象分布

#### jhat

浏览器观察快照

jhat dump.hprof -port 7000

## 案例

+ 死循环导致oom,异常会递归，死循环，正常不会出现
+ 动态代理，for 中生成类 导致oom 应该把初始化写在循环外
+ 动态代理 容易引起方法区溢出
+ **JVM 栈溢出** GC 日志无法调查栈内存溢出问题，线程过多引起，正常log就可以看到
+ **JVM 堆溢出** MAT快照容易分析
+ 显示“http -nio -8080 - exec -1089" oom：jhs 是tomcat工作线程，明明只有100Qps 却沾满了400个线程 800个数组，一个数组10m, 100qps 沾满400个线程原因是 一次访问时间是4秒

![](http://wechatapppro-1252524126.file.myqcloud.com/image/ueditor/62194800_1578304130.cn/txdocpic/0/2df16e80a0e4f1403f1a8f16a842ffd6/0)

解决办法，降低响应时间，和tomcat的线程工作空间大小

+ 堆外内存 oom

堆外内存oom 一般是nio 有关

![](http://wechatapppro-1252524126.file.myqcloud.com/image/ueditor/97970500_1578304137.cn/txdocpic/0/a3074bb955474986939163d1f18bcff1/0)

原因 ：创建过多DirectByteBuffer对象，占用大量堆外内存，然后dbb没有被回收，通过jstat分析日志发现jetty一直创建dbb，接着年轻代eden满了，触发ygc,触发同时大量对象没有用完，但s1去过小，进入老年代，老年代过大迟迟不FGC，导致堆外内存oom，但jetty其实想到这个问题，每次都会调用system,gc(),但jvm参数关了这个功能

解决：打开-XX : + DisableExplicitGc ，合理分配S区大小

+ 数据库查询 没有where ,查出大量对象导致oom
+ 日志清洗系统  递归生成char[] .jstat 分析 ygc 后 old 区占比变高，产生fgc ，但fgc 后 old 并没有减少很多，分析原因，s区过 小，大文件直接进入old区
+ 数据同步系统 从中间件消费消息，产生oom ，重启服务过一段时间有oom,说明重启后不断产生对象，不是高并发就是内存泄漏 mat定位是 中间件生产消费速度问题，将list 当一个元素,消费不了，越攒越多，改成一个个放的定长队列
+ **服务假死**，俩个问题一个是一直gc 一直stw,另一个是cpu过高抢不到，用top观察cpu占领低，内存高，考虑三种情况

​        1.内存高，频繁full gc,gc 带来stw带来影响

​        2.内存高，导致jvm自己oom

​        3.内存高，进程被杀掉

jstat 分析log gc时间几百毫秒，日志查看是否oom,猜是进程杀掉，但被脚本唤醒，最后mat 查出ClassLoader类加载器一大推

+ 频繁fgc log正常，代码写了system.gc()
+ cpu 过高 

​        同时运行过多线程

​		频繁fgc		

+ 访客系统高并发查询导致对象快速进入老年代 每秒请求量过多，有很多还没处理完 解决办法，加机器，s区更大，cms压缩

+ 优化cms

  XX:+CMSParallelInitialMarkEnabled  // 初始化标记并行- XX:+CMSScavengeBeforeRemark// 重新标记前先ygc一次

+ 频繁Fgc原因

  1.内存分配不合理，ygc后进入old

  2.大对象

  3.永久代

  4.system.gc（）

+ **消息中间件挂掉了，消息停在内存中，不断尝试发送**、
+ “-Xms4096M -Xmx4096M -Xmn3072M -Xss1M  -XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=256M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFaction=92 -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0 -XX:+CMSParallelInitialMarkEnabled -XX:+CMSScavengeBeforeRemark -XX:+DisableExplicitGC -XX:+PrintGCDetails -Xloggc:gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/usr/local/app/oom”
+ **软显示导致添加照片栈溢出**

## 监控

+ 监控cpu 超过90%
+ 内存超过90%
+ 频繁fullgc 5分钟10次
+ 业务数量过多，防止刷单
+ 异常警告

### 发现oom 两种情况

+ 客服
+ 警告邮件

### 快照

-XX:+HeapDumpOnOutOfMemoryError

## 面试题

#### 1.请解释一下对象创建过程



#### 2.对象在内存中的存储布局

-XX: +PrintCommandLineFlags -version

##### 普通对象

1. 对象头：markwork 8
2. ClassPointer指针 ：-XX:+UseCompressedClassPointers 为4字节 不开启为8字节
3. 实例数据
   1. 引用类型：-XX:+UseCompressedOops 为4字节 不开启为8字节 Oops Ordinary Object Pointers
4. Padding对齐，8的倍数



##### 数组对象

1. 对象头：markwork 8
2. ClassPointer指针 ：-XX:+UseCompressedClassPointers 为4字节 不开启为8字节
3. 数组长度：4字节
4. 数组数据
5. 对齐8的倍数

#### 3.对象头具体包括什么

![](https://img2020.cnblogs.com/blog/1304333/202004/1304333-20200404135305196-2043648903.jpg)

值得注意的是,偏向模式直接修改了Mark Word而没有留下备份,而在java中,JVM需要保证,没有重写hashcode方法的对象,其hash只能被计算一次.
 所以,对于没有重写hashcode方法的对象,如果以及计算过hash值,那么它就无法被偏向锁锁定.如果处于偏向锁状态,计算hash值也会直接导致偏向模式的退出

#### 4.对象怎么定位

+ 句柄池：中间有一个间接指针，间接指针俩个地址一个指向对象，一个指向class(gc效率高)
+ 直接指针:直接指向对象 （hot）

#### 5.对象怎么分配

#### Object o = new Object内存占用多少字节

jvm.agent 

16字节 markword 8 + 指针压缩后 4 + 对齐4

oops

#### 6.为什么年轻代分区比例要分为e:s1:s2 = 8:1:1

#### 7.1000订单需要多少台机器，什么配置的机器，什么参数

访客一张照片大概100-400k,另一些任务（审批。机器）一个请求大概是3,400k，300个就是300m,是垃圾，给jvm16g系统一般给8g,栈空间到2m,新生代给4g，大概30s一次ygc,存活100m



-Xms7168M -Xmx7168M -Xmn5102M -Xss1.5M  -XX:PermSize=256M -XX:MaxPermSize=256M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=5 -XX:PretenureSizeThreshold=2M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFaction=92 -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0

#### 8.什么时候ygc对系统影响大

年轻代大内存但不使用G1