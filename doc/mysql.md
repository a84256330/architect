# mysql

## 基础

### mysql单表容量

控制在500w

### 缓冲区的数据结构是怎样的

## 引擎

### mysql的存储引擎

innodb、myisam、memory等

### innodb和myisam的区别

+ myisam，不支持事务，不支持外键约束，索引文件和数据文件分开，这样在内存里可以缓存更多的索引，对查询的性能会更好，适用于那种少量的插入，大量查询的场景
+ 主要特点就是支持事务，走聚簇索引，强制要求有主键，支持外键约束，高并发、大数据量、高可用等相关成熟的数据库架构，分库分表、读写分离、主备切换，全部都可以基于innodb存储引擎来玩儿，如果真聊到这儿，其实大家就可以带一带，说你们用innodb存储引擎怎么玩儿分库分表支撑大数据量、高并发的，怎么用读写分离支撑高可用和高并发读的

### 为什么myisam不支持事务 

### innodb是如何支持的事务

### 为什么myisam不采用和innodb相同的方案来解决事务问题

### 

## 分库分表

### mysql分库分表原则

### 分库分表怎么做

### 如何做到无影响扩容

###  为什么要分这么多库这么多表基于什么考虑？

### 如何实现数据库动态扩容？

### 分库分表如何不同库表间数据不重复

## 锁

### 锁哪几种

### 行锁的实现？

### 数据库乐观锁和悲观锁，共享锁和排他锁

### 乐观锁悲观锁数据库和juc不同实现

### MVCC

## 索引

### 索引了解么？balabala 

### InnoDB还能有什么索引 

### 为什么用索引？项目中怎么用的？ 

### 讲一下B+树的实现 

### B+树与B树有什么区别？ 

### B-树B+树区别，数据库索引原理，组合索引怎么使用？最左匹配的原理 

### 聚簇和非聚簇索引区别以及分别怎么使用；

### 什么是索引覆盖？ 

### innodb存储引擎中是如何为磁盘io优化的

### lru是如何移除和插入数据的？链表中存储的是什么数据，如果没有索引那还存储什么

## 事务

### MySQL的事务隔离级别 
+ 读未提交
未提交其他事务也能看到
+ 不可重复读
第一次查询，别的事务也修改这条数据，再次读数据不一样
+ 可重复读（默认）
每次读一样，但会出现幻读 一个范围内查询其他事务修改
+ 串行化


### 事务的四个特性？事务的隔离级别？讲讲MySQL 的事务隔离？RR解决了什么问题？

## 调优

### 为什么数据量大的时候会出现慢sql？

### 慢sql如何解决

### 如何sql优化

### 回表

## 高可用

### 数据库是怎么保证一定不会丢失数据的  

### 数据库主从同步过程及原理；

### 数据库同步延迟如何降低或者怎么解决，新版本innodb如何解决此类问题的；

### 全局唯一性id是如何生成的

### 你们生成id的速率超过了mysql的性能极限了吗？没超过为什么你们不采用MySQL生成全局唯一性id

### MySQL作为相对于雪花算法全局唯一性id的缺点除了性能问题，还有什么
## 数据表设计
### 三范式
+ 字段为原子不可再分（地址）
+ 主键要与每个字段都有关系
+ 主键与字段是直接关系