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