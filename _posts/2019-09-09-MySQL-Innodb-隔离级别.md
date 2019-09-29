---
layout: post
title:  MySQL/Innodb隔离级别
subtitle:   伟大的人总有伟大的牺牲
date:   2019-09-09
author: fengjp
catalog:    true
tags:
    - 数据库
---

## MySQL/Innodb隔离级别

### 隔离性

数据库提供一定隔离机制，保证事务在不受外部并发操作影响独立执行，一个事务执行不受其他事务影响。

### 隔离级别

- 4种隔离级别

> Read uncommitted : 未提交读，事务中的修改，即使没有提交，对其他事务也是可见的。存在脏读

> Read commited : 提交读，Oracle等数据库默认级别 ( MySQL不是 ) ， 一个事务从开始提交前所做的修改对其他事务不可见。

> repeatable read : 可重复读，保证同一事务多次读取的数据结果一致的。存在幻读。

> serializable : 串行化读，强制事务串行执行。

### Read uncommited

事务能获取一个事务未提交的数据。 MySQL/Innodb 一般不采用。

### Read commited

事务能读取一个事务提交的数据，解决脏读，存在不可重复读、幻读。

### Repeatable read

一个事务读取后，后面多次读取数据获得是同样的结果。解决脏读和不可重复读，存在幻读。

### serializable

强制事务串行执行，避免幻读的问题。但是性能较差，并发度下降，MySQL / Innodb 不建议使用。

---

不可重复读和幻读区别在于，不可重复读强调重点在于 update 和 delete，幻读重点是 insert 。可重复读中， sql 第一次读取到数据后，就将数据进行加锁，其他事务无法修改这些数据，可以实现重复读。但这种方法无法锁住 insert 的数据，当其他事务 insert 后，就会产生幻读，不能通过锁来避免。