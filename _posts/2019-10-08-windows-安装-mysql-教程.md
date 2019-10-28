---
layout: post
title:  windows 安装 mysql 8.0.17 版本
subtitle:   
date:   2019-10-09
author: fengjp
catalog:    true
tags:
    - mysql
---

#   windows 安装 mysql 8.0.17 版本

[安装](https://dev.mysql.com/downloads/mysql/)

[教程](https://www.cnblogs.com/yfb918/p/11578156.html)

设置 my.ini 文件和 data 文件夹，并拷贝如下部分，记得 basedir 和 datadir 要改为自己的路径。

```

[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录
basedir=E:\mysql-8.0.17-winx64\mysql-8.0.17-winx64
# 设置mysql数据库的数据的存放目录
datadir=E:\mysql-8.0.17-winx64\mysql-8.0.17-winx64\data
# 允许最大连接数
max_connections=200
# 允许连接失败的次数。这是为了防止有人从该主机试图攻击数据库系统
max_connect_errors=10
# 服务端使用的字符集默认为UTF8
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8
[client]
# 设置mysql客户端连接服务端时默认使用的端口
port=3306
default-character-set=utf8

```

安装 mysql

mysqld install

初始化命令

mysqld --initialize-insecure --user=mysql

启动 mysql

net start mysql

关闭 mysql

net stop mysql

登陆命令

mysql -u root -p （可能登陆不上）

重置密码

先关闭 mysql 输入 net stop mysql ，开启跳过验证登陆 mysql 服务 输入 mysqld --console --skip-grant-tables --shared-memory ，另开一个管理员 cmd ，输入 

    use mysql

    update user set authentication_string='' where user='root';
    
    quit

关闭SQL语句的自动提交

set autocommit=off;

查看SQL语句自动提交是否关闭

show variables like 'autocommit';

打印展示创建的表

show create table 表名;

查看表结构（属性结构）

desc < 表名 >

SHOW FIELDS FROM 视图名

##  多表连接查询

### 1、内链接

内连接INNER JOIN是最常用的连接操作。从数学的角度讲就是求两个表的交集，从笛卡尔积的角度讲就是从笛卡尔积中挑出ON子句条件成立的记录。

### 2、连接 left join，left outer join ，right join， right outer join， union

右连接 RIGHT JOIN

左连接 LEFT JOIN 的含义就是求两个表A表和B表的交集外加左表剩下的数据。依旧从笛卡尔积的角度讲，就是先从笛卡尔积中挑出ON子句条件成立的记录，然后加上左表A表中剩余的记录（见最后三条）。

右连接 RIGHT JOIN

右连接 RIGHT JOIN 就是求两个表A和B表的交集外加右表B剩下的数据。再次从笛卡尔积的角度描述，右连接就是从笛卡尔积中挑出ON子句条件成立的记录，然后加上右表中剩余的记录（见最后一条）

外连接 FULL OUTER JOIN

外连接就是求两个表A和B集合的并集,MySQL不支持OUTER JOIN，可以使用 UNION 来实现。

---

打印出表索引

SHOW INDEX FROM employees.titles;

---

查看索引的使用情况

EXPLAIN SELECT * FROM employees.titles WHERE emp_no='10001' AND title='Senior Engineer' AND from_date='1986-06-26';

ref字段

---

创建视图

create view 视图名 (参数1，参数2...) as ...，后面 ... 代表 select 某个表的数据

---

修改视图

CREATE OR REPLACE VIEW 视图名 AS SELECT [ ... ] FROM [ ... ]

---

WITH CHECK OPTION

如果在创建视图的时候制定了“WITH CHECK OPTION”，那么更新数据时不能 插入或更新 不符合视图限制条件的记录。

通过视图所做的修改，必须在视图的可见范围内：  
- 假设INSERT，新增的记录在视图仍可查看  
- 假设UPDATE，修改后的结果必须能通过视图查看到  
- 假设DELETE，只能删除现有视图里能查到的记录  

如：create view v_price as select * from product where price >= 3000 with check option;

一般来说没有特殊理由，建议加上 with check option 命令

---


